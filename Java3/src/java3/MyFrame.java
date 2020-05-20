/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author thanh
 */
public class MyFrame  extends Frame implements ActionListener{
    Button bt1, bt2;
    Label lb;
    
    public MyFrame(){
        bt1=new Button("bt1");
        bt2=new Button("bt2");
        lb=new Label("lb");
        this.setLayout(new FlowLayout());
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        this.add(bt1);
        this.add(bt2);
        this.add(lb);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String chuoi = e.getActionCommand();
        if(chuoi.equals("bt1")){
            
        }if(chuoi.equals("bt2")){
            
        }
    }
}















