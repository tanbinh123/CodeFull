
package lab5;

import java.util.*;
/**
 *
 * @author thanh
 */
public class baitest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hang = 3;
        System.out.println("số hàng bằng: " + hang);
        int cot = 2;
        System.out.println("số cột bằng: " + cot);
        int matran[][]= new int [hang][cot];
        for (int G = 0;G<hang;G++){
            for (int S = 0; S < cot;S++ ){
                matran[G][S]=sc.nextInt();
            }
            System.out.println();
        }
        for(int T = 0; T < hang; T++){
            for (int N = 0; N < cot;N++){
                
                System.out.print(matran[T][N] * matran[T][N]+" ");
            }
            System.out.println();
        }
        
    }
}
