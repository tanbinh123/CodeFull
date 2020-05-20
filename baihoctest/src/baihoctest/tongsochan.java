//viết chương trình tính tổng các số chẵn từ 2 đến  N (nhập từ bàn phím là số nguyên dương)
package baihoctest;

import java.util.*;
/**
 *
 * @author thanh
 */
public class tongsochan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("N =");
        int N = sc.nextInt();
        int sum = 0;
        for(int i = 0; i<N; i++ ){
            if(i%2 ==0){
                sum = sum + i;
            }
                    
        }
           System.out.println("sum = " + sum);     
    }
}
