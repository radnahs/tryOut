/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.amazon;
* File Name: MinimumDifference.java
* Create Date: Jun 29, 2016
* Create Time: 5:17:34 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.amazon;

import java.util.Arrays;

public class MinimumDifference {

	public static void main(String[] args) {
		System.out.println(minArray(new int[] { 4,5,3,8,3,7}));		
	}
	static int minArray(int[] arr) {
		//display(arr);
		Arrays.sort(arr);
		boolean cnt=false; 
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = arr.length-1; k >i ; k--) {
				if(arr[k]>=arr[i]*2){
					count++;
				}else{
					cnt=true;
					break;
				}
			}
			if(cnt){
				break;
			}
		}
	
		return count;
    }
	static void display(int[] arr){
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}


}
