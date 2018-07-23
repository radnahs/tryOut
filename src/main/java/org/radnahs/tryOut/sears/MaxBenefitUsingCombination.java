/**
 * Project: rytry
 * Package Name:package org.radnahs.tryOut.sears;
 * File Name: MaxBenefitUsingCombination.java
 * Create Date: Aug 23, 2016
 * Create Time: 2:55:56 PM
 * Copyright: Copyright (c) 2016
 * @author: Shantanu Sikdar, ssikdar
 * @version 1.0
 */
package org.radnahs.tryOut.sears;

import java.util.List;

/**
 * Shantanu wants to learn a new technique. He can choose from N (1<=N<=1000)
 * techniques. Each technique i (0<=i<N) requires ei (0<=ei<=1000) efforts and
 * provides bi(0<=bi<=1000) benefits. Shantanu is willing to extend at most
 * E(1<=E<=1000) number of total efforts. What is the maximum amount of benefit
 * Shantanu can achieve?
 * 
 * INPUT You need to fill in a function that takes as input an integer N, the
 * number of techniques, an integer array e[], effort required by each
 * technique, an integer array b[], benefit provided by each technique, and an
 * integer E, the total number of efforts Shantanu is willing to extend.
 * 
 * OUTPUT Set the output variable to the maximum benefit Shantanu can achieve.
 * 
 * EXAMPLE Input: 3{10,20,10}{10,20,11}20 Output: 21
 * 
 * EXPLANATION Shantanu choose technique 0 and 2 requiring 10+10=20 efforts and
 * providing 10+11=21 benefits.
 * 
 * 
 * 
 * @author ssikdar
 * 
 */
public class MaxBenefitUsingCombination {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int r = 1;
		int n = arr.length;
		printCombination(arr, n, r);

	}

	public static void maxBenefit(int input1, int[] input2, int[] input3,
			int input4) {
		// write code here
	}

	static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println("");
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

	static void printCombination(int arr[], int n, int r) {
		// A temporary array to store all combination one by one
		int data[] = new int[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, n - 1, 0, r);
	}

}
