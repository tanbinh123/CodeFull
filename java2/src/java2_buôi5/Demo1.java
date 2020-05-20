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
public class Demo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> a = new ArrayList<Integer>();
        int[] sv = new int [5];
        sv[0]=5;
        sv[1]=7;
        sv[2]=9;
        a.add(5);//5 
        a.add(7);//5 7
        a.add(9);// 5 7 9
        int x = a.indexOf(7);
        System.out.println(x);
        System.out.println(a.toString());
        a.remove(1);
        System.out.println(a.toString());
        a.add(1, 8);
        System.out.println(a.toString());
        a.set(1, 7);
        System.out.println(a.toString());
        a.add(0, 11);
        System.out.println(a.toString());
        Collections.sort(a);
        System.out.println(a.toString());
        Collections.reverse(a);
        System.out.println(a.toString());
        //Duyet ArrayList
        for(int i=0;i<a.size();i++)
            System.out.println(a.get(i));
        System.out.println("==================");
        for(int doituong:a)// 11 9 7 5
            System.out.println(doituong);//doituong == a.get(i)
                       
    }
    
}
