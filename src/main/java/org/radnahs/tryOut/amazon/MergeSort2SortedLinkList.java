/**
 * <p>Project: org.radnahs.tryOut.amazon </p>
 * <p>Package Name: org.radnahs.tryOut.amazon </p>
 * <p>File Name: MergeSort2SortedLinkList.java </p>
 * <p>Create Date: Apr 24, 2017 </p>
 * <p>Create Time: 8:12:01 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

/**
 * Given two sorted Linked Lists, implement code to return a 
 * merged sorted list.
 * For e.g
 * List1 : 15, 12, 10, 6, 4
 * List2 : 9, 5, 3, 2, 1
 * Should return
 * 15, 12, 10, 9, 6, 5, 4, 3, 2, 1
 * 
 * Another example e.g
 * List1 : 15, 12, 10
 * List2 : 14, 11
 * Should return
 * 15, 14, 12, 11, 10

 */
package org.radnahs.tryOut.amazon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Shantanu Sikdar
 */
public class MergeSort2SortedLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort2SortedLinkList ms2sll = new MergeSort2SortedLinkList();
		
		List<Integer> lst1 = new LinkedList<>();
		lst1.add(6);
		lst1.add(10);
		lst1.add(15);
		lst1.add(12);
		lst1.add(4);
		Collections.sort(lst1);
		
		List<Integer> lst2 = new LinkedList<>();
		lst2.add(9);
		lst2.add(5);
		lst2.add(3);
		lst2.add(2);
		lst2.add(1);
	
		ms2sll.mergeSortedLinkList(lst1,lst2);
	}

	public void mergeSortedLinkList(List<Integer> ll1, List<Integer> ll2){
		ll1.addAll(ll2);
		System.out.println(ll1);
		Collections.sort(ll1);
		System.out.println(ll1);
		Collections.reverse(ll1);
		System.out.println(ll1);
	}
	
	
	
}
