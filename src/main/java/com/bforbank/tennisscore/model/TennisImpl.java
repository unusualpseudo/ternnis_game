package com.bforbank.tennisscore.model;

import org.springframework.stereotype.Component;

@Component
public class TennisImpl implements Tennis {

    private static final int[] scores = {0, 15, 30, 40};

    private int playerAScoreIndex = 0;
    private int playerBScoreIndex = 0;
    private boolean playerAAdvantage = false;
    private boolean playerBAdvantage = false;

    private boolean isWon = false;

    public String computeScore(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == 'A') {
                result.append(playerAWonBall());
            } else if (c == 'B') {
                result.append(playerBWonBall());
            } else {
                result.append("Invalid input");
                return result.toString();
            }
            if(isWon) return result.toString();
            result.append(getScore()).append("\n");

        }

        return result.toString();
    }
    public String playerAWonBall() {
        StringBuilder result = new StringBuilder();
        if (playerAAdvantage) {
            result.append("Player A wins the game");
            resetGame();
            isWon = true;
        } else if (playerBAdvantage) {
            playerBAdvantage = false;
        } else if (playerAScoreIndex == 3 && playerBScoreIndex == 3) { // deuce
            playerAAdvantage = true;
        } else if (playerAScoreIndex < 3) {
            playerAScoreIndex++;
        } else {
            result.append("Player A wins the game");
            resetGame();
            isWon = true;
        }
        return result.toString();
    }

    public String playerBWonBall() {

        StringBuilder result = new StringBuilder();

        if (playerBAdvantage) {
            result.append("Player B wins the game");
            resetGame();
            isWon = true;
        } else if (playerAAdvantage) {
            playerAAdvantage = false; // back to deuce
        } else if (playerAScoreIndex == 3 && playerBScoreIndex == 3) { // deuce
            playerBAdvantage = true;
        } else if (playerBScoreIndex < 3) {
            playerBScoreIndex++;
        } else {
            result.append("Player B wins the game");
            resetGame();
            isWon = true;
        }
        return result.toString();
    }

    public String getScore() {
        StringBuilder result = new StringBuilder();
        if (playerAAdvantage) {
            result.append( "Advantage Player A");
        } else if (playerBAdvantage) {
            result.append("Advantage Player B");
        } else if (playerAScoreIndex == 3 && playerBScoreIndex == 3) {
            result.append("Deuce");
        } else {
            result.append("Player A: ").append(scores[playerAScoreIndex]).append(" / Player B: ").append(scores[playerBScoreIndex]);
        }
        return result.toString();
    }
    public void resetGame() {
        playerAScoreIndex = 0;
        playerBScoreIndex = 0;
        playerAAdvantage = false;
        playerBAdvantage = false;
        isWon = false;
    }
}