package math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class RationalNumberTest {

	private Random random = new Random();
	private int n = getRandomPrime();
	private int m = getRandomPrime();
	private int p = getRandomPrime();
	private int q = getRandomPrime();
	private int r = getRandomPrime();

	@BeforeEach
	void init() {
		while (m == n) m = getRandomPrime();
		while (p == n || p == m) p = getRandomPrime();
		while (q == n || q == m || q == p) q = getRandomPrime();
		System.out.println("Test data: n=" + n + ", m=" + m + ", p=" + p + ", q=" + q + ", r=" + r);
	}

	@Test
	void testCreation() {
		RationalNumber x = new RationalNumber(n);
		assertEquals(n, x.getNumerator());
		assertEquals(1, x.getDenominator());
		x = new RationalNumber(n, m);
		assertEquals(n, x.getNumerator());
		assertEquals(m, x.getDenominator());
	}

	@Test
	void testReduction() {
		RationalNumber x = new RationalNumber(r * n, r * m);
		assertEquals(n, x.getNumerator());
		assertEquals(m, x.getDenominator());
	}

	@Test
	void testNormalization() {
		RationalNumber x = new RationalNumber(n, -m);
		assertEquals(-n, x.getNumerator());
		assertEquals(m, x.getDenominator());
		x = new RationalNumber(-n, -m);
		assertEquals(n, x.getNumerator());
		assertEquals(m, x.getDenominator());
	}

	@Test
	void testZeroDenominator() {
		assertThrows(IllegalArgumentException.class, () -> new RationalNumber(n, 0));
	}

	@Test
	void testNegative() {
		RationalNumber x = new RationalNumber(n, m);
		RationalNumber y = x.negative();
		assertEquals(-n, y.getNumerator());
		assertEquals(m, y.getDenominator());
	}

	@Test
	void testReciprocal() {
		RationalNumber x = new RationalNumber(n, m);
		RationalNumber y = x.reciprocal();
		assertEquals(m, y.getNumerator());
		assertEquals(n, y.getDenominator());
	}

	@Test
	void testAdd() {
		RationalNumber x = new RationalNumber(n, m);
		RationalNumber y = new RationalNumber(p, q);
		RationalNumber z = x.add(y);
		assertEquals(n * q + m * p, z.getNumerator());
		assertEquals(m * q, z.getDenominator());
	}

	@Test
	void testSubtract() {
		RationalNumber x = new RationalNumber(n, m);
		RationalNumber y = new RationalNumber(p, q);
		RationalNumber z = x.subtract(y);
		assertEquals(n * q - m * p, z.getNumerator());
		assertEquals(m * q, z.getDenominator());
	}

	@Test
	void testMultiply() {
		RationalNumber x = new RationalNumber(n, m);
		RationalNumber y = new RationalNumber(p, q);
		RationalNumber z = x.multiply(y);
		assertEquals(n * p, z.getNumerator());
		assertEquals(m * q, z.getDenominator());
	}

	@Test
	void testDivide() {
		RationalNumber x = new RationalNumber(n, m);
		RationalNumber y = new RationalNumber(p, q);
		RationalNumber z = x.divide(y);
		assertEquals(n * q, z.getNumerator());
		assertEquals(m * p, z.getDenominator());
	}

	@Test
	void testEquals() {
		RationalNumber x = new RationalNumber(n, m);
		RationalNumber y = new RationalNumber(n, m);
		assertEquals(x, y);
	}

	@Test
	void testHashCode() {
		RationalNumber x = new RationalNumber(n, m);
		RationalNumber y = new RationalNumber(n, m);
		assertEquals(x.hashCode(), y.hashCode());
	}

	@Test
	void testToString() {
		assertEquals(String.valueOf(n), new RationalNumber(n).toString());
		assertEquals(n + "/" + m, new RationalNumber(n, m).toString());
		assertEquals(-n + "/" + m, new RationalNumber(-n, m).toString());
	}

	@Test
	void testRationalNumberAbstract() {
		// Vehicle class must be abstract
		assertTrue(Modifier.isFinal( RationalNumber.class.getModifiers()));
	}

	@Test
	void testRationalNumberSetter() {
		assertThrows(NoSuchMethodException.class,
				() -> RationalNumber.class.getMethod("setNumerator",
						int.class),
				"Class RationalNumber shouldn't have a public method " +
						"setNumerator(int i)");
		assertThrows(NoSuchMethodException.class,
				() -> RationalNumber.class.getMethod("setDenominator ",
						int.class),
				"Class RationalNumber shouldn't have a public method " +
						"setDenominator(int i)");
	}


	private int getRandomPrime() {
		while (true) {
			int n = random.nextInt(1000);
			if (n >= 2 && !IntStream.rangeClosed(2, (int) Math.sqrt(n)).filter(i -> n % i == 0).findFirst().isPresent())
				return n;
		}
	}
}
