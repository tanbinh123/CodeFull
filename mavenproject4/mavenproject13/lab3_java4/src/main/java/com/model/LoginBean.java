/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.model;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author thanh
 */
public class LoginBean {
    public boolean checkLogin(String username, String password){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Sinhvien";
            Connection con = DriverManager.getConnection(url, "sa", "songlong");
            String sql = "select * from Registration where username = ? and password =?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            boolean result = rs.next();
            rs.close();
            stm.close();
            con.close();
            if(result){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
