/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;


/**
 *
 * @author Welcome
 */
public class xArray {
    
    static  Scanner sc = new Scanner(System.in);

    public static void swap(int[] a, int i, int j)  {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void swap(double[] a, int i, int j)  {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void swap(String[] a, int i, int j)  {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static int min(int[] a) {
        int min = a[0];
        for (int i = 0; i <= a.length -1; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
    public static double min(double[]a ){
        double min = a[0];
        for(int i = 0; i <= a.length -1; i++){
            if (a[i] < min){
                 min = a[i];
            }
        }
         return min;
    }
    public static int max(int[] a){
        int max = a[0];
        for (int i = 0; i <= a.length -1; i++){
            if (a[i] > max){
                max = a[i];
            }
        }
    return max;
    }
    
    public  static  double max(double[] a){
        double max = a[0];
        for(int i = 0; i <= a.length -1; i++){
            if (a[i] > max){
              max = a[i];
            }
        }
        return max;
    }

    public static int[] remove(int[] a, int i) {
        int b[] = new  int[a.length - 1];
        System.arraycopy(a, 0, b, 0, i);
        System.arraycopy(a, i + 1, b, i, a.length - i -1);
        return b;
    }
    public static double[] remove(double[] a, int i) {
        double b[] = new double[a.length -1];
        System.arraycopy(a, 0, b, 0, i);
        System.arraycopy(a, i + 1, b, i, a.length - i -1);
        return b;
    }
    public static String[] remove(String[] a, int i) {
        String b[] =new String[a.length -1];
        System.arraycopy(a, 0, b, 0, i);
        System.arraycopy(a, i + 1, b, i, a.length -i -1);
        return b;
    }
    
    public  static int[] add(int[] a, int x){
        int b[] = new int[a.length +1];
        System.arraycopy(a, 0, b, 0, a.length +1);
        b[a.length +1] = x;
        return b;
    }
    public static double[] add(double[] a, double x ) {
        double b[] = new double[a.length +1];
        System.arraycopy(a, 0, b, 0, a.length +1);
        b[a.length +1] = x;
        return b;
    }
    public static String[] add(String[] a, String x ) {
        String b[] = new String[a.length +1];
        System.arraycopy(a, 0, b, 0, a.length +1);
        b[a.length +1] = x;
        return b;
    }

}

            
