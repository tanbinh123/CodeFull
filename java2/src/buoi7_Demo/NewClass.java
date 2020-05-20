/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi7_Demo;

import java.util.ArrayList;

/**
 *
 * @author thanh
 */
public class NewClass {

    public static void main(String[] args) {
        ArrayList ds = new ArrayList();
        ds.add("teo");
        ds.add(1);
        ds.add(15.4f);
        //nếu bắt buộc chỉ chứa số nguyên
        ArrayList<Integer> gt = new ArrayList<Integer>();
        gt.add(5);
        //nếu String
        ArrayList<String> st = new ArrayList<String>();
        st.add("dsf");
        
    }
}
