/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.logicMonitor </p>
 * <p>File Name: FirstNonRepeatingAlphabet.java </p>
 * <p>Create Date: 03-Mar-2020 </p>
 * <p>Create Time: 11:12:51 pm </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.logicMonitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author : Shantanu Sikdar
 *
 */
public class FirstNonRepeatingAlphabet {

	public static void main(String[] args) {
		System.out.println(firstNonRepeatingLetter("a"));
		System.out.println(firstNonRepeatingLetter("eeoot"));
		System.out.println(firstNonRepeatingLetter("toppot"));
		System.out.println(firstNonRepeatingLetter("stress"));
		System.out.println(firstNonRepeatingLetter("STreSS"));
	}

	public static String firstNonRepeatingLetter(String str) {
		char[] charArr = str.toCharArray();
		String val = "";
		if (charArr.length > 1) {
			for (int i = 0; i < charArr.length - 1; i++) {
				val = charArr[i] + "";
				int j = i + 1;
				for (; j < charArr.length; j++) {
					if (charArr[i] == charArr[j]) {
						break;
					}
				}
				if (j == charArr.length) {
					break;
				}

			}
		} else {
			val = str;
		}
		return val;
	}

	public static String mapWay(String str) {
		char[] chrArr = str.toCharArray();
		int key = 0;
		Character chrVal = ' ';
		if (chrArr.length > 1) {
			Map<Character, List<Integer>> mapChar = new TreeMap<Character, List<Integer>>();
			for (int i = 0; i < chrArr.length; i++) {
				if (mapChar.containsKey(chrArr[i])) {
					List<Integer> tmpLst = mapChar.get(chrArr[i]);
					tmpLst.add(i);
					mapChar.put(chrArr[i], tmpLst);
				} else {
					List<Integer> tmpLst = new ArrayList<Integer>();
					tmpLst.add(i);
					mapChar.put(chrArr[i], tmpLst);
				}
			}

			
			for (Entry<Character, List<Integer>> mapVal : mapChar.entrySet()) {
				if (mapVal.getValue().size() == 1 && key < mapVal.getValue().get(0)) {
					key = mapVal.getValue().get(0);
					chrVal = mapVal.getKey();
				}
			}
		}else {
			return str;
		}

		return chrVal + "";

	}
}
