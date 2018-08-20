package com.stevenjkennedy.hotpotatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;


public class CoopGame extends AppCompatActivity {

    protected String[] _words;
    protected Integer _correct = 0;
    protected Integer _wordIndex = 0;
    protected Timer _timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coopgame);

        Intent intent = getIntent();
        _words = intent.getStringArrayExtra(CategoryMenu.WORDS);
    }

    public void start(){
        //Start timer
    }

    public void nextWord(View view){
        Button next = findViewById(R.id.btnCoopNext);
        next.setText("Next");
        TextView textView = findViewById(R.id.tvCoopWord);

        if (_wordIndex == _words.length){
            textView.setText("GAME OVER!!");
            next.setVisibility(View.INVISIBLE);
            Button newGame = findViewById(R.id.btnCoopNewGame);
            newGame.setVisibility(View.VISIBLE);
        } else {
            textView.setText(_words[_wordIndex]);
            _wordIndex++;
        }
    }

    public void playAgain(View view){
        Intent intent = new Intent(this, CategoryMenu.class);
        startActivity(intent);
    }
}
