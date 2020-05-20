
package com.httcinema.model;

import java.util.Objects;

public class PhongChieu {
    private int maPhongChieu;
    private String tenPhongChieu;

    public PhongChieu() {
    }

    @Override
	public int hashCode() {
		int hash = 5;
		hash = 17 * hash + Objects.hashCode(this.maPhongChieu);
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
		
		final PhongChieu other = (PhongChieu) obj;
		if (!Objects.equals(this.maPhongChieu, other.maPhongChieu)) {
			return false;
		}
		
		return true;
	}
    
    public PhongChieu(int maPhongChieu, String tenPhongChieu) {
        this.maPhongChieu = maPhongChieu;
        this.tenPhongChieu = tenPhongChieu;
    }

    public int getMaPhongChieu() {
        return maPhongChieu;
    }

    public void setMaPhongChieu(int maPhongChieu) {
        this.maPhongChieu = maPhongChieu;
    }

    public String getTenPhongChieu() {
        return tenPhongChieu;
    }

    public void setTenPhongChieu(String tenPhongChieu) {
        this.tenPhongChieu = tenPhongChieu;
    }

    @Override
    public String toString() {
    	return this.tenPhongChieu;
    }
}
