package com.happyrecipek.web.com.system.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *@author KYJ
 *@since 2019-02-03
 * Common File Utils
 **/
public final class DateUtil {
	private static final GregorianCalendar gc = new GregorianCalendar();
	
	/**
	 *@author KYJ
	 *@since 2019-02-03
	 *@param  
	 *@return String(currentDate)
	 **/
	public static final String getCurrentDate() {
		String currentDate = String.valueOf(System.currentTimeMillis());
		return currentDate;
	}
	
	/**
	 *@author KYJ
	 *@since 2019-02-03
	 *@param  
	 *@return String(year)
	 **/
	public static final String getYear() {
		String year = String.valueOf(gc.get(Calendar.YEAR));
		return year;
	}
	
	/**
	 *@author KYJ
	 *@since 2019-02-03
	 *@param  
	 *@return String(month)
	 **/
	public static final String getMonth() {
		String month = String.valueOf(gc.get(Calendar.MONTH)+1);
		return month;
	}
	
	/**
	 *@author KYJ
	 *@since 2019-02-03
	 *@param  
	 *@return String(day)
	 **/
	public static final String getDay() {
		String day = String.valueOf(gc.get(Calendar.DATE));
		return day;
	}
}
