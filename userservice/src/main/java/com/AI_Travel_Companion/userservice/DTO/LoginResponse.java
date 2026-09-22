package com.AI_Travel_Companion.userservice.DTO;

import com.AI_Travel_Companion.userservice.Entity.Roles;

public record LoginResponse(
        String message,
        String email,
        Roles Role,
        String token

) {
}
