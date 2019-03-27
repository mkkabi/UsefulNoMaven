/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatting;

import java.util.Formattable;
import java.util.Formatter;
import java.util.FormattableFlags;

public class CustomFormatter implements Formattable {

    private String firstName = "Unknown";
    private String lastName = "Unknown";

    public CustomFormatter(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* Other code goes here... */
    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        String str = this.firstName + " " + this.lastName;
        int alternateFlagValue = FormattableFlags.ALTERNATE & flags;
        if (alternateFlagValue == FormattableFlags.ALTERNATE) {
            str = this.lastName + ", " + this.firstName;
        }
// Check if uppercase variant of the conversion is being used
        int upperFlagValue = FormattableFlags.UPPERCASE & flags;
        if (upperFlagValue == FormattableFlags.UPPERCASE) {
            str = str.toUpperCase();
        }
// Call the format() method of formatter argument,
// so our result is stored in it and the caller will get it
        formatter.format(str);
    }
}
