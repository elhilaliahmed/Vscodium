/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//CHECKSTYLE:OFF MagicNumber
class FridgeTest {

	private Fridge fridge = new Fridge(10, 2.0);

	@Test
	void testFillMilk() {
		double milkBefore = fridge.getLitersOfMilk();
		fridge.fillMilk(1.0);
		assertEquals(milkBefore + 1.0, fridge.getLitersOfMilk());
	}

	@Test
	void testFillDrinks() {
		int drinksBefore = fridge.getNumberOfDrinks();
		fridge.fillDrinks(5);
		assertEquals(drinksBefore + 5, fridge.getNumberOfDrinks());
	}

	@Test
	void testTakeDrinksNotEnough() {
		int drinksBefore = fridge.getNumberOfDrinks();
		String res = "";
		for (int i = 0; i < drinksBefore + 1; i++) {
			res = fridge.takeADrink();
		}
		assertEquals("Not enough drinks!", res);

	}

	@Test
	void testTakeMilkNotEnough() {
		double milkBefore = fridge.getLitersOfMilk();
		assertEquals("Not enough milk!", fridge.takeMilk(milkBefore + 0.4));
	}

	@Test
	void testTakeDrinks() {
		int drinksBefore = fridge.getNumberOfDrinks();
		if (drinksBefore < 1) {
			fridge.fillDrinks(5);
		}
		assertEquals("Here is your drink.", fridge.takeADrink());
	}

	@Test
	void testTakeMilk() {
		double milkBefore = fridge.getLitersOfMilk();
		assertEquals("Here is your milk.", fridge.takeMilk(milkBefore - 0.4));

	}

}
