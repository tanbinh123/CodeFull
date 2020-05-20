/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;


import java.util.*;
/**
 *
 * @author thanh
 */
public class bai1 {
    private static Object Marth;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        Random random = new Random();
        
        int b = random.nextInt(16) + 5;
       
        int c = Math.min(a, b);
 
        double d = Math.pow(a,b);
        
        double e = Math.round(b);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        
    }
}
