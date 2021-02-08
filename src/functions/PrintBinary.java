package functions;

public class PrintBinary {
    
    public static void printBinary (long value, int size){
	for (int i = size-1; i >=0; i--){
	long mask = 1L << i;
	long result = (mask & value) >> i;
	System.out.print(result);
	}
	System.out.println();
	// or System.out.print(Long.toBinaryString(value));
}
    
    public static void main(String[] args) {
        int a = 5;
        int b = 9;
        
        printBinary(a, 4);
        printBinary(b, 4);
        printBinary(a & b, 4);
        printBinary(a | b, 4);
        printBinary(a ^ b, 4);
        
        a = a^b;
        b = a^b;
        a= a^b;
        
        
    }
}
