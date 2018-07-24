/**
 * <p>Project: org.radnahs.tryOut.nice </p>
 * <p>Package Name: org.radnahs.tryOut.nice </p>
 * <p>File Name: MyThread.java </p>
 * <p>Create Date: May 5, 2017 </p>
 * <p>Create Time: 2:06:07 PM </p>
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
public class MyThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadOperation to1 = new ThreadOperation();
		Thread t1= new Thread(to1);
		Thread t2= new Thread(to1);
		t1.start();
		t2.start();
	}
	
}

class ThreadOperation extends Thread{
	int m_sum =0 ;
	
	public void run(){
		sum();
	}
	
	public void sum(){
		for (int i = 0; i < 100; i++) {
			m_sum++;
			System.out.println(m_sum+"  "+Thread.currentThread());
		}
	}
}
