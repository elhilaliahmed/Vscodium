/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

//CHECKSTYLE:OFF MagicNumber
class PairwiseSumTest {
	static final int NBR_TESTS = 20;
	private Random random = new Random();

	@Test
	void pairwiseSum1() {
		Assertions.assertArrayEquals(new int[] {}, PairwiseSum.pairwiseSum(new int[] {}));
	}

	@Test
	void pairwiseSum2() {
		for (int i = 0; i < NBR_TESTS; i++) {
			Assertions.assertArrayEquals(new int[] {}, PairwiseSum.pairwiseSum(new int[] { i }));
		}
	}

	@Test
	void pairwiseSum3() {
		for (int i = 0; i < NBR_TESTS; i++) {
			Assertions.assertArrayEquals(new int[] { i + i }, PairwiseSum.pairwiseSum(new int[] { i, i }));
			int r = random.nextInt(20);
			Assertions.assertArrayEquals(new int[] { i + r }, PairwiseSum.pairwiseSum(new int[] { i, r }));
		}
	}

	@Test
	void pairwiseSum4() {
		for (int i = 0; i < NBR_TESTS; i++) {
			Assertions.assertArrayEquals(new int[] { i + i, i + i }, PairwiseSum.pairwiseSum(new int[] { i, i, i }));
			int r = random.nextInt(20);
			int r2 = random.nextInt(10);
			Assertions.assertArrayEquals(new int[] { i + r, r + r2 }, PairwiseSum.pairwiseSum(new int[] { i, r, r2 }));
		}
	}

	@Test
	void pairwiseSum5() {
		for (int i = 0; i < NBR_TESTS; i++) {
			Assertions.assertArrayEquals(new int[] { i + i, i + i, i + i },
					PairwiseSum.pairwiseSum(new int[] { i, i, i, i }));
			int r = random.nextInt(20);
			int r2 = random.nextInt(10);
			int r3 = random.nextInt(30);
			Assertions.assertArrayEquals(new int[] { i + r, r + r2, r2 + r3 },
					PairwiseSum.pairwiseSum(new int[] { i, r, r2, r3 }));
		}
	}

	@Test
	void pairwiseSum6() {
		Assertions.assertArrayEquals(new int[] { 3, 5, 7, 9, 13, 17 },
				PairwiseSum.pairwiseSum(new int[] { 1, 2, 3, 4, 5, 8, 9 }));
	}
}
