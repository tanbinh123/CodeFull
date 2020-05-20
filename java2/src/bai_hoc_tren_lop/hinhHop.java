/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_hoc_tren_lop;

/**
 *
 * @author thanh
 */
public class hinhHop extends hinh{
    int cd;
    int cr;
    int cc;
    
    hinhHop(){
        cd  = 1;
        cr = 1;
        cr = 1;
                
    }
    hinhHop(int x){
        cd = cr= cc =x;
    }
    hinhHop(int cd, int cr, int cc){
        
        // phải là hàm đầu tiên trong hàm tạo của hàm con
        super();
        this.cc = cc;
    }
    
    int tinhTheTich(){
        return cd*cr*cc;
        // hoặc tinhDienTich()*cc
    }
    String xuatTT(){
        return  super.xuatTT()+"cc: " +"the tich: "+tinhTheTich();
    }
}
