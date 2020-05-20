/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Online_lab7;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.Socket;
import java.nio.Buffer;
import javax.swing.JTextArea;

/**
 *
 * @author thanh
 */
public class ServerThread {

    Socket client = new Socket();
    JTextArea txtClient = new JTextArea();
    public Object dis;

    public ServerThread(Socket client, JTextArea txtClient) {
        this.client = client;
        this.txtClient = txtClient;
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            BufferedInputStream bi = new BufferedInputStream(in);
            bi = new BufferedInputStream(in);
            dis = new DataInputStream(bi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String s = "";
        while (true) {
            try {
                s = dis.toString();
                txtClient.append(s + "");
            } catch (Exception ex) {
               
            }
        }
    }
}

