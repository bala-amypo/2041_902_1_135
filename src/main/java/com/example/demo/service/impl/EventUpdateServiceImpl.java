package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.EventUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventUpdateRepository repository;

    public EventUpdateServiceImpl(EventUpdateRepository repository) {
        this.repository = repository;
    }

    // ✅ Controller-compatible methods

    @Override
    public EventUpdate publishUpdate(EventUpdate update) {
        return repository.save(update);
    }

    @Override
    public EventUpdate getUpdateById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event update not found"));
    }

    @Override
    public List<EventUpdate> getUpdatesForEvent(Long eventId) {
        return repository.findByEventId(eventId);
    }
}
