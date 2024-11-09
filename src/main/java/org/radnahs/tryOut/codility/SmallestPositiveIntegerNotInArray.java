/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.codility </p>
 * <p>File Name: SmallestPositiveIntegerNotInArray.java</p>
 * <p>Create Date: 23-Jun-2020 </p>
 * <p>Create Time: 9:27:19 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.codility;

import java.util.Arrays;

/**
 * This is a demo task.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); } that, given an array A of N
 * integers, returns the smallest positive integer (greater than 0) that does
 * not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 * 
 * @author : Shantanu Sikdar
 *
 */
public class SmallestPositiveIntegerNotInArray {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 3, 6, 4, 1, 2 };
		Arrays.sort(A);
		int notInArr = 1;
		for (int i = 0; i < A.length; i++) {
			if (notInArr == A[i]) {
				notInArr++;
			}
		}
		System.out.println(notInArr);

	}
}
