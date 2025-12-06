/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.hilti </p>
 * <p>File Name: TargetPair.java</p>
 * <p>Create Date: 24-Feb-2025 </p>
 * <p>Create Time: 10:54:20 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.hilti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Given an array of integers nums and an integer target, return the
 * indices of the two numbers such that they add up to target. Assume there is
 * exactly one solution, and you may not use the same element twice. Example
 * Input: nums = [2, 6, 7, 11, 15], target = 9 Output: [0, 2] (Because nums[0] +
 * nums[2] == 9)
 * 
 * 
 */
public class TargetPair {

	private static List<Integer> solutionONSquare(int[] intArr, int target) {
		List<Integer> output = new ArrayList();
		boolean breakItr = false;
		for (int i = 0; i < intArr.length - 1; i++) {
			for (int j = 1; j < intArr.length; j++) {
				if (intArr[i] + intArr[j] == target) {
					output.add(i);
					output.add(j);
					breakItr = true;
					break;
				}
			}
			if (breakItr) {
				break;
			}
		}
		return output;
	}

	private static List<Integer> solutionTT(int[] intArr, int target) {
		for (int i = 0; i < intArr.length; i++) {
			
		}
		return null;
	}
		
	
	// suggested by interviewer
	private static List<Integer> solutionON(int[] intArr, int target) {
		List<Integer> output = new ArrayList();
		boolean breakItr = false;
		Map<Integer, Integer> mm = new HashMap<Integer, Integer>();
		//mm.contains(mm)
		//Set<Integer> mm = new HashSet<Integer>();
		//mm.contains()
		for (int i = 0; i < intArr.length - 1; i++) {
			
		}
		return output;
	}

	public static void main(String[] args) {
		List<Integer> sol1 = solutionONSquare(new int[] { 2, 6, 7, 11, 15 }, 9);
		System.out.println(sol1);
	}

}
