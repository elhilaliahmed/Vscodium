package callcontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PhoneNumberTest {
	private PhoneNumber phoneNumber;
	
	@Test
	void testNoTreatment() {
		phoneNumber = new PhoneNumber("+41", "44", "7258912");
		assertEquals("+41 44/725 8912", phoneNumber.toString());
	}

	@Test
	void testCountryCodeWithZeros() {
		phoneNumber = new PhoneNumber("0041", "44", "7258912");
		assertEquals("+41 44/725 8912", phoneNumber.toString());
	}

	@Test
	void testCountryCodeWithoutPlus() {
		phoneNumber = new PhoneNumber("41", "44", "7258912");
		assertEquals("+41 44/725 8912", phoneNumber.toString());
	}
	
	@Test
	void testCountryAreaCodeWithZero() {
		phoneNumber = new PhoneNumber("+41", "044", "7258912");
		assertEquals("+41 44/725 8912", phoneNumber.toString());
	}

	@Test
	void testPhoneNumberSetter() {
		assertThrows(NoSuchMethodException.class,
				() -> PhoneNumber.class.getMethod("setCountryCode",String.class),
				"Class PhoneNumber shouldn't have a public method " +
						"setCountryCode(String c)");
		assertThrows(NoSuchMethodException.class,
				() -> PhoneNumber.class.getMethod("setAreaCode",String.class),
				"Class PhoneNumber shouldn't have a public method " +
						"setAreaCode(String c)");
		assertThrows(NoSuchMethodException.class,
				() -> PhoneNumber.class.getMethod("setSuscriberNbr",String.class),
				"Class PhoneNumber shouldn't have a public method " +
						"setSuscriberNbr(String c)");
	}
}
