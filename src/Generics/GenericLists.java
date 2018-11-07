
package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericLists{
	public static void main(String[] args) {
		
		List<?> list1 = new ArrayList<String>();
		// list2 will take any class child of number
		List<? extends Number> list2 = new ArrayList<Double>();
		//list3 will take only classes above Number
		List<? super Number> list3 = new ArrayList<Object>();
				
		Voice voice1 = new Voice("uuu");
		
		GenericLists gen = new GenericLists();
		gen.processCallable(voice1);
 	}
	
	// for generics that implement interfaces need to use EXTEND keyword
	public <T extends Callable> void processCallable(T t){
		t.call();
	}
}

class Voice implements Callable{
	String name;
	public Voice(String s){name=s;}
	@Override
	public void call(){
		System.out.println("elements " + name);
	}
	
}

interface Callable{
	public void call();
}
