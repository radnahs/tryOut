/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.mmt </p>
 * <p>File Name: EvenOddNumber.java</p>
 * <p>Create Date: Sep 7, 2015 </p>
 * <p>Create Time: 4:17:15 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.mmt;


/**
 * @author Shantanu Sikdar 
 *
 */
public class EvenOddNumber {
	
	private int lastNumber = 0;
	
	public synchronized void oddNumber(){
		if(this.lastNumber%2==0){
			System.out.println("1. odd lastNumber : " + lastNumber);
			try {
				wait();
				this.lastNumber++;
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		  
		System.out.println("2. odd lastNumber : " + lastNumber);
	}
	
	public synchronized void evenNumber(){
		if(!(this.lastNumber%2==0)){
			System.out.println("1. even lastNumber : " + lastNumber);
			try {
				wait();
				this.lastNumber++;
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		System.out.println("2. even lastNumber : " + lastNumber);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final EvenOddNumber eon=new EvenOddNumber();  
		new Thread(){  
			public void run(){eon.oddNumber();}  
		}.start();  
		new Thread(){  
			public void run(){eon.evenNumber();}  
		}.start();
	}

}
