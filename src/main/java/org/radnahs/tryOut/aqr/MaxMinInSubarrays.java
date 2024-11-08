/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.aqr </p>
 * <p>File Name: Problem2.java </p>
 * <p>Create Date: 26-Jan-2020 </p>
 * <p>Create Time: 10:06:07 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.aqr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers a and an integer m, your task is to find the
 * maximum value among the minimum values of each contiguous subarray of size m
 * in array a. Example For a = [1, 2, 3, 1, 2] and m = 1, the output should be
 * maxMinInSubarrays(a, m) = 3. The subarrays of size m = 1 are [1], [2], [3],
 * [1], and [2]. Since each array contains only one element, each value is the
 * minimal element of the subarray it is in. The maximum of these values is 3.
 * 
 * For a = [1, 1, 1] and m = 2, the output should be maxMinInSubarrays(a, m) =
 * 1. The subarrays of size m = 2 are [1, 1] and [1, 1]. The minimum value for
 * both arrays is 1. The maximum of these values is 1.
 * 
 * For a = [2, 5, 4, 6, 8] and m = 3, the output should be maxMinInSubarrays(a,
 * m) = 4. The subarrays of size m = 3 are [2, 5, 4], [5, 4, 6], and [4, 6, 8].
 * The respective minimum values for these subarrays are 2, 4, and 4, so the
 * maximum of these values is 4.
 * 
 * Input/Output [execution time limit] 5 seconds (java) [input] array.integer a
 * An array of integers in which subarrays should be considered. Guaranteed
 * constraints: 1 ≤ a.length ≤ 106, 1 ≤ a[i] ≤ 109. [input] integer m An integer
 * representing the size of the subarrays to consider.
 * 
 * Guaranteed constraints: 1 ≤ m ≤ 105, m ≤ a.length. [output] integer The
 * maximum value among the minimum values of all subarrays of size m.
 * 
 * [Java] Syntax Tips // Prints help message to the console // Returns a string
 * // // Globals declared here will cause a compilation error, // declare
 * variables inside the function instead! String helloWorld(String name) {
 * System.out.println("This prints to the console when you Run Tests"); return
 * "Hello, " + name; }
 * 
 * @author : Shantanu Sikdar
 *
 */
public class MaxMinInSubarrays {

	public static void main(String[] args) {
		MaxMinInSubarrays maxMinInSubarrays = new MaxMinInSubarrays();
		System.out.println(maxMinInSubarrays.maxMinInSubarraysUsingCollections(new int[] { 2, 5, 4, 6, 8 }, 3));
		System.out
				.println(maxMinInSubarrays.maxMinInSubarraysUsingCollections(new int[] { 9, 2, 8, 7, 4, 6, 6, 1 }, 5));
		System.out.println(maxMinInSubarrays.maxMinInSubarraysUsingCollections(new int[] { 2, 5, 4, 6, 8 }, 3));
	}

	private int maxMinInSubarraysUsingCollections(int[] a, int m) {
		List<List<Integer>> intArrList = new ArrayList<>();
		List<Integer> intLst = new ArrayList<Integer>();
		for (int i = 0; i < a.length + 1 - m; i++) {
			List<Integer> intList = new ArrayList<Integer>();
			for (int j = i; j < i + m; j++) {
				intList.add(a[j]);
			}
			System.out.println(intList);
			int min = Collections.min(intList);
			intLst.add(min);
			intArrList.add(intList);
		}
		System.out.println(intLst);
		// System.out.println(intArrList);
		return Collections.max(intLst);
	}

	/*
	 * private int maxMinInSubarraysUsingArray(int[] a, int m) { int sze = a.length
	 * int[] intArrMin = new int()[];
	 * 
	 * }
	 */

}
