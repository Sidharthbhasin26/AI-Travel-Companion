package com.AI_Travel_Companion.userservice.Service;

import com.AI_Travel_Companion.userservice.DTO.LoginRequest;
import com.AI_Travel_Companion.userservice.DTO.LoginResponse;
import com.AI_Travel_Companion.userservice.DTO.RegisterRequest;
import com.AI_Travel_Companion.userservice.DTO.RegisterResponse;
import com.AI_Travel_Companion.userservice.Entity.Roles;
import com.AI_Travel_Companion.userservice.Entity.SeatPreference;
import com.AI_Travel_Companion.userservice.Entity.UsersEntity;
import com.AI_Travel_Companion.userservice.ExceptionHandler.EmailNotFoundException;
import com.AI_Travel_Companion.userservice.Repository.UserRepository;
import com.AI_Travel_Companion.userservice.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
   // private final UsersEntity usersEntity;

    public RegisterResponse signUp(RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.email()).isPresent()) {
            throw new RuntimeException("User with email " + registerRequest.email() + " already exists");
        }
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setFirstName(registerRequest.firstName());
        usersEntity.setLastName(registerRequest.lastName());
        usersEntity.setEmail(registerRequest.email());
        usersEntity.setPassword(passwordEncoder.encode(registerRequest.password()));
        usersEntity.setSeatPreference(registerRequest.seatPreference());
        usersEntity.setRoles(Roles.TRAVELER);
        usersEntity.setBudget(registerRequest.budget());

        UsersEntity saved = userRepository.save(usersEntity);

        return new RegisterResponse(
                saved.getId(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail(),
                saved.getSeatPreference(),
                saved.getRoles(),
                saved.getBudget()
        );
    }

    public LoginResponse logIn (LoginRequest loginRequest){
       Authentication authentication =  authenticationManager
               .authenticate(new UsernamePasswordAuthenticationToken
                       (loginRequest.email() , loginRequest.password()));

       UsersEntity usersEntity = userRepository.findByEmail(loginRequest.email())
               .orElseThrow(() -> new EmailNotFoundException("Invalid email or password"));

       String token = jwtUtil.generateToken(usersEntity);


       return new LoginResponse(
               "Welcome " + usersEntity.getFirstName() ,
               usersEntity.getEmail(),
               usersEntity.getRoles(),
               token

       );

    }
    public RegisterResponse getMyProfile(String email){
        UsersEntity usersEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Invalid email or password"));

        return new RegisterResponse(
                usersEntity.getId(),
                usersEntity.getFirstName(),
                usersEntity.getLastName(),
                usersEntity.getEmail(),
                usersEntity.getSeatPreference(),
                usersEntity.getRoles(),
                usersEntity.getBudget()
        );
    }



}

