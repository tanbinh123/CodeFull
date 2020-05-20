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
public class sinhVienIT extends SinhVienPoly{  

    float java, html, css;

    public sinhVienIT(String hoten, String nganh, float java, float html, float css) {
        super(hoten, nganh);
        this.java=java;
        this.html=html;
        this.css=css;
    }

    @Override
    float getDiem() 
    {
        return (java*2+html+css)/4;
    }
    
}
