/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phunglv.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import phunglv.bean.Student;

/**
 *
 * @author Administrator
 */
public class Student3Model {

    public Student3Model() {
    }
    
    public static List<Student> showStudent(String tensp){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Sinhvien";
            Connection con = DriverManager.getConnection(url, "sa", "songlong");
            String sql = "select * from Students";
            if(tensp.length() > 0){
                sql += " where Name like '%"+tensp+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Student> list = new ArrayList<Student>();
            while(rs.next()){
                int masv = rs.getInt("masv");
                String name = rs.getString("name");
                double mark = rs.getDouble("mark");
                String major = rs.getString("major");
                Student sp = new Student(masv,name, mark, major);
                list.add(sp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void delete(int masv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "");
            String sql = "delete from Students where masv=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, masv);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void insert(Student sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "");
            String sql = "insert into Students values(?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getName());
            stm.setDouble(2, sv.getMark());
            stm.setString(3, sv.getMajor());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void update(Student sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "");
            String sql = "update Students set name=?, mark=?, major=? where masv=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getName());
            stm.setDouble(2, sv.getMark());
            stm.setString(3, sv.getMajor());
            stm.setInt(4, sv.getMasv());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
