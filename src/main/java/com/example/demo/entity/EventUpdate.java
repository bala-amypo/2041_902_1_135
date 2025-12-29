package com.example.demo.entity;

import java.time.Instant;

public class EventUpdate {

    private Long id;
    private Event event;
    private String updateContent;
    private SeverityLevel severityLevel;
    private Instant timestamp;

    public void onCreate() {
        this.timestamp = Instant.now();
        if (severityLevel == null) {
            this.severityLevel = SeverityLevel.LOW;
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
    public SeverityLevel getSeverityLevel() { return severityLevel; }
    public Instant getTimestamp() { return timestamp; }
}
