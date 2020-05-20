
package newpackage;

import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class Keyboard {
    
        
    public static String readString(String message) {
        Scanner sc = new  Scanner(System.in);
        System.out.println(message);
        String a = sc.nextLine();
        return a;
    }
    
    public static int readInt(String message){
        Scanner sc = new  Scanner(System.in);
        System.out.println(message);
        int a = sc.nextInt();
        return a;
    }

    public static double readDouble(String message){
        Scanner sc = new  Scanner(System.in);
        System.out.println(message);
        double a = sc.nextDouble();
        return a;
    }

    public static boolean readBoolean(String message){
        Scanner sc = new  Scanner(System.in);
        System.out.println(message);
        boolean a = sc.nextBoolean();
        return a;
    }
}
 
