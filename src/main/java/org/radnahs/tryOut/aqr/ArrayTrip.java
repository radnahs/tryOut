/**
 * <p>Project: tryout </p>
 * <p>Package Name: com.shandar.tryout.aqr </p>
 * <p>File Name: Problem1.java </p>
 * <p>Create Date: 26-Jan-2020 </p>
 * <p>Create Time: 10:05:42 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

/**
 * You are given an array of integers arr, representing a sequence of numerical tiles that you 
 * can stand on. Initially, you're standing on the first tile (arr[0]), and you can step forward 
 * by at most k tiles at a time. Your mission is to reach the final tile (arr[arr.length - 1]), 
 * and the value of each tile you stand on is added to your total score (including the first and 
 * last tile). 
 * Your task is to find the maximal possible score you can achieve after reaching the end.
 * Example
 * 
 * For arr = [3, 4, -2, 1, 2] and k = 2, the output should be arrayTrip(arr, k) = 10.
 * 
 * Since k = 2, it's possible to skip over one tile by taking a step of size 2. We can get the 
 * best score by skipping over the negative tile (arr[2] = -2), and visiting all the positive tiles. 
 * This gives a total of 3 + 4 + 1 + 2 = 10.
 * 
 * For arr = [0, -3, -2, -5, -7, 1] and k = 3, the output should be arrayTrip(arr, k) = -1.
 * 
 * With k = 3, we could skip over a maximum of two tiles at a time, so we won't be able to avoid 
 * all the negative tiles. The best option is to visit the least negative value arr[2] = -2 and 
 * avoid the others. This gives a total of 0 + (-2) + 1 = -1.
 * 
 * Input/Output
 * [execution time limit] 3 seconds (java)
 * [input] array.integer arr
 * An array of integers representing a set of numerical tiles that we're trying to move across.
 * Guaranteed constraints:
 * 1 ≤ arr.length ≤ 105,
 * -105 ≤ arr[i] ≤ 105.
 * [input] integer k
 * The maximum step size we can take.
 * Guaranteed constraints:
 * 1 ≤ k ≤ 105.
 * [output] integer64
 * The maximum score that is possible to get.
[Java] Syntax Tips
// Prints help message to the console
// Returns a string
// 
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}


*/
package com.shandar.tryout.aqr;

/**
 * @author : Shantanu Sikdar
 *
 */
public class ArrayTrip {

	public static void main(String[] args) {
		System.out.println("test");
		ArrayTrip at = new ArrayTrip();
		System.out.println(at.arrayTrip(new int[] { 3, 4, -2, 1, 2 }, 2));
		System.out.println(at.arrayTrip(new int[] { 0, -3, -2, -5, -7, 1}, 3));
		System.out.println(at.arrayTrip(new int[] { 0, -3, -5, -5, -7, 1}, 3));
	}

	private int arrayTrip(int[] arr, int k) {
		int sum = 0;
		for (int i = 0; i < arr.length;) {
			if (arr[i] >= 0) {
				sum += arr[i];
			} else {
				int tmpVal = arr[i], tmpIndx = i;
				for (int j = i; j < i + k ; j++) {
					if (tmpVal < arr[j]) {
						tmpVal = arr[j];
						tmpIndx = j;
					}
				}
				i = tmpIndx;
				sum += arr[tmpIndx];
			}
			i++;
		}

		return sum;
	}

}
