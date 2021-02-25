package math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RationalCalculatorTest {

	private Random random = new Random();
	private int n = getRandomPrime();
	private int m = getRandomPrime();

	@BeforeEach
	void init() {
		System.out.println("Test data: n=" + n + ", m=" + m);
	}

	@Test
	void testConversion() {
		assertEquals(new RationalNumber(n), RationalCalculator.convert(String.valueOf(n)));
		assertEquals(new RationalNumber(n, m), RationalCalculator.convert(n + "/" + m));
		assertEquals(new RationalNumber(-n, m), RationalCalculator.convert("-" + n + "/" + m));
		assertEquals(new RationalNumber(-n, m), RationalCalculator.convert(n + "/-" + m));
		assertEquals(new RationalNumber(n, m), RationalCalculator.convert("-" + n + "/-" + m));
	}

	@Test
	void testEvaluation() {
		assertEquals(new RationalNumber(3, 2), RationalCalculator.evaluate("1 + 1/2"));
		assertEquals(new RationalNumber(4, 3), RationalCalculator.evaluate("1 + 1/2 - 1/6"));
		assertEquals(new RationalNumber(1, 3), RationalCalculator.evaluate("1 + 1/2 - 1/6 * 1/4"));
		assertEquals(new RationalNumber(1), RationalCalculator.evaluate("1 + 1/2 - 1/6 * 1/4 : 1/3"));
	}

	private int getRandomPrime() {
		while (true) {
			int n = random.nextInt(1000);
			if (n >= 2 && !IntStream.rangeClosed(2, (int) Math.sqrt(n)).filter(i -> n % i == 0).findFirst().isPresent())
				return n;
		}
	}
}
