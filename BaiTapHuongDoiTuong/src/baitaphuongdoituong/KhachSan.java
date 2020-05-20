/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaphuongdoituong;

import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class KhachSan {

    private int soNgayTro;
    private String loaiPhongTro;
    private double giaPhong;
    nguoi Nguoi;

    public KhachSan() {

    }

    public KhachSan(int soNgayTro, String loaiPhongtro, double giaPhong, nguoi Nguoi) {
        this.soNgayTro = soNgayTro;
        this.loaiPhongTro = loaiPhongTro;
        this.Nguoi = Nguoi;
    }

    

    public void nhapThongTin(Scanner sc) {
        Nguoi = new nguoi();
        this.Nguoi.nhapThongTin(sc);
        System.out.println("Nhập số ngày trọ: ");
        this.soNgayTro = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập loại phòng trọ: ");
        this.loaiPhongTro = sc.nextLine();
        System.out.println("Nhập giá phòng: ");
        this.giaPhong = sc.nextDouble();
        sc.nextLine();
    }
    
    public void hienThongTin(){
        Nguoi.hienThongTin();
        System.out.println("Số ngày trọ: " + this.soNgayTro);
        System.out.println("Loại Phòng trọ: "+ this.loaiPhongTro);
        System.out.println("Giá phòng trọ: "+ this.giaPhong);
        
    }
    
    public double thanhTien(){
        return this.soNgayTro*this.giaPhong;
    }
    
    public nguoi getKhach(){
        return this.Nguoi;
    }
    
    public void xoa(){
        this.Nguoi = new nguoi();
        this.soNgayTro=0;
        this.loaiPhongTro=null;
        this.giaPhong=0;
    }
    
}
