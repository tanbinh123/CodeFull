/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaphuongdoituong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachSan> ds;
        int n;
        
        System.out.println("Nhập số lượng khách trọ");
        n = sc.nextInt();
        sc.nextLine();
        ds = new ArrayList<KhachSan>(n);
        KhachSan b;
        for (int i = 0; i < n; i++) {
                b = new KhachSan();
            b.nhapThongTin(sc);
            ds.add(b);
        }
        System.out.println("Danh Sách Khách trọ: ");
        for (KhachSan d : ds) {
            d.hienThongTin();
            String tim;
            System.out.println("Nhập số chứng minh nhân dân khách hàng cần thanh toán: ");
            tim = sc.nextLine();
        }
        
    }
}
