/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package math;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * RationalCalculator class allows the user to perform calculations on rational numbers.
 * @author ahmed elhilali
 */
public class RationalCalculator {
    private static final String ADD = "+";
    private static final String MULTIPLY = "*";
    private static final String SUBTRACT = "-";
    private static final String DIVIDE = ":";

    /**
     * This method takes a string and returns the corresponding RationalNumber object to it.
     * @param number is the string to be converted to a rational number
     * @return a rational number
     */
    public static RationalNumber convert(String number) {
        Scanner input = new Scanner(number.replaceAll("\\s","")).useDelimiter("[/]");
        int numerator = input.nextInt();
        int denominator;

        if (input.hasNextInt()) {
            denominator = input.nextInt();
        }
        else {
            denominator = 1;
        }
        return new RationalNumber(numerator, denominator);
    }

    /**
     * This method prompt the user to enter a rational expression as a string and returns its value as a rational number.
     * Examples: --> 1 + 1/2                       returns     3/2
     *           --> 1 + 1/2 - 1/6                 returns     4/3
     *           --> 1 + 1/2 - 1/6 * 1/4           returns     1/3
     *           --> 1 + 1/2 - 1/6 * 1/4 : 1/3     returns     1
     * @param number is the string to be converted to a rational number
     * @return a rational number
     */
    public static RationalNumber evaluate(String number) {
        RationalNumber rationalNumber;
        Scanner scanner = new Scanner(number);
        Pattern pattern = Pattern.compile("-?[0-9]+(/-?[0-9]+)?");
        Pattern operator = Pattern.compile("[+\\-*:]");
        Matcher matcher = pattern.matcher(scanner.next());
        if (matcher.find()) {
            rationalNumber = convert(matcher.group());
        }
        else {
            throw new IllegalArgumentException();
        }
        while (scanner.hasNext()) {
            Matcher operatorMatcher = operator.matcher(scanner.next());
            Matcher patternMatcher = pattern.matcher(scanner.next());
            if (!(operatorMatcher.find() && patternMatcher.find())) {
                throw new IllegalArgumentException();
            }
            switch (operatorMatcher.group()) {
                case ADD        -> rationalNumber.add(convert(patternMatcher.group()));
                case SUBTRACT   -> rationalNumber.subtract(convert(patternMatcher.group()));
                case MULTIPLY   -> rationalNumber.multiply(convert(patternMatcher.group()));
                case DIVIDE     -> rationalNumber.divide(convert(patternMatcher.group()));
            }
        }
        return rationalNumber;
    }
}
