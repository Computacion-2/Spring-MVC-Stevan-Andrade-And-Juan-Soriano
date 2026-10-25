package com.example.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.model.RolePermission;
import com.example.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
public class UserDetailsApp implements UserDetails {
    
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.addAll(
            user.getRole()
                .getRolePermissions()
                .stream()
                .map(RolePermission::getPermission)
                .map(SecurityAuthority::new)
                .toList()
        );

        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

}
