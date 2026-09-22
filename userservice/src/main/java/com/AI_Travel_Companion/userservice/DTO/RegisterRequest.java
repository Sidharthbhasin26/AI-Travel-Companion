package com.AI_Travel_Companion.userservice.DTO;

import com.AI_Travel_Companion.userservice.Entity.SeatPreference;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        SeatPreference seatPreference,
        int budget
) {
}
