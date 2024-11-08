/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.codility </p>
 * <p>File Name: ArraysCyclicRotation.java </p>
 * <p>Create Date: 12-Mar-2020 </p>
 * <p>Create Time: 10:45:35 pm </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.codility;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means
 * that each element is shifted right by one index, and the last element of the
 * array is moved to the first place. For example, the rotation of array A = [3,
 * 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6
 * is moved to the first place).
 * 
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right K times.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int[] A, int K); }
 * 
 * that, given an array A consisting of N integers and an integer K, returns the
 * array A rotated K times.
 * 
 * For example, given
 * 
 * A = [3, 8, 9, 7, 6] K = 3 the function should return [9, 7, 6, 3, 8]. Three
 * rotations were made:
 * 
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7] [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9] [7, 6,
 * 3, 8, 9] -> [9, 7, 6, 3, 8] For another example, given
 * 
 * A = [0, 0, 0] K = 1 the function should return [0, 0, 0]
 * 
 * Given
 * 
 * A = [1, 2, 3, 4] K = 4 the function should return [1, 2, 3, 4]
 * 
 * Assume that:
 * 
 * N and K are integers within the range [0..100]; each element of array A is an
 * integer within the range [−1,000..1,000]. In your solution, focus on
 * correctness. The performance of your solution will not be the focus of the
 * assessment.
 * 
 * 
 * @author : Shantanu Sikdar
 *
 */
public class ArraysCyclicRotation {

	public static void main(String[] args) {
		int[] arrA = new int[] { 3, 8, 9, 7, 6 };// 9,7,6,3,8
		int rotation = 3;
		priorToJava8(arrA, rotation);
	}
	
	private static void priorToJava8(int[] arrA, int rotation) {
		int size = arrA.length;
		int[] arrB = new int[size];
		for (int i = 0; i < size; i++) {
			arrB[(rotation + i) % size] = arrA[i];
		}
		for (int i = 0; i < arrB.length; i++) {
			System.out.println("i = " + arrB[i]);
		}
	}

}
