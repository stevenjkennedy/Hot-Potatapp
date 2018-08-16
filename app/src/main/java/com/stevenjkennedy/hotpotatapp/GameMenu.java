package com.stevenjkennedy.hotpotatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GameMenu extends AppCompatActivity {

    public static final String GAME_MODE = "com.stevenjkennedy.hotpotatapp.gamemode";
    public static final String GAME_MODE_COOP = "com.stevenjkennedy.hotpotatapp.gamemode.coop";
    public static final String GAME_MODE_COMPETITIVE = "com.stevenjkennedy.hotpotatapp.gamemode.competitive";
    private String _gameMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameselect);
    }

    public void selectCoop(View view){
        _gameMode = GAME_MODE_COOP;
        showGameMenu();
    }

    public void selectCompetitive(View view){
        _gameMode = GAME_MODE_COMPETITIVE;
        showGameMenu();
    }

    protected void showGameMenu(){
        Intent intent = new Intent(this, CategoryMenu.class);
        intent.putExtra(GAME_MODE,_gameMode);
        startActivity(intent);
    }
}
