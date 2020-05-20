
package newpackage;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Keyboard {

    public static String readString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String a = sc.nextLine();
        return a;
    }
    
       public static double readDouble(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        double a = sc.nextDouble();
        return a;
    }
        public static double readInt(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        int a = sc.nextInt();
        return a;
    }
}
