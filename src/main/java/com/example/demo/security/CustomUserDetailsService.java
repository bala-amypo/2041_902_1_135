package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Dummy user (replace with DB later)
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails("admin", "{noop}admin123");
    }
}
