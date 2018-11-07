
package FunctionalInterfaces;

import Resources.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
//BiPredicate is just a variation on Predicate that allows you to
//pass in two objects for testing instead of one
public class BiPredicateExample {
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		BiPredicate<String, Double> javaBuy = (name, price) -> name.contains("Java");
		BiPredicate<String, Double> priceBuy = (name, price) -> price<55.00;
		BiPredicate<String, Double> definitelyBuy = javaBuy.and(priceBuy);
		
		books.forEach(book->{
			if (definitelyBuy.test(book.getName(), book.getPrice())){
				System.out.println("You should definitely buy "+ book.getName() + 
						"(" + book.getPrice() + ")");
			}
		});
				
	}
}
