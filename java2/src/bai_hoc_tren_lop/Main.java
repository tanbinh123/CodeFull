/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_hoc_tren_lop;

/**
 *
 * @author thanh
 */
public class Main {
    public static void main(String[] args) {
        hinh a = new hinh();
        a.cd = 5;
        a.cr = 7;
        
        hinh b = new hinh (5);
        System.out.println("dientich " + b.tinhdientich());
        System.out.println("chu vi " + b.tinhchuvi());
        
        hinh c = new hinh(7,9);
        System.out.println("diện tích "+c.tinhdientich());
        System.out.println("tính chu vi "+c.tinhchuvi());
        System.out.println(c.xuatTT());
        
        hinhHop d = new hinhHop();
        d.cd = 5;
        d.cr = 7;
        d.cc = 5;
        System.out.println(d.xuatTT());
    }
}
