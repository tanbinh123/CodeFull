/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author thanh
 */
public class NhanVien implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String maNhanVien;
    private String hoVaTen;
    private Integer Tuoi;
    private String email;
    private double luong;

    public NhanVien(String maNhanVien, String hoVaTen, int tuoi, String email, double luong) {
        this.maNhanVien = maNhanVien;
        this.hoVaTen = hoVaTen;
        this.Tuoi = tuoi;
        this.email = email;
        this.luong = luong;
    }

    public NhanVien() {

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
