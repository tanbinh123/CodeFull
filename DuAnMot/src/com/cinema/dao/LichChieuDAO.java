/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.LichChieu;
import com.cinema.model.Phim;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haivo
 */
public class LichChieuDAO {
    public void insert(LichChieu model){
        String sql = "INSERT INTO LICHCHIEU (NgayChieu, GioChieu, MaPhim, MaPhongChieu) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, 
                model.getNgayChieu(),
                model.getGioChieu(),
                model.getMaPhim(),
                model.getMaPhongChieu());
    }
    
    public void update(LichChieu model){
        String sql = "UPDATE LICHCHIEU SET NgayChieu=?, GioChieu=?, MaPhim=?, MaPhongChieu=? WHERE MaLichChieu=?";
        JdbcHelper.executeUpdate(sql,
                model.getNgayChieu(),
                model.getGioChieu(),
                model.getMaPhim(),
                model.getMaPhongChieu(),
                model.getMaLichChieu());
    }
    
    public void delete(String MaLichChieu){
        String sql = "DELETE FROM LICHCHIEU WHERE MaLichChieu=?";
        JdbcHelper.executeUpdate(sql, MaLichChieu);
    }
    
    public List<LichChieu> select(){
        String sql = "SELECT * FROM LICHCHIEU";
        return select(sql);
    }
    
    public LichChieu findByID(int id){
        String sql = "SELECT * FROM LICHCHIEU WHERE MaLichChieu = ?";
        LichChieu model = null;
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, id);
                while (rs.next()) {
                    model = ReadFormResultSet(rs);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    
    private List<LichChieu> select(String sql, Object... args) {
        List<LichChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    LichChieu model = ReadFormResultSet(rs);
                    list.add(model);
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    private LichChieu ReadFormResultSet(ResultSet rs) throws SQLException{
        LichChieu lc = new LichChieu();
        lc.setMaLichChieu(rs.getInt("MaLichChieu"));
        lc.setNgayChieu(rs.getString("NgayChieu"));
        lc.setGioChieu(rs.getString("GioChieu"));
        lc.setMaPhim(rs.getInt("MaPhim"));
        lc.setMaPhongChieu(rs.getInt("MaPhongChieu"));
        return lc;
    }
}
