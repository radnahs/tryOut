/**
* Project: tryOut
* Package Name:package org.radnahs.tryOut.nice;
* File Name: OverloadedMain.java
* Create Date: Feb 11, 2017
* Create Time: 7:58:33 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.nice;

public class OverloadedMain {

	
	public static void main(String[] args) {
		System.out.println("in main string as param");
	}

	static{
		System.out.println("hello static");
		System.out.println(System.getProperty("java.version"));
	}
	
	public static void main(int[] args) {
		System.out.println("in main int as param");
	}
	
}