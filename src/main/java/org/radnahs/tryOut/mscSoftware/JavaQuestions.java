/**
* Project: tryOut
* Package Name:package org.radnahs.tryOut.mscSoftware;
* File Name: JavaQuestions.java
* Create Date: Mar 15, 2017
* Create Time: 4:26:58 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.mscSoftware;

public class JavaQuestions {

	public static void main(String[] args) {
		//JavaQuestions jq = new JavaQuestions();
		Dog d = new Dog("Puppy");
		System.out.println("1st : "+d.getName());
		d.setName("pood");
		System.out.println("2nd : "+d.getName());
	}
	
/*	public void setName(Dog d){
		d = new Dog("pood");
	}*/
	
}

class Dog{
	private String name;
	private String type;
	
	Dog(String str){
		name=str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
