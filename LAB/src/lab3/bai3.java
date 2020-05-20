/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.*;
/**
 *
 * @author thanh
 */
public class bai3 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("số điện là: ");
        double sodien = sc.nextDouble();
    if (sodien < 50){
        double tiendien = sodien*1000;
        System.out.print("tiền điện là: " + tiendien);
    }else{
        double tiendien = 50*1000+(sodien-50)*1200;
        System.out.println("tiền điện là: " + tiendien);
    }
  
    }
    
}
