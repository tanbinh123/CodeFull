/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class demo1 {
    public static void main(String[] args)  {
        try {
            FileWriter file = new FileWriter("E:\\ud14302.txt");
            file.write("Hello các bạn");
            file.write(" I love You");
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(demo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("bắt đầu đọc file");
        try {
            FileReader out = new FileReader ("E:\\ud14302.txt");
            int x = out.read();
            while(x!=-1){
                System.out.print((char)x);
                x=out.read();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(demo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
