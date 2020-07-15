package Builder_14;

import java.util.LinkedList;

// "Product"
class Product {
    // We can use any data structure that you prefer. We have used LinkedList here.
    private LinkedList<String> parts;
    public Product() {
        parts = new LinkedList<String>();
    }
    public void Add(String part) {
        parts.addLast(part);
    }

    public void Show() {
        System.out.println("\n Product completed as below :");
        for (int i = 0; i < parts.size(); i++) {
            System.out.println(parts.get(i));
        }
    }
}
