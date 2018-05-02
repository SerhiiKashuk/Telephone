package com.phonebook.service;

import java.util.List;

import com.phonebook.model.Contact;

public interface ContactService {

	Iterable<Contact> listAllContacts();

	Contact getContactById(Integer id);

	Contact saveContact(Contact contact);

	List<Contact> findBySurname(String surname);

	void deleteContact(Integer id);

	List<Contact> getAllUserContacts(int user_id);

}
