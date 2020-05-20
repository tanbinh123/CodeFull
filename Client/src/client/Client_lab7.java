/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Client_lab7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập IPAddress: ");
        String Address = sc.nextLine();
        
        
        while (true) {
            try {
                Socket server = new Socket(Address, 7777);

                System.out.print("Nhập số đầu tiên cần tính: ");
                double so1 = sc.nextDouble();
                System.out.print("Nhập số thứ 2 cần tính: ");
                double so2 = sc.nextDouble();

                //gửi dữ liệu lên server
                DataOutputStream guiLenServer = new DataOutputStream(server.getOutputStream());
                guiLenServer.writeDouble(so1);
                guiLenServer.writeDouble(so2);

                //lấy dữ liệu từ sever xuống lại Client
                DataInputStream layDuLieu = new DataInputStream(server.getInputStream());
                double chuoiDoc = layDuLieu.readDouble();
                System.out.println("Kết quả là: " + chuoiDoc);
                System.out.println("Tiếp tục Yes || No");
                sc.nextLine();
                String y_n = sc.nextLine();
                if(y_n.equalsIgnoreCase("no")){
                break;
            }

            } catch (Exception e) {
            }

        }
    }

}
