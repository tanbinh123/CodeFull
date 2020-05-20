/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaphuongdoituong;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class nguoi {

    private int ID;
    private String tenKhachHang;
    private String ngaySinh;

    public nguoi() {

    }

    nguoi(int ID, String tenKhachHang, String ngaSinh) {
        this.ID = ID;
        this.ngaySinh = ngaySinh;
        this.tenKhachHang = tenKhachHang;
    }

    public void nhapThongTin(Scanner sc) {
        System.out.println("Nhập số chứng minh");
        ID = sc.nextInt();
        System.out.println("Nhập tên khách hàng");
        tenKhachHang = sc.nextLine();
        System.out.println("Nhập ngày sinh");
        ngaySinh = sc.nextLine();

    }

    public void hienThongTin() {
        System.out.println(this.ID);
        System.out.println(this.tenKhachHang);
        System.out.println(this.ngaySinh);
    }
    
    public Date chuyenStringDate (String str){
        Date ns = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        try{
            ns=sdf.parse(str);
        }catch(Exception e){
            System.out.println("Lỗi định dạng thời gian!");
        }
        return ns;
    }
    
    public int getSoCMND(){
        return this.ID;
    }
    
    
    

}
