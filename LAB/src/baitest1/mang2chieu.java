
package baitest1;

import java.util.*;
/**
 *
 * @author thanh
 */
public class mang2chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String hoten[]= new String[10];
        int hang = 10;
        int cot = 2;
        int a [][]= new int [hang][cot];
        for(int S = 0; S < hang; S++){
                System.out.print("họ  và tên: ");
                hoten[S]= sc.nextLine();
                System.out.print("điểm lý thuyết: " + (S+1) +" " );
                a[S][0]= sc.nextInt();
                System.out.print("điểm thực hành: " + (S+1) + " ");
                a[S][1]= sc.nextInt();
            
        }
       for(int G = 0; G < hang; G++){
           System.out.println("điểm lý thuyết sinh viên: " + (G+1) + " " + a[G][1]);
           System.out.println("điểm thực hành sinh viên: " + (G+1) + " " + a[G][0] );
       }
       
    }
}
