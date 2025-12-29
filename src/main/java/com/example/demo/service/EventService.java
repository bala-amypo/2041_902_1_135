package com.example.demo.service;

import com.example.demo.entity.Event;
import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event getEventById(Long id);

    List<Event> getAllEvents();

    Event updateEvent(Long id, Event event);

    void deleteEvent(Long id);
}
