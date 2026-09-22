package com.AI_Travel_Companion.flightservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ApiError> flightNotFoundException(FlightNotFoundException exception) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(exception.getMessage())
                .time(Instant.now())
                .errors(List.of(exception.getClass().getSimpleName() + ": " + exception.getMessage()))
                .build();
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }
}
