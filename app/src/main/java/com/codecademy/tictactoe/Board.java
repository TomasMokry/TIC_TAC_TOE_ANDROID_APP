package com.codecademy.tictactoe;

public class Board {
    private String[][] board = new String[3][3];

    public Board(){
        String unit = "   ";
        for (int y = 0; y < this.board.length; y++) {
            for (int x = 0; x < this.board[y].length; x++) {
                this.board[x][y] = unit;
            }
        }
    }
    public boolean isEmpty(int position){
        int index1 = (int)((position - 1) / 3);
        int index2 = (position -1) % 3;
        boolean result;
        if(this.board[index1][index2] == "   "){result = true;}
        else {result = false;}
        return result;
    }

    public void printBoard(){
        for (int y = 0; y < board.length; y++){
            for (int x = 0; x < board[y].length;x++){
                System.out.print("|" + board[y][x]+ "|");
            }
            System.out.println();
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public void writePlayerMove(int position, String player){
        int index1 = (int)((position - 1) / 3);
        int index2 = (position -1) % 3;
        this.board[index1][index2] = player;
    }

    public void createBoard(){
        String unit = "   ";
        for (int y = 0; y < this.board.length; y++) {
            for (int x = 0; x < this.board[y].length; x++) {
                this.board[x][y] = unit;
            }
        }
    }

    public boolean isBoardFull(){
        boolean full = true;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (this.board[i][j].equals("   ")){
                    full = false; break;
                }
            }
        }
        return full;

    }

    public boolean findWinnerRow(String player) {
        for (int i = 0; i < 3; i++) {
            boolean winner = true;
            for (int j = 0; j < 3; j++) {
                if (!this.board[i][j].equals(player)) {
                    winner = false;
                    break;
                }
            }
            if (winner) {
                return winner;
            }
        }
        return false;
    }

    public boolean findWinnerColumn(String player) {
        for (int i = 0; i < 3; i++) {
            boolean winner = true;
            for (int j = 0; j < 3; j++) {
                if (!this.board[j][i].equals(player)) {
                    winner = false;
                    break;
                }
            }
            if (winner) {
                return winner;
            }
        }
        return false;
    }

    public boolean findDiagoanWinner1(String player) {

        boolean winner = true;
        for (int i = 0; i < 3; i++) {
            if (!this.board[i][i].equals(player)) {
                winner = false;
                break;
            }
        }
        if (winner) {
            return winner;
        }
        return  false;
    }

    public boolean findDiagoanWinner2(String player) {

        boolean winner = true;
        for (int i = 0; i < 3; i++) {
            int iAbs = Math.abs(i - 2);
            if (!this.board[i][iAbs].equals(player)) {
                winner = false;
                break;
            }
        }
        if (winner) {
            return winner;
        }
        return  false;
    }

    public boolean isWinner(String player){
        boolean winRow = findWinnerRow(player);
        boolean winColl = findWinnerColumn(player);
        boolean winDia = findDiagoanWinner1(player);
        boolean winDia2=findDiagoanWinner2(player);
        return winRow || winColl || winDia || winDia2;
    }

}
