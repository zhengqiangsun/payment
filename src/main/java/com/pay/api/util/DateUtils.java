package com.pay.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @author zhengqiangsun
 */
public final class DateUtils {
	//
	private static AtomicReference<DateTimeProvider> PROVIDER = new AtomicReference<DateTimeProvider>(new DefaultDateTimeProvider());

	//
	private static final int MIN_YEAR = 0;
	private static final int MAX_YEAR = 9999;
	private static final int MIN_MONTH = 0;
	private static final int MAX_MONTH = 11;
	private static final int MIN_DAY_OF_MONTH = 1;
	private static final int MAX_DAY_OF_MONTH = 31;
	private static final int DAYS_OF_MONTH[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	
	/**
	 * 
	 */
	public static Date currentDate() {
		return date(now());
	}
	
	public static Date currentTime() {
		return now();
	}
	
	public static long currentTimeInMillis() {
		return now().getTime();
	}
	
	/**
	 * 
	 */
	public static boolean isLeapYear(Date date) {
		return isLeapYear(getYear(date));
	}

	public static boolean isLeapYear(int year) {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.isLeapYear(year);
	}
	
	public static boolean isSameDay(Date d1, Date d2) {
		//
		assertNotNull(d1, "invalid parameter d1");
		assertNotNull(d2, "invalid parameter d2");
		
		//
		return date(d1).equals(date(d2));
	}
	
	public static boolean isValidDate(int year, int month, int dayOfMonth) {
		//
		if (year < MIN_YEAR || year > MAX_YEAR) {
			return false;
		}
		if (month < MIN_MONTH || month > MAX_MONTH) {
			return false;
		}
		if (dayOfMonth < MIN_DAY_OF_MONTH || dayOfMonth > MAX_DAY_OF_MONTH) {
			return false;
		}
		
		//
		if (month == 1) {
			if (isLeapYear(year)) {
				if(dayOfMonth > 29) {
					return false;
				}
			} else {
				if(dayOfMonth > 28) {
					return false;
				}
			}
		} else {
			if(dayOfMonth > DAYS_OF_MONTH[month]) {
				return false;
			}
		}
		
		//
		if(year == 1582 && month == 9 && (dayOfMonth >= 5 && dayOfMonth <= 14)) {
			return false;
		}
		
		//
		return true;
	}
	
	/**
	 * 
	 */
	public static Date date(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	public static java.sql.Date toSqlDate(Date date) {
		if(date == null) {
			return null;
		} else {
			return new java.sql.Date(date.getTime());
		}
	}
	
	public static Date valueOf(java.sql.Date date) {
		if(date == null) {
			return null;
		} else {
			return new Date(date.getTime());
		}
	}
	
	public static java.sql.Timestamp toTimestamp(Date date) {
		if(date == null) {
			return null;
		} else {
			return new java.sql.Timestamp(date.getTime());
		}
	}
	
	public static Date valueOf(java.sql.Timestamp timestamp) {
		if(timestamp == null) {
			return null;
		} else {
			return new Date(timestamp.getTime());
		}
	}
	
	public static Date valueOf(int year, int month, int dayOfMonth) {
		// Precondition checking
		if(!isValidDate(year, month, dayOfMonth)) {
			throw new IllegalArgumentException("invalid parameters, year: " + year + ", month: " + month + ", dayOfMonth: " + dayOfMonth);
		}
		
		//
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 
	 */
	public static int getYear(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH);
	}
	
	public static int getDayOfMonth(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getHourOfDay(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinute(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}
	
	public static int getSecond(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}
	
	public static int getMilliSecond(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MILLISECOND);
	}
	
	/**
	 * 
	 */
	public static Date addYear(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, delta);
		return c.getTime();
	}
	
	public static Date addMonth(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, delta);
		return c.getTime();
	}
	
	public static Date addDayOfMonth(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, delta);
		return c.getTime();
	}
	
	public static Date addHourOfDay(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, delta);
		return c.getTime();
	}
	
	public static Date addMinute(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, delta);
		return c.getTime();
	}
	
	public static Date addSecond(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.SECOND, delta);
		return c.getTime();
	}
	
	public static Date addMilliSecond(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MILLISECOND, delta);
		return c.getTime();
	}
	
	/**
	 * 
	 */
	public static DateTimeProvider getProvider() {
		return PROVIDER.get();
	}

	public static void setProvider(DateTimeProvider provider) {
		PROVIDER.set(provider);
	}

	/**
	 * 
	 */
	private static Date now() {
		return getProvider().now();
	}
	
	private static void assertNotNull(Date date, String message) {
		if(date == null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 
	 */
	public static interface DateTimeProvider {
		
		Date now();
	}
	
	public static class DefaultDateTimeProvider implements DateTimeProvider {

		public Date now() {
			return new Date();
		}
	}
	
	public static Date valueOf(String date){
		Date rtn = null;
		try {
			rtn = new Date(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rtn; 
	}
	/**
	 * 日期转成字符串.
	 *
	 * @param date
	 *            the date
	 * @param pattern
	 *            the pattern
	 * @return the string
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);

	}
	/**
	 * 判断日期是星期几（返回值为1-7星期一是1）
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static int getweekNum(Calendar date){
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		int result=0;
		try {
			Date sun = sdf.parse("2016-09-18");
			cal.setTime(sun);
	        int timeDay=cal.get(Calendar.DAY_OF_WEEK);
	       
	        if(timeDay==1){
	        	result=date.get(Calendar.DAY_OF_WEEK)-1;
	    		if(result==0){
	    			result=7;
	    		}
	        }else{
	        	result=date.get(Calendar.DAY_OF_WEEK);
	        }
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
        return result;
	}
	
	public static String generateGiftCardPwd(int length){
		return String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10.0, length - 1)));
	}
}
