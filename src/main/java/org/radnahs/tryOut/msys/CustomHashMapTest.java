/**
 * <p>Project: tryout </p>
 * <p>Package Name: com.shandar.tryout.msys </p>
 * <p>File Name: CustomHashMapTest.java </p>
 * <p>Create Date: 11-Mar-2020 </p>
 * <p>Create Time: 10:50:13 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package com.shandar.tryout.msys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author G01157921
 *
 */
public class CustomHashMapTest {

	public static void main(String[] args) {
		String inpt1 = "[\"i:1:2\",	\"i:66:3\",	\"j:66\",	\"k\" ]";
		String[] inpt1Arr = inpt1.replace("[", "").replace("]", "").split(",");
		CustomHashMapTest.CustomHashMap customHashMap = new CustomHashMapTest().new CustomHashMap();
		StringBuilder sbldr = new StringBuilder();
		for (String string : inpt1Arr) {
			System.out.println(string.trim());
			String[] inptArr = string.replace("\"", "").trim().split(":");
			switch (inptArr[0]) {
			case "i":
				System.out.println("i");
				customHashMap.add(inptArr[1], inptArr[2]);
				break;
			case "j":
				System.out.println("j");
				sbldr.append(customHashMap.get(inptArr[1])==null?"-1":customHashMap.get(inptArr[1]).get(0));
				break;
			case "k":
				System.out.println("k");
				sbldr.append(" "+customHashMap.size()+" ");
				break;
			case "l":
				System.out.println("l");
				customHashMap.remove(inptArr[1]);
				break;
			default:
				break;
			}
		}
		System.out.println(customHashMap);
		System.out.println(sbldr.toString().trim());
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


