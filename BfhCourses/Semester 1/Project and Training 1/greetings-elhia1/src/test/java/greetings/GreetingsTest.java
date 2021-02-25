/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package greetings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GreetingsTest {

	@Test
	void testWrongCity() {
		assertEquals("City not found!", Greetings.getGreeting("BadCity"));
	}

	@Test
	void testGerman() {
		String[] cities = { "Berlin", "Bern", "BErn", "BERlin", "bern", "berlin" };
		for (int i = 0; i < cities.length; i++) {
			assertEquals("Guten Tag!", Greetings.getGreeting(cities[i]));
		}
	}

	@Test
	void testEnglish() {
		String[] cities = { "London", "london", "LONdon", "Boston", "BOSton", "boston" };
		for (int i = 0; i < cities.length; i++) {
			assertEquals("Hello!", Greetings.getGreeting(cities[i]));
		}
	}

	@Test
	void testFrench() {
		String[] cities = { "Paris", "PARis", "paris" };
		for (int i = 0; i < cities.length; i++) {
			assertEquals("Bonjour!", Greetings.getGreeting(cities[i]));
		}
	}

	@Test
	void testItalian() {
		String[] cities = { "Milano", "MILano", "milano" };
		for (int i = 0; i < cities.length; i++) {
			assertEquals("Ciao!", Greetings.getGreeting(cities[i]));
		}
	}

	@Test
	void testSpanish() {
		String[] cities = { "Madrid", "madrid", "MADrid" };
		for (int i = 0; i < cities.length; i++) {
			assertEquals("Hola!", Greetings.getGreeting(cities[i]));
		}
	}

}
