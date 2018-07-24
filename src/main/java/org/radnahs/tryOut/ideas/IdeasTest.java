/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.ideas </p>
 * <p>File Name: IdeasTest.java</p>
 * <p>Create Date: Feb 19, 2016 </p>
 * <p>Create Time: 6:33:20 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ideas;

import java.util.Calendar;

/**
 * @author Shantanu Sikdar 
 *
 */
public class IdeasTest {

	public static void main(String[] args) {
		IdeasTest it = new IdeasTest();
		System.out.println("Start :"+Calendar.getInstance().getTime());
		System.out.println(it.n_squares(1000));
		System.out.println("Start :"+Calendar.getInstance().getTime());
	}
	
	String n_squares(int n) {
	    StringBuffer s = new StringBuffer("0");
	    int n_squared = n*n;
	    for (int i=0; i<n_squared; i++) {
	        s.append (", " + i);
	    }
	    return s.toString();
	}

}
