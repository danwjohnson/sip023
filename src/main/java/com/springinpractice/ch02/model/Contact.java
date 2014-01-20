/*
 * Spring in Practice Chapter 02
 * Recipe: 2.3
 * Class: Contact.java
 */
package com.springinpractice.ch02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.springinpractice.util.StringUtils;

@Entity
@Table(name = "contact")
@NamedQuery(
	name = "findContactsByEmail",
	query = "from Contact where email like :email")
public class Contact {

	private Long id;
	private String lastName;
	private String firstName;
	private String middleInitial;
	private String email;
	
	
	// Getters and Setters
	
	/**
	 * Gets the id of the contact
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getId() {
		
		return id;
		
	} // end getId()
	
	
	/**
	 * Sets the id of the contact
	 * @param id
	 */
	public void setId(Long id) {
		
		this.id = id;
		
	} // end setId()
	
	
	/**
	 * Gets the last name
	 * @return lastName
	 */
	@NotNull
	@Length(min = 1, max = 40)
	@Column(name = "last_name")
	public String getLastName() {
		
		return lastName;
		
	} // end getLastName()
	
	
	/**
	 * Sets the last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		
		this.lastName = StringUtils.cleanup(lastName);
		
	} // end setLastName()
	
	
	/**
	 * Gets the first name
	 * @return firstName
	 */
	@NotNull
	@Length(min = 1, max = 40)
	@Column(name = "first_name")
	public String getFirstName() {
		
		return firstName;
		
	} // end getFirstName()
	
	
	/**
	 * Sets the first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	} // end setFirstName()
	
	
	/**
	 * Gets the middle initial
	 * @return middleInitial
	 */
	@Length(max = 1)
	@Column(name = "mi")
	public String getMiddleInitial() {
		
		return middleInitial;
		
	} // end getMiddleInitial()
	
	
	/**
	 * Sets the middle initial
	 * @param mi
	 */
	public void setMiddleInitial(String mi) {
		
		this.middleInitial = mi;
		
	} // end setMiddleInitial()
	
	
	/**
	 * Gets the email address
	 * @return email
	 */
	@Email
	@Column
	public String getEmail() {
		
		return email;
		
	} // end getEmail()
	
	
	/**
	 * Sets the email address
	 * @param email
	 */
	public void setEmail(String email) {
		
		this.email = email;
		
	} // end setEmail()
	
	
	/**
	 * Concatenates lastName, firstName and middleInitial (if present) into
	 * one String value.
	 * @return fullName
	 */
	@Transient
	public String getFullName() {
		
		String fullName = lastName + ", " + firstName;
		if (! (middleInitial == null) || "".equals(middleInitial.trim())) {
			
			fullName += " " + middleInitial + ".";
			
		} // end if to validate if middleInitial is present
		
		return fullName;
		
	} // end getFullName()
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "[Contact: id=" + id
			+ ", firstName=" + firstName
			+ ", middleInitial=" + middleInitial
			+ ", lastName=" + lastName
			+ ", email=" + email
			+ "]";
			
	} // end toString()
	
} // end Contact
