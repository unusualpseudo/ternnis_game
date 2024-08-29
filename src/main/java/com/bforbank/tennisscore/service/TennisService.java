package com.bforbank.tennisscore.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface TennisService {
    String playerAWonBall();
    String playerBWonBall();
    String getScore();
    void resetGame();
    String computeScore(String input);
}
