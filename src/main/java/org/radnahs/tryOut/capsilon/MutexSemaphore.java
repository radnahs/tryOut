/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.capsilon;
* File Name: MutexSemaphore.java
* Create Date: Feb 6, 2017
* Create Time: 11:32:44 AM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.capsilon;

import java.util.concurrent.Semaphore;

public class MutexSemaphore {

	public static void main(String[] args) {
		
		Semaphore semaphoreProducer = new Semaphore(1);
		Semaphore semaphoreConsumer =  new Semaphore(0);

		MutexProducer  mutexProducer = new MutexProducer(semaphoreProducer,semaphoreConsumer);
		MutexConsumer mutexConsumer = new MutexConsumer(semaphoreConsumer, semaphoreProducer);
		
		Thread threadProducer = new Thread(mutexProducer,"Mutex Producer Thread");
		Thread threadConsumer = new Thread(mutexConsumer,"Mutex Consumer Thread");
		threadProducer.start();
		threadConsumer.start();
	}

}

class MutexProducer implements Runnable{
	
	Semaphore mutexProducer;
	Semaphore mutexConsumer;
	
	MutexProducer(Semaphore mutexProducer,Semaphore mutexConsumer){
		this.mutexProducer=mutexProducer;
		this.mutexConsumer=mutexConsumer;
	}
	
	public void run(){
		try{
			for(int i=1;i<=5;i++){
				mutexProducer.acquire();
				System.out.println("Prducer Thread = " + Thread.currentThread().getName()+ " having id = "+Thread.currentThread().getId() + " acquire = " + i);
				mutexConsumer.release();
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}

class MutexConsumer implements Runnable{
	
	Semaphore mutexConsumer;
	Semaphore mutexProducer;
	
	MutexConsumer(Semaphore mutexConsumer,Semaphore mutexProducer){
		this.mutexConsumer=mutexConsumer;
		this.mutexProducer=mutexProducer;
	}
	
	public void run(){
		try{
			for(int i=1;i<=5;i++){
				mutexConsumer.acquire();
				System.out.println("Consumer Thread = " + Thread.currentThread().getName() +  " having id = "+Thread.currentThread().getId() + " release = " + i);
				mutexProducer.release();
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}