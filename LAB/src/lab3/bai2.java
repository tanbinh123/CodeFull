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
public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a");
        double a=sc.nextDouble();
        System.out.println("Nhập b");
        double b=sc.nextDouble();
        System.out.println("Nhập c");
        double c=sc.nextDouble();
        if (a==0){
            if ( b == 0 ){
                if ( c == 0){
                    System.out.println("Phuong trinh vo so nghiem");
                } else {
                    System.out.println("Phuong trinh vo nghiem");
                }
            } else{
                double  x = -c/b;
                System.out.println("Phuong trinh co mot nghiem : " + x);
            }
        } else{
            double delta = ( b * b) - ( 4 * a * c);
            if ( delta < 0){
                System.out.println("Phuong trinh vo nghiem");
            } else if ( delta == 0){
                double x = - b/ ( 2*a);
                System.out.println("Phuong trinh co nghiem kep : " + x);
            } else {
                double canDelta =Math.sqrt(delta);
                double x1 = ( - b + canDelta) / ( 2 * a );
                double x2 = (- b - canDelta) / ( 2 * a );
                System.out.println("Phuong trinh co hai nghiem phan biet : ");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            
        }  
    }
    }
    }
    
    

