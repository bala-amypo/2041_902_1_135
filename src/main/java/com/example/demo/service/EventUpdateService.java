package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {

    List<EventUpdate> getUpdatesForEvent(Long eventId);

    // ✅ REQUIRED FOR CONTROLLER
    EventUpdate publishUpdate(EventUpdate update);

    EventUpdate getUpdateById(Long id);
}
