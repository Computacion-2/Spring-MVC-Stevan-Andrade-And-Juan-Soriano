package com.example.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.exception.UserEmptyException;
import com.example.exception.UserNoFoundException;
import com.example.model.User;
import com.example.service.interf.IUserService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class UserDetailsServiceApp implements UserDetailsService {
    
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = null;

        try {
            user = userService.findByName(name);
        } catch (UserEmptyException | UserNoFoundException e) {
            e.printStackTrace();
        }

        return new UserDetailsApp(user);

    }

    

}
