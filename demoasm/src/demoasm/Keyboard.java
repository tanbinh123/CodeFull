/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoasm;

import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class Keyboard {
    
        
    public static String readString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String a = sc.nextLine();
        return a;
    }
    
    public static int readInt(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        int a = sc.nextInt();
        return a;
    }

    public static double readDouble(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        double a = sc.nextDouble();
        return a;
    }

    public static boolean readBoolean(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        boolean a = sc.nextBoolean();
        return a;
    }
}
 

