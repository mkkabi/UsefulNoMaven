package functions;

public class ArrayArguments {

    public static void print(int i, Object... values) {
        System.out.println("first argument: " + i);
        for (Object c : values) {
            System.out.println(c);
        }
    }

}

class Testing {

    public static void main(String[] args) {
        ArrayArguments.print(2, "adsf", "zzzzzzzzzz", "adsf");
    }
}

