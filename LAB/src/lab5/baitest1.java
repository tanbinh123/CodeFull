
package lab5;

import java.util.*;
/**
 *
 * @author thanh
 */
public class baitest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a[] = new int[5];
        int max , min;
        int tong = 0;
        int dem = 0;
        double trungbinhcong;
        //nhập
        
        for (int T = 0; T<5; T++){
            System.out.print("nhập a [" + T +"]= ");
            a[T]= sc.nextInt();
            
        }
        max = min = a[0];
        for(int T = 0; T<5; T++){
            if (a[T]>max){
                max = a[T];
            }
            if (a[T]<min){
                 min = a[T];
            }
            if(a[T]%3==0){
                tong = tong + a[T];
                dem++;
            }
            
        }  
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        trungbinhcong = tong/dem;
        System.out.println("trung bình cộng là = " + trungbinhcong);
        
        for (int i = 0; i < 5-1;i++){
            for (int j = i+1;j<5;j++){
                if (a[i]>a[j]){
                    //đổ
        }
        max = min = a[0];
        for(int T = 0; T<5; T++){
            if (a[T]>max){
                max = a[T];
            }
            if (a[T]<min){
                 min = a[T];
            }
            if(a[T]%3==0){
                tong = tong + a[T];
                dem++;
            }
            
        }  
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        trungbinhcong = tong/dem;
        System.out.println("trung bình cộng là = " + trungbinhcong);
        
        for (int S = 0; S<a.length;S++){
                     S = a[S];
                    a[i] = a[j];
                    a[j] = S;
                }
                
            }
        }
            
        for (int i =0; i<a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
        
}
