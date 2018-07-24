/**
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.oracle.threading </p>
 * <p>File Name: BankAccount.java</p>
 * <p>Create Date: Jun 13, 2016 </p>
 * <p>Create Time: 1:41:07 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.oracle;

public class BankAccount {

	private int amnt = 100;
	
	public synchronized void debit(int debitAmnt){
		if(this.amnt<debitAmnt){
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		this.amnt-=debitAmnt;  
		System.out.println("withdraw completed...");
	}
	
	public synchronized void credit(int creditAmnt){
		System.out.println("going to deposit...");  
		this.amnt+=creditAmnt;  
		System.out.println("deposit completed... ");  
		notify();  
	}
	
	public static void main(String args[]){
		System.out.println("inside BA");
		final BankAccount ba=new BankAccount();  
		new Thread(){  
			public void run(){ba.debit(150);}  
		}.start();  
		new Thread(){  
			public void run(){ba.credit(100);}  
		}.start();  
	}

}
