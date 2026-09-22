package com.AI_Travel_Companion.userservice.Repository;

import com.AI_Travel_Companion.userservice.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersEntity , Long> {
    Optional<UsersEntity> findByEmail(String email);
}
