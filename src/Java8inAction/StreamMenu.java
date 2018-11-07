package Java8inAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static java.util.Comparator.comparingInt;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMenu {

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}
	Optional<Dish> opt;

	public static void main(String[] args) {

		List<Dish> menu = new ArrayList();
		Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));

		// define max element in array
		int[] numbers = {5, 6, 1, 7, 9};
		//OptionalInt max = Arrays.stream(numbers).reduce(Integer::max);
		Arrays.stream(numbers).map((a) -> a * a).reduce(0, (a, b) -> a + b);

		// selecting only unique chars from Array of Strings with Stream
		String[] words = {"Hello", "world"};
		Stream<String> streamOfWords = Arrays.stream(words);
		List<String> uniqueChars = streamOfWords.map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(toList());

		// filtering List by condition with Stream
		List<Dish> dishesExpensive = menu.parallelStream().filter(a -> a.getCalories() > 1).collect(toList());
		int[] n = {1, 2, 3, 4, 5};
		IntStream streamOfInts = Arrays.stream(n);
		//streamOfInts.map(i -> i * i).forEach(System.out::println);
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream()
				.filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(toList());
		
		// ========= COLLECTORS  =======	
		// Grouping in Map by Type with Collectors
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

		// Grouping Dishes in Map with Lambda function
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
				groupingBy(dish -> {
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else {
						return CaloricLevel.FAT;
					}
				}));

		// Multilevel grouping
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishByTypeCaloricLeve = menu.stream().collect(
				groupingBy(Dish::getType,
						groupingBy(dish -> {
							if (dish.getCalories() <= 400) {
								return CaloricLevel.DIET;
							} else if (dish.getCalories() <= 700) {
								return CaloricLevel.NORMAL;
							} else {
								return CaloricLevel.FAT;
							}
						})
				)
		);

		// Finding the highest-calorie Dish in each subgroup
		Map<Dish.Type, Dish> mostCaloricByType = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(
				maxBy(comparingInt(Dish::getCalories)), Optional::get)));

		Map<Dish.Type, Integer> totalCaloriesByType = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
		
		// which CaloricLevels are available in the menu for each type of Dish
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType
				= menu.stream().collect(
						groupingBy(Dish::getType, mapping(
										dish -> {
											if (dish.getCalories() <= 400) {
												return CaloricLevel.DIET;
											} else if (dish.getCalories() <= 700) {
												return CaloricLevel.NORMAL;
											} else {
												return CaloricLevel.FAT;
											}
										},
										toCollection(HashSet::new))));
		
		/*==Partitioning==*/
//		Partitioning is a special case of grouping: having a predicate (a function returning a boolean),
//    called a partitioning function, as a classification function
		Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
				menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
//		most caloric dish among both vegetarian and nonvegetarian dishes:
		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian
				= menu.stream().collect(
						partitioningBy(Dish::isVegetarian,
								collectingAndThen(
										maxBy(comparingInt(Dish::getCalories)),
										Optional::get)));
		
		
		Collection<Dish> dishes;
		//dishes = menu.stream().collect(toCollection(), ArrayList::new);

		
		

	}
	
	interface Collector<T, A, R>{
	
	}
	
	
}

class Dish {

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}

	public enum Type {
		MEAT, FISH, OTHER
	}

}
