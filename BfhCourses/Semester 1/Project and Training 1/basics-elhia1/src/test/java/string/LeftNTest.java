/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static string.LeftN.leftN;

//CHECKSTYLE:OFF MagicNumber
class LeftNTest {

	static final int NBR_TESTS = 20;

	@Test
	void leftN1() {
		for (int i = 0; i < NBR_TESTS; i++) {
			Assertions.assertEquals("", leftN("", i));
		}
	}

	@Test
	void leftN2() {
		for (int i = 0; i < NBR_TESTS; i++) {
			Assertions.assertEquals("a", leftN("a", i));
		}
	}

	@Test
	void leftN3() {
		Assertions.assertEquals("Hi", leftN("Hi", 0));
		Assertions.assertEquals("iH", leftN("Hi", 1));
		for (int i = 2; i < NBR_TESTS; i++) {
			Assertions.assertEquals("Hi", leftN("Hi", i));
		}
	}

	@Test
	void leftN4() {
		Assertions.assertEquals("ABC", leftN("ABC", 0));
		Assertions.assertEquals("BCA", leftN("ABC", 1));
		Assertions.assertEquals("CAB", leftN("ABC", 2));
		for (int i = 3; i < NBR_TESTS; i++) {
			Assertions.assertEquals("ABC", leftN("ABC", i));
		}
	}

	@Test
	void leftN5() {
		Assertions.assertEquals("java", leftN("java", 0));
		Assertions.assertEquals("avaj", leftN("java", 1));
		Assertions.assertEquals("vaja", leftN("java", 2));
		Assertions.assertEquals("ajav", leftN("java", 3));
		for (int i = 4; i < NBR_TESTS; i++) {
			Assertions.assertEquals("java", leftN("java", i));
		}
	}

	@Test
	void leftN6() {
		Assertions.assertEquals("Hello", leftN("Hello", 0));
		Assertions.assertEquals("elloH", leftN("Hello", 1));
		Assertions.assertEquals("lloHe", leftN("Hello", 2));
		Assertions.assertEquals("loHel", leftN("Hello", 3));
		Assertions.assertEquals("oHell", leftN("Hello", 4));
		for (int i = 5; i < NBR_TESTS; i++) {
			Assertions.assertEquals("Hello", leftN("Hello", i));
		}
	}
}
