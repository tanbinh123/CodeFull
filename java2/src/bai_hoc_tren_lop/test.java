/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_hoc_tren_lop;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author thanh
 */
public class test {
    public static void main(String[] args) {
        NumberFormat formatter = new DecimalFormat("#"); 
        double a = 731;
        // int i = 1 -> 6 (i++)
        // int i = 2 -> 16 (i++)
        // int i = 3 -> 316 (i++)
        // if i = 3 -> .316 (i=1)
        
        // int i = 1 -> 7.316(i++)
        // int i = 2 -> 47.316 (i++)
        // int i = 3 -> 347.316 (i++)
        
        // if i = 3 -> .347.316 (i=1)
        String t = formatter.format(a);
        
        // "112347316" => char => 1 1 2 3 4 7 3 1 6
        //                        0 1 2 3 4 5 6 7 8
        
        int count = 0;
        String result = "";
        for(int i = t.length() -1; i >= 0; i--){
           if(count == 3){
               result = '.' + result;
               count = 0;
           }
           result = t.charAt(i) + result;
           count++;
        }
        System.out.println(result);
        
        
    }
}
