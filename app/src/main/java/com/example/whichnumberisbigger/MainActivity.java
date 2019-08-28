package com.example.whichnumberisbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private BiggerNumberGame game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

        game = new BiggerNumberGame(0, 1000000);
        updateGameDisplay();

    }

    private void updateGameDisplay() {
        game.generateRandomNumbers();
        buttonLeft.setText(String.valueOf(game.getNumber1()));
        buttonRight.setText(String.valueOf(game.getNumber2()));
        textViewScore.setText(String.valueOf(game.getScore()));

    }


    private void setListeners() {
        //  Creating an Anonymous Inner Class that implements View.OnClickListener
        //  Overriding the one abstract method onClick(View v)
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                int answer = Integer.parseInt(buttonLeft.getText().toString());
                String message = game.checkAnswer(answer);
                Toast.makeText(MainActivity.this, "LEFT CLICKED!", Toast.LENGTH_SHORT).show();
                updateGameDisplay();
            }
        }
        );

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = Integer.parseInt(buttonRight.getText().toString());
                String message = game.checkAnswer(answer);
                Toast.makeText(MainActivity.this, "RIGHT CLICKED!", Toast.LENGTH_SHORT).show();
                updateGameDisplay();
            }
        });


    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textview_main_score);
    }
}
