
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

    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String name)
            throws UsernameNotFoundException {

        try {
            User user = userService.findByName(name);

            if (user == null) {
                throw new UsernameNotFoundException(
                    "No existe el usuario: " + name
                );
            }

            return new UserDetailsApp(user);

        } catch (UserEmptyException | UserNoFoundException e) {
            throw new UsernameNotFoundException(
                "No se encontró el usuario: " + name, e
            );
        }
    }
}
