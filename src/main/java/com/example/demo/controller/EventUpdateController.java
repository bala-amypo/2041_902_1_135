package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.EventUpdate;
import com.example.demo.service.EventUpdateService;

@RestController
@RequestMapping("/api/updates")
public class EventUpdateController {

    private final EventUpdateService service;

    public EventUpdateController(EventUpdateService service) {
        this.service = service;
    }

    @PostMapping
    public EventUpdate create(@RequestBody EventUpdate update) {
        return service.save(update);
    }

    @GetMapping
    public List<EventUpdate> getAll() {
        return service.getAll();
    }
}
