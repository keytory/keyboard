package com.keytory.keyboard.application.keytory;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ViewTrackingService {

    private final Map<String, LocalDateTime> userViewCache = new ConcurrentHashMap<>();

    public boolean shouldIncrementView(Long keytoryId, String userIp) {
        String cacheKey = keytoryId + ":" + userIp;

        LocalDateTime lastViewed = userViewCache.get(cacheKey);
        if (lastViewed == null || lastViewed.isBefore(LocalDateTime.now().minusDays(1))) {
            userViewCache.put(cacheKey, LocalDateTime.now());
            return true;
        }

        return false;
    }
}
