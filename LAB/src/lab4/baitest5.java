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
public class baitest5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double diem = 0;
        do{
            diem = sc.nextDouble();
        }
        while (diem > 10 || diem < 0);
            System.out.println("điểm là: " + diem);
        }
    
    }
