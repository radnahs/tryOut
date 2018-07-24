/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.oracle </p>
 * <p>File Name: ClassB.java</p>
 * <p>Create Date: Dec 1, 2015 </p>
 * <p>Create Time: 12:51:34 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.oracle;

/**
 * @author Shantanu Sikdar 
 *
 */
public class ClassB extends ClassA{
	
	int variable=11;
	
	public static void staticMeth(){
		System.out.println("hello in static method B");
	}

	public void nonStaticMeth(){
		System.out.println("hello in non static method B");
	}
	
}
