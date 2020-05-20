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
public class Oddthread extends Thread{

    @Override
    public void run() {
        super.run(); 
        
        for(int i = 0; i<10; i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
    
    
}
