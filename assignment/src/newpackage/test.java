/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class test {
    public static String text(){
        Scanner sc = new Scanner(System.in);
        String email = "";
        System.out.println("Nhập email: ");
        while (true) {
            email = sc.nextLine();
            if (email.matches("(.*)@(.+\\.{\\w})")) {
                //  
                return email;
            }    
            else {
                System.out.println("Sai cú pháp email. Hãy nhập lại");
                continue;
            }        
        }

       
    }
}
