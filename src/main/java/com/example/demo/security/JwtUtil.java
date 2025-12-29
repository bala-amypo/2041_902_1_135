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

    // ✅ Required by test cases
    public JwtUtil(String secretKey, long expirationMs) {
        this.secretKey = secretKey;
        this.expirationMs = expirationMs;
    }

    // --------------------------------------------------
    // TOKEN GENERATION
    // --------------------------------------------------

    // Used by AuthController + tests
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

    // --------------------------------------------------
    // VALIDATION (used by tests)
    // --------------------------------------------------

    public boolean validateToken(String token) {
        try {
            Claims claims = extractAllClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // --------------------------------------------------
    // CLAIM EXTRACTION (used by tests)
    // --------------------------------------------------

    public String getUsernameFromToken(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Long getUserIdFromToken(String token) {
        Object value = extractAllClaims(token).get("userId");
        return value == null ? null : Long.valueOf(value.toString());
    }

    public String getRoleFromToken(String token) {
        Object value = extractAllClaims(token).get("role");
        return value == null ? null : value.toString();
    }

    // --------------------------------------------------
    // BACKWARD COMPATIBILITY (used by JwtAuthenticationFilter)
    // --------------------------------------------------

    // JwtAuthenticationFilter expects this
    public boolean isTokenValid(String token) {
        return validateToken(token);
    }

    // JwtAuthenticationFilter expects this
    public String extractUsername(String token) {
        return getUsernameFromToken(token);
    }

    // --------------------------------------------------
    // INTERNAL HELPER
    // --------------------------------------------------

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
