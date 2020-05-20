/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author thanh
 */
public class XArrays {
    public static void swap(int [] a , int  i, int  j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
        public static int min (int []a){
            int min = a[0];
            for(int i = 0; i < a.length; i++){
                if(a[i] < min){
                    min = a[i];
                }
            }
            return min;
            }
            public static int[] add(int [] a,int x){
                int b [] = new int [a.length + 1];
               System.arraycopy(a, 0, b, 0, a.length);
               b[a.length] = x;
               return b;
            }
                
                    public static int [] remove(int [] a, int i){
                        int b[] = new int [a.length - 1];
                        System.arraycopy(a,0,b,0,i);
                        System.arraycopy(a, i + 1, b ,i,a.length-i-1);
                        return b;
                    
                
        
                    }
}
