/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.tomtom;
* File Name: ImmutabilityCheck.java
* Create Date: Sep 30, 2016
* Create Time: 1:12:43 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.tomtom;

import java.util.HashMap;
import java.util.Map;

public class ImmutabilityCheck {

	public static void main(String[] args) {
		Map<String, String> mapStr = new HashMap<String, String>();
		mapStr.put("A", "1");
		//String strr = "A";
		String strr = new String("A");
		//Integer a = 10;
		Integer a = new Integer(10);
		int ii =10;
		updateMethod(strr,a,ii,mapStr);
		System.out.println(mapStr.size());
		System.out.println(a);
		System.out.println(ii);
		System.out.println(strr);
	}
	
	static void updateMethod(String str, Integer iI, int ii, Map<String, String> map){
		map.put("B", "2");
		str="A"+"B";
		ii++;
		iI++;
	}

}
