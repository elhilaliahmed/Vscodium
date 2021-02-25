/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

//CHECKSTYLE:OFF MagicNumber
class SameNumbersTest {

	static final int NBR_TESTS = 20;
	private Random random = new Random();

	@Test
	void sameNumbers1() {
		Assertions.assertEquals(true, SameNumbers.sameNumbers(new int[] {}, new int[] {}),
				"SameNumbers.sameNumbers(new int[]{}, new int[]{})");
	}

	@Test
	void sameNumbers2() {
		for (int i = 0; i < NBR_TESTS; i++) {
			int r = random.nextInt(20);
			Assertions.assertFalse(SameNumbers.sameNumbers(new int[] {}, new int[] { r }),
					"SameNumbers.sameNumbers(new int[]{}, new int[]{r})");
			Assertions.assertFalse(SameNumbers.sameNumbers(new int[] { r }, new int[] {}),
					"SameNumbers.sameNumbers(new int[]{r}, new int[]{})");
			Assertions.assertTrue(SameNumbers.sameNumbers(new int[] { r }, new int[] { r }),
					"SameNumbers.sameNumbers(new int[]{r}, new int[]{r})");
		}
	}

	@Test
	void sameNumbers3() {
		for (int i = 0; i < NBR_TESTS; i++) {
			int r = random.nextInt(20);
			int constvalue = 5;
			if (r != constvalue) {
				Assertions.assertFalse(SameNumbers.sameNumbers(new int[] { constvalue }, new int[] { r, constvalue }),
						"SameNumbers.sameNumbers(new int[]{" + constvalue + "}, new int[]{r," + constvalue + "})");
				Assertions.assertFalse(SameNumbers.sameNumbers(new int[] { r, constvalue }, new int[] { constvalue }),
						"SameNumbers.sameNumbers(new int[]{r," + constvalue + "}, new int[]{" + constvalue + "})");
			} else {
				Assertions.assertTrue(SameNumbers.sameNumbers(new int[] { constvalue }, new int[] { r, constvalue }),
						"SameNumbers.sameNumbers(new int[]{" + constvalue + "})");
				Assertions.assertTrue(SameNumbers.sameNumbers(new int[] { r, constvalue }, new int[] { constvalue }),
						"SameNumbers.sameNumbers(new int[]{r, " + constvalue + "}, new int[]{" + constvalue + "})");
			}
		}
	}

	@Test
	void sameNumbers4() {
		Assertions.assertTrue(SameNumbers.sameNumbers(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }),
				"SameNumbers.sameNumbers(new int[]{1, 2, 3}, new int[]{3, 2, 1})");
		Assertions.assertTrue(SameNumbers.sameNumbers(new int[] { 1, 2, 3 }, new int[] { 3, 3, 2, 1 }),
				"SameNumbers.sameNumbers(new int[]{1, 2, 3}, new int[]{3, 3, 2, 1})");
		Assertions.assertFalse(SameNumbers.sameNumbers(new int[] { 1, 2, 3 }, new int[] { 3, 4, 2, 1 }),
				"ameNumbers.sameNumbers(new int[]{1, 2, 3}, new int[]{3, 4, 2, 1})");
		Assertions.assertTrue(SameNumbers.sameNumbers(new int[] { 1, 2 }, new int[] { 2, 1, 1 }),
				"SameNumbers.sameNumbers(new int[]{1, 2}, new int[]{2, 1, 1})");
		Assertions.assertTrue(SameNumbers.sameNumbers(new int[] { 1, 2, 2 }, new int[] { 2, 1, 1 }),
				"SameNumbers.sameNumbers(new int[]{1, 2, 2}, new int[]{2, 1, 1})");
	}

}
