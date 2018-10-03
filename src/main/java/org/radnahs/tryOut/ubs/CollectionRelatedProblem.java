/**
 * <p>Project: org.radnahs.tryOut.ubs </p>
 * <p>Package Name: org.radnahs.tryOut.ubs </p>
 * <p>File Name: CollectionRelatedProblem.java </p>
 * <p>Create Date: Jun 20	, 2017 </p>
 * <p>Create Time: 11:20:33 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ubs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author: Shantanu Sikdar
 */
public class CollectionRelatedProblem {

	public static void main(String[] args) {
		CollectionRelatedProblem collectionRelatedProblem = new CollectionRelatedProblem();
		collectionRelatedProblem.nullKeyNullValueMap();
		collectionRelatedProblem.treeSetProblem();
	}

	private void nullKeyNullValueMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, "some val");
		map.put("jsk", "ran");
		map.put("shn", null);
		map.put("sik", null);
		System.out.println(map.get("ksj"));//any key not present give a call to a method will print null 
						//when the key is printed in sysout, the println()->print() method by default assign value to null String.
		for (Map.Entry<String, String> mapOpn : map.entrySet()) {
			System.out.println(mapOpn.getKey()+" "+mapOpn.getValue());
		}

	}

	



	private void treeSetProblem(){
		TreeSet<String> map = new TreeSet<>();
		map.add("one");
		map.add("two");
		map.add("three");
		map.add("four");
		map.add("one");
		Iterator<String> it = map.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
