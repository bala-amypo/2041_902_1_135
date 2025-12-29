package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private final String secretKey;
    private final long expirationMs;

    // ✅ REQUIRED by tests
    public JwtUtil(String secretKey, long expirationMs) {
        this.secretKey = secretKey;
        this.expirationMs = expirationMs;
    }

    // ✅ Generate JWT with userId + role
    public String generateToken(Long userId, String username, String role) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // ✅ Validate token
    public boolean validateToken(String token) {
        try {
            Claims claims = extractAllClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Extract username
    public String getUsernameFromToken(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ✅ Extract userId
    public Long getUserIdFromToken(String token) {
        Object value = extractAllClaims(token).get("userId");
        return value == null ? null : Long.valueOf(value.toString());
    }

    // ✅ Extract role
    public String getRoleFromToken(String token) {
        Object value = extractAllClaims(token).get("role");
        return value == null ? null : value.toString();
    }

    // 🔒 Internal helper
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
