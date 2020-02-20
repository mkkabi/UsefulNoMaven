package Threads;

	// Правильная реализация поставщика и потребителя.
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


	class Q {
		int n;
		boolean valueSet = true;
		
		synchronized int get() throws InterruptedException {
			while(valueSet) try {
				wait ();
			}
			catch(InterruptedException e) {
				System.out.println("InterruptedException перехвачено");
			}
			System.out.println("Получено: " + n);
			sleep(1000);
			valueSet = true;
			notify();
			return n;
		}
		
		synchronized void put(int n) {
			while(!valueSet) try {
				wait ();
			} catch(InterruptedException e) {
				System.out.println("InterruptedException перехвачено");
			}
			this.n = n;
			valueSet = false;
			System.out.println("Отправлено: " + n) ;
			notify();
		}
	}

	class Producer implements Runnable {
		Q q;
		Producer(Q q) {
			this.q = q;
			new Thread(this,"Поставщик").start();
		}
		
		@Override
		public void run() {
			int i = 0;
			while(true) {
				q.put(i++);
			}
		}
	}

	class Consumer implements Runnable {
		Q q; 
		Consumer(Q q) {
			this.q = q;
			new Thread(this, "Потребитель").start();
		}
		
		@Override
		public void run() {
		while(true) {
			try {
				q.get();
			} catch (InterruptedException ex) {
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
			}
			}
		}
	}

	class SenderConsumer {
		public static void main(String args[]) {
			Q q = new Q();
			new Producer (q);
			new Consumer (q);
			System.out.println("Для останова нажмите Control-C.");
		}
	}