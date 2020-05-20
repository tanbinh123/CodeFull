// tìm ước chung lớn nhất từ các số nhập từ bàn phím
package baihoctest;

import java.util.*;

/**
 *
 * @author thanh
 */
public class bai9 {
    //định nghĩa hàm ước chung lớn nhất
    public static int comDiv(int a, int b){
        return (b==0)?a:comDiv(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        int a = sc.nextInt();
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.println("ước chung lớn nhất của"+" "+a+" va"+" "+b+" là: " + comDiv(a,b));
    }
}
