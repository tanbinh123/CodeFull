/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastwing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class hello extends JFrame {

    public hello() {
        setSize(200, 150);
        setVisible(true);
        JLabel label = new JLabel("hello world");
        add(label);
    }
    public static void main(String[] args) {
        hello hl = new hello();
        
    }
}
