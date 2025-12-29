package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event createEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public Event getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public List<Event> getActiveEvents() {
        return repository.findAll()
                .stream()
                .filter(Event::isActive)
                .toList();
    }

    @Override
    public void deactivateEvent(Long id) {
        Event event = getById(id);
        event.setActive(false);
        repository.save(event);
    }
}
