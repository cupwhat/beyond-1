package com.bs.beyond;

import java.util.Locale;

public class AppConst {

	/**
	 * 
	 */
	public static final String BEYOND_TOKEN = "BEYOND_TOKEN";
	
	public static final Locale locale;

	public static class URL
	{
		public static final String VIEW_MAIN = "main";
		public static final String VIEW_LOGIN = "login";
		public static final String VIEW_REGISTER = "register";
		public static final String VIEW_TEST = "test";
	}
	
	static
	{
		locale = Locale.ENGLISH;
	}
	
}
