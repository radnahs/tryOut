/**
 * <p>Project: org.radnahs.tryOut.continuum </p>
 * <p>Package Name: org.radnahs.tryOut.continuum </p>
 * <p>File Name: ContinuumThread.java </p>
 * <p>Create Date: Jun 9, 2017 </p>
 * <p>Create Time: 1:59:18 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.continuum;

import java.util.Calendar;

/**
 * @author: Shantanu Sikdar
 */
public class ContinuumThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Calendar.getInstance().getTime());
		Thread t1 = new Thread(new Sleeper());
		Thread t2 = new Thread(new Sleeper());
		Thread t3 = new Thread(new Sleeper());
		Thread t4 = new Thread(new Sleeper());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		System.out.println("done");
		System.out.println(Calendar.getInstance().getTime());
	}

}

class Sleeper implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
