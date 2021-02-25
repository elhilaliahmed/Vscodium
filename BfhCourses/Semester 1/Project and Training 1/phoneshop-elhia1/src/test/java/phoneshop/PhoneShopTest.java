/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package phoneshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

//CHECKSTYLE:OFF MagicNumber
class PhoneShopTest {

	PhoneShop shop = new PhoneShop("Jim Smith");

	@Test
	void testGetOwner() {
		assertEquals("Jim Smith", shop.getOwner());
	}

	@Test
	void testGetPhonesNOK() {
		String res = shop.phoneSold();
		assertEquals(res, "NOK");
	}

	@Test
	void testGetPhones() {
		shop.fillStockPhones(10);
		String res = shop.phoneSold();
		assertEquals(shop.getPhoneStock(), 9);
		assertEquals(res, "OK");
	}

	@Test
	void testGetCasesNOK() {
		String res = shop.caseSold();
		assertEquals(res, "NOK");
	}

	@Test
	void testGetCases() {
		shop.fillStockCases(10);
		String res = shop.caseSold();
		assertEquals(shop.getPhonecaseStock(), 9);
		assertEquals(res, "OK");
	}

	@Test
	void testSetters() {
		assertThrows(NoSuchMethodException.class, () -> {
			PhoneShop.class.getMethod("setOwner", String.class);
		}, "Class PhoneShop shouldn't have a public method " + "setOwner(int i)");

		assertThrows(NoSuchMethodException.class, () -> {
			PhoneShop.class.getMethod("setPhoneStock", int.class);
		}, "Class PhoneShop shouldn't have a public method " + "setPhoneStock(int i)");

		assertThrows(NoSuchMethodException.class, () -> {
			PhoneShop.class.getMethod("setPhonecaseStock", int.class);
		}, "Class PhoneShop shouldn't have a public method " + "setPhonecaseStock(int i)");

	}
}
