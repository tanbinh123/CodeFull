/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.*;
/**
 *
 * @author thanh
 */
public class bai4 {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        System.out.println("-----Menu-----");
        System.out.println("1. Giải phương trình bậc nhất");
        System.out.println("2. Giải phương trình bậc 2");
        System.out.println("3. Tính tiền điện");
        System.out.println("4. Kết thúc");
        System.out.println("Chọn chức năng");
        int a=sc.nextInt();
        switch(a){
            case 1:
                bai1.main(null);
                break;
            case 2:
                bai2.main(null);
                break;
            case 3:
               bai3.main(null);
                break;
            default:
                System.out.println("Thoat");
        }
    }
    
}
