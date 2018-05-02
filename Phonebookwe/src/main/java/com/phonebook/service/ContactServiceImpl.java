package com.phonebook.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phonebook.model.Contact;
import com.phonebook.repository.ContactRepository;

/**
 * Product service implement.
 */
@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Iterable<Contact> listAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Integer id) {
        return contactRepository.findOne(id);
    }

    @Override
    
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    
    public void deleteContact(Integer id) {
    	contactRepository.delete(id);
    }

	@Override
	public List<Contact> findBySurname(String surname) {
		// TODO Auto-generated method stub
		return contactRepository.findBySurname(surname);
	}

	@Override
	public List<Contact> getAllUserContacts(int user_id) {
		// TODO Auto-generated method stub
		return contactRepository.getAllUserContacts(user_id);
	}



}
