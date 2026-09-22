package com.AI_Travel_Companion.userservice.Controller;


import com.AI_Travel_Companion.userservice.DTO.LoginRequest;
import com.AI_Travel_Companion.userservice.DTO.LoginResponse;
import com.AI_Travel_Companion.userservice.DTO.RegisterRequest;
import com.AI_Travel_Companion.userservice.DTO.RegisterResponse;
import com.AI_Travel_Companion.userservice.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<RegisterResponse> signUp(@RequestBody RegisterRequest registerRequest){
        RegisterResponse saved = userService.signUp(registerRequest);
        return new ResponseEntity<>(saved , HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> logIn(@RequestBody LoginRequest loginRequest){
        LoginResponse saved = userService.logIn(loginRequest);
        return new ResponseEntity<>(saved , HttpStatus.ACCEPTED);
    }
    @GetMapping("/me")
    public ResponseEntity<RegisterResponse> getMyProfile(Authentication authentication) {
        String email = authentication.getName();
        RegisterResponse response = userService.getMyProfile(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
