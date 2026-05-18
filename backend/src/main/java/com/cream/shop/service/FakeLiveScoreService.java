package com.cream.shop.service;

import com.cream.shop.dto.LiveScore;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FakeLiveScoreService {

    private final Map<String, LiveScore> scores = new ConcurrentHashMap<>();
    private final Random random = new Random();

    public LiveScore generate(String matchId) {
        LiveScore score = scores.getOrDefault(
                matchId,
                new LiveScore(matchId, "India", 0, 0, 0.0));

        score.setRuns(score.getRuns() + random.nextInt(7));

        if (random.nextInt(10) == 1) {
            score.setWickets(Math.min(10, score.getWickets() + 1));
        }

        score.setOvers(score.getOvers() + 0.1);
        scores.put(matchId, score);
        return score;
    }
}
