package com.AI_Travel_Companion.userservice.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionhandler {

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ApiError> emailNotFoundException(EmailNotFoundException exception){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Invalid email or password")
                .time(Instant.now())
                .errors(List.of("Invalid email or password"))
                .build();
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
