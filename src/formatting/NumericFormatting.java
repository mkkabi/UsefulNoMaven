/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatting;

import java.util.Locale;

/**
 *
 * @author matt
 */
public class NumericFormatting {

    public static void main(String[] args) {
        Locale englishUS = new Locale("en", "US");
        Locale hindiIndia = new Locale("hi", "IN");
        Locale thaiThailand = new Locale("th", "TH", "TH");
        System.out.printf(englishUS, "%d %n", 1234567890);
        System.out.printf(hindiIndia, "%d %n", 1234567890);
        System.out.printf(thaiThailand, "%d %n", 1234567890);
    }

}
