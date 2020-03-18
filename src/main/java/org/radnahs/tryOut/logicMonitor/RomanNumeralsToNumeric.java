/**
 * <p>Project: tryout </p>
 * <p>Package Name: com.shandar.tryout.logicMonitor </p>
 * <p>File Name: RomanNumeralsToNumeric.java </p>
 * <p>Create Date: 03-Mar-2020 </p>
 * <p>Create Time: 11:13:06 pm </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package com.shandar.tryout.logicMonitor;

/**
 * @author : Shantanu Sikdar
 *
 */
public class RomanNumeralsToNumeric {

	public static void main(String[] args) {
		decode("DCCVII");

	}

	public static Integer decode(String roman) {
		int len = roman.length();
		roman = roman + " ";
		int result = 0;
		for (int i = 0; i < len; i++) {
			char ch = roman.charAt(i);
			char nextChar = roman.charAt(i + 1);

			if (ch == 'M') {
				result += 1000;
			} else if (ch == 'C') {
				if (nextChar == 'M') {
					result += 900;
					i++;
				} else if (nextChar == 'D') {
					result += 400;
					i++;
				} else {
					result += 100;
				}
			} else if (ch == 'D') {
				result += 500;
			} else if (ch == 'X') {
				if (nextChar == 'C') {
					result += 90;
					i++;
				} else if (nextChar == 'L') {
					result += 40;
					i++;
				} else {
					result += 10;
				}
			} else if (ch == 'L') {
				result += 50;
			} else if (ch == 'I') {
				if (nextChar == 'X') {
					result += 9;
					i++;
				} else if (nextChar == 'V') {
					result += 4;
					i++;
				} else {
					result++;
				}
			} else {
				result += 5;
			}
		}

		return result;
	}

}
