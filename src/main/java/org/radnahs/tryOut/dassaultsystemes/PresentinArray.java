/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.dassaultsystemes </p>
 * <p>File Name: PresentinArray.java</p>
 * <p>Create Date: 31-Jul-2020 </p>
 * <p>Create Time: 5:46:05 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.dassaultsystemes;

import java.util.Arrays;

/**
 * 
 */
public class PresentinArray {

	public static void main(String[] args) {
		int[] intArr = { -9, 14, 102, 37 };
		int toFind = 102;
		loopingArrayStreamWay(intArr, toFind);
		loopingArrayForLoopWay(intArr, toFind);
		arrayBinarySearch(intArr, toFind);
	}

	private static void loopingArrayStreamWay(int[] intArr, int toFind) {
		boolean[] retVal = { false };
		Arrays.stream(intArr).forEach(intVal -> {
			if (toFind == intVal) {
				retVal[0] = true;
			}
		});
		System.out.println(retVal[0]);
	}

	private static void loopingArrayForLoopWay(int[] intArr, int toFind) {
		boolean[] retVal = { false };
		for (int i = 0; i < intArr.length; i++) {
			if (toFind == intArr[i]) {
				retVal[0] = true;
				break;
			}
		}
		System.out.println(retVal[0]);
	}

	private static void arrayBinarySearch(int[] intArr, int toFind) {
		int index = Arrays.binarySearch(intArr, toFind);
		System.out.println(index > -1 ? true : false);
	}

}
