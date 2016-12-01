/**
 * 
 */
package com.bs.beyond.core.util;

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
public class GengoInfo
{
	/**
	 * 元号数字標識
	 */
	int gengoIndex;
	/**
	 * 元号
	 */
	String gengo;
	/**
	 * 元号
	 */
	int gengoYear;
	/**
	 * 和暦日付 : 元号数字標識 + 元号年 + 月日
	 * 		eg: 4210912 ⇒ 平成21年9月12日(2009年09月12日)
	 */
	String gengoDate;
	/**
	 * 西暦日付
	 */
	String gregorianDate;

	/**
	 * 
	 * @return
	 */
	public int getGengoIndex()
	{
		return this.gengoIndex;
	}
	/**
	 * 
	 * @param gengoIndex
	 */
	public void setGengoIndex(int gengoIndex)
	{
		this.gengoIndex = gengoIndex;
	}
	/**
	 * 
	 * @return
	 */
	public String getGengo()
	{
		return this.gengo;
	}
	/**
	 * 
	 * @param gengo
	 */
	public void setGengo(String gengo)
	{
		this.gengo = gengo;
	}
	/**
	 * 
	 * @return
	 */
	public int getGengoYear()
	{
		return this.gengoYear;
	}
	/**
	 * 
	 * @param gengoYear
	 */
	public void setGengoYear(int gengoYear)
	{
		this.gengoYear = gengoYear;
	}

	/**
	 * 和暦日付 : 元号数字標識 + 元号年 + 月日
	 * 
	 * @return 和暦日付 : 元号数字標識 + 元号年 + 月日
	 */
	public String getGengoDate()
	{
		return this.gengoDate;
	}
	/**
	 * 和暦日付 : 元号数字標識 + 元号年 + 月日
	 * 
	 * @param gengoDate
	 */
	public void setGengoDate(String gengoDate)
	{
		this.gengoDate = gengoDate;
	}
	/**
	 * 西暦日付
	 * @return gregorianDate
	 */
	public String getGregorianDate()
	{
		return this.gregorianDate;
	}
	/**
	 * 西暦日付
	 * @param gregorianDate
	 */
	public void setGregorianDate(String gregorianDate)
	{
		this.gregorianDate = gregorianDate;
	}
}