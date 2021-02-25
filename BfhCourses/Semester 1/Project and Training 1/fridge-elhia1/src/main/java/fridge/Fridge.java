/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package fridge;

public class Fridge {

    private int drinksNumber;
    private double milkAmount;

    public Fridge(int drinksNumber, double milkAmount) {
        this.drinksNumber = drinksNumber;
        this.milkAmount = milkAmount;
    }

    public int getNumberOfDrinks() {
        return drinksNumber;
    }

    public double getLitersOfMilk() {
        return milkAmount;
    }

    public String takeADrink() {
        if (drinksNumber >= 1 ) {
            drinksNumber--;
            return "Here is your drink.";
        }
        else {
            return "Not enough drinks!";
        }
    }

    public String takeMilk(double litersOfMilk) {
        if (milkAmount > litersOfMilk) {
            return "Here is your milk.";
        }
        else {
            return "Not enough milk!";
        }
    }

    public void fillMilk(double litersOfMilk) {
        milkAmount += litersOfMilk;
    }

    public void fillDrinks(int number) {
        drinksNumber += number;
    }
}
