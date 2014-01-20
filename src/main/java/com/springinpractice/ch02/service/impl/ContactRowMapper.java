/*
 * Spring in Practice Chapter 02
 * Recipe: 2.1
 * Class: ContactRowMapper.java
 */
package com.springinpractice.ch02.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springinpractice.ch02.model.Contact;

@Component
public class ContactRowMapper implements RowMapper<Contact> {

	public Contact mapRow(ResultSet resultSet, int rowNum)
		throws SQLException {
		
		Contact contact = new Contact();
		contact.setId(resultSet.getLong(1));
		contact.setLastName(resultSet.getString(2));
		contact.setFirstName(resultSet.getString(3));
		contact.setMiddleInitial(resultSet.getString(4));
		contact.setEmail(resultSet.getString(5));
		
		return contact;
		
	} // end mapRow()
	
} // end ContactRowMapper class
