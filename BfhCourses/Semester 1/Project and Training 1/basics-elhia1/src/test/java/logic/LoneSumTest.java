/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

//CHECKSTYLE:OFF MagicNumber
class LoneSumTest {

	static final int NBR_TESTS = 20;
	private Random random = new Random();

	@Test
	void loneSum0() {
		Assertions.assertEquals(0, LoneSum.loneSum(new int[] {}));
	}

	@Test
	void loneSum1() {
		for (int i = 0; i < NBR_TESTS; i++) {
			int r = random.nextInt(10);
			Assertions.assertEquals(r, LoneSum.loneSum(new int[] { r }));
			Assertions.assertEquals(0, LoneSum.loneSum(new int[] { r, r }));
			Assertions.assertEquals(0, LoneSum.loneSum(new int[] { r, r, r }));
			Assertions.assertEquals(0, LoneSum.loneSum(new int[] { r, r, r, r }));
		}
	}

	@Test
	void loneSum2() {
		for (int i = 0; i < NBR_TESTS; i++) {
			int r = random.nextInt(10);
			int r2 = random.nextInt(10);
			if (r != r2) {
				Assertions.assertEquals(r + r2, LoneSum.loneSum(new int[] { r, r2 }));
				Assertions.assertEquals(r2, LoneSum.loneSum(new int[] { r, r, r2 }));
				Assertions.assertEquals(0, LoneSum.loneSum(new int[] { r, r, r2, r2 }));
				Assertions.assertEquals(r, LoneSum.loneSum(new int[] { r, r2, r2, r2 }));
			}
		}
	}

	@Test
	void loneSum3() {
		Assertions.assertEquals(6, LoneSum.loneSum(new int[] { 1, 2, 3 }));
		Assertions.assertEquals(2, LoneSum.loneSum(new int[] { 3, 2, 3 }));
		Assertions.assertEquals(5, LoneSum.loneSum(new int[] { 1, 1, 1, 2, 3 }));
	}
}
