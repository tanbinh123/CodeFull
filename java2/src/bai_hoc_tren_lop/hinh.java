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
public class hinh {

    int cd;
    int cr;

    hinh() {
        cd = 1;
        cr = 1;
    }

    hinh(int x) {
        cd = x;
        cr = x;
    }

    hinh(int cd, int cr) {
        this.cd = cd;
        this.cr = cr;
    }

    int tinhdientich() {
        return cd * cr;
    }

    int tinhchuvi() {
        return (cd * cr) * 2;

    }

    String xuatTT() {
        return "cd: " + cd + " ;cr: " + cr + " ;dien tich: " + tinhdientich() + " ;chu vi: " + tinhchuvi();
    }
}
