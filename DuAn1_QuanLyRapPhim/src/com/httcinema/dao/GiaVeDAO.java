
package com.httcinema.dao;

import com.httcinema.helper.JdbcHelper;
import com.httcinema.model.GiaVe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GiaVeDAO {
    public void insert(GiaVe model) {
        String sql = "INSERT INTO GiaVe (giaVe, moTa) VALUES (?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getGiaVe(),
                model.getMoTa());
    }

    public void update(GiaVe model) {
        String sql = "UPDATE GiaVe SET giaVe=?, moTa=? WHERE maGiaVe=?";
        JdbcHelper.executeUpdate(sql, 
                model.getGiaVe(),
                model.getMoTa(),
                model.getMaGiaVe());
    }

    public void delete(String maGiaVe) {
        String sql = "DELETE FROM GiaVe WHERE maGiaVe=?";
        JdbcHelper.executeUpdate(sql, maGiaVe);
    }

    public List<GiaVe> select() {
        String sql = "SELECT * FROM GiaVe";
        return select(sql);
    }
    
    public List<GiaVe> selectByKeyword(String keyword) {
		String sql = "SELECT * FROM GiaVe WHERE moTa LIKE ?";
		return select(sql, "%" + keyword + "%");
	}
    
    public GiaVe findById(String maGiaVe) {
        String sql = "SELECT * FROM GiaVe WHERE maGiaVe=?";
        List<GiaVe> list = select(sql, maGiaVe);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<GiaVe> select(String sql, Object... args) {
        List<GiaVe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    GiaVe model = readFromResultSet(rs);
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

    private GiaVe readFromResultSet(ResultSet rs) throws SQLException {
        GiaVe model = new GiaVe();
        model.setMaGiaVe(rs.getInt("maGiaVe"));
        model.setGiaVe(rs.getDouble("giaVe"));
        model.setMoTa(rs.getString("moTa"));
        return model;
    }
}
