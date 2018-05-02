package com.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.phonebook.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByLogin(String login);

	User findById(int id);

	//User findByEmail(String email);

}
