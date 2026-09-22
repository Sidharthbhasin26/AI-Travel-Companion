package com.AI_Travel_Companion.flightservice.Exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class ApiError {

        HttpStatus status;
        String message;
        Instant time;
        List<String> errors;

}
