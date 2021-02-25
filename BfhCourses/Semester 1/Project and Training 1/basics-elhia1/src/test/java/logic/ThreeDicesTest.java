/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//CHECKSTYLE:OFF MagicNumber
class ThreeDicesTest {

	@Test
	void getNbrOfCombinations0() {
		Assertions.assertEquals(0, ThreeDice.getNbrOfCombinations(0));
		Assertions.assertEquals(0, ThreeDice.getNbrOfCombinations(1));
		Assertions.assertEquals(0, ThreeDice.getNbrOfCombinations(2));
	}

	@Test
	void getNbrOfCombinations1() {
		Assertions.assertEquals(1, ThreeDice.getNbrOfCombinations(3));
		Assertions.assertEquals(3, ThreeDice.getNbrOfCombinations(4));
		Assertions.assertEquals(6, ThreeDice.getNbrOfCombinations(5));
		Assertions.assertEquals(10, ThreeDice.getNbrOfCombinations(6));
		Assertions.assertEquals(15, ThreeDice.getNbrOfCombinations(7));
	}

	@Test
	void getNbrOfCombinations2() {
		Assertions.assertEquals(21, ThreeDice.getNbrOfCombinations(8));
		Assertions.assertEquals(25, ThreeDice.getNbrOfCombinations(9));
		Assertions.assertEquals(27, ThreeDice.getNbrOfCombinations(10));
		Assertions.assertEquals(27, ThreeDice.getNbrOfCombinations(11));
		Assertions.assertEquals(25, ThreeDice.getNbrOfCombinations(12));
	}

	@Test
	void getNbrOfCombinations3() {
		Assertions.assertEquals(21, ThreeDice.getNbrOfCombinations(13));
		Assertions.assertEquals(15, ThreeDice.getNbrOfCombinations(14));
		Assertions.assertEquals(10, ThreeDice.getNbrOfCombinations(15));
		Assertions.assertEquals(6, ThreeDice.getNbrOfCombinations(16));
		Assertions.assertEquals(3, ThreeDice.getNbrOfCombinations(17));
		Assertions.assertEquals(1, ThreeDice.getNbrOfCombinations(18));
	}

	@Test
	void getNbrOfCombinations4() {
		Assertions.assertEquals(0, ThreeDice.getNbrOfCombinations(19));
		Assertions.assertEquals(0, ThreeDice.getNbrOfCombinations(20));
		Assertions.assertEquals(0, ThreeDice.getNbrOfCombinations(30));
		Assertions.assertEquals(0, ThreeDice.getNbrOfCombinations(50));

	}

}
