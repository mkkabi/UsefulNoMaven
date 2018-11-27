
package Concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StartingThread {
	
	/*
		There are 2 ways to start a new thread - by extending class Thread(not the best choice)
		and by implementing interface Runnable - the most common way
	
		A call to sleep() Guaranteed to cause the current thread to stop
	executing for at least the specified sleep duration (although it might
	be interrupted before its specified time).
	
	A call to yield() Not guaranteed to do much of anything, although
	typically, it will cause the currently running thread to move back to
	runnable so that a thread of the same priority can have a chance.
	
	A call to join() Guaranteed to cause the current thread to stop
	executing until the thread it joins with (in other words, the thread it
	calls join() on) completes, or if the thread it’s trying to join with is
	not alive, the current thread won’t need to back out.
	
	*/
	
	public static void main(String[] args) {
		
		Thread threadOne = new Thread(new ThreadWithInterface(), "One");
		ThreadWithThreadClass threadTwo = new ThreadWithThreadClass();
		threadTwo.setName("Two");
		
		Thread threadThree = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		threadThree.setName("Three");
		// once defined, same runnable can be used with many diff Threads
		Runnable r1 = ()->System.out.println(Thread.currentThread().getName());
		Thread threadFour = new Thread(r1, "Four");
		
		Thread threadFive = new Thread(()->System.out.println(Thread.currentThread().getName()), "Five");
		
		Thread threadSix = new Thread(
		()->{for(int i=0; i<4;i++){System.out.println(Thread.currentThread().getName());}});
		threadSix.setName("Six");
		threadSix.setPriority(Thread.MAX_PRIORITY);
		
		threadOne.start();
		threadTwo.start();
		threadThree.start();
		threadFour.start();
		threadFive.start();
		threadSix.start();
		// By default main has its own thread with name main
		System.out.println(Thread.currentThread().getName());
	}

}

class ThreadWithInterface implements Runnable{
	@Override
	public void run(){
		this.foo();
	}
	
	private synchronized void foo(){
		for(int i=0; i<4; i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class ThreadWithThreadClass extends Thread{
	@Override
	public void run(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			Logger.getLogger(ThreadWithThreadClass.class.getName()).log(Level.SEVERE, null, ex);
		}
		for(int i=0; i<2; i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
}