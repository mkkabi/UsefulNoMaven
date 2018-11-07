
package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortCollectionsWithComparator{
    
    static Comparator<Apple> byWeight = (Apple a1, Apple a2)-> a1.getWeight()-a2.getWeight();
    
    public static void main(String[] args) {

	Apple[] appleArray = {new Apple(1210), new Apple(230), new Apple(330)};
	List<Apple> inventory = new ArrayList(Arrays.asList(appleArray));
	
	inventory.sort(byWeight);
	
	for(Apple a : inventory){
	    System.out.println(a.getWeight());
	}
    }
}

class Apple{
    int weight;
    public int getWeight() {
	return weight;
    }
    public Apple(int weight) {
	this.weight = weight;
    }
}