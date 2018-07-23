/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.sears;
* File Name: CharacterClassification.java
* Create Date: Aug 22, 2016
* Create Time: 8:06:19 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.sears;

import java.util.HashMap;
import java.util.Map;


public class CharacterClassification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharacterClassification cc = new CharacterClassification();
		cc.charCount("Shantanu Sikdar will get CTC of 420000000");
	}
	
	public void charCount(String str){
		char[] chrArr = str.toCharArray(); 
		Map<String, Integer> charCountMap=new HashMap<>();
		charCountMap.put("upper", 0);
		charCountMap.put("lower", 0);
		charCountMap.put("digit", 0);
		for (char c : chrArr) {
/*			if(Character.isUpperCase(c)){
			}else if(Character.isLowerCase(c)){
			}else if(Character.isDigit(c)){
			}*/		
			int asciiVal = (int)c;
			//System.out.println(c + " ascii value is "+ asciiVal);
			if(asciiVal>96 && asciiVal<123){
				charCountMap.put("lower", charCountMap.get("lower")+1);
			}else if(asciiVal>64 && asciiVal<91){
				charCountMap.put("upper", charCountMap.get("upper")+1);
			}else if(asciiVal>47 && asciiVal<58){
				charCountMap.put("digit", charCountMap.get("digit")+1);
			}
		}
		System.out.println(charCountMap);
		
	}

}
