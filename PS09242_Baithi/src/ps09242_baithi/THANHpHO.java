/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps09242_baithi;

/**
 *
 * @author thanh
 */
public class THANHpHO {
    private int maThanhPho;
    private String tenThanhPho;
    
    public THANHpHO(){
        
    }
    
    public THANHpHO(int maThanhPho, String tenThanhPho){
        this.maThanhPho=maThanhPho;
        this.tenThanhPho=tenThanhPho;
    }

    public int getMaThanhPho() {
        return maThanhPho;
    }

    public void setMaThanhPho(int maThanhPho) {
        this.maThanhPho = maThanhPho;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }
    
}
