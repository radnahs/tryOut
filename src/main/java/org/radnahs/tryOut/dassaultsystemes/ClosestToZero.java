/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.dassaultsystemes </p>
 * <p>File Name: ClosestToZero.java</p>
 * <p>Create Date: 31-Jul-2020 </p>
 * <p>Create Time: 6:07:22 pm </p>
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
public class ClosestToZero {

	public static void main(String[] args) {
		System.out.println(closestoZeroUsingStreamForEach(new int[] { -5, 10, 9, 2 }));
		System.out.println(closestoZeroUsingStreamForEach(new int[] { -5, -4, -2, 12, -40, 4, 2, 18, 11, 5, -5 }));
	}

	public static int closestoZeroUsingStreamForEach(int[] ts) {
		int[] retVal = { ts[0] };
		if (ts.length > 0) {
			Arrays.stream(ts).forEach(intVal -> {
				if (Math.abs(retVal[0]) >= (Math.abs(0 - intVal))) {
					retVal[0] = intVal;
				}
			});
		}
		return retVal[0];
	}

	public static int closestoZeroUsingFor(int[] ts) {
		int[] retVal = { ts[0] };

		return retVal[0];
	}

}
