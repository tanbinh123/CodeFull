
package com.httcinema.dao;

import com.httcinema.helper.JdbcHelper;
import com.httcinema.model.PhongChieu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongChieuDAO {
    public void insert(PhongChieu model) {
        String sql = "INSERT INTO PhongChieu (maPhongChieu, tenPhongChieu) VALUES (?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaPhongChieu(),
                model.getTenPhongChieu());
    }

    public void update(PhongChieu model) {
        String sql = "UPDATE PhongChieu SET tenPhongChieu=? WHERE maPhongChieu=?";
        JdbcHelper.executeUpdate(sql, 
                model.getTenPhongChieu(),
                model.getMaPhongChieu());
    }

    public void delete(String maPhongChieu) {
        String sql = "DELETE FROM PhongChieu WHERE maPhongChieu=?";
        JdbcHelper.executeUpdate(sql, maPhongChieu);
    }

    public List<PhongChieu> select() {
        String sql = "SELECT * FROM PhongChieu";
        return select(sql);
    }

    public PhongChieu findById(String maPhongChieu) {
        String sql = "SELECT * FROM PhongChieu WHERE maPhongChieu=?";
        List<PhongChieu> list = select(sql, maPhongChieu);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<PhongChieu> select(String sql, Object... args) {
        List<PhongChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhongChieu model = readFromResultSet(rs);
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

    private PhongChieu readFromResultSet(ResultSet rs) throws SQLException {
        PhongChieu model = new PhongChieu();
        model.setMaPhongChieu(rs.getInt("maPhongChieu"));
        model.setTenPhongChieu(rs.getString("tenPhongChieu"));
        return model;
    }
}
