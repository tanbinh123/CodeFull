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
public class SinhVienBiz extends SinhVienPoly {
    float mkt,sales;
    public SinhVienBiz(String hoten, String nganh, float mkt, float sales ) {
        super(hoten, nganh);
        this.mkt = mkt;
        this.sales = sales;
    }

    @Override
    float getDiem() 
    {
        return (mkt*2 + sales)/3;
    }
}
