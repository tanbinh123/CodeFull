/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author thanh
 */
public class ClienThread {

    public static void main(String[] args) {
        class ClientThread implements Runnable {

            Socket client;
            JTextArea txtServer;
            InputStream in;
            BufferedInputStream bi;
            DataInputStream dis;
            OutputStream out;

            public ClientThread(Socket client, JTextArea txtServer) {
                this.client = client;
                this.txtServer = txtServer;
                try {
                    in = client.getInputStream();
                    bi = new BufferedInputStream(in);
                    dis = new DataInputStream(bi);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void run() {
                String s = " ";
                while (true) {
                    try {
                        s = dis.readLine();

                        txtServer.append(s + " " + " ");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        class ServerThread implements Runnable {

            Socket client;
            JTextArea txtClient;
            InputStream in;
            BufferedInputStream bi;
            DataInputStream dis;

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
    }
}