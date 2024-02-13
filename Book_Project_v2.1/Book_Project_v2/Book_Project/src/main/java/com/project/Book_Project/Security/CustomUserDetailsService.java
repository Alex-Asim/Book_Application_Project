package com.project.Book_Project.Security;

import com.project.Book_Project.Entity.User;
import com.project.Book_Project.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

// The following annotation (@Service) indicates that this class "CustomUserDetailsService" is a Spring service
// and it will be read and be created automatically from Spring IoC (Inversion of Control) container.
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    // Implementation of the loadUserByUsername method from UserDetailsService. This method load a user from Database using only her/his username and email.
    // If this user can not be found, it will be thrown an exception with the text message "User not exists by username or email".
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // In the next 2 following lines it is implementing a search method which is using the object "userRepository".
        // If the user can not be found it will be thrown an exception.
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by username or Email"));

        // This method creates a list with user roles. Each role convert in an object which is called "SimpleGrantedAuthority" (Spring Security).
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        // The following line returns an object "UserDetails" which contains user's info, password and her/his role.
        return new org.springframework.security.core.userdetails.User(
                usernameOrEmail,
                user.getPassword(),
                authorities
        );

    }
}