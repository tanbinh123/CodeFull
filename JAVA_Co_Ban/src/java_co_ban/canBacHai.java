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
public class canBacHai {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập hệ số bậc 2: ");
        double heSo2 = sc.nextDouble();
        System.out.println("nhập hệ số bậc 1: ");
        double heSo1 = sc.nextDouble();
        System.out.println("Nhập hệ số tự do: ");
        double heSoTuDo = sc.nextDouble();

        if (heSo2 == 0) {
        }
        if (heSo1 == 0) {
            System.out.println("phương trình vô nghiệm");
        } else {
            System.out.println("phương trình có môt nghiệm: " + "x = " + (-heSoTuDo / heSo2));

        }
    }

}
