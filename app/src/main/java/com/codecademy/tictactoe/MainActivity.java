package com.codecademy.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button pole1_1,pole1_2,pole1_3,pole2_1,pole2_2,pole2_3,pole3_1,pole3_2,pole3_3;

    TextView welcomeText;
    TextView player;
    Board board = new Board();
    Player playerMain = new Player();
    public String gameOverMSG(String player){
        return "GAME OVER, PLAYER: "+player+" WON";
    }
    String fullBoardMSG = "GAME OVER, FULL BOARD.";
    public void cleanBoard(){
        pole1_1.setText("");
        pole1_2.setText("");
        pole1_3.setText("");
        pole2_1.setText("");
        pole2_2.setText("");
        pole2_3.setText("");
        pole3_1.setText("");
        pole3_2.setText("");
        pole3_3.setText("");
    }
    public int compNumber(){
        return (int)(Math.random() * 9)+1;
    }

    public void autoMove(){
        int ranNum = compNumber();
        boolean notEmpty = true;
        while (notEmpty) {
            if (!board.isEmpty(ranNum)) {
                ranNum = compNumber();
            } else {
                board.writePlayerMove(ranNum, playerMain.getPlayerName());
                switch (ranNum) {
                    case 1:
                        pole1_1.setText(playerMain.getPlayerName()); notEmpty=false;
                        break;
                    case 2:
                        pole1_2.setText(playerMain.getPlayerName());notEmpty=false;
                        break;
                    case 3:
                        pole1_3.setText(playerMain.getPlayerName());notEmpty=false;
                        break;
                    case 4:
                        pole2_1.setText(playerMain.getPlayerName());notEmpty=false;
                        break;
                    case 5:
                        pole2_2.setText(playerMain.getPlayerName());notEmpty=false;
                        break;
                    case 6:
                        pole2_3.setText(playerMain.getPlayerName());notEmpty=false;
                        break;
                    case 7:
                        pole3_1.setText(playerMain.getPlayerName());notEmpty=false;
                        break;
                    case 8:
                        pole3_2.setText(playerMain.getPlayerName());notEmpty=false;
                        break;
                    case 9:
                        pole3_3.setText(playerMain.getPlayerName());notEmpty=false;
                        break;
                }
            }
        }
    }

    public void gameOver(String message){
        AlertDialog.Builder gameOverDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        gameOverDialogBuilder.setCancelable(false);
        gameOverDialogBuilder.setTitle(message);
        gameOverDialogBuilder.setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                board.createBoard();
                cleanBoard();
            }
        });
        gameOverDialogBuilder.create().show();
    }
    public void checkGame(){
        if ( board.isWinner(playerMain.getPlayerName())){
            gameOver(gameOverMSG(playerMain.getPlayerName()));
        } else if ( board.isBoardFull()) {
            gameOver(fullBoardMSG);
        } else {
            playerMain.swithPlayer();
            player.setText("Player \nto move: \n\t\t"+playerMain.playerName);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.TV_main_welcomeText);
        player = findViewById(R.id.TV_main_player);

        pole1_1 = findViewById(R.id.btn_main_1_1);
        pole1_2 = findViewById(R.id.btn_main_1_2);
        pole1_3 = findViewById(R.id.btn_main_1_3);
        pole2_1 = findViewById(R.id.btn_main_2_1);
        pole2_2 = findViewById(R.id.btn_main_2_2);
        pole2_3 = findViewById(R.id.btn_main_2_3);
        pole3_1 = findViewById(R.id.btn_main_3_1);
        pole3_2 = findViewById(R.id.btn_main_3_2);
        pole3_3 = findViewById(R.id.btn_main_3_3);

        welcomeText.setText(WelcomeText.getText());

        player.setText("Player \nto move: \n\t\t"+playerMain.playerName);

        pole1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(1,playerMain.getPlayerName());
                pole1_1.setText(playerMain.getPlayerName());
                checkGame();
            }
        });
        pole1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(2,playerMain.getPlayerName());
                pole1_2.setText(playerMain.getPlayerName());
                checkGame();
                //autoMove();
                //checkGame();
            }
        });
        pole1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(3,playerMain.getPlayerName());
                pole1_3.setText(playerMain.getPlayerName());
                checkGame();
            }
        });
        pole2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(4,playerMain.getPlayerName());
                pole2_1.setText(playerMain.getPlayerName());
                checkGame();
            }
        });
        pole2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(5,playerMain.getPlayerName());
                pole2_2.setText(playerMain.getPlayerName());
                checkGame();
                //autoMove();
                //checkGame();
            }
        });
        pole2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(6,playerMain.getPlayerName());
                pole2_3.setText(playerMain.getPlayerName());
                checkGame();
            }
        });
        pole3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(7,playerMain.getPlayerName());
                pole3_1.setText(playerMain.getPlayerName());
                checkGame();
            }
        });
        pole3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(8,playerMain.getPlayerName());
                pole3_2.setText(playerMain.getPlayerName());
                checkGame();
            }
        });
        pole3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.writePlayerMove(9,playerMain.getPlayerName());
                pole3_3.setText(playerMain.getPlayerName());
                checkGame();
            }
        });
    }
}