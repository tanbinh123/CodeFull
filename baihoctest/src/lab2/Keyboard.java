/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Keyboard {

    public static String readString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String a = sc.nextLine();
        return a;
    }
    
       public static double readDouble(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        double a = sc.nextDouble();
        return a;
    }
}
