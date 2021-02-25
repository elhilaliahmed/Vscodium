/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//CHECKSTYLE:OFF MagicNumber
class MostFrequentDigitTest {

	@Test
	void getMostFrequentDigit1() {
		Assertions.assertEquals(1, MostFrequentDigit.getMostFrequentDigit("13223111"));
	}

	@Test
	void getMostFrequentDigit2() {
		Assertions.assertEquals(1, MostFrequentDigit.getMostFrequentDigit("1112"));
		Assertions.assertEquals(6, MostFrequentDigit.getMostFrequentDigit("6"));
	}

	@Test
	void getMostFrequentDigit3() {
		Assertions.assertEquals(0, MostFrequentDigit.getMostFrequentDigit("0123456789"));
	}

	@Test
	void getMostFrequentDigit4() {
		Assertions.assertEquals(0, MostFrequentDigit.getMostFrequentDigit("30102017"));
	}

	@Test
	void getMostFrequentDigit5() {
		Assertions.assertEquals(1, MostFrequentDigit.getMostFrequentDigit("4441110"));
	}

	@Test
	void getMostFrequentDigit6() {
		Assertions.assertEquals(1, MostFrequentDigit.getMostFrequentDigit("15234123412312314123"));
	}

	@Test
	void getMostFrequentDigit7() {
		Assertions.assertEquals(4, MostFrequentDigit.getMostFrequentDigit("544554455445544"));
	}

	@Test
	void getMostFrequentDigit8() {
		Assertions.assertEquals(3, MostFrequentDigit.getMostFrequentDigit("4362345563"));
	}

	@Test
	void getMostFrequentDigit9() {
		Assertions.assertEquals(3, MostFrequentDigit.getMostFrequentDigit("94362345563"));
	}

	@Test
	void getMostFrequentDigit10() {
		Assertions.assertEquals(3, MostFrequentDigit.getMostFrequentDigit("31256845328645354385743"));
	}

	@Test
	void getMostFrequentDigit11() {
		Assertions.assertEquals(1, MostFrequentDigit.getMostFrequentDigit("1211212343"));
	}
}
