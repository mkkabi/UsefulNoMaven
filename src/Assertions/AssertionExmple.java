
package Assertions;

//An assertion allows testing the correctness of any assumptions that have been made in the program.
//Assertion is achieved using the assert statement in Java. 
//While executing assertion, it is believed to be true. 
//If it fails, JVM throws an error named AssertionError. 
//It is mainly used for testing purposes during development.
//The assert statement is used with a Boolean expression and can be written in two different ways.

//First way : assert expression;
//Second way : assert expression1 : expression2;
// Asserions have to be enabled by providing -ea with args in command line: java –ea AssertionExmple

import java.util.Scanner; 
//with -ea this class throws Exception 
//in thread "main" java.lang.AssertionError:  Underweight
//        at Test.main(Test.java:4)
public class AssertionExmple {
    public static void main(String args[]){ 
        int value = 15; 
        assert value >= 20 : " Underweight"; 
        System.out.println("value is "+value); 
    } 
} 