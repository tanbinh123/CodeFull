/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Online_lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class Sever_lab7 {
    public static void main(String[] args) throws IOException {
        try {
            InetAddress host = InetAddress.getLocalHost();
            System.out.println("Host name: " + host.getHostName());
            System.out.println("Address: " + host.getHostAddress());
            ServerSocket server = new ServerSocket(7777);
            
            while(true){
                
                System.out.println("Server Connecting...");
                
                //khi có Client kết nối
                Socket Client = server.accept();
                System.out.println("Server Connection! ");
                
                //đọc dữ liệu lên server
                DataInputStream read = new DataInputStream(Client.getInputStream());
                double so1 = read.readDouble();
                double so2 = read.readDouble();
                double ketQua = so1 + so2;
                
                
                //gửi dữ liệu lại Client
                
                DataOutputStream out = new DataOutputStream(Client.getOutputStream());
                out.writeDouble(ketQua);
                out.flush();
                System.out.println("Client: " + ketQua);
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
            
        }
    }
}
