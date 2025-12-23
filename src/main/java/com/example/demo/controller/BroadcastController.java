package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.BroadcastLog;
import com.example.demo.service.BroadcastService;

@RestController
@RequestMapping("/api/broadcasts")
public class BroadcastController {

    private final BroadcastService service;

    public BroadcastController(BroadcastService service) {
        this.service = service;
    }

    @PostMapping
    public BroadcastLog create(@RequestBody BroadcastLog log) {
        return service.save(log);
    }

    @GetMapping
    public List<BroadcastLog> getAll() {
        return service.getAll();
    }
}
