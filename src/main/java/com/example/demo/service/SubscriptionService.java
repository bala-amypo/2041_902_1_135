package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.Subscription;
import com.example.demo.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

    private final SubscriptionRepository repo;

    public SubscriptionService(SubscriptionRepository repo) {
        this.repo = repo;
    }

    public Subscription save(Subscription sub) {
        return repo.save(sub);
    }

    public List<Subscription> getAll() {
        return repo.findAll();
    }
}
