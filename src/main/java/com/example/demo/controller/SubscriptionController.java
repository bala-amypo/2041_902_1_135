package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.Subscription;
import com.example.demo.service.SubscriptionService;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public Subscription create(@RequestBody Subscription sub) {
        return service.save(sub);
    }

    @GetMapping
    public List<Subscription> getAll() {
        return service.getAll();
    }
}
