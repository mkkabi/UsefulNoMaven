
package Concurrency;

public class Account {

	private int balance = 50;

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

}
