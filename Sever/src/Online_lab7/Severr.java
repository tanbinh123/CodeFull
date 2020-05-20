/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Online_lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.*;

/**
 *
 * @author thanh
 */
public class Severr {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            System.out.println(host.getHostName());
            System.out.println(host.getHostAddress());
            
            ServerSocket sever = new ServerSocket(6789);
            
            while(true){
                System.out.println("đang đợi kết nối");
                //khi có một client kết nối
                Socket client = sever.accept();
                System.out.println("có client kết nối");
                
                //đọc dữ liệu Client gửi lên sever
                DataInputStream read = new DataInputStream(client.getInputStream());
                String clientGoiLenSever = read.readUTF();
                System.out.println("Client: "+clientGoiLenSever);
                
                //gởi dữ liệu từ Sever xuống Client
                String SeverGuiLai = clientGoiLenSever.toUpperCase();
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF(SeverGuiLai);
                
//                client.close();
//                read.close();
//                out.close();
            }
        } catch (Exception e) {
        }
    }
}
