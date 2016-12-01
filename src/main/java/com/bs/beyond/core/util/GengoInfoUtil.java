/**
 * 
 */
package com.bs.beyond.core.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.bs.beyond.core.BsConst;
import com.bs.beyond.core.exception.BsException;

/**
 * 元号情報
 * 
 * 明治：
 * 1868/01/01 - 1912/07/30
 * (改元の詔書が出されたのは1868/9/8)
 * (1912/07/30は明治の終了日とともに大正の開始日だが、
 *  計算では明治の終了日は1912/07/29とする）
 * 
 * 大正：
 * 1912/07/30 - 1926/12/25
 * (1926/12/24は大正の終了日とともに大正の昭和日だが、
 *  計算では大正の終了日は1926/12/24とする）
 * 
 * 昭和：
 * 1926/12/25 - 1989/01/07
 * 
 * 平成:
 * 1989/01/08 - 
 * 
 * @author Administrator
 */
public class GengoInfoUtil
{
	/**
	 * 元号数字標識 : 空
	 */
	public static final int GENGO_INDEX_NONE = 0;
	/**
	 * 元号数字標識 : 明治
	 */
	public static final int GENGO_INDEX_MEIJI = 1;
	/**
	 * 元号数字標識 : 大正
	 */
	public static final int GENGO_INDEX_TAISHOU = 2;
	/**
	 * 元号数字標識 : 昭和
	 */
	public static final int GENGO_INDEX_SHOUWA = 3;
	/**
	 * 元号数字標識 : 平成
	 */
	public static final int GENGO_INDEX_HEISEI = 4;

	/**
	 * 元号 : 空
	 */
	public static final String GENGO_NONE = "";
	/**
	 * 元号 : 明治
	 */
	public static final String GENGO_MEIJI = "明治";
	/**
	 * 元号 : 大正
	 */
	public static final String GENGO_TAISHOU = "大正";
	/**
	 * 元号 : 昭和
	 */
	public static final String GENGO_SHOUWA = "昭和";
	/**
	 * 元号 : 平成
	 */
	public static final String GENGO_HEISEI = "平成";

	/**
	 * 開始年 : 明治
	 */
	public static final int GENGO_MEIJI_START_YEAR = 1868;
	/**
	 * 開始年 : 大正
	 */
	public static final int GENGO_TAISHOU_START_YEAR = 1912;
	/**
	 * 開始年 : 昭和
	 */
	public static final int GENGO_SHOUWA_START_YEAR = 1926;
	/**
	 * 開始年 : 平成
	 */
	public static final int GENGO_HEISEI_START_YEAR = 1989;

	/**
	 * 西暦日付より、元号日付を取得する
	 * eg: 20090912 ⇒ 4210912 （2009年:平成21年）
	 *     19890107 ⇒ 3640107 （1989年1月7日:昭和64年1月7日）
	 *     19890108 ⇒ 4010108 （1989年1月8日:平成１年（元年）1月8日）
	 * 
	 * @param strGregorianDate - 西暦日付
	 * @return 元号日付
	 * @throws BsException 
	 * @throws ParseException 
	 */
	public static String getGengoDate(String strGregorianDate) throws ParseException, BsException
	{
		// 引数のフォーマットをチェックする。
		if (!CheckUtil.isNumeric(strGregorianDate)
			|| BsConst.DateTimeFormat.DATE_YYYY_MM_DD.length() != strGregorianDate.length())
		{
			throw new BsException(
				"Invalid Date！ " + strGregorianDate
				+ ". The right format is " + BsConst.DateTimeFormat.DATE_YYYY_MM_DD + ".");
		}
		
		// 元号情報
		Date dt = DateTimeUtil.toDate(BsConst.DateTimeFormat.DATE_YYYY_MM_DD, strGregorianDate);
		GengoInfo gengoInfo = getGengoInfo(dt);

		// 元号数字標識をチェックする。
		if (gengoInfo.getGengoIndex() == GENGO_INDEX_NONE)
		{
			throw new BsException(
				"Invalid Date！ " + strGregorianDate
				+ ". The right format is " + BsConst.DateTimeFormat.DATE_YYYY_MM_DD + ".");
		}
		
		return gengoInfo.getGengoDate();
	}

