package Puzzles_Traps;

import java.math.BigDecimal;

public class Funcs {

	public static void main(String[] args) {
		BigDecimal i = new BigDecimal("2.00");
		BigDecimal x = new BigDecimal(1.10);
		System.out.println(i.subtract(x));
		System.out.println(2.00 - 1.10);
	}

	// Check if number is Odd
	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	// same as isOdd but for performance critical settings
	public static boolean isOddPerformance(int i) {
		return (i & 1) != 0;
	}
	
	

}
