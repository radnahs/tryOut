/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.codility </p>
 * <p>File Name: CountFactors.java </p>
 * <p>Create Date: 11-Mar-2020 </p>
 * <p>Create Time: 10:50:13 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.codility;

import java.util.ArrayList;
import java.util.List;

/**
 * A positive integer D is a factor of a positive integer N if there exists an
 * integer M such that N = D * M.
 * 
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition
 * (24 = 6 * 4).
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the number of its factors.
 * 
 * For example, given N = 24, the function should return 8, because 24 has 8
 * factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..2,147,483,647].
 * 
 * @author G01157921
 *
 */
public class CountFactors {

	public static void main(String[] args) {
		int N = 24;
		List<Integer> lstInt = new ArrayList<Integer>();
		int count = 0;
		for (int i = 1; i < N / 2 + 1; i++) {
			if (N % i == 0) {
				lstInt.add(i);
				count++;
			}
		}
		count++;
		lstInt.add(N);
		System.out.println(lstInt);
		System.out.println(lstInt.size());
		System.out.println(count);
	}

}
