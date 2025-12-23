package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class BroadcastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long updateId;
    private String status;

    // getters & setters
}
