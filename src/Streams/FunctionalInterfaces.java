package Streams;

import java.util.ArrayList;
import java.util.List;

public class FunctionalInterfaces {
	
	public static void main(String[] args) {
		
	}

	// Working with a Predicate
	@FunctionalInterface
	interface Predicate<T> {
		boolean test(T t);
	}

 
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}
	
	

}


/*

 Common functional interfaces in Java 8

 Functional interface		Function descriptor			Primitive specializations

 Predicate<T>	    			 T -> boolean						IntPredicate, LongPredicate, DoublePredicate
 Consumer<T>							T -> void								IntConsumer, LongConsumer, DoubleConsumer
 Function<T, R>					T -> R									IntFunction<R>, IntToDoubleFunction, IntToLongFunction,
 LongFunction<R>, LongToDoubleFunction,
 LongToIntFunction, DoubleFunction<R>, ToIntFunction<T>,
 ToDoubleFunction<T>, ToLongFunction<T>
 Supplier<T>							() -> T									BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier
 UnaryOperator<T>				T -> T									IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
 BinaryOperator<T>				(T, T) -> T							IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator
 BiPredicate<L, R>				(L, R) -> boolean
 BiConsumer<T, U>				(T, U) -> void					ObjIntConsumer<T>, ObjLongConsumer<T>, ObjDoubleConsumer<T>
 BiFunction<T, U, R>			(T, U) -> R							ToIntBiFunction<T, U>, ToLongBiFunction<T, U>, ToDoubleBiFunction<T, U>
 */
