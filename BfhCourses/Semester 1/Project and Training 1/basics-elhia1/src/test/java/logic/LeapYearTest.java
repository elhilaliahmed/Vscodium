/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//CHECKSTYLE:OFF MagicNumber
class LeapYearTest {

	@Test
	void leapYear2() {
		for (int i = 1; i < 2500; i++) {
			if (i % 4 != 0) {
				Assertions.assertFalse(LeapYear.leapYear(i), "LeapYear(" + i + ")");
			} else if (i % 100 == 0 && i % 400 != 0) {
				Assertions.assertFalse(LeapYear.leapYear(i), "LeapYear(" + i + ")");
			} else {
				Assertions.assertTrue(LeapYear.leapYear(i), "LeapYear(" + i + ")");
			}
		}
	}

	@Test
	void leapYear1() {
		Assertions.assertTrue(LeapYear.leapYear(800), "LeapYear(800)");
		Assertions.assertFalse(LeapYear.leapYear(1995), "LeapYear(1995)");
		Assertions.assertTrue(LeapYear.leapYear(1996), "LeapYear(1996)");
		Assertions.assertTrue(LeapYear.leapYear(2000), "LeapYear(2000)");
		Assertions.assertFalse(LeapYear.leapYear(1900), "LeapYear(1900)");
		Assertions.assertTrue(LeapYear.leapYear(1600), "LeapYear(1600)");
		Assertions.assertFalse(LeapYear.leapYear(2019), "LeapYear(2019)");
		Assertions.assertFalse(LeapYear.leapYear(2222), "LeapYear(2222)");
	}
}
