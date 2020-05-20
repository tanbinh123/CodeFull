/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.*;

/**
 *
 * @author Welcome
 */
public class hocluc {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println(" NHÂP ĐIỂM SV: \n");
//        double diem = sc.nextDouble();
//        sc.nextLine();
//        
//        String  hocLuc = xepLoai(diem);
//        System.out.println("Học Lực\t"+ hocLuc);
//        
//       
//    }
    public static String xepLoai(double diem) {
        
       String hocLuc = " "; 
       
         if (diem < 5) {
           hocLuc = "Yếu";
        } else if (diem >= 5 && diem < 6.5) {
            hocLuc = "Trung bình";
        } else if (diem >= 6.5 && diem < 7.5) {
            hocLuc = "Khá";
        } else if (diem >= 7.5 && diem < 9) {
           hocLuc = "Giỏi";
        } else {
           hocLuc ="Xuất Sắc";
        }
        return hocLuc;
    }
                
}