	/**
	 * 元号日付より、西暦日付を取得する
	 * eg: 4210912 ⇒20090912（2009年:平成21年）
	 *     3640107 ⇒ 19890107（1989年1月7日:昭和64年1月7日）
	 *     4010108 ⇒19890108 （1989年1月8日:平成１年（元年）1月8日）
	 * 
	 * @param strGengoDate - 元号日付
	 * @return 西暦日付
	 * @throws BsException 
	 * @throws ParseException 
	 */
	public static String getGregorianDate(String strGengoDate) throws BsException, ParseException
	{
		// 引数のフォーマットをチェックする。
		if (!CheckUtil.isNumeric(strGengoDate)
			|| BsConst.DateTimeFormat.DATE_G_YY_MM_DD.length() != strGengoDate.length())
		{
			throw new BsException(
				"Invalid Date！ " + strGengoDate
				+ ". The right format is " + BsConst.DateTimeFormat.DATE_G_YY_MM_DD + ".");
		}
		
		String strGregorianDate = "";
		
		String strGengoIndex = strGengoDate.substring(0, 1);
		String strGengoYear = strGengoDate.substring(1, 3);
		String strMonthDay = strGengoDate.substring(3, 7);
		
		String strGregorianYear = getGregorianYear(strGengoIndex, strGengoYear);
		
		strGregorianDate = strGregorianYear + strMonthDay;
		return strGregorianDate;
	}

	/**
	 * 日付より、元号情報を取得する
	 * 
	 * TODO 平成天皇が退位するかも
	 * 
	 * @param gengoIndex
	 * @return 元号情報
	 * @throws ParseException 
	 * @throws BsException 
	 */
	public static GengoInfo getGengoInfo(Date dtGregorian) throws ParseException
	{
		int nGengoIndex = GENGO_INDEX_NONE;
		int nGengoYear = 0;
		Date dtGengoStart = null;
		String strGengo = GENGO_NONE;
		
		Date dtMeijiStart = getMeijiStartDate();
		Date dtTaishouStart = getTaishouStartDate();
		Date dtShouwaStart = getShouwaStartDate();
		Date dtHeiseiStart = getHeiseiStartDate();
		Date dtMaxDate = DateTimeUtil.getMaxDate();
		
		if (dtGregorian.compareTo(dtMeijiStart) < 0)
		{
			nGengoIndex = GENGO_INDEX_NONE;
			strGengo = GENGO_NONE;
			dtGengoStart = null;
		}
		else if (dtGregorian.compareTo(dtMeijiStart) >= 0
			&& dtGregorian.compareTo(dtTaishouStart) < 0)
		{
			nGengoIndex = GENGO_INDEX_MEIJI;
			strGengo = GENGO_MEIJI;
			dtGengoStart = dtMeijiStart;
		}
		else if (dtGregorian.compareTo(dtTaishouStart) >= 0
			&& dtGregorian.compareTo(dtShouwaStart) < 0)
		{
			nGengoIndex = GENGO_INDEX_TAISHOU;
			strGengo = GENGO_TAISHOU;
			dtGengoStart = dtTaishouStart;
		}
		else if (dtGregorian.compareTo(dtShouwaStart) >= 0
			&& dtGregorian.compareTo(dtHeiseiStart) < 0)
		{
			nGengoIndex = GENGO_INDEX_SHOUWA;
			strGengo = GENGO_SHOUWA;
			dtGengoStart = dtShouwaStart;
		}
		else if (dtGregorian.compareTo(dtHeiseiStart) >= 0
			&& dtGregorian.compareTo(dtMaxDate) <= 0)	// <=
		{
			nGengoIndex = GENGO_INDEX_HEISEI;
			strGengo = GENGO_HEISEI;
			dtGengoStart = dtHeiseiStart;
		}

		if (dtGengoStart != null)
		{
			nGengoYear = DateTimeUtil.getYears(dtGengoStart, dtGregorian) + 1;
		}
		
		/***     ***/
		Calendar calGregorian = Calendar.getInstance();
		calGregorian.setTime(dtGregorian);
		
		GengoInfo gengoInfo = new GengoInfo();
		gengoInfo.setGengoIndex(nGengoIndex);
		gengoInfo.setGengoYear(nGengoYear);
		gengoInfo.setGengo(strGengo);

		String strGengoDate
			= getGengoDateString(
				nGengoIndex,
				nGengoYear,
				(calGregorian.get(Calendar.MONTH) + 1),
				calGregorian.get(Calendar.DAY_OF_MONTH));
		
		gengoInfo.setGengoDate(strGengoDate);

		String strGregorianDate
			= DateTimeUtil.formatDate(
				dtGregorian, BsConst.DateTimeFormat.DATE_YYYY_MM_DD);
		gengoInfo.setGregorianDate(strGregorianDate);
		
		return gengoInfo;
	}

