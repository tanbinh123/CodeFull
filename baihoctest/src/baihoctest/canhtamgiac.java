/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baihoctest;

import java.util.*;

/**
 *
 * @author thanh
 */
public class canhtamgiac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào số a: ");
        double a = sc.nextDouble();
        System.out.println("nhập vào số b: ");
        double b = sc.nextDouble();
        System.out.println("nhập vào số c: ");
        double c = sc.nextDouble();
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("abc là ba cạnh của tam giác");

        }else{
            System.out.println("abc là ba cạnh không hợp lệ");
        }
        if (a == b && b == c && a == c) {
            System.out.println("nó là tam giác đều");
        }
        if (a == b || b == c || a == c) {
            System.out.println("nó là tam giác cân");

        }
        if (((a * 2 + b * 2 == c * 2) && (a == b) || a * a + c * c == b * b && (a == c) || b * 2 + c * 2 == a * 2) && (b == c)) {
            System.out.println("nó là tam giác vuông cân");
        }
        if (b * b == a * a + c * c || a * a == b * b + c * c || c * c == a * a + b * b) {
            System.out.println("tam giác vuông");
        }else{
            System.out.println("tam giác thường");
        }

    }
}
