package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.EventUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ THIS MAKES IT A SPRING BEAN
public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventUpdateRepository repository;

    public EventUpdateServiceImpl(EventUpdateRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventUpdate createUpdate(EventUpdate update) {
        return repository.save(update);
    }

    @Override
    public List<EventUpdate> getUpdatesByEventId(Long eventId) {
        return repository.findByEventId(eventId);
    }
}
