/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.techprep </p>
 * <p>File Name: TwoSum.java</p>
 * <p>Create Date: 21-Mar-2025 </p>
 * <p>Create Time: 4:45:21 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.techprep;

import java.util.Arrays;

/**
 * https://www.techprep.app/problems/two-sum?topic=blind-75
 */
public class TwoSum {

	public static void main(String[] args) {
		display(twoSum(new int[] { 1, 2, 3, 4, 5, 6 }, 9));//25
		display(twoSum(new int[] { 6, 7, 8, 9 }, 20));//
		display(twoSum(new int[] { 0, -1, 2, -3, 1, -2 }, -5));//35
	}

	private static int[] twoSum(int[] nums, int target) {
		int[] arr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[i] + nums[j] == target) {
					arr[0] = i;
					arr[1] = j;
					return arr;
				}
			}
		}
		return new int[0];
	}
	
	private static void display(int[] nums) {
		Arrays.stream(nums).forEach(System.out::print);
		System.out.println();
	}

}
