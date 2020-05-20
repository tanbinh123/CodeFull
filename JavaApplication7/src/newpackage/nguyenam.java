/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.*;
/**
 *
 * @author thanh
 */
public class nguyenam {
    
public static void main(String[] args) {
    String chuoi;
    char kyTu;
    int count = 0;
    Scanner scanner = new Scanner(System.in);
         
    System.out.println("Nhập vào một chuỗi bất kỳ: ");
    chuoi = scanner.nextLine();
         
    
    for (int i = 0; i < chuoi.length(); i++) {
        
        kyTu = chuoi.charAt(i);
             
        
        if(chuoi.charAt(i) == 'a' || chuoi.charAt(i) == 'e' || chuoi.charAt(i) == 'i' || chuoi.charAt(i) == 'o' || chuoi.charAt(i) == 'u' ){
            count++;
        }
        
    }
         
    System.out.println("Số nguyen am có trong chuỗi " + chuoi 
        + " = " + count);
}
}
