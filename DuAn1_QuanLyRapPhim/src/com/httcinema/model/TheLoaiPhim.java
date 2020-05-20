
package com.httcinema.model;

import java.util.Objects;

public class TheLoaiPhim {
    private int maTheLoai;
    private String tenTheLoai;

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 17 * hash + Objects.hashCode(this.maTheLoai);
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

		final TheLoaiPhim other = (TheLoaiPhim) obj;
		if (!Objects.equals(this.maTheLoai, other.maTheLoai)) {
			return false;
		}

		return true;
	}
    
    public TheLoaiPhim() {
    }

    public TheLoaiPhim(int maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
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
}
