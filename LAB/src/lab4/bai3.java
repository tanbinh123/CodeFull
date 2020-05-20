/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.*;
/**
 *
 * @author thanh
 */
public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double N = sc.nextDouble();
        boolean soNguyenTo = true;
        double i = 2;
        for( ;i<N/2;i++){
            if(N%i==0){
                soNguyenTo = false;
                break;
            }
        }
    }
}
