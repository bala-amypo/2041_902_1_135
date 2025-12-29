package com.example.demo.service;

import com.example.demo.entity.EventUpdate;

import java.util.List;

public interface EventUpdateService {

    EventUpdate createUpdate(EventUpdate update);

    List<EventUpdate> getUpdatesByEventId(Long eventId);
}
