/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.trial </p>
 * <p>File Name: AbstractTestClass.java</p>
 * <p>Create Date: Jul 30, 2015 </p>
 * <p>Create Time: 1:42:51 PM </p>
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
public class AbstractTestClass {
	
	
	/*public static void main(String[] args) {
		System.out.println("hello abstract");
		AbstractParent abp = new Child(11);
		System.out.println(abp.i);
	}*/

}
abstract class AbstractParent {
	int i=0;
	
	/*public AbstractParent(){
		this.i=i;
	}*/
	public AbstractParent(int i){
		this.i=i;
	}
}
class Child extends AbstractParent{
	public Child(int k){
		super(k);
	}
}