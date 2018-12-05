
package Concurrency;

public class AccountOverdtawExample implements Runnable {
	private Account ac = new Account();
	public static void main(String[] args) {
		AccountOverdtawExample st = new AccountOverdtawExample();
		Thread vasia = new Thread(st);
		Thread mania = new Thread(st);
		vasia.setName("Vasia");
		mania.setName("Mania");
		vasia.start();
		mania.start();
		
	}
	@Override
	public void run(){
		for (int i = 0; i < 5; i++) {
			makeWithdrawal(10);
			if(ac.getBalance()<0){
				System.out.println("Account ovedrawn!");
			}
		}
	}
	
	private void makeWithdrawal(int amount){
		if (ac.getBalance()>= amount){
			System.out.println(Thread.currentThread().getName()+" is going to withdraw");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {}
			ac.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+" performed withdrawal");
		}else{
			System.out.println("Not engough for "+Thread.currentThread().getName()+" current balance "+ac.getBalance());
		}
	}
	
}

