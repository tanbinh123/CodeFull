/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.helper;

import com.cinema.dialog.SonDialogMessage;
import java.awt.Container;

/**
 *
 * @author thanh
 */
public class SonOptionPane {   
    
    public static final int INFO = 1;
    public static final int WARNING = 0;
    
    public static void showMessage(Container parent, String message, int option){
        new SonDialogMessage(parent, message, option);
    }
}
