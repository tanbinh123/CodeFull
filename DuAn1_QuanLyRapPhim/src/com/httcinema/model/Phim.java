
package com.httcinema.model;

import java.util.Date;
import java.util.Objects;

public class Phim {
    private int maPhim;
    private String tenPhim;
    private int maTheLoai;
    private String nhaSanXuat;
    private int doTuoi;
    private int thoiLuong;
    private Date ngayCongChieu;
    private String trailer;
    private String hinh;

    public Phim() {
    }

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 17 * hash + Objects.hashCode(this.maPhim);
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
		
		final Phim other = (Phim) obj;
		if (!Objects.equals(this.maPhim, other.maPhim)) {
			return false;
		}
		
		return true;
	}
    
    public Phim(int maPhim, String tenPhim, int maTheLoai, String nhaSanXuat, int doTuoi, int thoiLuong, Date ngayCongChieu, String trailer, String hinh) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.maTheLoai = maTheLoai;
        this.nhaSanXuat = nhaSanXuat;
        this.doTuoi = doTuoi;
        this.thoiLuong = thoiLuong;
        this.ngayCongChieu = ngayCongChieu;
        this.trailer = trailer;
        this.hinh = hinh;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getDoTuoi() {
        return doTuoi;
    }

    public void setDoTuoi(int doTuoi) {
        this.doTuoi = doTuoi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Date getNgayCongChieu() {
        return ngayCongChieu;
    }

    public void setNgayCongChieu(Date ngayCongChieu) {
        this.ngayCongChieu = ngayCongChieu;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
    @Override
    public String toString() {
    	return this.tenPhim;
    }
}
