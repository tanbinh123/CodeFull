package baihoctest;

import java.util.*;

public class tinhptbac2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, x1, x2, del = 0;
        System.out.print("a = ");
        a = sc.nextDouble();
        System.out.print("b = ");
        b = sc.nextDouble();
        System.out.print("c = ");
        c = sc.nextDouble();
        if (a == 0 && b == 0 && c == 0) {

            System.out.println("phương trình vô số nghiệm");
        } else {
            System.out.println("phương trình vô nghiệm");

        }
        if (b != 0) {
            System.out.println("phương trình có nghiệm = " + (-c / b));
        } else {
            del = b * 2 - 4 * a * c;
            System.out.println("del = " + del);
        }
        if (del < 0) {
            x1 = x2 = -b / (2 * a);
            System.out.println("phương trình có nghiệm kép: " + x1);
        } else {
            x1 = (double) (-b + Math.sqrt(del)) / (2 * a);
            x2 = (double) (-b + Math.sqrt(del)) / (2 * a);
            System.out.println("Phương trình 2 nghiệm: \n x1= " + x1 + "\n x2 = " + x2);
        }
    }
}



