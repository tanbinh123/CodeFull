
import java.sql.*;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thanh
 */
public class lab_5 {
    public static void main(String[] args) {
        try {
            String User="Admin";
            String Pass ="";
            String url="jdbc:mysql://localhost/databaseName=ud14302_banhang";
            Connection con= DriverManager.getConnection(url, User, Pass);
            Statement  st = con.createStatement();
            String sql = "select * from khachhang";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("makhachhang")+", ");
                System.out.println(rs.getString("hovatenlot")+", ");
                System.out.println(rs.getString("ten")+", ");
                System.out.println(rs.getString("diachi")+", ");
                System.out.println(rs.getString("email")+", ");
                System.out.println(rs.getString("dienthoai")+", ");
            }
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
