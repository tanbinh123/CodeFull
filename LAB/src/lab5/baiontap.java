/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.*;
/**
 *
 * @author thanh
 */
public class baiontap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hoten [] = new String [10];
        double diem [] = new double [10];
        String hocluc [] = new String [10];
        for(int T = 0; T < hoten.length;T++){
            
            System.out.println("nhập họ tên sinh viên " + T + ": ");
            hoten[T]= sc.nextLine();
            
            System.out.print("nhập điểm: ");
            diem [T] = sc.nextDouble();
            sc.nextLine();
        }
        for (int T = 0; T < hoten.length;T++){
            if (diem[T] < 5){
                hocluc[T] = "yếu";
                
            }else if (diem[T] < 6.5){
                hocluc[T] = "trung bình";
            }else if (diem[T] < 7.5){
                hocluc[T] = "khá"; 
            }else if (diem[T] < 8){
                hocluc[T] = "giỏi";
            }else {
                hocluc[T] = "xuất sắc";
            }
            
        }
        for(int S = 0; S < hoten.length; S++){
            System.out.println("họ tên: " + hoten[S] + " " + "điểm " +diem[S] + " "+hocluc[S]);
        }
    }
}
