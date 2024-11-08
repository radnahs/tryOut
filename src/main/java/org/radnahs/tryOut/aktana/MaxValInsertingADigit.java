/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.aktana </p>
 * <p>File Name: MaxValInsertingADigit.java</p>
 * <p>Create Date: 08-Nov-2024 </p>
 * <p>Create Time: 10:52:57 am </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.aktana;

/**
 * @author : Shantanu Sikdar
 *
 *         Write a function
 * 
 *         solution that, given an integer N, returns the maximum possible value
 *         obtained by inserting one '5' digit inside the decimal representation
 *         of integer N.
 * 
 *         Examples: 1. Given N = 268, the function should return 5268. 2.
 *         Givenm N = 670, the function should return 6750. 3. Given N = 0, the
 *         function should return 50. 4. Given N = −999, the function should
 *         return −5999.
 * 
 *         Assume that: N is an integer within the range [−8,000..8,000].
 * 
 *         In your solution, focus on correctness The performance of your
 *         solution will not be the focus of the assessment.
 * 
 */

public class MaxValInsertingADigit {

	public static void main(String[] args) {
		System.out.println(solution(268));// 5268
		System.out.println(solution(670));// 6750
		System.out.println(solution(444));// 6750
		System.out.println(solution(0));// 50
		System.out.println(solution(666));// 50
	}

	public static int solution(int N) {
		char[] charr = (N + "").toCharArray();
		char[] charrnew = new char[charr.length + 1];
		char constchr = '5';
		boolean isGreater = true;
		if (N < 0) {
			charrnew[0] = charr[0];
			for (int i = 1, j = 1; i < charr.length; i++, j++) {
				if (charr[i] > constchr) {
					charrnew[j] = constchr;
					j++;
				}
				charrnew[j] = charr[i];
			}
		} else {
			for (int i = 0, j = 0; i < charr.length; i++, j++) {
				if (charr[i] < constchr && isGreater) {
					charrnew[j] = constchr;
					j++;
					isGreater = false;
				}
				charrnew[j] = charr[i];
			}
		}
		return Integer.parseInt(String.copyValueOf(charrnew));
	}

}
