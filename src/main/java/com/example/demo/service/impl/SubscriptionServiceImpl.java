package com.example.demo.service.impl;

import com.example.demo.entity.Subscription;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription subscribe(Long userId, Long eventId) {
        Subscription subscription = new Subscription();
        subscription.setUserId(userId);
        subscription.setEventId(eventId);
        return repository.save(subscription);
    }

    @Override
    public void unsubscribe(Long userId, Long eventId) {
        Subscription subscription =
                repository.findByUserIdAndEventId(userId, eventId)
                        .orElseThrow(() -> new RuntimeException("Subscription not found"));
        repository.delete(subscription);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public boolean isSubscribed(Long userId, Long eventId) {
        return repository.existsByUserIdAndEventId(userId, eventId);
    }
}
