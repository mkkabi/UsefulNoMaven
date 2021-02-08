package functions;
import static functions.PrintBinary.printBinary;
public class BitwiseOperators {
    
    public static void main(String[] args) {
        
        int a = 5;
        int b = 9;
        
        // example of operators |, &, ^
        printBinary(a, 4);
        printBinary(b, 4);
        printBinary(a & b, 4);
        printBinary(a | b, 4);
        printBinary(a ^ b, 4);
        
        // Bitwise SWAP
        a = a^b;
        b = a^b;
        a= a^b;
        System.out.println("a = " + a);
        System.out.println("b = "+ b);
        
        // examples of <<, >>, >>>, ~
        
        // << moves all bytes left specified number of times and does not change the variable c below:
        int c = 1;
        int d = c << 2;
        printBinary(d, 8);
        
    }

}
