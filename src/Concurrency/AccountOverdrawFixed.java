
package Concurrency;

public class AccountOverdrawFixed implements Runnable {

	private Account ac = new Account();

	public static void main(String[] args) {
		AccountOverdrawFixed st = new AccountOverdrawFixed();
		Thread vasia = new Thread(st);
		Thread mania = new Thread(st);
		vasia.setName("Vasia");
		mania.setName("Mania");
		vasia.start();
		mania.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			makeWithdrawal(5);
			if (ac.getBalance() < 0) {
				System.out.println("Account ovedrawn!");
			}
		}
	}

	/*
	make func synchronized and all variables private to fix overdraw error
	Now we’ve guaranteed that once a thread (Vasia or Mania) starts the withdrawal process by invoking makeWithdrawal(), 
	the other thread cannot enter that method until the first one completes the process by exiting the
method. The new output shows the benefit of synchronizing the makeWithdrawal() method
	 */
	private synchronized void makeWithdrawal(int amount) {
		if (ac.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}
			ac.withdraw(amount);
			System.out.println(Thread.currentThread().getName() + " performed withdrawal");
		} else {
			System.out.println("Not engough for " + Thread.currentThread().getName() + " current balance " + ac.getBalance());
		}
	}

}



