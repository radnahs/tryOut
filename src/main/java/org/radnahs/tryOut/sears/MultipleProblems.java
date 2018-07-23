/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.sears;
* File Name: MultipleProblems.java
* Create Date: Aug 21, 2016
* Create Time: 7:36:49 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.sears;

public class MultipleProblems {
	
	static{
		System.out.println("1");
	}
	
	public MultipleProblems(){
		System.out.println("2");
	}
	{
		System.out.println("3");
	}

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		new MultipleProblems();
	}
	
	public static void main(String[] args) {
		int i=1;
		do{
			System.out.println(i);
			i++;
		}while(i<=20);
				
	}

}
