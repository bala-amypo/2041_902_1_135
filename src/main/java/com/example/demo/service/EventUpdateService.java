package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {
    EventUpdate save(EventUpdate eventUpdate);
    List<EventUpdate> getAll();
}
