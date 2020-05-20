/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Nhanvien implements Serializable {
    private String manv;
    private String hoten;
    private int tuoi;
    private boolean gioitinh;
    private String nganh;

    public Nhanvien(String manv, String hoten, int tuoi, boolean gioitinh, String nganh) {
        this.manv = manv;
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.nganh = nganh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
    
}
