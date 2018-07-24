/**
 * Project: tryOut
 * Package Name:package org.radnahs.tryOut.mscSoftware;
 * File Name: LargestPalindrome.java
 * Create Date: Mar 15, 2017
 * Create Time: 2:58:29 PM
 * Copyright: Copyright (c) 2016
 * @author: Shantanu Sikdar, ssikdar
 * @version 1.0
 */
package org.radnahs.tryOut.mscSoftware;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to find the largest palindrome in the given string. The given
 * string should be treated as variable and can change for each program run.
 * 
 * input: 123456ShanSikd210345543012efcdfXDFsikdarradkis23842sdc34r output:
 * there are tow palindrome found in the above
 * 
 * 210345543012 sikdarradkis
 * 
 * @author Shantanu Sikdar
 * 
 */

public class LargestPalindrome {

	public boolean isPalindrome(String str) {
		char[] chaArr = str.toCharArray();
		for (int i = 0, j = chaArr.length - 1; i < j; i++, j--) {
			if (!(chaArr[i] == chaArr[j])) {
				return false;
			}
		}
		return true;
	}

	public void allSubStrings(String str) {
		String largestSubstring = "";
		Set<String> largstStrngLst = new HashSet<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 1; j <= str.length() - i; j++) {
				String sub = str.substring(i, i + j);
				// System.out.println(sub);
				if (isPalindrome(sub)) {
					System.out.println(sub + "   -- " + sub.length());
					largestSubstring = largestSubstring.length() < sub.length() ? sub
							: largestSubstring;
					largstStrngLst.add(largestSubstring);
				}
			}
		}
		System.out.println(largstStrngLst);
		// System.out.println(largestSubstring);
	}

	public static void main(String[] args) {
		LargestPalindrome lp = new LargestPalindrome();
		// System.out.println(lp.isPalindrome("shanahs"));
		// System.out.println(lp.isPalindrome("shan"));
		// lp.allSubStrings("DFsikdarradkis23");
		// lp.allSubStrings("123456ShanSikd210345543012efcdfXDFsikdarradkis23842sdc34r");
		lp.allSubStrings("HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE");
		//System.out.println(lp.getLongestPalindrome("HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE"));
	}

	public String getLongestPalindrome(final String input) {

		int rightIndex = 0, leftIndex = 0;
		String currentPalindrome = "", longestPalindrome = "";
		try {
			for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
				leftIndex = centerIndex - 1;
				rightIndex = centerIndex + 1;
				while (leftIndex >= 0 && rightIndex < input.length()) {
					if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
						break;
					}
					currentPalindrome = input.substring(leftIndex,rightIndex + 1);
					longestPalindrome = currentPalindrome.length() > longestPalindrome.length() ? currentPalindrome : longestPalindrome;
					leftIndex--;
					rightIndex++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return longestPalindrome;
	}

}
