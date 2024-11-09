/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.creditsuisse </p>
 * <p>File Name: AccountTransfer.java</p>
 * <p>Create Date: 18-Apr-2020 </p>
 * <p>Create Time: 10:47:17 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.creditsuisse;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Shantanu Sikdar
 * 
 * https://www.codejava.net/java-core/concurrency/java-synchronization-tutorial-part-1-the-problems-of-unsynchronized-code
 * and its 2nd/3rd page
 * 
 */

public class AccountTransfer {

	public static void main(String[] args) {
		Bank bank = new Bank();

		for (int i = 0; i < Bank.MAX_ACCOUNT; i++) {
			Thread t = new Thread(new Transaction(bank, i));
			t.start();
		}
	}

}

class Account {

	private int balance = 0;

	public Account(int balance) {
		this.balance = balance;
	}

	public void withdraw(int amount) {
		this.balance -= amount;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}

	public int getBalance() {
		return this.balance;
	}
}

class Bank {
	public static final int MAX_ACCOUNT = 10;
	public static final int MAX_AMOUNT = 10;
	public static final int INITIAL_BALANCE = 100;

	private Account[] accounts = new Account[MAX_ACCOUNT];

	private Lock bankLock;
	private Condition availableFund;

	public Bank() {
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(INITIAL_BALANCE);
		}

		bankLock = new ReentrantLock();
		availableFund = bankLock.newCondition();
	}

	public void transfer(int from, int to, int amount) {
		bankLock.lock();

		try {
			while (accounts[from].getBalance() < amount) {
				availableFund.await();
			}

			accounts[from].withdraw(amount);
			accounts[to].deposit(amount);

			String message = "%s transfered %d from %s to %s. Total balance: %d\n";
			String threadName = Thread.currentThread().getName();
			System.out.printf(message, threadName, amount, from, to, getTotalBalance());

			availableFund.signalAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bankLock.unlock();
		}
	}

	public int getTotalBalance() {
		bankLock.lock();
		try {
			int total = 0;
			for (int i = 0; i < accounts.length; i++) {
				total += accounts[i].getBalance();
			}
			return total;
		} finally {
			bankLock.unlock();
		}
	}
}

class Transaction implements Runnable {
	private Bank bank;
	private int fromAccount;

	public Transaction(Bank bank, int fromAccount) {
		this.bank = bank;
		this.fromAccount = fromAccount;
	}

	public void run() {
		while (true) {
			int toAccount = (int) (Math.random() * Bank.MAX_ACCOUNT);
			if (toAccount == fromAccount)
				continue;

			int amount = (int) (Math.random() * Bank.MAX_AMOUNT);

			if (amount == 0)
				continue;

			bank.transfer(fromAccount, toAccount, amount);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}