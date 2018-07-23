/**
 * <p>Project: org.radnahs.tryOut.cdkglobal </p>
 * <p>Package Name: org.radnahs.tryOut.cdkglobal </p>
 * <p>File Name: Problem12.java </p>
 * <p>Create Date: May 10, 2017 </p>
 * <p>Create Time: 9:15:06 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.cdkglobal;

/**
 * @author: Shantanu Sikdar
 */
public class Problem12 {

	public static void main(String[] args) {
		class A{
			public int x=10;
			public void print(){
				System.out.println(this.x);
			}
		}
		class B extends A{
			public int x=20;
			public void print(){
				System.out.println(this.x);
			}
		}
		A a = new B();
		System.out.println(a.x);
		a.print();
	}

}
