package com.httcinema.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {
	static final SimpleDateFormat DATE_FORMATER_DATE = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Chuyển đổi String sang Date
	 * 
	 * @param date    là String cần chuyển
	 * @param pattern là định dạng thời gian
	 * @return Date kết quả
	 */
	public static Date toDate(String date, String... pattern) {
		try {
			if (pattern.length > 0) {
				DATE_FORMATER_DATE.applyPattern(pattern[0]);
			}
			if (date == null) {
				return DateHelper.now();
			}
			return DATE_FORMATER_DATE.parse(date);
		} catch (ParseException ex) {
			return null;
		}
	}

	/**
	 * Chuyển đổi từ Date sang String
	 * 
	 * @param date    là Date cần chuyển đổi
	 * @param pattern là định dạng thời gian
	 * @return String kết quả
	 */
	public static String toString(Date date, String... pattern) {
		if (pattern.length > 0) {
			DATE_FORMATER_DATE.applyPattern(pattern[0]);
		}
		if (date == null) {
			date = DateHelper.now();
		}
		return DATE_FORMATER_DATE.format(date);
	}

	/**
	 * Lấy thời gian hiện tại
	 * 
	 * @return Date kết quả
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * Bổ sung số ngày vào thời gian
	 * 
	 * @param date thời gian hiện có
	 * @param days số ngày cần bổ sung váo date
	 * @return Date kết quả
	 */
//	public static Date addDays(Date date, int days) {
//		date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
//		return date;
//	}

	/**
	 * Bổ sung số ngày vào thời gian hiện hành
	 * 
	 * @param days số ngày cần bổ sung vào thời gian hiện tại
	 * @return Date kết quả
	 */
	public static Date add(int days) {
		Date now = DateHelper.now();
		now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
		return now;
	}
	
	/**
	 * Lấy tuổi dựa vào ngày sinh nhật
	 * 
	 * @param date ngày sinh nhật
	 * @return int kết quả tuổi
	 */
    public static int calculateAge(Date date) {
    	// parse Date to LocalDate
    	LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	
        if ((birthDate != null)) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
    
    /**
     * Tính số lượng ngày cách ngày hiện tại
     * 
	 * @param date 	ngày truyền vào
	 * @return int 	kết quả khoảng cách từ ngày hiện tại đến date,
	 * 				nếu kết bằng 0 thì ngày truyền vào là ngày hôm nay,
	 * 			 	nếu kết quả lớn hơn 0 thì ngày truyền vào là ngày của sau hôm nay,
	 * 				nếu kết quả nhỏ hơn 0 thì ngày truyền vào là ngày của trước hôm nay,
     * */
    public static int calculateDayDistance(Date date) {
    	// parse Date to LocalDate
    	LocalDate datePoint = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	
        if ((datePoint != null)) {
            return Period.between(LocalDate.now(), datePoint).getDays();
        } else {
            return 0;
        }
    }
    
    /**
	 * add days to date in java
	 * @param date
	 * @param days
	 * @return
	 */
    public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
}
