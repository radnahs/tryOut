/**
 * <p>Project: org.radnahs.tryOut.thoughtworks.merchantToGalaxy.util </p>
 * <p>Package Name: org.radnahs.tryOut.thoughtworks.merchantToGalaxy.util </p>
 * <p>File Name: RomanNumber.java </p>
 * <p>Create Date: Apr 18, 2017 </p>
 * <p>Create Time: 8:41:12 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.thoughtworks.merchantToGalaxy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Shantanu Sikdar
 */
public final class RomanNumber {

	private RomanNumber(){}

	public static boolean isRomanNumeral(String romanNumber){
		boolean isNum = false;
		String regex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		if(romanNumber.matches(regex)){
			isNum = true;
		}
		return isNum;
	}
	
	public static int romanToDecimal(String s) {
	    /*if (s == null || s.isEmpty() || !s.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))
	        return -1;*/
		if (s == null || s.isEmpty() || !isRomanNumeral(s))
	        return -1;

	    final Matcher matcher = Pattern.compile("M|CM|D|CD|C|XC|L|XL|X|IX|V|IV|I").matcher(s);
	    final int[] decimalValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    final String[] romanNumerals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    int result = 0;

	    while (matcher.find())
	        for (int i = 0; i < romanNumerals.length; i++)
	            if (romanNumerals[i].equals(matcher.group(0)))
	                result += decimalValues[i];

	    return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(RomanNumber.isRomanNumeral("XIV"));
		System.out.println(RomanNumber.isRomanNumeral("VV"));
		System.out.println(RomanNumber.isRomanNumeral("III"));
		System.out.println(RomanNumber.isRomanNumeral("XXXIIX"));

		System.out.println(RomanNumber.romanToDecimal("XIV"));
		System.out.println(RomanNumber.romanToDecimal("VV"));
		System.out.println(RomanNumber.romanToDecimal("III"));
		System.out.println(RomanNumber.romanToDecimal("XXXIIX"));
		System.out.println(RomanNumber.romanToDecimal("XLII"));
	}

}
