/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.PhongChieu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haivo
 */
public class PhongChieuDAO {
    public void insert(){
        String sql = "INSERT INTO PHONGCHIEU (MaPhongChieu, TenPhongChieu) VALUES (?, ?)";
    }
    
    public void update(){
        String sql = "UPDATE PHONGCHIEU SET TenPhongChieu=? WHERE MaPhongChieu=?";
    }
    
    public void delect(){
        String sql = "DELETE FROM PHONGCHIEU WHERE MaPhongChieu=?";
    }
    
    
    public List<PhongChieu> select() {
        String sql = "SELECT * FROM PhongChieu";
        return select(sql);
    }

    private List<PhongChieu> select(String sql, Object... args) {
        List<PhongChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhongChieu model = readFroResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private PhongChieu readFroResultSet(ResultSet rs) throws SQLException {
        PhongChieu pm = new PhongChieu();
        pm.setMaPhongChieu(rs.getInt("MaPhongChieu"));
        pm.setTenPhongChieu(rs.getString("TenPhongChieu"));
        return pm;
    }
}
