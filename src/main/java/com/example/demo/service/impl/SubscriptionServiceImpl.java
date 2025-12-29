package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.SubscriptionService;

import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repo;
    private final UserRepository userRepo;
    private final EventRepository eventRepo;

    public SubscriptionServiceImpl(SubscriptionRepository repo, UserRepository userRepo, EventRepository eventRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.eventRepo = eventRepo;
    }

    public Subscription subscribe(Long userId, Long eventId) {
        if (repo.existsByUserIdAndEventId(userId, eventId)) {
            throw new BadRequestException("Already subscribed");
        }
        Subscription s = new Subscription();
        s.setUser(userRepo.findById(userId).orElseThrow());
        s.setEvent(eventRepo.findById(eventId).orElseThrow());
        return repo.save(s);
    }

    public boolean isSubscribed(Long userId, Long eventId) {
        return repo.existsByUserIdAndEventId(userId, eventId);
    }

    public void unsubscribe(Long userId, Long eventId) {
        Subscription s = repo.findByUserIdAndEventId(userId, eventId)
                .orElseThrow(() -> new BadRequestException("Subscription not found"));
        repo.delete(s);
    }

    public List<Subscription> getUserSubscriptions(Long userId) {
        return repo.findByUserId(userId);
    }
}
