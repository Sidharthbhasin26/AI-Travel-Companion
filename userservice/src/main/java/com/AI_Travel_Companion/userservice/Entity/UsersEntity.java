package com.AI_Travel_Companion.userservice.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Role;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @Enumerated(EnumType.STRING)
    private SeatPreference seatPreference;

    private int budget;
}
