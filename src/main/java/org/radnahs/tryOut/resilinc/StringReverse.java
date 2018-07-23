/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: org.radnahs.tryOut.resilinc </p>
 * <p>File Name: StringReverse.java</p>
 * <p>Create Date: Aug 21, 2015 </p>
 * <p>Create Time: 8:11:58 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.resilinc;

/**
 * @author Shantanu Sikdar 
 *
 */
public class StringReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chrArr={'A','B','C','D','E'};	
		display(chrArr);
		for (int i = 0, k = chrArr.length-1; i < k; i++, k--) {
			char tmp = chrArr[i];
			chrArr[i]=chrArr[k];
			chrArr[k] = tmp;
		}
		System.out.println("");
		display(chrArr);
	}
	
	private static void display(char[] chrArr){
		for (char c : chrArr) {
			System.out.print(c+" ");
		}
	}

}
