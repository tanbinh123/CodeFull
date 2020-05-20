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
public class chuongtrinh {
    public static void main(String[] args) {
        int a[] = {1,2,5,6,7};
        int b [] = XArrays.remove(a, 2);
        for(int i = 0; i < a.length; i++){
        System.out.print(b[i] + " ");
    }
    }
}
