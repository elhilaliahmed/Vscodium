/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package contactbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactBookTest {

	private static final int CONTACT_BOOK_CAPACITY = 10;

	private ContactBook contactBook = new ContactBook(CONTACT_BOOK_CAPACITY);
	private Contact[] testContacts = new Contact[100];

	@BeforeEach
	public void init() {
		for (int i = 0; i < testContacts.length; i++) {
			testContacts[i] = new Contact("Alice" + i, "alice@example.org", "+1 23 4567890");
		}
	}

	@Test
	void testEmptyContactBook() {
		assertEquals(CONTACT_BOOK_CAPACITY, contactBook.getCapacity());
		assertEquals(0, contactBook.getSize());
	}

	@Test
	void testAddContact() {
		assertTrue(contactBook.addContact(testContacts[0]));
		assertNotNull(contactBook.findContact(testContacts[0].getName()));
		assertEquals(1, contactBook.getSize());
	}

	@Test
	void testAddContacts() {
		for (int i = 0; i < testContacts.length; i++) {
			assertTrue(contactBook.addContact(testContacts[i]));
		}
		for (int i = 0; i < testContacts.length; i++) {
			assertNotNull(contactBook.findContact(testContacts[i].getName()));
		}
		assertEquals(testContacts.length, contactBook.getSize());
		assertTrue(contactBook.getCapacity() >= testContacts.length);
	}

	@Test
	void testAddDuplicateContact() {
		assertTrue(contactBook.addContact(testContacts[0]));
		assertFalse(contactBook.addContact(testContacts[0]));
		assertEquals(1, contactBook.getSize());
	}

	@Test
	void testRemoveContact() {
		assertTrue(contactBook.addContact(testContacts[0]));
		assertTrue(contactBook.removeContact(testContacts[0].getName()));
		assertNull(contactBook.findContact(testContacts[0].getName()));
		assertEquals(0, contactBook.getSize());
	}

	@Test
	void testRemoveContacts() {
		for (int i = 0; i < contactBook.getCapacity(); i++) {
			assertTrue(contactBook.addContact(testContacts[i]));
		}
		for (int i = 0; i < contactBook.getCapacity(); i++) {
			assertTrue(contactBook.removeContact(testContacts[i].getName()));
		}
		for (int i = 0; i < contactBook.getCapacity(); i++) {
			assertNull(contactBook.findContact(testContacts[i].getName()));
		}
		assertEquals(0, contactBook.getSize());
	}

	@Test
	void testRemoveNonExistingContact() {
		for (int i = 0; i < contactBook.getCapacity(); i++) {
			assertTrue(contactBook.addContact(testContacts[i]));
		}
		assertFalse(contactBook.removeContact("Alice"));
	}

	@Test
	void testSetters() {
		assertThrows(NoSuchMethodException.class, () -> {
			ContactBook.class.getMethod("setSize", int.class);
		}, "Class ContactBook shouldn't have a public method " + "setSize(int i)");

		assertThrows(NoSuchMethodException.class, () -> {
			ContactBook.class.getMethod("setCapacity", int.class);
		}, "Class ContactBook shouldn't have a public method " + "setCapacity(int i)");

	}
}
