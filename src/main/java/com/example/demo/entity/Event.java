package com.example.demo.entity;

import java.time.Instant;

public class Event {

    private Long id;
    private String title;
    private String description;
    private String location;
    private String category;
    private boolean isActive;
    private User publisher;
    private Instant createdAt;
    private Instant lastUpdatedAt;

    public void onCreate() {
        this.createdAt = Instant.now();
        this.lastUpdatedAt = Instant.now();
        this.isActive = true;
    }

    public void onUpdate() {
        this.lastUpdatedAt = Instant.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public User getPublisher() { return publisher; }
    public void setPublisher(User publisher) { this.publisher = publisher; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getLastUpdatedAt() { return lastUpdatedAt; }
}
