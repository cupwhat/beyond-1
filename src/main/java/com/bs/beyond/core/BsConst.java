package com.bs.beyond.core;

public class BsConst
{

	public static class ResultCode
	{
		public static final String SUCCESS = "1";
		public static final String FAIL = "0";
	}

	public static class DateTimeFormat
	{
		/**
		 * DateTime Format String yyyy-MM-dd HH:mm:ss
		 */
		public static final String DATE_TIME_HYPHEN = new String("yyyy-MM-dd HH:mm:ss");

		/**
		 * DateTime Format String yyyy/MM/dd HH:mm:ss
		 */
		public static final String DATE_TIME_SLASH = new String("yyyy/MM/dd HH:mm:ss");
		/**
		 * DateTime Format String yyyy-MM-dd
		 */
		public static final String DATE_YYYY_MM_DD_HYPHEN = new String("yyyy-MM-dd");
		/**
		 * DateTime Format String yy-MM-dd
		 */
		public static final String DATE_YY_MM_DD_HYPHEN = new String("yy-MM-dd");
		/**
		 * DateTime Format String yy-MM-dd
		 */
		public static final String DATE_YY_MM_DD_SLASH = new String("yy/MM/dd");
		/**
		 * DateTime Format String yyyyMMdd
		 */
		public static final String DATE_YYYY_MM_DD = new String("yyyyMMdd");
		/**
		 * DateTime Format String yyMMdd
		 */
		public static final String DATE_YY_MM_DD = new String("yyMMdd");
		/**
		 * DateTime Format String HH:mm:ss
		 */
		public static final String TIME_HH_MM_SS_COLON = new String("HH:mm:ss");
		/**
		 * DateTime Format String HHmmss
		 */
		public static final String TIME_HH_MM_SS = new String("HHmmss");

		/**
		 * DateTime Format String gyyMMdd
		 * 和暦年号
		 */
		public static final String DATE_G_YY_MM_DD = new String("gyyMMdd");
	}

}
