/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author thanh
 */
public class Control {

    public static ArrayList<Books> getAllbooks() {
        ArrayList<Books> list = new ArrayList<>();
        Connection conn = Connection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Books");
            while(rs.next()){
                int ID = rs.getInt("ID");
                String Title = rs.getString("Title");
                float price = rs.getFloat("Price");
                
                Books book = new Books(ID, Title, price);
                list.add(book);
            }
        } catch (Exception e) {

        }
        return list;
    }
}
