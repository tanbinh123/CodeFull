/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author thanh
 */
public class Student {
    private String maSinhVien;
    private String tenSinhVien;
    private float tiengAnh;
    private float tinHoc;
    private float giaoDucTC;
    private float diemTrungBinh;
    private String Email;
    private String SDT;
    private String hinh;
    private boolean gioiTinh;
    private String diaChi;
    
    public Student(){
        
    }
    
    public Student(String maSinhVien, String tenSinhVien, String Email, String SDT,boolean gioiTinh, String diaChi,String hinh,float tiengAnh, float tinHoc, float giaoDucTC, float diemTrungBinh){
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.Email = Email;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.tinHoc = tinHoc;
        this.giaoDucTC = giaoDucTC;
        this.tiengAnh = tiengAnh;
        this.diemTrungBinh = diemTrungBinh;
        
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(float tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(float tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGiaoDucTC() {
        return giaoDucTC;
    }

    public void setGiaoDucTC(float giaoDucTC) {
        this.giaoDucTC = giaoDucTC;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    
    
    
    
}
