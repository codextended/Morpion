package com.codextended.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private TextView a1, a2, a3, b1, b2, b3, c1, c2, c3, title;
    private Button resetButton, restartButton;

    private String player1;
    private String player2;

    private String activePlayer;
    private int moves = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        startGame();


    }

    private void startGame(){
        fieldsInitializer();
        playerSetup();
        resetButton.setVisibility(View.INVISIBLE);
        restartButton.setVisibility(View.INVISIBLE);
    }

    private void playerSetup() {
        player1 = getIntent().getStringExtra("player choice");
        player2 = player1.equals("X") ? "O" : "X";

        activePlayer = player1;
        title.setText("Premye Jwe");
    }

    private void fieldsInitializer() {
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        title = findViewById(R.id.title_textView);

        resetButton = findViewById(R.id.reset_button);
        restartButton = findViewById(R.id.restart_button);
    }



    public void clickedField(View view){
        TextView selectView = (TextView) view;
        selectView.setText(activePlayer);
        selectView.setClickable(false);
        moves++;

        String newTitle = title.getText().toString().equals("Premye Jwe") ? "Dezyem Jwe" : "Premye Jwe";
        title.setText(newTitle);

        if (boardFull()){
            gameOver();
        }
        if (hasWinner()){
            gameOver();
            String winner = activePlayer.equals(player1) ? "Premye Jwe a Genyen!" : "Dezyem Jwe a Genyen!";
            title.setText(winner);
        }

        activePlayer = activePlayer.equals("X") ? "O" : "X";
    }

    private boolean boardFull() {
        return moves >= 9;
    }

    private boolean hasWinner() {
        if (a1.getText().equals(player1) && a2.getText().equals(player1) && a3.getText().equals(player1)
                || a1.getText().equals(player2) && a2.getText().equals(player2) && a3.getText().equals(player2))
            return true;
        if (b1.getText().equals(player1) && b2.getText().equals(player1) && b3.getText().equals(player1)
                || b1.getText().equals(player2) && b2.getText().equals(player2) && b3.getText().equals(player2))
            return true;
        if (c1.getText().equals(player1) && c2.getText().equals(player1) && c3.getText().equals(player1)
                || c1.getText().equals(player2) && c2.getText().equals(player2) && c3.getText().equals(player2))
            return true;
        if (a1.getText().equals(player1) && b1.getText().equals(player1) && c1.getText().equals(player1)
                || a1.getText().equals(player2) && b1.getText().equals(player2) && c1.getText().equals(player2))
            return true;
        if (a2.getText().equals(player1) && b2.getText().equals(player1) && c2.getText().equals(player1)
                || a2.getText().equals(player2) && b2.getText().equals(player2) && c2.getText().equals(player2))
            return true;
        if (a3.getText().equals(player1) && b3.getText().equals(player1) && c3.getText().equals(player1)
                || a3.getText().equals(player2) && b3.getText().equals(player2) && c3.getText().equals(player2))
            return true;
        if (a1.getText().equals(player1) && b2.getText().equals(player1) && c3.getText().equals(player1)
                || a1.getText().equals(player2) && b2.getText().equals(player2) && c3.getText().equals(player2))
            return true;
        if (a3.getText().equals(player1) && b2.getText().equals(player1) && c1.getText().equals(player1)
                || a3.getText().equals(player2) && b2.getText().equals(player2) && c1.getText().equals(player2))
            return true;

        return false;
    }

    private void gameOver() {
        title.setText("Jwet la fini!");
        deactivateFields();
        showOptionsButton();

    }

    private void showOptionsButton() {
        resetButton.setVisibility(View.VISIBLE);
        restartButton.setVisibility(View.VISIBLE);
    }

    private void deactivateFields() {
        a1.setClickable(false);
        a2.setClickable(false);
        a3.setClickable(false);
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        c1.setClickable(false);
        c2.setClickable(false);
        c3.setClickable(false);
    }

    public void resetGame(View view){
        moves = 0;
        playerSetup();
        resetFields();
        resetButton.setVisibility(View.INVISIBLE);
        restartButton.setVisibility(View.INVISIBLE);
    }

    private void resetFields() {
        a1.setClickable(true);
        a1.setText("");
        a2.setClickable(true);
        a2.setText("");
        a3.setClickable(true);
        a3.setText("");
        b1.setClickable(true);
        b1.setText("");
        b2.setClickable(true);
        b2.setText("");
        b3.setClickable(true);
        b3.setText("");
        c1.setClickable(true);
        c1.setText("");
        c2.setClickable(true);
        c2.setText("");
        c3.setClickable(true);
        c3.setText("");
    }

    public void restartGame(View view){
        Intent intent = new Intent(GameActivity.this, MainActivity.class);
        startActivity(intent);
    }
}