	/**
	 * 元号数字標識と元号年より、西暦年を取得する。
	 * 
	 * @param strGengoIndex - 元号数字標識
	 * @param strGengoYear - 元号年
	 * @return
	 * @throws BsException 
	 */
	public static String getGregorianYear(String strGengoIndex, String strGengoYear) throws BsException
	{
		int nGregorianYear = 0;
		
		int nGregorianBaseYear = 0;
		int nGengoIndex = Integer.parseInt(strGengoIndex);
		int nGengoYear = Integer.parseInt(strGengoYear);

		// 元号数字標識
		if (nGengoIndex != GENGO_INDEX_MEIJI
			|| nGengoIndex != GENGO_INDEX_TAISHOU
			|| nGengoIndex != GENGO_INDEX_SHOUWA
			|| nGengoIndex != GENGO_INDEX_HEISEI)
		{
			throw new BsException(
				"Invalid Gengo Index！ " + strGengoIndex
				+ ". The right value is in 1,2,3,4.");
		}

		//明治
		if (GENGO_INDEX_MEIJI == nGengoIndex)
		{
			if (nGengoYear >= 1 || nGengoYear <= 45)
			{
				nGregorianBaseYear = GENGO_MEIJI_START_YEAR;
			}
		}
		//大正
		else if (GENGO_INDEX_TAISHOU == nGengoIndex)
		{
			if (nGengoYear >= 1 || nGengoYear <= 15)
			{
				nGregorianBaseYear = GENGO_TAISHOU_START_YEAR;
			}
		}
		//昭和
		else if (GENGO_INDEX_SHOUWA == nGengoIndex)
		{
			if (nGengoYear >= 1 || nGengoYear <= 64)
			{
				nGregorianBaseYear = GENGO_SHOUWA_START_YEAR;
			}
		}
		//平成
		else if (GENGO_INDEX_HEISEI == nGengoIndex)
		{
			//9999が無限大の値とする。TODO 平成天皇が退位するかも
			if (nGengoYear >= 1 || nGengoYear <= 9999)	
			{
				nGregorianBaseYear = GENGO_HEISEI_START_YEAR;
			}
		}

		nGregorianYear = nGregorianBaseYear + nGengoYear - 1;

		// 計算した西暦年をチェックする
		if (nGregorianYear < GENGO_MEIJI_START_YEAR
			|| nGregorianYear > 9999)
		{
			throw new BsException(
				"Invalid Gengo Index and Gengo Year！ " 
				+ "Gengo Index : " + strGengoIndex
				+ "Gengo Year : " + strGengoYear);
		}

		return String.valueOf(nGregorianYear);
	}
	
