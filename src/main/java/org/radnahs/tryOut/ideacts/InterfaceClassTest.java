/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.trial </p>
 * <p>File Name: InterfaceClassTest.java</p>
 * <p>Create Date: Jul 31, 2015 </p>
 * <p>Create Time: 1:19:40 PM </p>
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
interface I1{
	int a=10;
	void m1();
}
interface I2{
	int a=20;
	void m2();
}
public class InterfaceClassTest implements I1,I2 {
	InterfaceClassTest(){
		int a=3;
		System.out.println(a);
	}
	public static void main(String[] args) {
		InterfaceClassTest ict = new InterfaceClassTest();
		
	}
	
	@Override
	public void m1() {
	}
	@Override
	public void m2() {
	}
}
