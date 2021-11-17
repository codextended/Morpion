package com.codextended.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SelectionActivity extends AppCompatActivity {

    private Button enterButton;
    private RadioButton xRadioButton;
    private RadioButton oRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        enterButton = findViewById(R.id.enter_button);
        xRadioButton = findViewById(R.id.x_button);
        oRadioButton = findViewById(R.id.o_button);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this, GameActivity.class);
                intent.putExtra("player choice", playerChoice());
                startActivity(intent);
            }
        });
    }

    private String playerChoice() {
        return xRadioButton.isChecked() ? xRadioButton.getText().toString() : oRadioButton.getText().toString();
    }
}