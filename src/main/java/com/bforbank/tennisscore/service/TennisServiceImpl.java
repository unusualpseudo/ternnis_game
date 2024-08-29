package com.bforbank.tennisscore.service;

import com.bforbank.tennisscore.model.Tennis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TennisServiceImpl implements TennisService{

   private final Tennis tennisGame ;
    @Autowired
    public TennisServiceImpl(Tennis tennisGame) {
        this.tennisGame = tennisGame;
    }

    @Override
    public String playerAWonBall() {
        return tennisGame.playerAWonBall();
    }

    @Override
    public String playerBWonBall() {
        return tennisGame.playerBWonBall();
    }

    @Override
    public String getScore() {
        return tennisGame.getScore();
    }

    @Override
    public void resetGame() {
        tennisGame.resetGame();
    }

    @Override
    public String computeScore(String input) {
        return tennisGame.computeScore(input);
    }
}
