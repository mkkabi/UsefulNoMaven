
package Concurrency;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		Runnable r = ()->{
		for (int i=0; i<5;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.join();
		t2.start();
	}
}
