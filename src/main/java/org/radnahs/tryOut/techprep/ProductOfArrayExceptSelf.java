/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.techprep </p>
 * <p>File Name: ProductOfArrayExceptSelf.java</p>
 * <p>Create Date: 21-Mar-2025 </p>
 * <p>Create Time: 5:49:50 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.techprep;

import java.util.Arrays;

/**
 * https://www.techprep.app/problems/product-of-array-except-self?topic=blind-75
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		display(productExceptSelf(new int[] { 1, 3, 5, 7 }));
	}

	private static int[] productExceptSelf(int[] nums) {
		int[] op = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int temp = 1;//nums[i];
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					temp *= nums[j];
				}
			}
			op[i] = temp;
		}
		return op;
	}

	private static void display(int[] nums) {
		Arrays.stream(nums).forEach(System.out::println);
		System.out.println();
	}
}
