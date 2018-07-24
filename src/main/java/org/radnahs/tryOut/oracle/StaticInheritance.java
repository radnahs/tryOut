/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.oracle </p>
 * <p>File Name: StaticInheritance.java</p>
 * <p>Create Date: Dec 1, 2015 </p>
 * <p>Create Time: 12:51:07 PM </p>
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
public class StaticInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassA a = new ClassB();
		a.staticMeth();
		a.nonStaticMeth();
		ClassB b = (ClassB)new ClassA();
	}

}
