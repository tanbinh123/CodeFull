
package lab5;

import java.util.*;
/**
 *
 * @author thanh
 */
public class baitest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] hoten = new String[10];
        float diem [] = new float[10];
        int i = 0;
        while (true){
            System.out.print("nhập tên: ");
            sc = new Scanner(System.in);
            hoten[i] = sc.nextLine();
            System.out.print("nhập điểm: ");
            diem [i] = sc.nextFloat();
            i++;
            System.out.print("tiếp hay dừng y/n: ");
            String ch = sc.next();
            if (ch.equalsIgnoreCase("n")){
                break;
            }
        }
    }
}
