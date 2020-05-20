/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author thanh
 */
public class baitest3 {
    public static void main(String[] args) {
        double i = 27;
        double tong = 0;
        double dem = 0;
        while(i<=250){
           if(i%3==0){
               tong = tong +i;
               dem ++;
               
           }
           i++;
        }
        double TBC = tong/dem;
        System.out.println("điểm trung bình là: " + TBC);
    }
    
}
