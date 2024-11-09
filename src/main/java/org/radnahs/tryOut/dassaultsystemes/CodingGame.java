/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.dassaultsystemes </p>
 * <p>File Name: CodingGame.java</p>
 * <p>Create Date: 31-Jul-2020 </p>
 * <p>Create Time: 5:36:28 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.dassaultsystemes;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class CodingGame {

	private int val = 1;

	class B {
		public void meth() {
			System.out.println(val);
		}
	}

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		for (Integer integer : set) {

		}
	}

	public static void main1(String[] args) {
		problem1(4);
		// problem1a(4);
		System.out.println(5 / 2);
		String s;
		// System.out.println(s);
		problem2();
		problem3();
		problem4();
		// A a = new CodingGame();
		CodingGame c = new A();
	}

	static void problem4() {

		System.out.println("output");
	}

	static void problem3() {

		System.out.println("output");
	}

	static void problem2() {

		System.out.println("output");
	}

	static void problem1(int count) {
		Long l = new Long(1);
		for (int i = 2; i <= count; i++) {
			l *= i;
		}
		long cntD = 1;
		for (int i = 2; i <= count - 2; i++) {
			cntD *= i;
		}

		Long reslt = l / (cntD * 2);

		reslt.intValue();
		System.out.println(reslt);

		System.out.println("output");
	}

	/*
	 * static void problem1a(int count) { BigInteger factL = new BigInteger("1");
	 * for(int i=2; i<=count ;i++) { l*=i; } factL.multiply(new BigInteger(1)); }
	 */

}

class A extends CodingGame {

}