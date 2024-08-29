package com.bforbank.tennisscore.service;

import com.bforbank.tennisscore.model.Tennis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TennisServiceImpl implements TennisService{

    @Autowired
    Tennis TennisGame ;
    @Override
    public String playerAWonBall() {
        return TennisGame.playerAWonBall();
    }

    @Override
    public String playerBWonBall() {
        return TennisGame.playerBWonBall();
    }

    @Override
    public String getScore() {
        return TennisGame.getScore();
    }

    @Override
    public void resetGame() {
        TennisGame.resetGame();
    }

    @Override
    public String computeScore(String input) {
        return TennisGame.computeScore(input);
    }
}
