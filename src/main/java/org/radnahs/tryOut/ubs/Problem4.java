/**
 * <p>Project: org.radnahs.tryOut.ubs </p>
 * <p>Package Name: org.radnahs.tryOut.ubs </p>
 * <p>File Name: Problem4.java </p>
 * <p>Create Date: Jun 25, 2017 </p>
 * <p>Create Time: 11:20:33 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ubs;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author: Shantanu Sikdar
 */
public class Problem4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<String> map = new TreeSet<>();
		map.add("one");
		map.add("two");
		map.add("three");
		map.add("four");
		map.add("one");
		Iterator it = map.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
