/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.aqr </p>
 * <p>File Name: AQREnvironmentCheck.java </p>
 * <p>Create Date: 26-Jan-2020 </p>
 * <p>Create Time: 9:35:41 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.aqr;

/**
 * @author : Shantanu Sikdar
 *
 */
public class AQREnvironmentCheck {

	public static void main(String[] args) {
		AQREnvironmentCheck envChk = new AQREnvironmentCheck();
		System.out.println(envChk.sumOfDigits(12));
		System.out.println(envChk.sumOfDigits(1092));
		System.out.println(envChk.sumOfDigits(100230002));
	}
	
	private int sumOfDigits(int n){
		char[] chrArr = (""+n).toCharArray();
		int temp=0;
		for (int i = 0; i < chrArr.length; i++) {
			temp+= Character.getNumericValue(chrArr[i]);
		}
		return temp;
	}

}
