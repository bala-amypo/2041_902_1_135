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
    public Subscription createSubscription(Subscription subscription) {
        return repository.save(subscription);
    }

    @Override
    public Subscription getSubscriptionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    @Override
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void unsubscribe(Long id) {
        repository.deleteById(id);
    }
}
