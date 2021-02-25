/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloTest {

	@Test
	void test() {
		Hello hello = new Hello();
		String message = hello.sayHello("John");
		assertEquals("Hello, John!", message);
	}
}
