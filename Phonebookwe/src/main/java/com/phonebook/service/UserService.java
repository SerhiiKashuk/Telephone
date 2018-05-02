package com.phonebook.service;

import com.phonebook.model.User;

public interface UserService {

	User findUserByLogin(String email);

	void saveUser(User user);

	User findById(int id);
}
