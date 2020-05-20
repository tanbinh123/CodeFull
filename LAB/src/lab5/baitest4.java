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
public class baitest4 {
        
        
    public static void main(String[] args) {

        String[] hoTen = {"Tuấn", "Hạnh", "Cường"}; 
        double[][]  diem = {{5,6,7},{7,9,5},{8,3,4}};
        double diemTrungBinh;
        for(int T = 0; T < hoTen.length; T++){
            double diemTong = diem[T][0] + diem[T][1] + diem[T][2];
            diemTrungBinh = diemTong / diem[T].length;
            System.out.print(hoTen[T] + ": ");
            System.out.println("điểm trung bình là: " + diemTrungBinh);
        }
          
    }        
   
}









