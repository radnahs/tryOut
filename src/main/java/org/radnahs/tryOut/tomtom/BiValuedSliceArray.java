/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.tomtom;
* File Name: BiValuedSliceArray.java
* Create Date: Nov 21, 2016
* Create Time: 1:20:26 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/

package org.radnahs.tryOut.tomtom;

/**
 * A zero-indexed array A consisting of N integers is given. A pair of integers (P, Q),
 * such that 0 <= P <= Q < N, is called a slice of array A. A slice is called
 * bi-valued if it consists of at most two different numbers.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A consisting of N integers, returns the size of the largest bi-valued slice in A.
 *
 * For example, given array A such that:
 * A[0] = 5
 * A[1] = 4
 * A[2] = 4
 * A[3] = 5
 * A[4] = 0
 * A[5] = 12
 * 
 * the function should return 4, because (0, 3) is a slice containing only 4 and 5.
 * There are also some other shorter bi-valued slices, such as: (1, 3), (4, 5) and (1,2) 
 * (a bi-valued slice can also contain just one value). Slice (3, 5) is not bi-valued as 
 * it consists of three different numbers.
 * Assume that:
 * N is an integer within the range [0 .. 100];
 * each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * 
 */


public class BiValuedSliceArray {

	public static void main(String[] args) {
		BiValuedSliceArray bivsa = new BiValuedSliceArray();
		int[] A = {5,4,4,5,0,12};
		int ans = bivsa.solution(A);
		System.out.println(ans);
	}
	
	public int solution(int[] A) {
	    double minAvg = 100000;
	    int index=0;
	    if(A.length<=2) {
	        return 0;
	    }
	    for(int i=0;i<A.length-2;i++) {
	        if((A[i]+A[i+1])/2.0<minAvg) {
	            minAvg=(A[i]+A[i+1])/2.0;
	            index=i;
	        }
	        if((A[i]+A[i+1]+A[i+2])/3.0<minAvg)  {
	            minAvg=(A[i]+A[i+1]+A[i+2])/3.0;
	            index=i;
	        }
	    }
	    int aMax = A.length-2;
	    if((A[aMax]+A[aMax+1])/2.0<minAvg) {
	        minAvg=(A[aMax]+A[aMax+1])/2.0;
	        index=aMax;
	    }
	    return index;
	}
	
	
}
