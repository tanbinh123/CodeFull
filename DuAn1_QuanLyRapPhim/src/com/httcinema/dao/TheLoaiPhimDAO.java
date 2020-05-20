
package com.httcinema.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.httcinema.helper.JdbcHelper;
import com.httcinema.model.TheLoaiPhim;
public class TheLoaiPhimDAO {
    public void insert(TheLoaiPhim model) {
        String sql = "INSERT INTO TheLoaiPhim (maTheLoai, tenTheLoai) VALUES (?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaTheLoai(),
                model.getTenTheLoai());
    }

    public void update(TheLoaiPhim model) {
        String sql = "UPDATE TheLoaiPhim SET tenTheLoai=? WHERE maTheLoai=?";
        JdbcHelper.executeUpdate(sql, 
                model.getTenTheLoai(),
                model.getMaTheLoai());
    }

    public void delete(String maTheLoai) {
        String sql = "DELETE FROM TheLoaiPhim WHERE maTheLoai=?";
        JdbcHelper.executeUpdate(sql, maTheLoai);
    }

    public List<TheLoaiPhim> select() {
        String sql = "SELECT * FROM TheLoaiPhim";
        return select(sql);
    }

    public TheLoaiPhim findById(String maTheLoai) {
        String sql = "SELECT * FROM TheLoaiPhim WHERE maTheLoai=?";
        List<TheLoaiPhim> list = select(sql, maTheLoai);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<TheLoaiPhim> select(String sql, Object... args) {
        List<TheLoaiPhim> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TheLoaiPhim model = readFromResultSet(rs);
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

    private TheLoaiPhim readFromResultSet(ResultSet rs) throws SQLException {
        TheLoaiPhim model = new TheLoaiPhim();
        model.setMaTheLoai(rs.getInt("maTheLoai"));
        model.setTenTheLoai(rs.getString("tenTheLoai"));
        return model;
    }
}
