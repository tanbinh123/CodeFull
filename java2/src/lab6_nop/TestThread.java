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
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        
        EvenThread my1 = new EvenThread();
        Thread t = new Thread(my1);
        
        
        Oddthread my2 = new Oddthread();
        Oddthread.sleep(10);
        
        t.start();
        t.join();
        my2.start();
        
    }
}
