package com.example.demo.service;

import com.example.demo.entity.Broadcast;
import java.util.List;

public interface BroadcastService {

    Broadcast createBroadcast(Broadcast broadcast);

    List<Broadcast> getAllBroadcasts();

    Broadcast getBroadcastById(Long id);

    void deleteBroadcast(Long id);
}
