package com.AI_Travel_Companion.userservice.Security;


import com.AI_Travel_Companion.userservice.Entity.UsersEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    public String jwtSecretKey;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(
                jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UsersEntity usersEntity) {
        return Jwts.builder()
                .claim("Email", usersEntity.getEmail())
                .claim("firstName", usersEntity.getFirstName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSecretKey())
                .compact();
    }

    public boolean verifyToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
       return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
               .get("Email", String.class);
    }
}
