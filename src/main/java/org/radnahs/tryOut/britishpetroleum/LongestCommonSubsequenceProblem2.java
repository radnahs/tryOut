/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.britishpetroleum </p>
 * <p>File Name: LongestCommonSubsequenceProblem2.java</p>
 * <p>Create Date: 11-Feb-2022 </p>
 * <p>Create Time: 9:18:20 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.britishpetroleum;

import java.util.Scanner;

/**
 * @author : Shantanu Sikdar
 * 
 *         https://www.javatpoint.com/longest-common-subsequence-in-java
 */

public class LongestCommonSubsequenceProblem2 {

	public static String findLengthOfLCS(String str1, String str2) {
		int p = str1.length();
		int q = str2.length();

		int[][] tableForLCS = new int[p + 1][q + 1];

		for (int i = 0; i <= p; i++) {
			for (int j = 0; j <= q; j++) {
				if (i == 0 || j == 0) {
					tableForLCS[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					tableForLCS[i][j] = tableForLCS[i - 1][j - 1] + 1;
				} else {
					tableForLCS[i][j] = Math.max(tableForLCS[i - 1][j], tableForLCS[i][j - 1]);
				}
			}
		}
		int index = tableForLCS[p][q];
		int temp = index;
		char[] longestCommonSubsequence = new char[index + 1];
		longestCommonSubsequence[index] = '\0';

		int i = p, j = q;
		String lcs = "";
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				longestCommonSubsequence[index - 1] = str1.charAt(i - 1);
				i--;
				j--;
				index--;
			} else if (tableForLCS[i - 1][j] > tableForLCS[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		for (int k = 0; k <= temp; k++) {
			lcs = lcs + longestCommonSubsequence[k];
		}
		return lcs.trim();
	}

	public static void main(String[] args) {

		String str1, str2, LCS;

		Scanner sc = new Scanner(System.in); // System.in is a standard input stream.
		System.out.print("Enter first sequence: ");
		str1 = sc.nextLine(); // reads string.

		System.out.print("Enter second sequence: ");
		str2 = sc.nextLine(); // reads string.

		LCS = findLengthOfLCS(str1, str2);

		System.out.print("Sequence1: " + str1 + "\nSequence2: " + str2);
		System.out.println("\nLCS: " + LCS);

	}

}
