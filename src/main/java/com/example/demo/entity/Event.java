package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String category;
    private boolean isActive = true;

    // getters & setters
}
