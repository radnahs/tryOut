/**
 * <p>Project: org.radnahs.tryOut.triplePoint </p>
 * <p>Package Name: org.radnahs.tryOut.triplePoint </p>
 * <p>File Name: Singleton.java </p>
 * <p>Create Date: Jun 12, 2017 </p>
 * <p>Create Time: 5:16:43 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.triplePoint;

/**
 * @author: Shantanu Sikdar
 */
public class Singleton {
	private static Singleton singleton;
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		if(singleton==null){
			synchronized(Singleton.class){
				if(singleton==null){
					singleton= new Singleton();
				}
			}
			
		}
		return singleton;
	}
	
	
}
