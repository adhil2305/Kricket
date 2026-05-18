package com.cream.shop.websocket;

import com.cream.shop.dto.LiveScore;
import com.cream.shop.service.FakeLiveScoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LiveScorePublisher {

    private final SimpMessagingTemplate messagingTemplate;
    private final FakeLiveScoreService service;

    @Scheduled(fixedRate = 2000)
    public void publish() {
        LiveScore score = service.generate("MATCH_001");
        messagingTemplate.convertAndSend("/topic/live-score", score);
    }
}
