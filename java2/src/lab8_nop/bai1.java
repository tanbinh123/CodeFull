/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_nop;

import java.util.ArrayList;

/**
 *
 * @author thanh
 */
public class bai1 {

    public static void main(String[] args) {

        ArrayList so = new ArrayList();
        //truyền số
        so.add(7);
        so.add(7.79);
        so.add(true);
        so.add("hello world");
        //xuất ra
        int soNguyen = (Integer) so.get(0);
        double soThuc = (Double) so.get(1);
        boolean giaTri = (Boolean) so.get(2);
        String chuoi = (String) so.get(3);

        System.out.println("Số nguyên: " + soNguyen);
        System.out.println("Số thực: " + soThuc);
        System.out.println("Giá trị boolean: " + giaTri);
        System.out.println("Chuỗi: " + chuoi);
    }
}
