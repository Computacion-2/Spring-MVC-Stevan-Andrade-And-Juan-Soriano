package com.example.service.interf;

import com.example.exception.RegistrationException;
import com.example.model.User;

public interface IAuthService {

    // Creates a user with the default role, storing the password hashed with the PasswordEncoder
    User register(String name, String email, String password, String confirmPassword) throws RegistrationException;

}
