package com.AI_Travel_Companion.userservice.DTO;

import com.AI_Travel_Companion.userservice.Entity.Roles;
import com.AI_Travel_Companion.userservice.Entity.SeatPreference;

public record RegisterResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        SeatPreference seatPreference,
        Roles Role,
        int budget
) {
}
