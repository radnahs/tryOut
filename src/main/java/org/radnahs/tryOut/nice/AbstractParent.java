/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.nice </p>
 * <p>File Name: AbstractParent.java</p>
 * <p>Create Date: Feb 2, 2016 </p>
 * <p>Create Time: 4:48:46 PM </p>
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
public abstract class AbstractParent {

	public AbstractParent(){
		System.out.println("Constructor Abstract Parent");
		call();
	}
	
	abstract void call();
}
