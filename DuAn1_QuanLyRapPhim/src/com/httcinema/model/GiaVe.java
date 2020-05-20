
package com.httcinema.model;

import java.text.DecimalFormat;

public class GiaVe {
    private int maGiaVe;
    private double giaVe;
    private String moTa;

    public GiaVe() {
    }

    public GiaVe(int maGiaVe, double giaVe, String moTa) {
        this.maGiaVe = maGiaVe;
        this.giaVe = giaVe;
        this.moTa = moTa;
    }

    public int getMaGiaVe() {
        return maGiaVe;
    }

    public void setMaGiaVe(int maGiaVe) {
        this.maGiaVe = maGiaVe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    @Override
    public String toString() {
    	return new DecimalFormat("###,###,###,###,###,###").format(this.giaVe) + " VND" + " - " + this.moTa;
    }
}
