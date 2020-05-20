/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java1;

import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Java1 {

    public static void main(String[] args) {
        chao();
        xuat(5);
        
        int m = 3;
        xuat(m);
        
        int z = nhap();
    }

    //không truyền, không trả
    public static void chao() {
        System.out.println("hello");
    }

    //có truyền, không trả

    public static void xuat(int x) {
        System.out.println("giá trị = " + x);
    }
    //không truyền, có trả
    public static int nhap(){
        int x;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        return x;
    }
    //có truyền, có trả

}
