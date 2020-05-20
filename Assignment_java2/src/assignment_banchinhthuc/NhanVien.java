/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_banchinhthuc;

import java.io.Serializable;

/**
 *
 * @author thanh
 */
public class NhanVien implements Serializable{

    public String maNhanVien;
    public String hoVaTen;
    public Integer Tuoi;
    public String email;
    public double luong;

    NhanVien(String maNhanVien, String hoVaTen, int tuoi, String email, double luong) {
        this.maNhanVien = maNhanVien;
        this.hoVaTen = hoVaTen;
        this.Tuoi = tuoi;
        this.email = email;
        this.luong = luong;
    }

    NhanVien() {
        
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

}
