/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanh
 */
public class UserDAO extends AbstractConnection {

    public UserDAO() {
        
    }

    public User checkLogin(String username, String password) {
        User user = null;
        try {
            this.open();
            String sql = "select * from usertbl where username =? and password=?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, password);
            rs = ptm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getInt("role"));
            }
        } catch (SQLException ex) {
            return null;
        } finally {
            this.close();
        }
        return user;
    }

    public boolean DeleteUser(String username) {
        boolean result = false;
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("delete usertbl where username=?");
            ps.setString(1, username);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return result;
    }

    public List<User> fillToTable() {
        List<User> list = new ArrayList<User>();
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("select * from usertbl where role = 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getInt("role"));
                user.setPhone(rs.getString("phone"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return list;
    }

    public boolean UpdateUser(User user) {
        boolean result = false;
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("update usertbl set username=?, fullname=?, phone=?, email=?, role=? where id=?");
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getRole());
            ps.setInt(6, user.getId());
            if(ps.executeUpdate() > 0){
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return result;
    }
    
    public boolean insertUser(User user){
        boolean result = false;
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO usertbl(username, password, fullname, phone, email, role) values(?,?,?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getRole());
            if(ps.executeUpdate()>0){
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            this.close();
        }
        return result;
    }
}
