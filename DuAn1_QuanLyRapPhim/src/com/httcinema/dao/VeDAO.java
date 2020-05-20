
package com.httcinema.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.httcinema.helper.DateHelper;
import com.httcinema.helper.JdbcHelper;
import com.httcinema.model.Ve;

public class VeDAO {
    public int insert(Ve model) {
        String sql = "INSERT INTO Ve (maLichChieu, maGhe, tenDangNhap, ngayTao, maGiaVe, giaVe) VALUES (?,?,?,?,?,?)";
        int maVe = JdbcHelper.executeUpdateReturnKey(sql,
                model.getMaLichChieu(),
                model.getMaGhe(),
                model.getTenDangNhap(),
                model.getNgayTao(),
                model.getMaGiaVe(),
                model.getGiaVe());
        
        return maVe;
    }

    public void update(Ve model) {
        String sql = "UPDATE Ve SET maLichChieu=?, maGhe=?, tenDangNhap=?, ngayTao=?, maGiaVe=?, giaVe=? WHERE maVe=?";
        JdbcHelper.executeUpdate(sql, 
                model.getMaLichChieu(),
                model.getMaGhe(),
                model.getTenDangNhap(),
                model.getNgayTao(),
                model.getMaGiaVe(),
                model.getGiaVe(),
                model.getMaVe());
    }

    public void delete(String maVe) {
        String sql = "DELETE FROM Ve WHERE maVe=?";
        JdbcHelper.executeUpdate(sql, maVe);
    }

    public List<Ve> select() {
        String sql = "SELECT * FROM Ve";
        return select(sql);
    }
    
    public List<Ve> selectOrderByDate(boolean giamDan) {
    	String sql = "SELECT * FROM Ve ORDER BY ngayTao";
    	if (giamDan) {
    		sql += " DESC";
    	}
    	return select(sql);
    }
    
    public List<Ve> selectByDate(Date ngayBatDau, Date ngayKetThuc, int maGiaVe) {
        String sql = "{call sp_HoaDonVeDuaTheoNgay (?, ?, ?)}";
        return select(sql, ngayBatDau, ngayKetThuc, maGiaVe);
    }

    public Ve findById(String maVe) {
        String sql = "SELECT * FROM Ve WHERE maVe=?";
        List<Ve> list = select(sql, maVe);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Ve> select(String sql, Object... args) {
        List<Ve> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Ve model = readFromResultSet(rs);
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

    public List<Object[]> printTicket(String maVe) {
    	List<Object[]> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				String sql = "{call sp_XuatVe (?)}";
				rs = JdbcHelper.executeQuery(sql, maVe);
				while (rs.next()) {
					Time time = rs.getTime("ngayTao");
					
					Object[] model = {
							rs.getInt("maVe"),
							rs.getString("tenPhim"),
							rs.getString("tenPhongChieu"),
							rs.getString("maGhe"),
							rs.getDate("ngayChieu"),
							rs.getTime("gioChieu"),
							rs.getString("moTa"),
							rs.getDouble("giaVe"),
							DateHelper.toString(rs.getDate("ngayTao"), "dd-MM-yyyy (EEE) ") + DateHelper.toString(time, "HH:mm:ss"),
					};
					list.add(model);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
    
    private Ve readFromResultSet(ResultSet rs) throws SQLException {
        Ve model = new Ve();
        model.setMaVe(rs.getInt("maVe"));
        model.setMaLichChieu(rs.getInt("maLichChieu"));
        model.setMaGhe(rs.getString("maGhe"));
        model.setTenDangNhap(rs.getString("tenDangNhap"));
        model.setNgayTao(rs.getDate("ngayTao"));
        model.setMaGiaVe(rs.getInt("maGiaVe"));
        model.setGiaVe(rs.getDouble("giaVe"));
        return model;
    }
}
