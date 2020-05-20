/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập IPAddress: ");
        String diaChi = sc.nextLine();
        
        try {
            Socket server = new Socket(diaChi, 6789);
            
            System.out.println("Nhập số cần gửi lên sever");
            String chuoi = sc.nextLine();
            
            //gửi dữ liệu từ client lên server
            DataOutputStream ghiLenSever = new DataOutputStream(server.getOutputStream());
            ghiLenSever.writeUTF(chuoi);
            
            //lấy dữ liệu từ sever xuống Client
            
            DataInputStream docTuServer = new DataInputStream(server.getInputStream());
            String chuoidoc = docTuServer.readUTF();
            System.out.println("Server: " + chuoidoc);
                    
        } catch (Exception e) {
        }
    }
    
}
