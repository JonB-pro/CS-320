package project1.cs320.services;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import project1.cs320.entities.Contact;


public class ContactService {
	
	Scanner scn = new Scanner(System.in);
	
	static ContactService INSTANCE;
	
	final Map<String, Contact> entityRepository;
	
	private ContactService() {
		entityRepository = new ConcurrentHashMap<>();
	}
	
	public static synchronized ContactService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ContactService();
		}
		
		return INSTANCE;
	}
	
	public Contact create(final Contact contact) {
		Objects.requireNonNull(contact);
		
		if(entityRepository.containsKey(contact.contactID())) {
			throw new IllegalArgumentException(String.format("A contact with ID [%s] already exists.", contact.contactID()));
		}
				
		return entityRepository.put(contact.contactID(), contact);	
	}
	
	public Optional<Contact> deleteById(final String id) {
		if (id == null || id.trim().length() < 1) {
			throw new IllegalArgumentException("An existing ID is required.");
		}
		return Optional.of(entityRepository.remove(id));
	}
	
	public Optional<Contact> findById(final String id) {
		if (id == null || id.trim().length() < 1) {
			throw new IllegalArgumentException("An existing ID is required.");
		}
		return Optional.of(entityRepository.get(id));
	}
	
	public Contact update(final Contact contact) {
		Objects.requireNonNull(contact);
		
		if(!entityRepository.containsKey(contact.contactID())) {
			throw new IllegalArgumentException(String.format("A contact with ID [%s] does not exist.", contact.contactID()));
		}
		
		entityRepository.put(contact.contactID(), contact);
		
		return contact;
		
	}
}
