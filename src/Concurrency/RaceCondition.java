
package Concurrency;

import java.util.HashSet;
import java.util.Set;

public class RaceCondition {
	public static void main(String[] args) {
		RaceCondition testThreads = new RaceCondition();
		testThreads.go();
	}
	
	public void go(){}
}

class Show{
	private static Show INSTANCE;
	private Set<String> availableSeats;
	public static Show getInstance(){
		if(INSTANCE==null){
			INSTANCE = new Show();
		}
		return INSTANCE;
	}
	private Show(){
		availableSeats = new HashSet<String>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}
	
	public boolean bookSeat(String seat){
		return availableSeats.remove(seat);
	}
	
	
}
