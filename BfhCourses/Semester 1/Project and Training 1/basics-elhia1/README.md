# Basics
## String Functions
### Arrow
Write a method which returns an "arrow" string as result, e.g. "--->>" or "<====", etc.
There are three parameters. The first indicates how long the arrow is (without the arrowhead),
where a positive value means an arrow from left to right and a negative value means an arrow from right to left.
The second parameter indicates whether the arrowhead consists of 2 characters (">>" instead of ">"),
and the third whether the arrow itself is a double arrow ("=" instead of "-").
An arrow of length 0 has no arrowhead.

### CountDogs
Count the occurrence of the string "dog" in the given string (contains only lowercase letters).
Also accept the vowels "a,e,i,u" instead of the "o" in "dog".

### LeftN
Given a string, return a "rotated left n" version where the first n chars are moved to the end.
* leftN("Hello",2) → "lloHe"
* leftN("java",0) → "java"
* leftN("Hi,1") → "iH"

## Logic
### ThreeDice
Implement a method that returns the number of possible combinations in which a red, a green and a blue die
add up to a sum.

Example for sum = 17:
The sum 17 is possible with {red = 5, green = 6, blue = 6} or {red = 6, green = 5, blue = 6} or
{red = 6, green = 6, blue = 5}. So there are 3 possible combinations with a total of 17.

### LoneSum
Given a Array of int values (all between 0 and 9), return their sum. However, iIf one of the values occurs more than once,
it does not count towards the sum.
* loneSum([1, 2, 3]) → 6
* loneSum([3, 2, 3]) → 2
* loneSum([3, 3, 3]) → 0

### LeapYear
Implement a method that checks whether the year with the specified year number (for example, 2017)
is a leap year. The method returns 'true' if year is a leap year.

The rules for determining leap years are as follows:
1. A year is NOT a leap year if the year is NOT divisible by four.
2. A year is NOT a leap year if the year number is divisible by 100, unless the number is also divisible by 400.
3. In all other cases, the year shall be a leap year.

## Array Functions
### MostFrequentDigit
Implement a method getMostFrequentDigit() that gets a string of digits (0 to 9) and then returns the most common digit.

Example: 1 occurs most often in the string "13223111".

If there are several digits with the same frequency, return the smallest of these digits.
The string passed contains at least one digit, empty strings are not allowed.

### PairwiseSum
Write a method pairwiseSum(), which takes 2 adjacent values from a given int array and
adds them up. The results are stored in a new int array and returned.
E.g.:
* {1, 5, 10} => {6, 15}
* {2,2} -> {4}
* {3} -> {}

### SameNumbers
Implement a method sameNumbers(), which tests whether the same numbers occur in the two given int arrays.
E.g.: {1, 2} ,  {1, 1, 2} -> true

