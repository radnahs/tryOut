/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.oracle </p>
 * <p>File Name: PalindromeSinglyLinkedList.java</p>
 * <p>Create Date: Dec 1, 2015 </p>
 * <p>Create Time: 12:57:31 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.oracle;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Shantanu Sikdar 
 *
 */
public class PalindromeSinglyLinkedList {
	
	public static void main(String[] args) {
		List<String> sll = new LinkedList<>();
		sll.add("M");
		sll.add("A");
		sll.add("D");
		sll.add("A");
		sll.add("M");
		System.out.println(sll);
		for (int i=0,j=sll.size()-1;i<sll.size();i++,j--) {
			System.out.print(sll.get(i));
			System.out.println("\b"+sll.get(j));
		}
	}
}
