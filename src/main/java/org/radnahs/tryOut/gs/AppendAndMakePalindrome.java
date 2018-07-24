/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.tests.gs </p>
 * <p>File Name: AppendAndMakePalindrome.java</p>
 * <p>Create Date: Apr 24, 2015 </p>
 * <p>Create Time: 5:39:16 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.gs;

/**
 * @author Shantanu Sikdar 
 *
 */
public class AppendAndMakePalindrome {

	private boolean isPalindrome(String isPalindrmStr){
		int start=0,length=isPalindrmStr.length(),end=length-1;
		while(start<end){
			if(isPalindrmStr.charAt(start)!=isPalindrmStr.charAt(end)){
				return false;
			}
			start++;end--;			
		}
		return true;
	}
	
	private String appendAndMakePalindrome(String appeder, String originalStr){
		if(isPalindrome(appeder+originalStr)){
			return appeder+originalStr;
		}else{
			return null;//need to finish
		}
	}
	
	
	public static void main(String[] args) {
		AppendAndMakePalindrome aamp = new AppendAndMakePalindrome();
		System.out.println(aamp.isPalindrome("shahs"));
		System.out.println(aamp.isPalindrome("naan"));
		System.out.println(aamp.isPalindrome("naen"));
		System.out.println(aamp.isPalindrome("naesaen"));
	}

}

