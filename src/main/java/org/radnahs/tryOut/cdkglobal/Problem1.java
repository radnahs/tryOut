/**
 * <p>Project: org.radnahs.tryOut.cdkglobal </p>
 * <p>Package Name: org.radnahs.tryOut.cdkglobal </p>
 * <p>File Name: Problem1.java </p>
 * <p>Create Date: May 10, 2017 </p>
 * <p>Create Time: 9:29:46 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.cdkglobal;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author: Shantanu Sikdar
 */
public class Problem1 {

	public static void main(String[] args) {
		Set<String> distinctMovies = new TreeSet<>();
		distinctMovies.add("bahubali");
		distinctMovies.add("dangal");
		distinctMovies.add("raees");
		distinctMovies.add("kaabil");
		distinctMovies.add("sultaan");
		for (String string : distinctMovies) {
			System.out.println(string);
		}
	}
}
