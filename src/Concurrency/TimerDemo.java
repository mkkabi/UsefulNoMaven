package Concurrency;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("alarm going off");
				System.exit(0);
			}
		};
		
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println(System.currentTimeMillis());
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(task, 2000); // Execute one-shot timer task after 2-second delay.
		
		Timer timer2 = new Timer();
		timer.schedule(task2, 0, 1000);
	}
}
