/**
 * 
 */
package com.bs.beyond.core.util;

//import org.apache.log4j.Logger;

/**
 * 
 *
 */
public class CheckUtil
{
	
//	private Logger logger = Logger.getLogger(CheckUtil.class);

	private static final String REG_NUMBER = "^[-\\+]?[\\d]*$";

	private static final String REG_DOUBLE = "^[-\\+]?[.\\d]*$";
	
//	private static final String REG_UNICODE_JP_CHARACTER = "[\u3041-\u30fe]+";
	
	/**
	 * check if the parameter is a number or not
	 * @param str
	 * @return boolean -
	 * 			true : the parameter is a number.
	 * 			false: the parameter is not a number.
	 */
	public static final boolean isNumeric(String str)
	{
		boolean bIsNum = false;

		if (str != null && str.trim().length() != 0)
			bIsNum = str.matches(REG_NUMBER);
		else
			return false;
		
		
		
		return bIsNum;
	}

	/**
	 * check if the parameter is a double number or not
	 * @param str
	 * @return boolean -
	 * 			true : the parameter is a double number.
	 * 			false: the parameter is not a double number.
	 */
	public static final boolean isDouble(String str)
	{
		boolean bIsNum = false;

		if (str != null && str.trim().length() != 0)
			bIsNum = str.matches(REG_DOUBLE);
		else
			return false;
		
		
		
		return bIsNum;
	}
	
	/**
	 * check if the parameter is a number or not
	 * @param str
	 * @return boolean -
	 * 			true : the parameter is a number.
	 * 			false: the parameter is not a number.
	 */
	public static final boolean isCharacter(String str)
	{
		boolean bIsNum = false;

		// TODO 

		return bIsNum;
	}

	/**
	 * check if the parameter is a XXXX or not
	 * @param str
	 * @return boolean -
	 * 			true : the parameter is a XXX.
	 * 			false: the parameter is not a XXX.
	 */
	public static final boolean isHiraganaFull(String str)
	{
		boolean bIsHiraganaFull = false;

		// TODO 

		return bIsHiraganaFull;
	}

	/**
	 * check if the parameter is a XXXX or not
	 * @param str
	 * @return boolean -
	 * 			true : the parameter is a XXX.
	 * 			false: the parameter is not a XXX.
	 */
	public static final boolean isHiraganaHalf(String str)
	{
		boolean bIsHiraganaHalf = false;

		// TODO 

		return bIsHiraganaHalf;
	}

	/**
	 * check if the parameter is a XXXX or not
	 * @param str
	 * @return boolean -
	 * 			true : the parameter is a XXX.
	 * 			false: the parameter is not a XXX.
	 */
	public static final boolean isKanaFull(String str)
	{
		boolean bIsKanaFull = false;

		// TODO 

		return bIsKanaFull;
	}

	/**
	 * check if the parameter is a XXXX or not
	 * @param str
	 * @return boolean -
	 * 			true : the parameter is a XXX.
	 * 			false: the parameter is not a XXX.
	 */
	public static final boolean isKanaHalf(String str)
	{
		boolean bIsKanaHalf = false;

		// TODO 
		
		return bIsKanaHalf;
	}
	

	/**
	 * check if the parameter's length is right or not
	 * 
	 * @param str - String for check
	 * @param length - Required length
	 * @return boolean -
	 * 			true : the parameter's length is right.
	 * 			false: the parameter's length is not right.
	 */
	public static final boolean isLengthRequired(String str, int length)
	{
		boolean bIsRightLength = false;

		if (length == str.length())
		{
			bIsRightLength = true;
		}

		return bIsRightLength;
	}

	/**
	 * check if the parameter's length fit the condition or not.
	 * 
	 * @param str - String for check
	 * @param length - Required length
	 * @return boolean -
	 * 			true : the parameter's length is right.
	 * 			false: the parameter's length is not right.
	 */
	public static final boolean isLengthRequired(String str, String strCondition, int length)
	{
		boolean bIsRightLength = false;

//		if (length == str.length())
//		{
//			bIsRightLength = true;
//		}

		return bIsRightLength;
	}
}
