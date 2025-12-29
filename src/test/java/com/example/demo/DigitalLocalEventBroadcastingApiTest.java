package com.example.demo;

import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.BroadcastService;
import com.example.demo.service.impl.EventUpdateServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DigitalLocalEventBroadcastingApiTest {

    @Mock
    private EventUpdateRepository eventUpdateRepository;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private BroadcastService broadcastService;

    private EventUpdateServiceImpl eventUpdateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        eventUpdateService = new EventUpdateServiceImpl(
                eventUpdateRepository,
                eventRepository,
                broadcastService
        );
    }

    @Test
    void contextLoads() {
        assertNotNull(eventUpdateService);
    }
}
