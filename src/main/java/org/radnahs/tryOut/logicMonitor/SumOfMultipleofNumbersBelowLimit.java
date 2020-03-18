/**
 * <p>Project: tryout </p>
 * <p>Package Name: com.shandar.tryout.logicMonitor </p>
 * <p>File Name: SumOfMultipleofNumbersBelowLimit.java </p>
 * <p>Create Date: 03-Mar-2020 </p>
 * <p>Create Time: 11:12:29 pm </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package com.shandar.tryout.logicMonitor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Shantanu Sikdar
 *
 */
public class SumOfMultipleofNumbersBelowLimit {

	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(15));
		System.out.println(solution(20));
		System.out.println(solutionSet(20));
		//System.out.println(solution(200));
	}

	public static int solution(int number) {
		int three = belowNumber(number, 3);
		int five = belowNumber(number, 5);
		return three+five;
	}


	private static  Integer belowNumber(int number, int toMultiply) {
		int sum = 0;
		int check = number / toMultiply;
		for (int i = 1; i <= check; i++) {
			if (toMultiply * i < number) {
				sum += toMultiply * i;
			}
		}
		return sum;
	}
	
	public static int solutionSet(int number) {
		Set<Integer> three = belowNumberSet(number, 3);
		Set<Integer> five = belowNumberSet(number, 5);
		Set<Integer> mergeSet = new HashSet<Integer>() {{
			addAll(three);
			addAll(five);
		}};
		
		return sumSetValue(mergeSet);
	}
	
	public static int sumSetValue(Set<Integer> mergeSet) {
		int sum = 0;
		for (Integer integer : mergeSet) {
			sum+=integer;
		}
		return sum;
	}
	
	private static  Set<Integer> belowNumberSet(int number, int toMultiply) {
		Set<Integer> set = new HashSet<Integer>();
		int check = number / toMultiply;
		for (int i = 1; i <= check; i++) {
			if (toMultiply * i < number) {
				//sum += toMultiply * i;
				set.add(toMultiply*i);
			}
		}
		return set;
	}
	
}
