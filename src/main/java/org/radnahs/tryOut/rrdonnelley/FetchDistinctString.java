/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.rrdonnelley </p>
 * <p>File Name: FetchDistinctString.java</p>
 * <p>Create Date: 12-Mar-2025 </p>
 * <p>Create Time: 12:51:00 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.rrdonnelley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 */
public class FetchDistinctString {

	public static void main(String[] args) {

		String arr[] = { "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" };
		usingSET(arr);
		System.out.println("");
		usingMAP(arr);
	}

	private static void usingSET(String arr[]) {
		Set<String> setStr = new HashSet();
		for (int j = 0; j < arr.length; j++) {
			char[] charArr = arr[j].toCharArray();
			Arrays.sort(charArr);
			setStr.add(new String(charArr));
		}
		System.out.println(setStr);
	}
	
	private static void usingMAP(String arr[]) {
		Map<String, List<String>> mapStr = new HashMap<>();
		for (int j = 0; j < arr.length; j++) {
			char[] charArr = arr[j].toCharArray();
			Arrays.sort(charArr);
			String ss = new String(charArr);
			if(mapStr.containsKey(ss)) {
				List<String> lst = mapStr.get(ss);
				lst.add(j+"_"+arr[j]);
				mapStr.put(ss, lst);
			}else {
				List<String> lst = new ArrayList<>();
				lst.add(j+"_"+arr[j]);
				mapStr.put(ss, lst);
			}
		}
		System.out.println(mapStr);
	}
	
}
