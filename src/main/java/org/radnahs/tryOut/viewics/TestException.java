/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.viewics </p>
 * <p>File Name: TestException.java</p>
 * <p>Create Date: Apr 24, 2015 </p>
 * <p>Create Time: 3:49:56 PM </p>
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
public class TestException {

	public void print() throws Exception{
		try{
			throw new Exception(" throw exception"); 
		}catch(Exception ex){
			System.out.println("in catch");
		}finally{
			System.out.println("in finally");
		}		
	}
	
	public static void main(String[] args) throws Exception {
		new TestException().print();
	}
}
