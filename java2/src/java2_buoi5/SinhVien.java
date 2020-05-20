/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_buoi5;

/**
 *
 * @author thanh
 */
public class SinhVien {

    public String hoTen;
    public double diem;
    public String hocluc;

    SinhVien(String hoTen, double diem, String nganh, String hocLuc, String thuong) {
        this.hoTen = hoTen;
        this.diem = diem;
        this.hocluc = hocLuc;
    }
    SinhVien(){
        
    }

    public String getGrade() {
        if (this.diem < 3) {
            return "kém";
        } else if (this.diem < 5) {
            return "yếu";
        } else if (this.diem < 7) {
            return "trung bình";
        } else if (this.diem < 8.5) {
            return "khá";}
        
            return "xuat xac";
        }


    public boolean isBonus() {
        return this.diem >= 7.5;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getHocluc() {
        return hocluc;
    }

    public void setHocluc(String hocluc) {
        this.hocluc = hocluc;
    }
    
    }
