/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.continuum </p>
 * <p>File Name: DoubleTime.java </p>
 * <p>Create Date: Jun 9, 2017 </p>
 * <p>Create Time: 2:27:34 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.continuum;

import java.util.Calendar;

/**
 * @author: Shantanu Sikdar
 */
public class DoubleTime {

	String n_squares(int n) {
	    StringBuffer s = new StringBuffer("0");
	    int n_squared = n*n;
	    for (int i=0; i<n_squared; i++) {
	        s.append (", " + i);
	    }
	    return s.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Calendar.getInstance().getTime());
		DoubleTime dt = new DoubleTime();
		System.out.println(dt.n_squares(10));
		System.out.println(Calendar.getInstance().getTime());
	}

}
