/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.britishpetroleum </p>
 * <p>File Name: LongestCommonSubsequenceProblem1.java</p>
 * <p>Create Date: 11-Feb-2022 </p>
 * <p>Create Time: 9:16:54 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.britishpetroleum;

/**
 * 
 */
public class LongestCommonSubsequenceProblem1 {

	int lcs(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (X[m - 1] == Y[n - 1])
			return 1 + lcs(X, Y, m - 1, n - 1);
		else
			return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
	}

	/* Utility function to get max of 2 integers */
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		LongestCommonSubsequenceProblem1 lcs = new LongestCommonSubsequenceProblem1();
		String s1 = "XMJYAUZ";
		String s2 = "MZJAWXU";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
	}

	private static void longestCommonSubSequence() {
		String line = "XMJYAUZ;MZJAWXU";
		String[] strArr = line.split(";");
		System.out.println(strArr[0] + " " + strArr[1]);
	}

}
