package com.example.demo.entity;

import java.time.Instant;

public class User {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private Instant createdAt;

    public void onCreate() {
        this.createdAt = Instant.now();
        if (this.role == null) {
            this.role = Role.SUBSCRIBER;
        }
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public Instant getCreatedAt() { return createdAt; }
}
