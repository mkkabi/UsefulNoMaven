package FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		String[] strArr = {"str 1", "str 2", ""};
		List<String> listOfStrings = Arrays.asList(strArr);

		// Working with a Predicate
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

		System.out.println(nonEmpty);

	}

	// Working with a Predicate
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}

	//Working with a Consumer

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T i : list) {
			c.accept(i);
		}
	}

	//Working with a Function
	/*
	 The java.util.function.Function<T, R> interface defines an abstract method named apply that
	 takes an object of generic type T as input and returns an object of generic type R
	 */	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
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
