/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.tomtom;
* File Name: CareerCupTomTomPractice.java
* Create Date: Sep 8, 2016
* Create Time: 5:21:49 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.tomtom;

/**
 * Returns the zero based index of the first occurrence of any character of str2 in str1 
Input: 
str1="adf6ysh" 
str2="123678" 

output: 3 
 * @author ssikdar
 *
 */
public class CareerCupTomTomPractice {

	public static void main(String[] args) {
		CareerCupTomTomPractice ccttp = new CareerCupTomTomPractice();
		System.out.println(ccttp.charFinder("adf6ysh","123678"));
	}
	
	private int charFinder(String str1, String str2){
		char[] car1 = str1.toCharArray(), car2 = str2.toCharArray();
		int ret=0;
		for (char c1 : car1) {
			for (int i=0;i<car2.length;i++) {
				if(c1==car2[i]){
					return i;
				}
			}
		}
		return 0;
	}
	
}
