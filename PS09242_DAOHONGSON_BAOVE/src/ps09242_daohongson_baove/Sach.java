/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps09242_daohongson_baove;

import java.io.Serializable;

/**
 *
 * @author thanh
 */
public class Sach implements Serializable{
    private String maSach;
    private String tenSach;
    private String theLoai;
    private boolean hinhThuc;
    
    public Sach(){
        
    }
    
    public Sach(String maSach, String tenSach, String theLoai, boolean hinhThuc){
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.hinhThuc = hinhThuc;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public boolean isHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(boolean hinhThuc) {
        this.hinhThuc = hinhThuc;
    }
    
}
