/*
 * Spring in Practice Chapter 02
 * Recipe: 2.1
 * Class: ContactServiceImpl.java
 */
package com.springinpractice.ch02.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springinpractice.ch02.model.Contact;
import com.springinpractice.ch02.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

	@Inject private SessionFactory sessionFactory;
	
	public void createContact(Contact contact) {
	
		getSession().save(contact);
		
	} // end createContact()
	
	
	@SuppressWarnings("unchecked")
	public List<Contact> getContacts() {
		
		return getSession()
				.createQuery("from Contact")
				.list();
		
	} // end getContacts()
	
	
	@SuppressWarnings("unchecked")
	public List<Contact> getContactsByEmail(String email) {
		
		return getSession()
				.getNamedQuery("findContactsByEmail")
				.setString("email", "%" + email + "%")
				.list();
				
	} // end getContactsByEmail
	
	
	public Contact getContact(Long id) {
		
		return (Contact) getSession().get(Contact.class, id);
				
	} // end getContact()
	
	
	public void updateContact(Contact contact) {
		
		getSession().update(contact);
		
	} // end updateContact()
	
	
	public void deleteContact(Long id) {
		
		getSession().delete(getContact(id));
		
	} // end deleteContact()
	
	
	private Session getSession() {
		
		return sessionFactory.getCurrentSession();
		
	}
	
} // end ContactServiceImpl class