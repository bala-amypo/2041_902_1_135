package com.example.demo.service;

import com.example.demo.entity.Event;
import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Long id, Event event);   // ✅ ADD THIS

    Event getById(Long id);

    List<Event> getAllEvents();

    List<Event> getActiveEvents();

    void deactivateEvent(Long id);
}
