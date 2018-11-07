package Lambdas;

import java.util.ArrayList;
import java.util.List;


public class AppleExample {
	int weight;
	String name;
	static List<AppleExample> inventory;
	
	static{
		inventory = new ArrayList();
	}

	public AppleExample(int weight, String name) {
		this.weight = weight;
		this.name = name;
		inventory.add(this);
	}
	
	public static <T> List<T> sortApples(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList();
		for(T e : list){
			if (p.compare(e)){
				result.add(e);
			}
		}
		return result;
	}
	
	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		AppleExample a1 = new AppleExample(120, "green");
		AppleExample a2 = new AppleExample(55, "black");
		AppleExample a3 = new AppleExample(180, "red");
		AppleExample a4 = new AppleExample(190, "blue");
		AppleExample a5 = new AppleExample(20, "green");
		AppleExample a6 = new AppleExample(350, "green");
		
		List<AppleExample> bigApples = a1.sortApples(a1.inventory, new Predicate<AppleExample>(){
			public boolean compare(AppleExample a) {
				return "red".equals(a.getName());
			}
		});
		
		List<AppleExample> greenApples = AppleExample.sortApples(AppleExample.inventory, (AppleExample a)->a.getName().equals("green"));
		System.out.println(greenApples.toString());
	}
	
	
}

interface Predicate<T>{
	public boolean compare(T t);
}
