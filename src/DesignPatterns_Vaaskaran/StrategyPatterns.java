package DesignPatterns_Vaaskaran;

import java.io.IOException;
//For Java old versions-to take input from user 
//import java.io.BufferedReader; 
//import java.io.InputStreamReader; 
/* Java 5 added a nice utility class called Scanner, to get input from user */

/**
 * GoF Definition: Define a family of algorithms, encapsulate each one, and make
 * them interchangeable. The strategy pattern lets the algorithm vary
 * independently from client to client. Concept We can select the behavior of an
 * algorithm dynamically at runtime
 */
import java.util.Scanner;

interface IChoice {

    void myChoice(String s1, String s2);
}

class FirstChoice implements IChoice {

    public void myChoice(String s1, String s2) {
        System.out.println("You wanted to add the numbers.");
        int int1, int2, sum;
        int1 = Integer.parseInt(s1);
        int2 = Integer.parseInt(s2);
        sum = int1 + int2;
        System.out.println(" The result of the addition is:" + sum);
        System.out.println("***End of the strategy***");
    }
}

class SecondChoice implements IChoice {

    public void myChoice(String s1, String s2) {
        System.out.println("You wanted to concatenate the numbers.");
        System.out.println(" The result of the addition is:" + s1 + s2);
        System.out.println("***End of the strategy***");
    }
}

class Context {

    IChoice myC;

    // Set a Strategy or algorithm in the Context 
    public void SetChoice(IChoice ic) {
        myC = ic;
    }

    public void ShowChoice(String s1, String s2) {
        myC.myChoice(s1, s2);
    }
}

class StrategyPatterns {

    public static void main(String[] args) throws IOException {
        System.out.println("***Strategy Pattern Demo***");
        Scanner in = new Scanner(System.in);//To take input from user 
        IChoice ic = null;
        Context cxt = new Context();
        String input1, input2;
        //Looping twice to test two different choices 
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println("Enter an integer:");
                input1 = in.nextLine();
                System.out.println("Enter another integer:");
                input2 = in.nextLine();
                System.out.println("Enter ur choice(1 or 2)");
                System.out.println("Press 1 for Addition, 2 for Concatenation");
                String c = in.nextLine();
                /*For Java old versions-use these lines to collect input from user 
				 BufferedReader br = new BufferedReader( new InputStreamReader( System.in )); 
				 String c = br.readLine();*/
                if (c.equals("1")) {
                    /*If user input is 1, create object of FirstChoice (Strategy 1)*/
                    ic = new FirstChoice();
                } else {
                    /*If user input is 2, create object of SecondChoice (Strategy 2)*/
                    ic = new SecondChoice();
                }
                /*Associate the Strategy with Context*/
                cxt.SetChoice(ic);
                cxt.ShowChoice(input1, input2);
            }
        } finally {
            in.close();
        }
        System.out.println("End of Strategy pattern");
    }
}
