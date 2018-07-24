/**
* Project: tryOut
* Package Name:package org.radnahs.tryOut.nice;
* File Name: SetOperations.java
* Create Date: Feb 11, 2017
* Create Time: 8:37:09 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.nice;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class SetOperations {

	public static void main(String[] args) {
		Set<String> hashSet =  new HashSet<String>();
		hashSet.add("Coal");
		hashSet.add("plastic");
		System.out.println(hashSet);
		
		Set<String> treeSet =  new TreeSet<String>();
		treeSet.add("plastic");
		treeSet.add("Coal");
		System.out.println(treeSet);
	}

}
