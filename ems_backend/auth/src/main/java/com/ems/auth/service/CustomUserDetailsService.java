package com.ems.auth.service;

import com.ems.auth.model.AuthUser;
import com.ems.auth.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    @Autowired
    public CustomUserDetailsService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch employee from the repository
        AuthUser authUser = authUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email: " + email));

        // Create and return UserDetails object
        return new org.springframework.security.core.userdetails.User(
                authUser.getEmail(),
                authUser.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + authUser.getRole().name())) // Assign role
        );
    }
}
