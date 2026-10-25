package com.example.service.interf;

import java.util.Optional;

import com.example.model.User;

public interface IUserService {
    
    void add();

    Optional<User> findByName(String name);

}
