package com.hpzc.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换工具类
 * @author 张江立
 *
 */
public class DateUtils {
	
	/**
	 * 按传入的格式化规则格式化传入的日期
	 * @author 张江立
	 * @param date : 传入日期对象
	 * @param dateFormat : 格式化规则(如：yyyy-MM-dd,yyyyMMdd等，如果传空或NULL则默认为yyyy-MM-dd)
	 * @return String
	 */
	public static String formatDate(Date date, String dateFormat){
		if (null == date) {
			return null;
		}
		
		if (null == dateFormat && "".equals(dateFormat)) {
			dateFormat="yyyy-MM-dd";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String formatDateAfterStr = sdf.format(date);
		
		return formatDateAfterStr;
	}
	
	/**
	 * 传入日期添加天数
	 * @param date : 日期对象
	 * @param days : 天数
	 * @return Date
	 */
	@SuppressWarnings("static-access")
	public static Date addDays(Date date, int days){
		if (null == date) {
			return null;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, days);
		return calendar.getTime();
	}
	
	/**
	 * 日期字符串转成日期对象
	 * @param dateString; 如："2012-12-06"
	 * @param dateFormat : 格式化规则(如：yyyy-MM-dd)
	 * @return Date
	 */
	public static Date stringToDate(String dateString, String dateFormat){
		Date date = null;
		if (null == dateString || "".equals(dateString) 
				|| null == dateFormat || "".equals(dateFormat)) {
			return date;
		}
		
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);  
		    date = sdf.parse(dateString);  
		}  
		catch (ParseException e)  
		{  
			 System.out.println(e.getMessage());
			 return date;
		}
		
		return date;
	}
}
