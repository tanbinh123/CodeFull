
package com.httcinema.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.httcinema.helper.JdbcHelper;
import com.httcinema.model.LichChieu;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class LichChieuDAO {
    public void insert(LichChieu model) throws SQLServerException {
        String sql = "INSERT INTO LichChieu (maPhim, maPhongChieu, ngayChieu, gioChieu) VALUES (?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaPhim(),
                model.getMaPhongChieu(),
                model.getNgayChieu(),
                model.getGioChieu());
    }

    public void update(LichChieu model) {
        String sql = "UPDATE LichChieu SET maPhim=?, maPhongChieu=?, ngayChieu=?, gioChieu=? WHERE maLichChieu=?";
        JdbcHelper.executeUpdate(sql, 
                model.getMaPhim(),
                model.getMaPhongChieu(),
                model.getNgayChieu(),
                model.getGioChieu(),
                model.getMaLichChieu());
    }

    public void delete(String maLichChieu) {
        String sql = "DELETE FROM LichChieu WHERE maLichChieu=?";
        JdbcHelper.executeUpdate(sql, maLichChieu);
    }

    public List<LichChieu> select() {
        String sql = "SELECT * FROM LichChieu";
        return select(sql);
    }
    
    public List<Date> selectOrderByDate(boolean giamDan) {
    	String sql = "SELECT DISTINCT ngayChieu FROM LichChieu ORDER BY ngayChieu";
    	if (giamDan) {
    		sql += " DESC";
    	}
    	return selectDate(sql);
    }
    
    public List<LichChieu> selectByKeyword(String keyword) {
		String sql = "SELECT * FROM LichChieu WHERE maLichChieu LIKE ?";
		return select(sql, "%" + keyword + "%");
	}
    
    public List<LichChieu> selectByIdMovieDateTime(String keywordId, int movieId, String keywordDate, String keywordTime) {
		String sql = "{call sp_TruyVanLichChieuDuaTheoMaPhimNgayGio (?, ?, ?, ?)}";
		return select(sql, "%" + keywordId + "%", movieId, "%" + keywordDate + "%", "%" + keywordTime + "%");
	}
    
    public List<LichChieu> selectByMovieAndDate(String maPhim, Date date) {
        String sql = "{call sp_TimTatCaGioChieuCuaPhimTrongNgay (?, ?)}";
        return select(sql, maPhim, date);
    }
    
    public LichChieu findById(String maLichChieu) {
        String sql = "SELECT * FROM LichChieu WHERE maLichChieu=?";
        List<LichChieu> list = select(sql, maLichChieu);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public LichChieu findInTicket(String maLichChieu) {
        String sql = "{call sp_KiemTraLichChieuDaDuocMua (?)}";
        List<LichChieu> list = select(sql, maLichChieu);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<LichChieu> select(String sql, Object... args) {
        List<LichChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    LichChieu model = readFromResultSet(rs);
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
    
    private List<Date> selectDate(String sql, Object... args) {
        List<Date> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                	Date model = readDateFromResultSet(rs);
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

    private LichChieu readFromResultSet(ResultSet rs) throws SQLException {
        LichChieu model = new LichChieu();
        model.setMaLichChieu(rs.getInt("maLichChieu"));
        model.setMaPhim(rs.getInt("maPhim"));
        model.setMaPhongChieu(rs.getInt("maPhongChieu"));
        model.setNgayChieu(rs.getDate("ngayChieu"));
        model.setGioChieu(rs.getTime("gioChieu"));
        return model;
    }
    
    private Date readDateFromResultSet(ResultSet rs) throws SQLException {
        Date model = rs.getDate("ngayChieu");
        return model;
    }
}
