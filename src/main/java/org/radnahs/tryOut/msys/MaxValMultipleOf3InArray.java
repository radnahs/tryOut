/**
 * <p>Project: tryout </p>
 * <p>Package Name: com.shandar.tryout.msys </p>
 * <p>File Name: MacValMultipleOf3InArray.java </p>
 * <p>Create Date: 13-Mar-2020 </p>
 * <p>Create Time: 8:08:08 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package com.shandar.tryout.msys;

/**
 * @author : Shantanu Sikdar
 *
 */
public class MaxValMultipleOf3InArray {

	public static void main(String[] args) {
		int[] arrA = new int[] {-6,-91,1011,-100,84,-22,0,1,473};
		int temp=0;
		for (int i = 0; i < arrA.length; i++) {
			if(arrA[i]%3==0) {
				temp=temp>arrA[i]?temp:arrA[i];
			}
		}
		System.out.println(temp);
		
	}

}
