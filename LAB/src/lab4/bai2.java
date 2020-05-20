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
public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int f0 = 1;
        int f1 = 2;
        int next = f0 + f1;
        while(next<m){
            next = f0 + f1;
            System.out.println("next = " + next);
            f0=f1;
            f1=next;
        }
           
       
    }
    
}
