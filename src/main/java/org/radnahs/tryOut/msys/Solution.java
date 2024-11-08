/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.msys </p>
 * <p>File Name: Solution.java </p>
 * <p>Create Date: 13-Mar-2020 </p>
 * <p>Create Time: 10:41:49 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.msys;

/**
 * @author : Shantanu Sikdar
 *
 */
//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");
import java.util.*;
class Solution {
 public String solution(String[] A) {
     // write your code in Java SE 8
     Solution.CustomHashMap customHashMap = new Solution().new CustomHashMap();
     StringBuilder sbldr = new StringBuilder();
     String[] strArr = new String[2];
     for (String string : A) {
         String[] inptArr = string.trim().split(":");
         switch (inptArr[0]) {
			case "i":
				customHashMap.add(inptArr[1], inptArr[2]);
				break;
			case "j":
				sbldr.append(customHashMap.get(inptArr[1])==null?" -1 ":" "+customHashMap.get(inptArr[1]).get(0)  +  " ");
				strArr[0] = customHashMap.get(inptArr[1])==null?"-1":customHashMap.get(inptArr[1]).get(0);
				break;
			case "k":
				sbldr.append(" "+customHashMap.size()+" ");
				strArr[1] = customHashMap.size()+"";
				break;
			case "l":
				customHashMap.remove(inptArr[1]);
				break;
			default:
				break;
			}
         
     }
     //System.out.println(sbldr.toString());
     
     return sbldr.toString().trim();
 }
 
 	class CustomHashMap {
		Map<String, List<String>> customHM = new HashMap<String, List<String>>();

		public void add(String strKey, String strValue) {
			if (customHM.containsKey(strKey)) {
				List<String> strLst = customHM.get(strKey);
				strLst.add(strValue);
				customHM.put(strKey, strLst);
			} else {
				List<String> strLst = new ArrayList<String>();
				strLst.add(strValue);
				customHM.put(strKey, strLst);
			}
		}

		public List<String> get(String strKey) {
			if(customHM.containsKey(strKey)) {
				return customHM.get(strKey);
			}else {
				return null;
			}
		}

		public int size() {
			return customHM.size();
		}

		public void remove(String strKey) {
			customHM.remove(strKey);
		}

	
	}
}
