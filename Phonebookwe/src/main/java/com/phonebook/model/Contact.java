package com.phonebook.model;



import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;
	@Email(message = "Email must have @" )
	private String email;

	private String homephone;
	
	@Column
	@NotEmpty(message = "Required field")
	@Size(min = 4, max = 50)
	@Pattern(regexp = "^\\+?([0-9]{2})?\\(?[0-9]{3}\\)?[0-9]{7}$",
	message = "Format mobile number must be: +38(099)1234567")
	private String mobile;

	@Column
	@NotEmpty(message = "Required field")
	@Size(min = 4, max = 50)
	private String name;

	@Column
	@NotEmpty(message = "Required field")
	@Size(min = 4, max = 50)
	private String patronymic;

	@Column
	@NotEmpty(message = "Required field")
	@Size(min = 4, max = 50)
	private String surname;

	@Column(name="user_id")
	private int userId;

	public Contact() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return this.patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}