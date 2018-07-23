/**
 * Project: rytry
 * Package Name:package org.radnahs.tryOut.capsilon;
 * File Name: MutexThread.java
 * Create Date: Feb 6, 2017
 * Create Time: 1:08:53 PM
 * Copyright: Copyright (c) 2016
 * @author: Shantanu Sikdar, ssikdar
 * @version 1.0
 */
package org.radnahs.tryOut.capsilon;

import java.util.List;

public class MutexThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Producer implements Runnable {
	private final List<Integer> taskQueue;
	private final int MAX_CAPACITY;

	public Producer(List<Integer> sharedQueue, int size) {
		this.taskQueue = sharedQueue;
		this.MAX_CAPACITY = size;
	}

	@Override
	public void run() {
		int counter = 0;
		while (true) {
			try {
				produce(counter++);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		synchronized (taskQueue) {
			while (taskQueue.size() == MAX_CAPACITY) {
				System.out.println("Queue is full "	+ Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
				taskQueue.wait();
			}

			Thread.sleep(1000);
			taskQueue.add(i);
			System.out.println("Produced: " + i);
			taskQueue.notifyAll();
		}
	}
}

class Consumer implements Runnable {
	private final List<Integer> taskQueue;

	public Consumer(List<Integer> sharedQueue) {
		this.taskQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		synchronized (taskQueue) {
			while (taskQueue.isEmpty()) {
				System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
				taskQueue.wait();
			}
			Thread.sleep(1000);
			int i = (Integer) taskQueue.remove(0);
			System.out.println("Consumed: " + i);
			taskQueue.notifyAll();
		}
	}
}