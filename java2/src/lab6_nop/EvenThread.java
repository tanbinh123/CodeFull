/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_nop;

/**
 *
 * @author thanh
 */
public class EvenThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }
   
}
