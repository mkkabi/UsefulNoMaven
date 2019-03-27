/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatting;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author matt
 */
public class StringFormatting {
    
    /*
    The general syntax for a format specifier is as follows:
    %<argument-index$><flags><width><.precision><conversion>
    */

    public static void main(String[] args) {
        LocalDate dob = LocalDate.of(1970, Month.JANUARY, 16);
        String name = "Vasia";
        System.out.printf("%1$tB %1$td, %1$tY is %2$s's birth day. %n", dob, name);
    }

}
