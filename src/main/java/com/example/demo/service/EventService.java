package com.example.demo.service;

import com.example.demo.entity.Event;
import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event getById(Long id);               // ✅ FIX #2

    List<Event> getAllEvents();

    List<Event> getActiveEvents();        // ✅ FIX #3

    void deactivateEvent(Long id);        // ✅ FIX #4
}
