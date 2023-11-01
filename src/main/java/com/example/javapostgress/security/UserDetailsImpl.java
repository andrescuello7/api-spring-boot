package com.example.javapostgress.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.javapostgress.models.User;

public class UserDetailsImpl implements UserDetails{
    private final User userDao;

    UserDetailsImpl(User userDao) {
        this.userDao = userDao;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return userDao.getPassword();
    }

    public String getEmail() {
        return userDao.getEmail();
    }

    @Override
    public String getUsername() {
        return userDao.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
