/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.techprep </p>
 * <p>File Name: GroupingAnagrams.java</p>
 * <p>Create Date: 21-Mar-2025 </p>
 * <p>Create Time: 7:58:20 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.techprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.techprep.app/problems/group-anagrams/submissions?topic=blind-75
 */
public class GroupingAnagrams {

	public static void main(String[] args) {
		groupAnagrams(new String[] { "race", "care", "acre", "hello", "world", "dworl" });

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> lstLstStr = new ArrayList<List<String>>();
		Map<String, List<String>> mapLstStr = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] charArr = strs[i].toCharArray();
			Arrays.sort(charArr);
			String skey = new String(charArr);
			if (mapLstStr.containsKey(skey)) {
				List<String> lstStr = mapLstStr.get(skey);
				lstStr.add(strs[i].toString());
				mapLstStr.put(skey, lstStr);
			} else {
				List<String> lstStr = new ArrayList<String>();
				lstStr.add(strs[i].toString());
				mapLstStr.put(skey, lstStr);
			}
		}
		for (Map.Entry<String, List<String>> entry : mapLstStr.entrySet()) {
			String key = entry.getKey();
			List<String> val = entry.getValue();
			lstLstStr.add(val);
		}
		return lstLstStr;
	}

}
