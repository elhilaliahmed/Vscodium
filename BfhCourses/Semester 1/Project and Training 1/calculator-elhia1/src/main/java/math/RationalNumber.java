/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */
package math;
import java.util.Objects;

/**
 * RationalNumber is an immutable class that represents a rational numbers
 * @author ahmed elhilali
 */
public final class RationalNumber {
      private int numerator;
      private int denominator = 1;

    /**
     * RationalNumber constructor that takes only the numerator as an argument.
      * @param numerator
     */
    public RationalNumber(int numerator) {
        this.numerator = numerator;
    }

    /**
     * RationalNumber constructor that take a numerator and a denominator as arguments.
     * The constructor reduces and normalizes the numerator and denominator by using the reduction method.
     * @param numerator
     * @param denominator
     */
    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException();
        reduction(numerator, denominator);
    }

    /**
     * returns the numerator.
     * @return numerator.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * returns the denominator.
     * @return denominator.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * This method reduces and normalizes the numerator and the denominator by dividing them on the gcd.
     * Examples: reduction(5, 10)    --> (1,2)
     *           reduction(-5,-10)   --> (1,2)
     *           reduction(-5, 10)   --> (-1,2)
     *           reduction(5, -10)   --> (-1,2)
     * @param numerator
     * @param denominator
     */
    private void reduction(int numerator, int denominator) {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        if (gcd == 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        else {
            this.numerator = numerator / gcd;
            this.denominator = denominator /gcd;
        }
    }

    /**
     * This methods find the greatest common divisor (gcd) between any two numbers.
     * @param a first argument
     * @param b second argument
     * @return gcd
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * This method adds two rational numbers and reduces them.
     * @param rationalNumber
     * @return a rational number
     */
    public RationalNumber add(RationalNumber rationalNumber){
        reduction(((numerator * rationalNumber.denominator) + (denominator * rationalNumber.numerator)), (denominator * rationalNumber.denominator));
        return this;
    }

    /**
     * this method substract two rational numbers and reduces them.
     * @param rationalNumber
     * @return a rational number
     */
    public RationalNumber subtract(RationalNumber rationalNumber){
        reduction(((numerator * rationalNumber.denominator) - (denominator * rationalNumber.numerator)), (denominator * rationalNumber.denominator));
        return this;
    }

    /**
     * this method multiply two rational numbers and reduces them.
     * @param rationalNumber
     * @return a rational number
     */
    public RationalNumber multiply(RationalNumber rationalNumber) {
        reduction((numerator * rationalNumber.numerator), (denominator * rationalNumber.denominator));
        return this;
    }

    /**
     * this method divide two rational numbers and reduces them.
     * @param rationalNumber
     * @return a rational number
     */
    public RationalNumber divide(RationalNumber rationalNumber){
        return multiply(rationalNumber.reciprocal());
    }

    /**
     * This method calculates the negative number of the rational number
     * @return a rational number
     */
    public RationalNumber negative(){
        return new RationalNumber(numerator, -denominator);
    }

    /**
     * this method calculates the reciprocal number of the rational number
     * @return a rational number
     */
    public RationalNumber reciprocal() {
        return new RationalNumber(denominator, numerator);
    }


    /**
     * This method compares two rational numbers to validate if they are equal.
     * @param o is the object that the equals method will try to compare with the rational number.
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof RationalNumber) {
            RationalNumber rationalNumber = (RationalNumber) o;
            return ((numerator == rationalNumber.numerator) && (denominator == rationalNumber.denominator));
        }
        return false;
    }

    /**
     * This method calculates the hashcode of a rational number using the numerator and the denominator.
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    /**
     * This methods creates a string representation of the rational number.
     * @return a rational number as a string
     */
    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }
}

