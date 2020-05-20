
package com.httcinema.model;

import java.sql.Time;
import java.util.Date;

public class LichChieu {
    private int maLichChieu;
    private int maPhim;
    private int maPhongChieu;
    private Date ngayChieu;
    private Time gioChieu;

    public LichChieu() {
    }

    public LichChieu(int maLichChieu, int maPhim, int maPhongChieu, Date ngayChieu, Time gioChieu) {
        this.maLichChieu = maLichChieu;
        this.maPhim = maPhim;
        this.maPhongChieu = maPhongChieu;
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public int getMaPhongChieu() {
        return maPhongChieu;
    }

    public void setMaPhongChieu(int maPhongChieu) {
        this.maPhongChieu = maPhongChieu;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Time getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(Time gioChieu) {
        this.gioChieu = gioChieu;
    }
}
