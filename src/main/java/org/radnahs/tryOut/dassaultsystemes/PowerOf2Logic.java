/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.dassaultsystemes </p>
 * <p>File Name: PowerOf2Logic.java</p>
 * <p>Create Date: 05-Aug-2020 </p>
 * <p>Create Time: 3:41:26 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.dassaultsystemes;

/**
 * @author : Shantanu Sikdar
 *
 * 
 *         input : 1 2 3 4 5 6 7 8 9 output : 1,0 2,1 4,2 4,2 8,3 8,3 8,3 8,3
 *         16,4
 *
 */
public class PowerOf2Logic {

	private static int power(int val, int power) {
		int powerVal = 1;
		for (int i = 0; i < power; i++) {
			powerVal = powerVal * val;
		}
		return powerVal;
	}

	public static void main(String[] args) {
		// System.out.println(power(2,3));
		int[] inptArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < inptArr.length; i++) {
			int div = inptArr[i] / 2;
			int rem = inptArr[i] % 2;
			int pow = power(2, div);
			System.out.println(inptArr[i]);
			if (pow < inptArr[i]) {
				System.out.println("\t" + power(2, div + 1) + ", " + (div + 1));
			} else {
				System.out.println("\t" + power(2, div) + ", " + (div));
			}

		}
	}

}
