/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.gs </p>
 * <p>File Name: LeastDifferenceArrayElementSum.java</p>
 * <p>Create Date: Feb 9, 2016 </p>
 * <p>Create Time: 7:36:16 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shantanu Sikdar
 * 
 */
public class LeastDifferenceArrayElementSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] inArr = new int[]{19,1,1,10,1,7};
		// int[] inArr = new int[]{8,3,5,10,1,7};
		//int[] inArr = new int[] { 1, 2, 3, 3, 3, 9 };
		//System.out.println(bothSideMinimumDiff(inArr));
		/*Integer[] intArr = new Integer[] { 1, 2, 3, 3, 3, 9 };
		List<Integer[]> listElem = splitArray(intArr,intArr.length-2);
		System.out.println(listElem.size());
		for (Integer[] integers : listElem) {
			for (Integer integer : integers) {
				System.out.print(integer+", ");
			}
		}*/
		Integer[] intArr = new Integer[] { 1, 2, 3, 3, 3, 9 };
		/*List<Integer[]> listElem = new 
		combinationWithoutRepetition(0, 0, "", list,new ArrayList(listElem));*/
		
	}

	private static int bothSideMinimumDiff(int[] intArr) {
		int diff = 0;
		int tillIndex = 0;
		int size = intArr.length;
		for (int i = 0; i < size; i++) {
			int leftSum = 0, rightSum = 0;
			for (int j = 0, k = size - 1; j <= i || k > i; j++, k--) {
				if (j <= i) {
					leftSum += intArr[j];
				}
				if (k > i) {
					rightSum += intArr[k];
				}
			}
			// System.out.println("leftSum = "+leftSum);
			// System.out.println("rightSum = "+rightSum);
			// System.out.println("abs val == "+ Math.abs(leftSum-rightSum));
			if (i == 0) {
				diff = Math.abs(leftSum - rightSum);
			}
			if (Math.abs(leftSum - rightSum) <= diff) {
				diff = Math.abs(leftSum - rightSum);
				tillIndex = i;
				// System.out.println("diff val == "+ diff +
				// ", at index =="+tillIndex );
			}
		}
		return diff;
	}

	public static <T extends Object> List<T[]> splitArray(T[] array, int max) {
		int x = array.length / max;
		int r = (array.length % max); // remainder
		int lower = 0;
		int upper = 0;
		List<T[]> list = new ArrayList<T[]>();
		int i = 0;
		for (i = 0; i < x; i++) {
			upper += max;
			list.add(Arrays.copyOfRange(array, lower, upper));
			lower = upper;
		}
		if (r > 0) {
			list.add(Arrays.copyOfRange(array, lower, (lower + r)));
		}
		return list;
	}

	private static void combinationWithoutRepetition(int n, int index, String prefix, List<Integer>...incrList){		
		 if(n >= incrList.length){
	            System.out.println(prefix);
	            return;
	     }
	    for(int i=index;i<incrList[n].size();i++){
	    	combinationWithoutRepetition(n+1, i, prefix+incrList[n].get(i)+" || ", incrList);
	    }
	}
}
