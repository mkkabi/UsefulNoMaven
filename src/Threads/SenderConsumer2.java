package Threads;

import java.util.concurrent.*;
import java.lang.Math;
import java.util.Random;



//Реализация с использованием библиотеки BlockingQueue

public class SenderConsumer2 {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	public static void main(String[] args){
		Thread thread1 = new Thread(()->{
			try{
			produce();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		});
		
		Thread thread2 = new Thread(()->{
			try{
			consume();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		});
		
		thread1.start();
		thread2.start();
		
		try {
            thread1.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}
	
	public static void produce() throws InterruptedException{
		Random random = new Random();
		while(true){
			queue.put(random.nextInt(100));
		}
	}
	
	private static void consume() throws InterruptedException{
		while(true){
			Thread.sleep(100);
			System.out.println(queue.take());
			System.out.println("queue size is " + queue.size());
		}
	}
}