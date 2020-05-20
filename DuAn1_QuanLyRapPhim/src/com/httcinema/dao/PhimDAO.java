
package com.httcinema.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.httcinema.helper.JdbcHelper;
import com.httcinema.model.Phim;


public class PhimDAO {
   public void insert(Phim model) {
        String sql = "INSERT INTO Phim (tenPhim, maTheLoai, nhaSanXuat, doTuoi, thoiLuong, ngayCongChieu, trailer, hinh) VALUES (?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getTenPhim(),
                model.getMaTheLoai(),
                model.getNhaSanXuat(),
                model.getDoTuoi(),
                model.getThoiLuong(),
                model.getNgayCongChieu(),
                model.getTrailer(),
                model.getHinh());
    }

    public void update(Phim model) {
        String sql = "UPDATE Phim SET tenPhim=?, maTheLoai=?, nhaSanXuat=?, doTuoi=?, thoiLuong=?, ngayCongChieu=?, trailer=?, hinh=? WHERE maPhim=?";
        JdbcHelper.executeUpdate(sql, 
                model.getTenPhim(),
                model.getMaTheLoai(),
                model.getNhaSanXuat(),
                model.getDoTuoi(),
                model.getThoiLuong(),
                model.getNgayCongChieu(),
                model.getTrailer(),
                model.getHinh(),
                model.getMaPhim());
    }

    public void delete(String maPhim) {
        String sql = "DELETE FROM Phim WHERE maPhim=?";
        JdbcHelper.executeUpdate(sql, maPhim);
    }

    public List<Phim> select() {
        String sql = "SELECT * FROM Phim";
        return select(sql);
    }
    
    public List<Phim> selectOrderByName(boolean giamDan) {
    	String sql = "SELECT * FROM Phim ORDER BY tenPhim";
    	if (giamDan) {
    		sql += " DESC";
    	}
    	return select(sql);
    }
    
	public List<Phim> selectByKeyword(String keyword) {
		String sql = "SELECT * FROM Phim WHERE tenPhim LIKE ? ORDER BY TenPhim";
		return select(sql, "%" + keyword + "%");
	}
    
    public List<Phim> selectByDate(Date date) {
        String sql = "{call sp_TimPhimTrongNgay (?)}";
        return select(sql, date);
    }

    public Phim findById(String maPhim) {
        String sql = "SELECT * FROM Phim WHERE maPhim=?";
        List<Phim> list = select(sql, maPhim);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public Phim findInTicket(String maPhim) {
        String sql = "{call sp_KiemTraPhimDaDuocMua (?)}";
        List<Phim> list = select(sql, maPhim);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Phim> select(String sql, Object... args) {
        List<Phim> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Phim model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private Phim readFromResultSet(ResultSet rs) throws SQLException {
        Phim model = new Phim();
        model.setMaPhim(rs.getInt("maPhim"));
        model.setTenPhim(rs.getString("tenPhim"));
        model.setMaTheLoai(rs.getInt("maTheLoai"));
        model.setNhaSanXuat(rs.getString("nhaSanXuat"));
        model.setDoTuoi(rs.getInt("doTuoi"));
        model.setThoiLuong(rs.getInt("thoiLuong"));
        model.setNgayCongChieu(rs.getDate("ngayCongChieu"));
        model.setTrailer(rs.getString("trailer"));
        model.setHinh(rs.getString("hinh"));
        return model;
    } 
}
