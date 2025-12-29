package com.example.demo.service;

import com.example.demo.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription createSubscription(Subscription subscription);

    Subscription getSubscriptionById(Long id);

    List<Subscription> getSubscriptionsByUser(Long userId);

    void unsubscribe(Long id);
}
