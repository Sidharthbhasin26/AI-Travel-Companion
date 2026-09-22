package com.AI_Travel_Companion.userservice.DTO;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public record LoginRequest(
        String email,
        String password
) {
}
