/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.ideas </p>
 * <p>File Name: Unbox.java</p>
 * <p>Create Date: Feb 19, 2016 </p>
 * <p>Create Time: 6:48:48 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ideas;

/**
 * @author Shantanu Sikdar 
 *
 */
public class Unbox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Shape s = new Circle();
	     //Circle c = s.makeCopy();
	}

}
class Shape {
    public Shape makeCopy() {
        // code to make a copy of this Shape
    	return new Shape();
    }
}

class Circle extends Shape {
    @Override
    public Circle makeCopy() {
        // code to make a copy of a Circle
    	return new Circle();
    }
}