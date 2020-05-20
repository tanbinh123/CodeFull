/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_buoi5;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author thanh
 */
public class NewClass {

    public static void main(String[] args) {
        ArrayList<String> ten = new ArrayList<String>();
        ten.add("nguyen");
        ten.add("dat");
        for (String item : ten) {
            System.out.println(item);
            Collections.sort(ten);
            System.out.println(ten.toString());
            
        }
    }
}
