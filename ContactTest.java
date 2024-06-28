package project1.cs320.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ContactTest {
	
	final String id = "ABCDEFGHIJ";
	final String firstName = "ABCDEFGHIJ";
	final String lastName = "ABCDEFGHIJ";
	final String phone = "ABCDEFGHIJ";
	final String address = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	@Test
	public void filledContact() {
		Contact c = new Contact(id, firstName, lastName, phone, address);
		
		assertNotNull(c.contactID());
		assertNotNull(c.firstName());
		assertNotNull(c.lastName());
		assertNotNull(c.phone());
		assertNotNull(c.address());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "A", "ABCDEFGHIJ", "ABCDEFGHIJKLMNOP"})
	void CorrectIDLength(String ids) {
		Contact c = new Contact(ids, firstName, lastName, phone, address);
		
		assertTrue(((c.contactID().length()) <= 10) && ((c.contactID().length()) > 0));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "A", "ABCDEFGHIJ", "ABCDEFGHIJKLMNOP"})
	void CorrectFNLength(String firstNames) {
		Contact c = new Contact(id, firstNames, lastName, phone, address);
		
		assertTrue(((c.firstName().length()) <= 10) && ((c.firstName().length()) > 0));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "A", "ABCDEFGHIJ", "ABCDEFGHIJKLMNOP"})
	void CorrectLNLength(String lastNames) {
		Contact c = new Contact(id, firstName, lastNames, phone, address);
		
		assertTrue(((c.lastName().length()) <= 10) && ((c.lastName().length()) > 0));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "A", "ABCDEFGHI", "ABCDEFGHIJ", "ABCDEFGHIJKLMNOP"})
	void CorrectPhoneLength(String phones) {
		Contact c = new Contact(id, firstName, lastName, phones, address);
		
		assertTrue((c.phone().length()) == 10);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "A", "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234", "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345"})
	void CorrectAddressLength(String addresses) {
		Contact c = new Contact(id, firstName, lastName, phone, addresses);
		
		assertTrue(((c.address().length()) <= 30) && ((c.address().length()) > 0));
	}
	
}
