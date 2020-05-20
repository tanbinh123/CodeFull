/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.model;

import java.util.Objects;

/**
 *
 * @author HuyPham
 */
public class LoaiPhim {

    private int maLoaiPhim;
    private String tenTheLoai;

    public LoaiPhim(int maLoaiPhim, String tenTheLoai) {
        this.maLoaiPhim = maLoaiPhim;
        this.tenTheLoai = tenTheLoai;
    }
    
    public LoaiPhim() {
    }

    public int getMaLoaiPhim() {
        return maLoaiPhim;
    }

    public void setMaLoaiPhim(int maLoaiPhim) {
        this.maLoaiPhim = maLoaiPhim;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    @Override
    public String toString() {
        return this.tenTheLoai;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.maLoaiPhim);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoaiPhim other = (LoaiPhim) obj;
        if (!Objects.equals(this.maLoaiPhim, other.maLoaiPhim)) {
            return false;
        }
        return true;
    }
}
