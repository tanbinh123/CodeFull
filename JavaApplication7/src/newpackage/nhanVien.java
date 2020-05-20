/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.*;
public class nhanVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String nhanvien[] = new String[5] ;
        for(int i = 0; i < 5;i++){
            System.out.println("nhập tên nhân viên: " + (i+1));
            nhanvien[i] = sc.nextLine();
            
        }
        for(int i = 0; i< 5;i++){
            System.out.println("nhân viên: " + nhanvien[i]);
        }
    }
}
