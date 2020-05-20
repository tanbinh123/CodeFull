/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baihoctest;

import java.util.Scanner;

public class kiemtra {
    String nhapten;
    int nhaptuoi;
    Scanner sc = new Scanner(System.in);
    public void nhap(){
        System.out.println("nhập họ tên: ");
         nhapten = sc.nextLine();
        System.out.println("nhập tuổi: ");
         nhaptuoi = sc.nextInt();
    }
    public void xuat(){
            System.out.println("tên: "+nhapten);
            System.out.println("tuổi: "+nhaptuoi);
}

}
