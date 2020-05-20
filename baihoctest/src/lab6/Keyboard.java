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
public class Keyboard {
    static Scanner sc = new Scanner (System.in);
    public static String readString(String message){
        System.out.print(message);
        String str= sc.nextLine();
        return str;
    }
}
