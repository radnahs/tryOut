/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.viewics </p>
 * <p>File Name: TestStaticInheritance.java</p>
 * <p>Create Date: Apr 24, 2015 </p>
 * <p>Create Time: 3:55:59 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.viewics;

/**
 * @author Shantanu Sikdar 
 *
 */
public class TestStaticInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		A b = new B();
		System.out.println(b.getThis(10));
		System.out.println(b.getThat(10));
	}

}

class A{
	public static int getThis(int n){
		return n+5;
	}
	
	public int getThat(int n){
		return n-5;
	}
}

class B extends A{
	public static int getThis(int n){
		return n*5;
	}
	
	public int getThat(int n){
		return n+15;
	}
}
