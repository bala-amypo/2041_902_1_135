package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.BroadcastService;

import java.util.List;

public class BroadcastServiceImpl implements BroadcastService {

    private final EventUpdateRepository updateRepo;
    private final SubscriptionRepository subRepo;
    private final BroadcastLogRepository logRepo;

    public BroadcastServiceImpl(EventUpdateRepository u, SubscriptionRepository s, BroadcastLogRepository l) {
        this.updateRepo = u;
        this.subRepo = s;
        this.logRepo = l;
    }

    public void broadcastUpdate(Long updateId) {
        EventUpdate update = updateRepo.findById(updateId).orElseThrow();
        List<Subscription> subs = subRepo.findByEventId(update.getEvent().getId());
        for (Subscription s : subs) {
            BroadcastLog log = new BroadcastLog();
            log.setEventUpdate(update);
            log.setSubscriber(s.getUser());
            logRepo.save(log);
        }
    }

    public void recordDelivery(Long updateId, Long userId, boolean success) {
        List<BroadcastLog> logs = logRepo.findByEventUpdateId(updateId);
        for (BroadcastLog log : logs) {
            if (log.getSubscriber().getId().equals(userId)) {
                log.setDeliveryStatus(success ? DeliveryStatus.SENT : DeliveryStatus.FAILED);
                logRepo.save(log);
            }
        }
    }

    public List<BroadcastLog> getLogsForUpdate(Long id) {
        return logRepo.findByEventUpdateId(id);
    }
}
