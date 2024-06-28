package project1.cs320.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project1.cs320.entities.Contact;

public class ContactServiceTest {
	
	ContactService service;

	@BeforeEach
	void init() {
		ContactService.INSTANCE = null;
		service = ContactService.getInstance();
	}
	
	@Test
	public void create_PreventsAdditionOfExistingContact() {
		final String id = "ABCDEFGHIJK";
		final Contact c = new Contact(id, null, null, null, null);
		
		service.create(c);
		
		assertThrows(Exception.class, () -> service.create(new Contact(id, null, null, null, null)));
	}
	
	@Test
	public void deleteById_LengthLessThanOne() {
		final String id = "ABCDEFGHIJK";
		final Contact c = new Contact(id, null, null, null, null);
		
		service.create(c);
		service.deleteById(id);
		
		assertThrows(Exception.class, () -> service.deleteById(""));
	}
	
	@Test
	public void deleteById_NullEntry() {
		final String id = "ABCDEFGHIJK";
		final Contact c = new Contact(id, null, null, null, null);
		
		service.create(c);
		service.deleteById(id);
		
		assertThrows(Exception.class, () -> service.deleteById(null));
	}
	
	@Test
	public void findById_LengthLessThanOne() {
		final String id = "ABCDEFGHIJK";
		final Contact c = new Contact(id, null, null, null, null);
		
		service.create(c);
		service.findById(id);
		
		assertThrows(Exception.class, () -> service.findById(""));
	}
	
	@Test
	public void findById_NullEntry() {
		final String id = "ABCDEFGHIJK";
		final Contact c = new Contact(id, null, null, null, null);
		
		service.create(c);
		service.findById(id);
		
		assertThrows(Exception.class, () -> service.findById(null));
	}
	
	@Test
	public void update_UpdatesExistingContactsOnly() {
		final String id = "ABCDEFGHIJ";
		final String firstName = "ABCDEFGHIJ";
		final String lastName = "ABCDEFGHIJ";
		final String phone = "ABCDEFGHIJ";
		final String address = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final Contact c = new Contact(id, firstName, lastName, phone, address);
		
		service.create(c);
		service.update(c);
		
		assertThrows(Exception.class, () -> service.update(new Contact("ABCDEFGHIJK", firstName, lastName, phone, address)));
	}
}
