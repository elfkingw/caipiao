package com.richie.caipiao.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static int parseDate(String thedate) throws ParseException {
		DateFormat objDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = objDateFormat.parse(thedate);
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.setTime(date);
		int dayOfWeek = objCalendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek-1;
	}
	public static String format(Date date) throws ParseException {
		DateFormat objDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = objDateFormat.format(date);
		return dateStr;
	}

	public static void main(String[] args) {
		try{
			DateUtil util = new DateUtil();
			System.out.println(util.parseDate("2012-10-13"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
