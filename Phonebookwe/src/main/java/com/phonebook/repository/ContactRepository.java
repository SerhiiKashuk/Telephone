package com.phonebook.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phonebook.model.Contact;



public interface ContactRepository extends CrudRepository<Contact, Integer> {
	
	@Query("SELECT p FROM Contact p WHERE  p.surname LIKE CONCAT('%',:surname,'%')")
    public List<Contact> findBySurname(@Param("surname") String surname);
	
	@Query("SELECT p FROM Contact p WHERE  p.user_id =:user_id")
    public List<Contact> getAllUserContacts(@Param("user_id") int user_id);
	
	

}
