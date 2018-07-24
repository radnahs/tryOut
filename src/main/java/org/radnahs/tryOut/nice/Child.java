/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.nice </p>
 * <p>File Name: Child.java</p>
 * <p>Create Date: Feb 2, 2016 </p>
 * <p>Create Time: 4:50:22 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.nice;

/**
 * @author Shantanu Sikdar 
 *
 */
public class Child extends AbstractParent {

	private Integer intgr;
	public Child(){
		intgr= new Integer(10);
		System.out.println("Constructor Non-Abstract Child");
	}

	@Override
	void call() {
		System.out.println("In call, value of intgr = "+intgr );
	}
	
	public static void main(String[] args) {
		Child c = new Child();
	}

}
