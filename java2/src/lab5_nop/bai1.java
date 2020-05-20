/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_nop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class bai1 {

    public static byte[] read(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            int n = fis.available();
            byte[] data = new byte[n];
            fis.read(data);
            fis.close();
            return data;
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }

        return null;

    }

    public static byte[] write(String xuat) {

        try {
            FileOutputStream fos = new FileOutputStream(xuat);
            int n = fos.hashCode();
            byte[] data = new byte[n];
            fos.write(data);
            fos.close();

        } catch (Exception ex) {
            Logger.getLogger(bai1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Object readObject(String path) {
        try {
            ObjectInputStream ios = new ObjectInputStream(new FileInputStream(path));
            Object object = ios.readObject();
            ios.close();
            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeObject(String path, Object object) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


