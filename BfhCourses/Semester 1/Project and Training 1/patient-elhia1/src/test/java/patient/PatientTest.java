/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package patient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//CHECKSTYLE:OFF MagicNumber
public class PatientTest {

	private Patient p1 = new Patient("Jim Smith");
	private Patient p2 = new Patient("John Miller");

	@Test
	public void testToString() {
		p1.addCheckup(180, 80, 36.5, true);
		p2.addCheckup(170, 72, 36.2, false);
		String res = p1.toString();
		assertEquals("Name: Jim Smith,Height: 180,Weight: 80.0," + "Temperature: 36.5", res);
	}

	@Test
	public void testGetTemp() {
		Checkup checkup = new Checkup(150, 50, 36.4, true);
		assertEquals(checkup.getTemperature(), 36.4);
	}

	@Test
	void testGetHeight() {
		Checkup checkup = new Checkup(150, 50, 36.4, true);
		assertEquals(checkup.getHeight(), 150);
	}

	@Test
	void testGetWeight() {
		Checkup checkup = new Checkup(150, 50, 36.4, true);
		assertEquals(checkup.getWeight(), 50);
	}

	@Test
	void testGetVaccs() {
		Checkup checkup = new Checkup(150, 50, 36.4, true);
		assertEquals(checkup.getVaccsOk(), true);
	}

	@Test
	void testCheckUpSetters() {
		assertThrows(NoSuchMethodException.class, () -> {
			Checkup.class.getMethod("setHeight", int.class);
		}, "Class Checkup shouldn't have a public method " + "setHeight(int i)");

		assertThrows(NoSuchMethodException.class, () -> {
			Checkup.class.getMethod("setWeight", double.class);
		}, "Class Checkup shouldn't have a public method " + "setWeight(double i)");

		assertThrows(NoSuchMethodException.class, () -> {
			Checkup.class.getMethod("setTemperature", double.class);
		}, "Class Checkup shouldn't have a public method " + "setTemperature(double i)");

		assertThrows(NoSuchMethodException.class, () -> {
			Checkup.class.getMethod("setVaccsOk", boolean.class);
		}, "Class Checkup shouldn't have a public method " + "setVaccsOk(boolean i)");

	}

	@Test
	void testPatientSetters() {
		assertThrows(NoSuchMethodException.class, () -> {
			Patient.class.getMethod("setName", String.class);
		}, "Class Patient shouldn't have a public method " + "setName(String i)");
		assertThrows(NoSuchMethodException.class, () -> {
			Patient.class.getMethod("setLastCheckup", Checkup.class);
		}, "Class Patient shouldn't have a public method " + "setLastCheckup(Checkup i)");
	}

}
