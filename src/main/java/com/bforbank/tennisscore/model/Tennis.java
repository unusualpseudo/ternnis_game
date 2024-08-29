package com.bforbank.tennisscore.model;

import org.springframework.stereotype.Component;


public interface Tennis {
    String playerAWonBall();
    String playerBWonBall();
    String getScore();
    void resetGame();
    String computeScore(String input);
}
