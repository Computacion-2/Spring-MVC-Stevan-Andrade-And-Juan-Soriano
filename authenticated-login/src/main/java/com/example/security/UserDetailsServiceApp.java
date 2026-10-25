package com.example.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.service.interf.IUserService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class UserDetailsServiceApp implements UserDetailsService {
    
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = userService.findByName(name);
        if (user.isEmpty()) throw new UsernameNotFoundException("Nombre no encontrado: " + name);

        return new UserDetailsApp(user.get());

    }

    

}
