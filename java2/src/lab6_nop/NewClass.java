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
public class NewClass {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 my1 = new MyThread2();
        Thread t = new Thread(my1);
        
        //mythread1
        MyThread my2 = new MyThread();
        
        t.start();
        MyThread.sleep(500);
        my2.start();
        
    }
}
