/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//CHECKSTYLE:OFF MagicNumber
class CountDogsTest {

	// Testfall fehlt !!!! "dogdogdog" -> 3

	@Test
	void countDogs1() {
		Assertions.assertEquals(0, CountDogs.countDogs(""));
		Assertions.assertEquals(0, CountDogs.countDogs("a"));
		Assertions.assertEquals(0, CountDogs.countDogs("do"));
		Assertions.assertEquals(0, CountDogs.countDogs(" "));
		Assertions.assertEquals(0, CountDogs.countDogs("    "));
	}

	@Test
	void countDogs2() {
		Assertions.assertEquals(1, CountDogs.countDogs("dog"));
		Assertions.assertEquals(1, CountDogs.countDogs("  dug  "));
		Assertions.assertEquals(1, CountDogs.countDogs(" dag "));
		Assertions.assertEquals(1, CountDogs.countDogs(" dig"));
		Assertions.assertEquals(1, CountDogs.countDogs("deg "));
	}

	@Test
	void countDogs3() {
		Assertions.assertEquals(0, CountDogs.countDogs("dgg"));
		Assertions.assertEquals(0, CountDogs.countDogs("dod"));
		Assertions.assertEquals(0, CountDogs.countDogs("dacdoc"));
	}

	@Test
	void countDogs4() {
		Assertions.assertEquals(5, CountDogs.countDogs("dagdegdigdugdog"));
		Assertions.assertEquals(1, CountDogs.countDogs("abc.dog"));
		Assertions.assertEquals(1, CountDogs.countDogs("dadagag"));
		Assertions.assertEquals(1, CountDogs.countDogs("dogdo"));
	}

	@Test
	void countDogs5() {
		Assertions.assertEquals(2, CountDogs.countDogs("dogdog"));
		Assertions.assertEquals(3, CountDogs.countDogs("dogdogdog"));
		Assertions.assertEquals(3, CountDogs.countDogs("dagdagdog"));
		Assertions.assertEquals(4, CountDogs.countDogs("digdigdigdig"));
	}

}
