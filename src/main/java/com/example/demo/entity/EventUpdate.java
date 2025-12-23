package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private String updateContent;
    private String updateType;

    // getters & setters
}
