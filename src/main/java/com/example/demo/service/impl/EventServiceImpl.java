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

    // CREATE EVENT
    @Override
    public Event createEvent(Event event) {
        event.setActive(true); // default active
        return repository.save(event);
    }

    // UPDATE EVENT
    @Override
    public Event updateEvent(Long id, Event event) {
        Event existing = getById(id);

        existing.setTitle(event.getTitle());
        existing.setDescription(event.getDescription());
        existing.setDate(event.getDate());
        existing.setActive(event.isActive());

        return repository.save(existing);
    }

    // GET EVENT BY ID
    @Override
    public Event getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // GET ALL EVENTS
    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    // GET ONLY ACTIVE EVENTS
    @Override
    public List<Event> getActiveEvents() {
        return repository.findByActiveTrue();
    }

    // DEACTIVATE EVENT (SOFT DELETE)
    @Override
    public void deactivateEvent(Long id) {
        Event event = getById(id);
        event.setActive(false);
        repository.save(event);
    }
}
