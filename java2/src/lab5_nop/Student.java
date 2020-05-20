/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_nop;

import java.io.Serializable;

/**
 *
 * @author thanh
 */
     public class Student implements Serializable {

        public String name;
        public double diem;
        public String hocLuc;

        public Student(String name, double diem, String hocLuc) {
            this.name = name;
            this.diem = diem;
            this.hocLuc = hocLuc;
        }

        public String getGrade() {
            if (this.diem < 3) {
                return "kém";
            }
            if (this.diem < 5) {
                return "yếu";
            }
            if (this.diem < 7.5) {
                return "khá";
            }
            if (this.diem < 6.5){
                return "trung bình";
            }
            if (this.diem < 9) {
                return "giỏi";
            }
            return "xuất sắc";
        }
        public boolean isBonus(){
            return this.diem >= 7.5;
        }
    }

