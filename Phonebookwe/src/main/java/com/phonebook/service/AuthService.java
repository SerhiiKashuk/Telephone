package com.phonebook.service;

import com.phonebook.model.User;

public interface AuthService {

    User getAuthenticatedUser();
}
