# Rational Calculator


## Introduction

The goal of this exercise is to implement a calculator that allows you to make exact calculations with rational numbers. A rational number consists of a numerator and a denominator separated by a slash, e.g. `2/3`. Allowed operations are additions (`+`), subtractions (`-`), multiplications (`*`), and divisions (`:`). The result of a calculation shall always be reduced, e.g. the result of `1/2 + 1/6` is `2/3`.


## Rational Number Class

Implement an *immutable* and *final* class `RationalNumber` which represents rational numbers.

The class has two constructors, one which takes only the numerator as argument (the denominator is set to 1), and one which takes the numerator and denominator as arguments (an `IllegalArgumentException` is thrown if the denominator is 0). The latter constructor reduces and normalizes the numerator and denominator such that their greatest common divisor is 1 and the denominator is positive.

_@Kotlin: Use an `Init`-Block to validate the parameters of the constructor and to reduce and normalize the numerator and denominator._

Furthermore, the class provides the following methods:

- `getNumerator` and `getDenominator` to obtain the numerator and denominator of the rational number
- `negative` and `reciprocal` to calculate the negative and reciprocal of the rational number
- `add`, `subtract`, `multiply` and `divide` which take another rational number as argument and return the sum, difference, product and quotient of the two numbers
- `equals`, `hashCode` and `toString` to test if the rational number is equal to another one, and to create a hash code or a string representation of the rational number

Use the test class `RationalNumberTest` to verify your implementation.


## Rational Calculator Class

Implement a class `RationalCalculator` which allows a user to perform rational calculations. The class has the following the static methods:

- The `convert` method takes a string representing a rational number and returns the corresponding `RationalNumber` object. 
  Hint: Create a `Scanner` object on the string, set `/` as delimiter and use the `nextInt`method to obtain the numerator and denominator.
- The `evaluate` method takes a string representing of a rational expression and returns its value as `RationalNumber` object.
  Hint: Create a `Scanner` object on the string and use the `next` method with the regex patterns `-?[0-9]+(/-?[0-9]+)?` and `[+\\-*:]` to obtain the next rational number or operator (see class [java.util.regex.Pattern]()) for a description of the regex syntax)
- The `main` method repeatedly prompts the user to enter a rational expression and displays its value, e.g.

```
> 1 + 1/2
3/2
> 1 + 1/2 - 1/6
4/3
> 1 + 1/2 - 1/6 * 1/4
1/3
> 1 + 1/2 - 1/6 * 1/4 : 1/3
1
```

Use the test class `RationalCalculatorTest` to verify your implementation.

_@Kotlin: Kotlin does not know static methods, use top level functions instead. To be called correctly from the test class, insert the following annotation into your Kotlin file (as the first line):_

```
@file:JvmName("RationalCalculator")
```


## Remarks

- A valid rational expression is defined by the following [Backus-Naur form](https://en.wikipedia.org/wiki/Backus-Naur_form):

```
<rational_expression> ::= <rational_number> | <rational_expression> " " <operator> " " <rational_number>
<rational_number> ::= <integer> "/" <integer>
<integer> ::= <unsigned_integer> | "-" <unsigned_integer>
<unsigned_integer> ::= <digit> | <digit> <unsigned_integer>
<digit> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
<operator> ::= "+" | "-" | "*" | ":"
```

- If an input line does not contain a valid expression, a corresponding error message shall be displayed.
- The expressions are evaluated from left to right without regard to an operator precedence.


## Extra Task

The test class `RationalNumberTest` uses random numbers between 0 and 1000. If this bound is removed, the tests will often fail. Why is that and how could this behavior be corrected?
