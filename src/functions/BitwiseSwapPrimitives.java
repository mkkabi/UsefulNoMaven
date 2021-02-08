package functions;

public class BitwiseSwapPrimitives {
    
    private static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    
    public static void main(String[] args) {
        int a = 5;
        int b = 9;
        // this method will not affect variables a and b initialized earlier since methods create local copies 
        // of variables passed in
        swap(a, b);
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        
        // this will actuallu perform the bitwise swap
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}
