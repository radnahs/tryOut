/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.msys </p>
 * <p>File Name: NotInArray.java </p>
 * <p>Create Date: 13-Mar-2020 </p>
 * <p>Create Time: 7:48:56 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.msys;

/**
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 * 
 * @author : Shantanu Sikdar
 *
 */
public class NotInArray {

	public static void main(String[] args) {
		int[] A = new int[] {1, 3, 6, 4, 1, 2};
		int size = A.length; 
		int val =  size*(size+1)/2;
		int temp = 0;
		for(int i=0;i<=size; i++) {
			for(int j =0 ; j<size; j++) {
				if(!(A[j]==i)) {
					temp = i;
					break;
				}
			}
		}
		System.out.println(temp);
	}

}
