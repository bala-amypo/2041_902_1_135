package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // ✅ LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String username,
            @RequestParam String password) {

        // 🔴 DEMO authentication (replace with DB later)
        if (!username.equals("admin") || !password.equals("admin123")) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // Dummy user data
        Long userId = 1L;
        String role = "ADMIN";

        // ✅ Generate JWT (matches JwtUtil)
        String token = jwtUtil.generateToken(userId, username, role);

        Map<String, Object> response = new HashMap<>();
        response.put("userId", userId);
        response.put("username", username);
        response.put("role", role);
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}
