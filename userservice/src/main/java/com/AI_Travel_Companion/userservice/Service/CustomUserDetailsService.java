package com.AI_Travel_Companion.userservice.Service;

import com.AI_Travel_Companion.userservice.Entity.UsersEntity;
import com.AI_Travel_Companion.userservice.ExceptionHandler.EmailNotFoundException;
import com.AI_Travel_Companion.userservice.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UsersEntity usersEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email Not Found "+ email));


        return User
                .builder()
                .username(usersEntity.getEmail())
                .password(usersEntity.getPassword())
                .authorities("TRAVELER")
                .build();
    }
}
