/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class AbstractConnection {

    final String user = "sa";
    private final String pass = "songlong";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=JAVA4";
    protected Connection conn = null;
    protected PreparedStatement ptm = null;
    protected ResultSet rs = null;

    public AbstractConnection() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void open(){
        try {
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void close(){
        try {
            if (this.rs != null) {
                rs.close();
            }
            if (this.ptm != null) {
                ptm.close();
            }
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
