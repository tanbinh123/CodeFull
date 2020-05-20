/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author thanh
 */
public class Products {

    public Products() {

    }

    public void delete(String masp) {
        
    }
    public void insert(String masp, String tensp, float gia){
        
    }
    public void update(String masp, String tensp, float gia){
        
    }
    public List<Product>showProduct(String tensp){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=AssignSOF301";
            Connection con = DriverManager.getConnection(url, "sa", "songlong");
            String sql = "select * from Products";
            if(tensp.length()>0){
                sql += " where name like '%"+tensp+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Product> list = new ArrayList<Product>();
            while(rs.next()){
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                Product sp = new Product(code, name, price);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
