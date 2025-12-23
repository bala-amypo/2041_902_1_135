package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.BroadcastLog;
import com.example.demo.repository.BroadcastLogRepository;

@Service
public class BroadcastService {

    private final BroadcastLogRepository repo;

    public BroadcastService(BroadcastLogRepository repo) {
        this.repo = repo;
    }

    public BroadcastLog save(BroadcastLog log) {
        return repo.save(log);
    }

    public List<BroadcastLog> getAll() {
        return repo.findAll();
    }
}
