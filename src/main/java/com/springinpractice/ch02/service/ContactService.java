/*
 * Spring in Practice Chapter 02
 * Recipe: 2.1
 * Interface: ContactService.java
 */

package com.springinpractice.ch02.service;

import java.util.List;

import com.springinpractice.ch02.model.Contact;

public interface ContactService {

	/**
	 * Creates the given contact in the persistent store.
	 * 
	 * @param contact
	 * 			contact to create
	 * @throws IllegalArgumentException
	 * 			if <code>contact</code> is <code>null</code>
	 * 
	 */
	void createContact(Contact contact);
	
	
	/**
	 * Returns a list containing all contacts.  Returns an empty list if there
	 * aren't any contacts.
	 * 
	 * @return list of all contacts
	 */
	List<Contact> getContacts();
	
	List<Contact> getContactsByEmail(String email);
	
	
	/**
	 * Returns the contact having the given ID, or <code>null</code> if no
	 * such contact exists.
	 * 
	 * @param id
	 * 			contact ID
	 * @return contact
	 * 			having the given ID
	 */
	Contact getContact(Long id);
	
	
	/**
	 * Updates the contact having the given ID.
	 * 
	 * @param contact
	 * 				contact ID
	 */
	void updateContact(Contact contact);
	
	
	/**
	 * Deletes the contact having the given ID.
	 * 
	 * @param id
	 * 			contact ID
	 */
	void deleteContact(Long id);
	
	
	
} // end ContactService interface
