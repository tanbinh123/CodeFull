/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface55;

/**
 *
 * @author thanh
 */
public class mayBay implements mayMoc{

    @Override
    public void mauSac() {
        System.out.println("bạc");
    }

    @Override
    public double congSuat() {
        return 7000;
    }

    @Override
    public double giaThanh() {
        return 7000;
    }

    @Override
    public String doNhienLieu() {
        return "dầu";
    }
    
}
