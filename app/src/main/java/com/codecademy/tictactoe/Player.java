package com.codecademy.tictactoe;

public class Player {
    String playerName;
    boolean isTurn;

    public Player() {
        int randomNumber = (int)(Math.random() * 10);
        String result = (randomNumber < 5) ? " X " : " O ";

        this.playerName = result;
        this.isTurn = true;
    }

    public void swithPlayer(){
        String result = (this.playerName.equals(" O ")) ? " X " : " O ";
        this.playerName = result;

    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

}
