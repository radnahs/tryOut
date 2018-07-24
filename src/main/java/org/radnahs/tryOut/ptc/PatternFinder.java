/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.tests.ptc </p>
 * <p>File Name: PatternFinder.java</p>
 * <p>Create Date: Jun 22, 2015 </p>
 * <p>Create Time: 3:09:02 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ptc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Shantanu Sikdar 
 *
 */
public class PatternFinder {
	
	static boolean doesStringHasPattern(String givenPattern){
		boolean isPatternMatch = false;
		char[] charArr =  givenPattern.toCharArray();
		return isPatternMatch;
	}
	
	static List<String> charCheck(String givenPattern){
		List<String> strL = new ArrayList<String>();
		char[] charStr = givenPattern.toCharArray();
		for (int i = 0; i < charStr.length; i++) {
			String c = charStr[i]+"";
			if(i == 0)
				strL.add(c);
			else
				strL.add(strL.get(i-1)+c);
		}
		System.out.println(strL);
		return  strL;
	}
	
	static boolean isPattern(String[] strArr){
		boolean isPatt = false;
		for (int i = 1; i < strArr.length; i++) {
			if(strArr[i]==strArr[i-1]){
				isPatt=true;
				System.out.println("index="+i+",Val="+strArr[i]+" index="+i+",Val="+ strArr[i-1]);
			}else{
				System.out.println("index="+i+",Val="+strArr[i]+" index="+i+",Val="+ strArr[i-1]);
				isPatt=false;
				break;
			}				
		}
		return isPatt;
	}
	
	static void checkPattern(String pattString, int noOfChar){
		//pattString.
		if(noOfChar==pattString.length()/2){
			return;
		}		
	}
	
	static void divideString(String strToDivide,int beginIndex,int divideStrInSize){
		int szr = strToDivide.length();
		String[] ssArr = new String[szr];
		for(int i=0; i<szr/divideStrInSize;i++){
			int t=beginIndex+divideStrInSize;
			ssArr[i]=strToDivide.substring(beginIndex,t);
			System.out.println(ssArr[i]);
			beginIndex=beginIndex+divideStrInSize;			
		}
	}
	
	
	public static void main(String[] args) {
		PatternFinder pf = new PatternFinder();
		//PatternFinder.doesStringHasPattern("abab");
		//PatternFinder.charCheck("abab");
		//System.out.println(PatternFinder.isPattern(new String[]{"ab","ab","ab"}));
		/*List<String> strarr = PatternFinder.charCheck("abab");
		for (String string : strarr) {
			System.out.println(string);
		}*/
		//System.out.println(PatternFinder.isPattern(new String[]{"abd","abd","ab"}));
		//PatternFinder.divideString("sikdarshantanu", 0, 2);
		//PatternFinder.divideString("abab", 0, 2);
		PatternFinder.divideString("abcabc", 0, 2);
	}
	
	

}
