/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_nop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanh
 */
public class main {

    public static void main(String[] args) {
        byte[] data = bai1.read("E:\\Nike.jpg");

        System.out.println(data);

        bai1.read("E:\\Nike.jpg");

        List<Student> list = new ArrayList<Student>();
        list.add(new Student("tuấn", 5, "CNTT"));
        list.add(new Student("Cường", 7.5, "TKTW"));
        list.add(new Student("Hạnh", 8.5, "CNTT"));
        bai1.writeObject("E:\\lab5.txt", list);
        List<Student> list2 = (List<Student>) bai1.readObject("E:\\lab5.txt");
        for (Student sv : list) {
            System.out.println(">Họ và tên: " + sv.name);
        }

    }
}
