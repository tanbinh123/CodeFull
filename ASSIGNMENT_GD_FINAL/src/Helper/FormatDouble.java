/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author thanh
 */
public class FormatDouble {
    
    private static NumberFormat formatter = new DecimalFormat("#"); 
    
    public static String formatPerThousand(double d){
        String num = formatter.format(d);
        String result = "";        
        int count = 0;
        for(int i = num.length() -1; i >= 0; i--){
           if(count == 3){
               result = '.' + result;
               count = 0;
           }
           result = num.charAt(i) + result;
           count++;
        }        
        return result;
    }
    
    public static String formatPerThousand(String d){
        String result = "";        
        int count = 0;
        for(int i = d.length() -1; i >= 0; i--){
           if(count == 3){
               result = '.' + result;
               count = 0;
           }
           result = d.charAt(i) + result;
           count++;
        }        
        return result;
    }
    
    public static String format(double d){
        return formatter.format(d);
    }
}
