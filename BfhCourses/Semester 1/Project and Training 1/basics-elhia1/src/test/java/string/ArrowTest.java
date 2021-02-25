/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrowTest {

	static final int NBR_TESTS = 20;

	@Test
	void arrow0() {
		Assertions.assertEquals("", Arrow.arrow(0, true, true));
		Assertions.assertEquals("", Arrow.arrow(0, false, true));
		Assertions.assertEquals("", Arrow.arrow(0, true, false));
		Assertions.assertEquals("", Arrow.arrow(0, false, false));
	}

	@Test
	void arrowSingleSingle() {
		for (int i = 1; i < NBR_TESTS; i++) {
			String result = Arrow.arrow(i, false, false);
			Assertions.assertEquals(i + 1, result.length());
			for (int j = 0; j < result.length() - 1; j++) {
				Assertions.assertEquals("-", result.substring(j, j + 1));
			}
			Assertions.assertEquals(">", result.substring(result.length() - 1));
		}
	}

	@Test
	void arrowSingleSingleNeg() {
		for (int i = 1; i < NBR_TESTS; i++) {
			String result = Arrow.arrow(-i, false, false);
			Assertions.assertEquals(i + 1, result.length());
			for (int j = 1; j < result.length(); j++) {
				Assertions.assertEquals("-", result.substring(j, j + 1));
			}
			Assertions.assertEquals("<", result.substring(0, 1));
		}
	}

	@Test
	void arrowSingleDouble() {
		for (int i = 1; i < NBR_TESTS; i++) {
			String result = Arrow.arrow(i, false, true);
			Assertions.assertEquals(i + 1, result.length());
			for (int j = 0; j < result.length() - 1; j++) {
				Assertions.assertEquals("=", result.substring(j, j + 1));
			}
			Assertions.assertEquals(">", result.substring(result.length() - 1));
		}
	}

	@Test
	void arrowSingleDoubleNeg() {
		for (int i = 1; i < NBR_TESTS; i++) {
			String result = Arrow.arrow(-i, false, true);
			Assertions.assertEquals(i + 1, result.length());
			for (int j = 1; j < result.length(); j++) {
				Assertions.assertEquals("=", result.substring(j, j + 1));
			}
			Assertions.assertEquals("<", result.substring(0, 1));
		}
	}

	@Test
	void arrowDoubleSingle() {
		for (int i = 1; i < NBR_TESTS; i++) {
			String result = Arrow.arrow(i, true, false);
			Assertions.assertEquals(i + 2, result.length());
			for (int j = 0; j < result.length() - 2; j++) {
				Assertions.assertEquals("-", result.substring(j, j + 1));
			}
			Assertions.assertEquals(">>", result.substring(result.length() - 2));
		}
	}

	@Test
	void arrowDoubleSingleNeg() {
		for (int i = 1; i < NBR_TESTS; i++) {
			String result = Arrow.arrow(-i, true, false);
			Assertions.assertEquals(i + 2, result.length());
			for (int j = 2; j < result.length(); j++) {
				Assertions.assertEquals("-", result.substring(j, j + 1));
			}
			Assertions.assertEquals("<<", result.substring(0, 2));
		}
	}

	@Test
	void arrowDoubleDouble() {
		for (int i = 1; i < NBR_TESTS; i++) {
			String result = Arrow.arrow(i, true, true);
			Assertions.assertEquals(i + 2, result.length());
			for (int j = 0; j < result.length() - 2; j++) {
				Assertions.assertEquals("=", result.substring(j, j + 1));
			}
			Assertions.assertEquals(">>", result.substring(result.length() - 2));
		}
	}

	@Test
	void arrowDoubleDoubleNeg() {
		for (int i = 1; i < NBR_TESTS; i++) {
			String result = Arrow.arrow(-i, true, true);
			Assertions.assertEquals(i + 2, result.length());
			for (int j = 2; j < result.length(); j++) {
				Assertions.assertEquals("=", result.substring(j, j + 1));
			}
			Assertions.assertEquals("<<", result.substring(0, 2));
		}
	}

}
