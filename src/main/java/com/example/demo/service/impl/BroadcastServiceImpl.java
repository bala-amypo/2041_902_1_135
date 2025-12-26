package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    private final BroadcastLogRepository repository;

    public BroadcastServiceImpl(BroadcastLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public BroadcastLog save(BroadcastLog log) {
        return repository.save(log);
    }

    @Override
    public List<BroadcastLog> getAll() {
        return repository.findAll();
    }
}
