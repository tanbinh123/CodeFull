// nhập vào từ bàn phím và kiểm tra xem có phải số nguyên tố
package baihoctest;

import java.util.*;

public class songuyento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số: ");
        double songuyento = sc.nextDouble();
        for (int i = 2; i > songuyento; i++) {
            
            if (songuyento%i == 0 ) {
                System.out.println("Nó không phải là số nguyên tố");
            } else {
                System.out.println("nó là số nguyên tố");
                break;
            }
        }

    }
}
