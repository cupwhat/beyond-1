/**
 * 
 */
package com.bs.beyond.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bs.beyond.core.BsConst;


/**
 * @ClassName: DateTimeUtil
 * @Description: This Util is for handler the Date Time data;
 */
public final class DateTimeUtil
{

	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(DateTimeUtil.class);

	/**
	 * DateTime Format yyyy-MM-dd HH:mm:ss
	 */
	private static final SimpleDateFormat FMT_DATE_TIME_HYPHEN
		= new SimpleDateFormat(BsConst.DateTimeFormat.DATE_TIME_HYPHEN);
	/**
	 * DateTime Format yyyy/MM/dd HH:mm:ss
	 */
	private static final SimpleDateFormat FMT_DATE_TIME_SLASH
		= new SimpleDateFormat(BsConst.DateTimeFormat.DATE_TIME_SLASH);
	/**
	 * DateTime Format yyyy-MM-dd
	 */
	private static final SimpleDateFormat FMT_DATE_YYYY_MM_DD_HYPHEN
		= new SimpleDateFormat(BsConst.DateTimeFormat.DATE_YYYY_MM_DD_HYPHEN);

	/**
	 * DateTime Format HHmmss
	 */
	private static final SimpleDateFormat FMT_TIME_HH_MM_SS
		= new SimpleDateFormat(BsConst.DateTimeFormat.TIME_HH_MM_SS);
	
	/**
	 * Get current datetime of the system
	 * 
	 * @return String yyyy-MM-dd HH:mm:ss
	 */
	public static String getNow()
	{
		Calendar now = Calendar.getInstance();
		return FMT_DATE_TIME_HYPHEN.format(now);
	}

	/**
	 * Get current datetime of the system
	 * 
	 * @return String yyyy/MM/dd HH:mm:ss
	 */
	public static String getNowSlash()
	{
		Calendar now = Calendar.getInstance();
		return FMT_DATE_TIME_SLASH.format(now);
	}

	/**
	 * Get current date of the System
	 * 
	 * @return String yyyy-MM-dd
	 */
	public static String getCurrentDate()
	{
		Calendar now = Calendar.getInstance();
		return FMT_DATE_YYYY_MM_DD_HYPHEN.format(now);
	}
	
	/**
	 * Get current time of the System
	 * 
	 * @return String HH:mm:ss
	 */
	public static String getCurrentTime()
	{
		Calendar now = Calendar.getInstance();
		return FMT_TIME_HH_MM_SS.format(now);
	}


	/**
	 * Format the Date to String
	 * 
	 * @param date - Date(eg: 2009/09/12, 20090912)
	 * @param strFmt - Format(eg: "yyyy/MM/dd", "yyyyMMdd")
	 * @return Formatted Date String
	 */
	public static String formatDate(Date date, String strFmt)
	{
		SimpleDateFormat fmtDateTime = new SimpleDateFormat(strFmt);
		
		return fmtDateTime.format(date);
	}

	/**
	 * Format String to Date
	 * @param strDate - Date String (eg: "2009/09/12", "20090912")
	 * @param strFmt - Format(eg: "yyyy/MM/dd", "yyyyMMdd")
	 * @return date
	 * @throws ParseException
	 */
	public static Date toDate(String strDate, String strFmt) throws ParseException
	{
		try
		{
			SimpleDateFormat fmtDateTime = new SimpleDateFormat(strFmt);
			return fmtDateTime.parse(strDate);
		} catch (ParseException e)
		{
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Calculate the days between the begin date and the end date.
	 * 
	 * @param strBeginDate - Begin Date
	 * @param strEndDate - End Date
	 * @param strFmt - Format(eg: "yyyy/MM/dd", "yyyyMMdd")
	 * @return int - the days between the begin date and the end date.
	 * @throws ParseException
	 *             - ParseException
	 */
	public static int getDays(String strBeginDate, String strEndDate, String strFmt) throws ParseException
	{
		long lDays = 0;

		try
		{
			Date dtBegin = toDate(strBeginDate, strFmt);
			Date dtEnd = toDate(strEndDate, strFmt);

			Calendar calBegin = Calendar.getInstance();
			Calendar calEnd = Calendar.getInstance();
			
			calBegin.setTime(dtBegin);
			calEnd.setTime(dtEnd);
			
			long lTimeBegin = calBegin.getTimeInMillis();
			long lTimeEnd = calEnd.getTimeInMillis();

			lDays = (lTimeEnd - lTimeBegin) / (1000 * 60 * 60 * 24) + 1;
		}
		catch (ParseException e)
		{
			logger.error(e.getMessage());
			throw e;
		}

		return Integer.parseInt(String.valueOf(lDays));
	}
	
	/**
	 * Calculate the years between the begin date and the end date.
	 * 
	 * @param strBeginDate - Begin Date
	 * @param strEndDate - End Date
	 * @param strFmt - Format(eg: "yyyy/MM/dd", "yyyyMMdd")
	 * @return
	 * @throws ParseException
	 */
	public static int getYears(String strBeginDate, String strEndDate, String strFmt) throws ParseException
	{
		int nYears = 0;

		Date dtBegin = toDate(strBeginDate, strFmt);
		Date dtEnd = toDate(strEndDate, strFmt);
		
		nYears = getYears(dtBegin, dtEnd);
		
		return nYears;
	}

	/**
	 * Calculate the years between the begin date and the end date.
	 * 
	 * @param dtBegin - Begin Date
	 * @param dtEnd - End Date
	 * @return
	 * @throws ParseException
	 */
	public static int getYears(Date dtBegin, Date dtEnd) throws ParseException
	{
		int nYears = 0;

		Calendar calBegin = Calendar.getInstance();
		Calendar calEnd = Calendar.getInstance();
		
		calBegin.setTime(dtBegin);
		calEnd.setTime(dtEnd);
		
		nYears = calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);
		
		return nYears;
	}

	/**
	 * Compare two Datetime
	 * 
	 * @param strDateTime1
	 * @param strDateTime2
	 * @param strFmt(eg: "yyyy/MM/dd", "yyyyMMdd")
	 * @return Compare result
	 * 		-1: strDateTime1 < strDateTime2
	 * 		0: strDateTime1 = strDateTime2
	 * 		1: strDateTime1 > strDateTime2
	 * 
	 * @throws ParseException
	 */
	public static int compareTo(String strDateTime1, String strDateTime2, String strFmt) throws ParseException
	{
		int lCompareResult = 0;
		
		try
		{
			Date dt1 = toDate(strDateTime1, strFmt);
			Date dt2 = toDate(strDateTime2, strFmt);
			
			lCompareResult = dt1.compareTo(dt2);
		}
		catch (ParseException e)
		{
			logger.debug(e.getMessage());
			throw e;
		}
		
		return lCompareResult;
	}

	/**
	 * The Max Date : 9999/12/31
	 * @return
	 */
	public static Date getMaxDate()
	{
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 9999);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		
		return cal.getTime();
	}
	
}

