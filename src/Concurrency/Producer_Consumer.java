package Concurrency;

//Never call a wait() method outside of a loop. The loop tests the condition
//before and after the wait() call. Testing the condition before calling wait() ensures
//liveness. If this test was not present, and if the condition held and notify() had been
//called prior to wait() being called, it’s unlikely that the waiting thread would ever wake
//up. Retesting the condition after calling wait() ensures safety. If retesting didn’t occur, and
//if the condition didn’t hold after the thread had awakened from the wait() call (perhaps
//another thread called notify() accidentally when the condition didn’t hold), the thread
//would proceed to destroy the lock’s protected invariants.

public class Producer_Consumer {

	public static void main(String[] args) {
		Shared s = new Shared();
		new Producer(s).start();
		new Consumer(s).start();
	}
}

class Shared {

	private char c;
	private volatile boolean writeable = true;

	synchronized void setSharedChar(char c) {
		while (!writeable) {
			try {
				wait();
			} catch (InterruptedException ie) {
			}
		}
		this.c = c;
		writeable = false;
		notify();
	}

	synchronized char getSharedChar() {
		while (writeable) {
			try {
				wait();
			} catch (InterruptedException ie) {
			}
		}
		writeable = true;
		notify();
		return c;
	}
}

class Producer extends Thread {

	private final Shared s;

	Producer(Shared s) {
		this.s = s;
	}

	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			s.setSharedChar(ch);
			System.out.println(ch + " produced by producer.");
		}
	}
}

class Consumer extends Thread {

	private final Shared s;

	Consumer(Shared s) {
		this.s = s;
	}

	@Override
	public void run() {
		char ch;
		do {
			ch = s.getSharedChar();
			System.out.println(ch + " consumed by consumer.");
		} while (ch != 'Z');
	}
}
