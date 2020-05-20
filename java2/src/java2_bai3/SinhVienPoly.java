/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_bai3;

/**
 *
 * @author locth
 */
public abstract class SinhVienPoly {
    String hoten;
    String nganh;
    
    SinhVienPoly(String hoten, String nganh)
    {
        this.hoten=hoten;
        this.nganh=nganh;
    }
    abstract float getDiem();
    String getHocluc()
    {
        if(getDiem()<5)
            return "yeu";
        else if (getDiem()<6.5)
            return "Trung binh";
        else if (getDiem()<7.5)
            return "Kha";
        else if (getDiem()<9)
            return "Gioi";
        else if (getDiem()>=9)
            return "Xuat xac";
       
        return "Null";
    }
    
    String xuat()
    {
        return "Ho ten: "+hoten +   " Nganh: "+nganh + "Diem tb: "+getDiem() + " hoc luc: " +getHocluc();
    }
}