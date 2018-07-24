/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.tests.ideacts </p>
 * <p>File Name: InterfaceImpl.java</p>
 * <p>Create Date: Jul 17, 2015 </p>
 * <p>Create Time: 1:30:05 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ideacts;

/**
 * @author Shantanu Sikdar 
 *
 */
public class InterfaceImpl implements InterfaceOne {
	int a=20;
	
	InterfaceImpl(){
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		InterfaceImpl ii = new InterfaceImpl();
	}
}