	/**
	 * 元号数字標識より、元号を取得する
	 * 
	 * @param gengoIndex
	 * @return 元号
	 */
	public static String getGengo(int gengoIndex)
	{
		String strGengo = "";
		switch (gengoIndex)
		{
			case GENGO_INDEX_MEIJI:
				strGengo = GENGO_MEIJI;
				break;
			case GENGO_INDEX_TAISHOU:
				strGengo = GENGO_TAISHOU;
				break;
			case GENGO_INDEX_SHOUWA:
				strGengo = GENGO_SHOUWA;
				break;
			case GENGO_INDEX_HEISEI:
				strGengo = GENGO_HEISEI;
				break;
			default:
				strGengo = "";
		}
		
		return strGengo;
	}

	/**
	 * 元号より、元号数字標識を取得する
	 * 
	 * @param gengoIndex
	 * @return 元号数字標識
	 */
	public static int getGengoIndex(String gengo)
	{
		int nGengo = GENGO_INDEX_NONE;
		switch (gengo)
		{
			case GENGO_MEIJI:
				nGengo = GENGO_INDEX_MEIJI;
				break;
			case GENGO_TAISHOU:
				nGengo = GENGO_INDEX_TAISHOU;
				break;
			case GENGO_SHOUWA:
				nGengo = GENGO_INDEX_SHOUWA;
				break;
			case GENGO_HEISEI:
				nGengo = GENGO_INDEX_HEISEI;
				break;
			default:
				nGengo = GENGO_INDEX_NONE;
		}
		
		return nGengo;
	}

	/**
	 * 明治　開始日
	 * @return
	 */
	protected static Date getMeijiStartDate()
	{
		Calendar cal = Calendar.getInstance();

		// 1868年1月1日
		cal.set(Calendar.YEAR, GENGO_MEIJI_START_YEAR);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	/**
	 * 大正　開始日
	 * @return
	 */
	protected static Date getTaishouStartDate()
	{
		Calendar cal = Calendar.getInstance();
		
		// 1912年6月30日
		cal.set(Calendar.YEAR, GENGO_TAISHOU_START_YEAR); 
		cal.set(Calendar.MONTH, 5); 
		cal.set(Calendar.DAY_OF_MONTH, 30); 
		
		return cal.getTime();
	}
	/**
	 * 昭和　開始日
	 * @return
	 */
	protected static Date getShouwaStartDate()
	{
		Calendar cal = Calendar.getInstance();
		
		// 1926年12月25日
		cal.set(Calendar.YEAR, GENGO_SHOUWA_START_YEAR); 
		cal.set(Calendar.MONTH, 11); 
		cal.set(Calendar.DAY_OF_MONTH, 25); 
		
		return cal.getTime();
	}
	/**
	 * 平成 　開始日
	 * @return
	 */
	protected static Date getHeiseiStartDate()
	{
		Calendar cal = Calendar.getInstance();
		
		// 1989年1月8日
		cal.set(Calendar.YEAR, GENGO_HEISEI_START_YEAR);
		cal.set(Calendar.MONTH, 0); 
		cal.set(Calendar.DAY_OF_MONTH, 8); 
		
		return cal.getTime();
	}

	/**
	 * 年号年月日を組み合わせ
	 * 
	 * @param nGengoIndex - 年号数字標識
	 * @param nGengoYear - 年号年
	 * @param nMonth - 月
	 * @param nDay - 日
	 * @return 年号年月日 (eg: 4210912⇒平成21年9月12日)
	 */
	protected static String getGengoDateString(
		int nGengoIndex, int nGengoYear, int nMonth, int nDay)
	{
		String strGengoIndex = String.valueOf(nGengoIndex);
		String strGengoYear = String.format("%02d", nGengoYear);
		String strMonth = String.format("%02d", nMonth);
		String strDay = String.format("%02d", nDay);
		
		return strGengoIndex + strGengoYear + strMonth + strDay;
	}

}