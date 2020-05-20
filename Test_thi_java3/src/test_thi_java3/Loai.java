/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_thi_java3;

/**
 *
 * @author thanh
 */
public class Loai {
    private int maLoai;
    private String tenLoai;

    public Loai(int maLoai, String tenLoai){
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public Loai(){
        
    }
    
    
    
    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    
}
