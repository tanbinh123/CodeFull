/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienich.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author DauTay
 */


    public class DateHelper {

        static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

        /**
         * * Chuyển đổi String sang Date * @param date là String cần chuyển *
     * @param date
     * @param pattern   *  là định dạng thời gian * @return Date kết quả PROJECT
         * DOCUMENT SAMPLE PROJECT - ỨNG DỤNG PHẦN MỀM PAGE 44          *
     * @return date 
         */
        public static Date toDate(String date, String... pattern) {
            try {
                if (pattern.length > 0) {
                    
                    DATE_FORMATER.applyPattern(pattern[0]);
                    
                }
                if (date == null) {
                    return DateHelper.now();
                }
                System.out.println(date);
                return DATE_FORMATER.parse(date);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }

        /**
         * * Chuyển đổi từ Date sang String * @param date là Date cần chuyển đổi
         * * @param pattern là định dạng thời gian * @return String kết quả
     * @param date
     * @param pattern
     * @return String
         */
        public static String toString(Date date, String... pattern) {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                date = DateHelper.now();
            }
            return DATE_FORMATER.format(date);
        }

        /**
         * * Lấy thời gian hiện tại * @return Date kết quả
          @return date
         */
        public static Date now() {
            return new Date();
        }

        /**
         * * Bổ sung số ngày vào thời gian * @param date thời gian hiện có *
     * @param date
         * @param days số ngày cần bổ sung váo date * @return Date kết quả
     * @return date
         */
        public static Date addDays(Date date, int days) {
            date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
            return date;
        }

        /**
         * * Bổ sung số ngày vào thời gian hiện hành * @param days số ngày cần
         * bổ sung vào thời gian hiện tại * @return Date kết quả
     * @param days
     * @return date
         */
        public static Date add(int days) {
            Date now = DateHelper.now();
            now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
            return now;
        }
    }

