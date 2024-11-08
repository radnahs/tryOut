/**
 * <p>Project: tryoOut </p>
 * <p>Package Name: org.radnahs.tryOut.logicMonitor </p>
 * <p>File Name: ReversingStringInteger.java </p>
 * <p>Create Date: 04-Mar-2020 </p>
 * <p>Create Time: 8:51:23 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.logicMonitor;

import java.util.Stack;

/**
 * @author : Shantanu Sikdar
 *
 */
public class ReversingStringInteger {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(reverseNumberLogic(1234));
		System.out.println(reverseNumberLogic(-1234));
		System.out.println(reverseNumberArray(5678));
		System.out.println(reverseNumberLogic(-5678));
		System.out.println(reverseStringBuilder("shantanu sikdar"));

		System.out.println(reverseStack("shantanu"));
	}

	private static Integer reverseNumberLogic(Integer intgr) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		int reverse = 0;
		while (intgr != 0) {
			reverse = reverse * 10 + intgr % 10;
			intgr = intgr / 10;
		}
		return reverse;
	}

	private static Integer reverseNumberArray(Integer intgr) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		char[] chrArr = intgr.toString().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = chrArr.length - 1; i > -1; i--) {
			sb.append(chrArr[i]);
		}
		return Integer.parseInt(sb.toString());
	}

	private static String reverseStringBuilder(String strInpt) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		return new StringBuilder(strInpt).reverse().toString();
	}
	
	private static String reverseStringCharArray(String strInpt) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		char[] chrArr = strInpt.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = chrArr.length - 1; i > -1; i--) {
			sb.append(chrArr[i]);
		}
		return sb.toString();
	}

	private static String reverseStack(String strInpt) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(strInpt);
		Stack<String> stckStr = new Stack<String>();
		char[] chrArr = strInpt.toCharArray();
		for (char chr : chrArr) {
			stckStr.push(chr + "");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stckStr.size(); i++) {
			sb.append(stckStr.pop());
			System.out.println(i);
			System.out.println(sb.toString());
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}

	// will not work as the reverse method give the bit operation
	private static void reverseIntegerMethod(Integer intgr) {
		System.out.println(intgr);
		System.out.println(Integer.reverse(intgr));// it does a
	}

}
