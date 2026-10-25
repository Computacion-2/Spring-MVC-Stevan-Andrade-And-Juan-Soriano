package com.example.service.interf;

import java.util.List;

import com.example.exception.UserEmptyException;
import com.example.exception.UserNoFoundException;
import com.example.model.User;

public interface IUserService {
    
    // Directly modification DB user records
    void create(User userToAdd) throws UserEmptyException;
    void update(User userToUpdate) throws UserNoFoundException, UserEmptyException;
    void delete(User userToDelete) throws UserNoFoundException, UserEmptyException;

    //Querys
    User findByName(String name) throws UserEmptyException, UserNoFoundException;
    List<User> findAll();
    User findById(int id) throws UserEmptyException, UserNoFoundException;

}
