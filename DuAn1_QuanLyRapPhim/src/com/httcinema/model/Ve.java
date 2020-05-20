
package com.httcinema.model;

import java.util.Date;

public class Ve {
    private int maVe;
    private int maLichChieu;
    private String maGhe;
    private String tenDangNhap;
    private Date ngayTao;
    private int maGiaVe;
    private double giaVe;

    public Ve() {
    }

    public Ve(int maLichChieu, String maGhe, String tenDangNhap, Date ngayTao, int maGiaVe, double giaVe) {
        this(0, maLichChieu, maGhe, tenDangNhap, ngayTao, maGiaVe, giaVe);
    }
    
    public Ve(int maVe, int maLichChieu, String maGhe, String tenDangNhap, Date ngayTao, int maGiaVe, double giaVe) {
        this.maVe = maVe;
        this.maLichChieu = maLichChieu;
        this.maGhe = maGhe;
        this.tenDangNhap = tenDangNhap;
        this.ngayTao = ngayTao;
        this.maGiaVe = maGiaVe;
        this.giaVe = giaVe;
    }

    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
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

    public void setGiaVe(double money) {
        this.giaVe = money;
    }
    
    
}
