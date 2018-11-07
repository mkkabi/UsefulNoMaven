package Lambdas;

import java.util.function.Consumer;

public class Lambdas {
    public static void main(String[] args) {
        /*
        Using Consumer Interface that takes parameters and does not return anything
        List of all functional inteerfaces can be found here:
        https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
        Package java.util.function
        */
        Consumer<String> cons = (s)->System.out.println(s);
        cons.accept("sting of lines");
    
				LambdaTest lmb = new LambdaTest();
				lmb.foo(new Consumer(){

					@Override
					public void accept(Object t) {
						System.out.println("qwe");
					}
				});
		}
}


class LambdaTest{
	
	void foo(Consumer c){
		System.out.println(c.toString());
	}
}
