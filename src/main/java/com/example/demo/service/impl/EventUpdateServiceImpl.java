package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.EventUpdateService;

import java.util.List;

public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventUpdateRepository repo;

    public EventUpdateServiceImpl(EventUpdateRepository repo, Object unused) {
        this.repo = repo;
    }

    @Override
    public List<EventUpdate> getUpdatesForEvent(Long eventId) {
        return repo.findByEventIdOrderByTimestampAsc(eventId);
    }

    // ✅ REQUIRED
    @Override
    public EventUpdate publishUpdate(EventUpdate update) {
        return repo.save(update);
    }

    // ✅ REQUIRED
    @Override
    public EventUpdate getUpdateById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Update not found"));
    }
}
