# Fridge

Write a class Fridge that organizes a fridge.

## Instance variables:

- number of drinks in the fridge
- amount of milk in the fridge (in liters)

_@Kotlin: Use mutable properties (keyword var)._ 

## Constructors:

The constructor receives and sets the initial values for the two instance variables.

_@Kotlin: The constructor is created implicitly, when properties are used._ 

## Methods:

Getter methods:

- `public int getNumberOfDrinks()`
- `public double getLitersOfMilk()`

_@Kotlin: Getter and also setter methods are created implicitly for all mutable properties._ 

- `public String takeADrink()`

This method is used when a drink is taken from the fridge.
When there are enough drinks in the fridge, it returns "Here is your drink.", otherwise it returns "Not enough drinks!"

- `public String takeMilk (double litersOfMilk)`

This method is used when milk is taken from the fridge.
When there is enough milk available, it returns "Here is your milk.", otherwise it returns "Not enough milk!"

- `public void fillMilk(double litersOfMilk)`
- `public void fillDrinks(int number)`

These methods are used to fill up the stock of milk and drinks in the fridge.

