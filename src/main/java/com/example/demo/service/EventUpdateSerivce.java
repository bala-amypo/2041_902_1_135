package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.EventUpdateRepository;

@Service
public class EventUpdateService {

    private final EventUpdateRepository repo;

    public EventUpdateService(EventUpdateRepository repo) {
        this.repo = repo;
    }

    public EventUpdate save(EventUpdate update) {
        return repo.save(update);
    }

    public List<EventUpdate> getAll() {
        return repo.findAll();
    }
}
