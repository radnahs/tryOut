/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.amazon;
* File Name: RepeatCharactersInString.java
* Create Date: Jun 30, 2016
* Create Time: 12:25:57 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.amazon;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RepeatCharactersInString {

	public static void main(String[] args) {
		findRepeatCharacters("abbcddeff");
	}
	

	static void findRepeatCharacters(String a) {
		char[] chrArr = a.toCharArray();
		Arrays.sort(chrArr);
		Map<Character, Integer> mapChar =  new TreeMap<Character, Integer>();
		for (int i = 0; i < chrArr.length; i++) {
			if(mapChar.containsKey(chrArr[i])){
				mapChar.put(chrArr[i], mapChar.get(chrArr[i])+1);
				System.out.println(chrArr[i]);
			}else{
				mapChar.put(chrArr[i], 1);
			}
		}
		
		//System.out.println(mapChar);
	}

}
