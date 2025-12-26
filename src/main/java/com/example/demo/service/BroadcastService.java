package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import java.util.List;

public interface BroadcastService {
    BroadcastLog save(BroadcastLog log);
    List<BroadcastLog> getAll();
}
