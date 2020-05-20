/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.io.Serializable;

/**
 *
 * @author thanh
 */
public class NhanVien implements Serializable {

    private String hoten;
    private Integer tuoi;

    public NhanVien(String hoten, int tuoi) {
        this.hoten = hoten;
        this.tuoi = tuoi;
    }
    public NhanVien(){
        
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }
    
}
