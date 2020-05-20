/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_baove;

import java.io.Serializable;

/**
 *
 * @author thanh
 */
public class NhanVien implements Serializable {

    private String hoVaTen;
    private Integer tuoi;
    private boolean gioiTinh;
    private String trinhDo;

    public NhanVien(String hoVaten, Integer tuoi, boolean gioiTinh, String trinhDo) {

    }

    NhanVien() {

    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGioitinh() {
        return gioiTinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioiTinh = gioitinh;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

}
