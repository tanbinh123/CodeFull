/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_buôi5;

/**
 *
 * @author locth
 */
public class SV {
    String name;
    int tuoi;
    static int soluong;
    SV(){
        soluong++;
    }
    SV(String name, int tuoi){
        this.name=name;
        this.tuoi=tuoi;
        soluong++;
    }
    
}
