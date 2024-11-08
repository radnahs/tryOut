/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.aktana </p>
 * <p>File Name: OrderedAlhabetOccurence.java</p>
 * <p>Create Date: 24-Jun-2020 </p>
 * <p>Create Time: 10:56:02 am </p>
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
 *         solution that, given a string S consisting of N letters 'a' and/or
 *         'b' returns true when all occurrences of letter 'a' are before all
 *         occurrences of letter 'b' and returns false otherwise.
 * 
 *         Examples: 1. Given S = "aabbb", the function should return true.
 * 
 *         2. Given S = "ba", the function should return false.
 * 
 *         3. Given S = "aaa", the function should return true. Note that 'b'
 *         does not need to occur in S.
 * 
 *         4. Given S = "b", the function should return true. Note that 'a' does
 *         not need to occur in S.
 * 
 *         5. Given S = "abba", the function should return false. Write an
 *         efficient algorithm for the following assumptions:
 * 
 *         N is an integer within the range [1..300,000]; string S consists only
 *         of the characters 'a' and/or 'b'.
 */

public class OrderedAlhabetOccurence {

	public static void main(String[] args) {
		System.out.println(solution("aaabb"));
		System.out.println(solution("aababb"));
	}

	public static boolean solution(String str) {
		boolean val = true;
		char[] chr = str.toCharArray();
		for (int i = 0, j = 1; i < chr.length - 1; i++, j++) {
			System.out.println(chr[i] + " " + chr[j]);
			if (chr[j] < chr[i]) {
				val = false;
				break;
			} /*
				 * else { val = true; continue; }
				 */
		}

		return val;
	}

}
