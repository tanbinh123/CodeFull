
package com.httcinema.model;


public class VaiTro {
    private String maVaiTro;
    private String tenVaiTro;
    private String moTa;

    public VaiTro() {
    }

    public VaiTro(String maVaiTro, String tenVaiTro, String moTa) {
        this.maVaiTro = maVaiTro;
        this.tenVaiTro = tenVaiTro;
        this.moTa = moTa;
    }

    public String getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(String maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    @Override
    public String toString() {
    	return this.tenVaiTro;
    }
    
}
