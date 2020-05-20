/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.*;

/**
 *
 * @author thanh
 */
public class baitest6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int s = 0;
        do {
            i = sc.nextInt();
            s = s + i;
        } while (i % 2 != 0);
        System.out.println("s là: " + s);
    }
}
