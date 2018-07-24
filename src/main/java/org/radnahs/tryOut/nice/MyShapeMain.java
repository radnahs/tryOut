/**
 * <p>Project: org.radnahs.tryOut.nice </p>
 * <p>Package Name: org.radnahs.tryOut.nice </p>
 * <p>File Name: MyShapeMain.java </p>
 * <p>Create Date: May 5, 2017 </p>
 * <p>Create Time: 1:49:48 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.nice;

/**
 * @author: Shantanu Sikdar
 */
public class MyShapeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] chrArr1 = new char[]{'n','a','s','h'};
		MyShape shape1 = new MyShape(chrArr1);
		MyShape shape2 =  shape1;
		changeMyShape(shape2);
		System.out.println(shape2.getChrArr());
	}
	
	static void changeMyShape(MyShape shape){
		//shape = new MyShape(new StringBuffer("cube"));
		char[] chrArr = new char[]{'s','h','a','n'};
		shape = new MyShape(chrArr);
	}

}

class MyShape{

	private char[] chrArr;

	public MyShape(char[] chrArr) {
		super();
		this.chrArr = chrArr;
	}

	public char[] getChrArr() {
		return chrArr;
	}

	public void setChrArr(char[] chrArr) {
		this.chrArr = chrArr;
	}
	
	
/*	private StringBuffer name;

	public MyShape(StringBuffer name) {
		super();
		this.name = name;
	}

	public StringBuffer getName() {
		return name;
	}

	public void setName(StringBuffer name) {
		this.name = name;
	}
*/	
}
