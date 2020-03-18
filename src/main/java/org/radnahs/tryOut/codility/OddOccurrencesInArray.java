/**
 * <p>Project: tryout </p>
 * <p>Package Name: com.shandar.tryout.codility </p>
 * <p>File Name: OddOccurrencesInArray.java </p>
 * <p>Create Date: 11-Mar-2020 </p>
 * <p>Create Time: 10:50:13 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package com.shandar.tryout.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * A non-empty array A consisting of N integers is given. The array contains an
 * odd number of elements, and each element of the array can be paired with
 * another element that has the same value, except for one element that is left
 * unpaired.
 * 
 * For example, in array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the elements
 * at indexes 0 and 2 have value 9, the elements at indexes 1 and 3 have value
 * 3, the elements at indexes 4 and 6 have value 9, the element at index 5 has
 * value 7 and is unpaired. Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers fulfilling the above
 * conditions, returns the value of the unpaired element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the function
 * should return 7, as explained in the example above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an odd integer within the range [1..1,000,000]; each element of array A
 * is an integer within the range [1..1,000,000,000]; all but one of the values
 * in A occur an even number of times.
 * 
 * @author G01157921
 *
 */

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] arrInt = new int[] { 9, 3, 9, 3, 9, 7, 9, 1, 1 };
		usingJava8Way(arrInt);
		priorToJava8(arrInt);

	}

	private static void priorToJava8(int[] arrInt) {
		System.out.println(Thread.currentThread().getStackTrace()[1]);
		int odd = 0;
		Map<Integer, Integer> mapCnt = new HashMap<Integer, Integer>();
		for (int i = 0; i < arrInt.length; i++) {
			if (mapCnt.containsKey(arrInt[i])) {
				Integer cnt = mapCnt.get(arrInt[i]);
				mapCnt.put(arrInt[i], ++cnt);
			} else {
				mapCnt.put(arrInt[i], 1);
			}
		}
		System.out.println(mapCnt);
		for (Entry<Integer, Integer> mapIt : mapCnt.entrySet()) {
			if (mapIt.getValue() % 2 != 0) {
				odd = mapIt.getKey();
			}
		}
		System.out.println(odd);

	}

	private static void usingJava8Way(int[] arrInt) {
		System.out.println(Thread.currentThread().getStackTrace()[1]);
		int[] odd = new int[1];
		Map<Integer, Integer> mapCnt = new HashMap<Integer, Integer>();
		Arrays.stream(arrInt).forEach(elem -> {
			if (mapCnt.containsKey(elem)) {
				Integer cnt = mapCnt.get(elem);
				mapCnt.put(elem, ++cnt);
			} else {
				mapCnt.put(elem, 1);
			}
		});
		System.out.println(mapCnt);
		mapCnt.entrySet().stream().forEach(elem -> {
			if (elem.getValue() % 2 != 0) {
				odd[0] = elem.getKey();
			}
		});
		System.out.println(odd[0]);

	}

}
