/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_buôi5;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author locth
 */
public class Demo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> ten = new ArrayList<String>();
        ten.add("Hoa");
        ten.add("Lan");
        ten.add("Ti");
        ten.add("An");
        ten.add("Vy");
        for(String item: ten)
            System.out.println(item);
        Collections.sort(ten);
        System.out.println(ten.toString());
        Collections.reverse(ten);
        System.out.println(ten.toString());
        ten.remove(ten.indexOf("Ti"));
        System.out.println(ten.toString());
    }
    
}
