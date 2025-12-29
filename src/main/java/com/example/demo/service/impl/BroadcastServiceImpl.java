package com.example.demo.service.impl;

import com.example.demo.entity.Broadcast;
import com.example.demo.repository.BroadcastRepository;
import com.example.demo.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ THIS IS THE KEY
public class BroadcastServiceImpl implements BroadcastService {

    private final BroadcastRepository repository;

    public BroadcastServiceImpl(BroadcastRepository repository) {
        this.repository = repository;
    }

    @Override
    public Broadcast createBroadcast(Broadcast broadcast) {
        return repository.save(broadcast);
    }

    @Override
    public List<Broadcast> getAllBroadcasts() {
        return repository.findAll();
    }

    @Override
    public Broadcast getBroadcastById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Broadcast not found"));
    }

    @Override
    public void deleteBroadcast(Long id) {
        repository.deleteById(id);
    }
}
