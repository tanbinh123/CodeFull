/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_co_ban;

import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class GiaiThua {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("mời bạn nhập số n: ");
        int n = sc.nextInt();
        giaiThua(n);
    }
    public static void giaiThua(int n){
        int ketQua = 1;
        for(int i = 1; i<=n; i++)ketQua =ketQua*i;{
            System.out.println("kết quả của n là: " + ketQua);
        }
    }
}
