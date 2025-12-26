package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String username) {
        return "jwt-token-" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token");
    }
}
