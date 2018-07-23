/**
 * <p>Project: org.radnahs.tryOut.ubs </p>
 * <p>Package Name: org.radnahs.tryOut.ubs </p>
 * <p>File Name: Problem1Main.java </p>
 * <p>Create Date: Jun 25, 2017 </p>
 * <p>Create Time: 9:42:10 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ubs;

/**
 * @author: Shantanu Sikdar
 */
public class Problem1Main {

	public static void main(String[] args) {
		
	}

}

class Vertical{
	private int alt;
	public synchronized void up(){
		++alt;
	}
	
	public void down(){
		--alt;
	}
	public synchronized void jump(){
		int a = alt;
		up();
		down();
		assert(a==alt);
	}
	
}
