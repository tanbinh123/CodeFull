package lab3;

import java.util.*;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập a: ");
        double a = sc.nextDouble();
        System.out.print("nhập b: ");
        double b = sc.nextDouble();
        if(a == 0){
    if(b == 0){
        System.out.print("vô số nghiệm");
    }
    else{
        System.out.print("vô nghiệm");
    }
    }
    else{
    double x = -b/a;
    System.out.print("x= " + x);
}
    }
}