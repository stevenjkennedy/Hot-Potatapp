package com.stevenjkennedy.hotpotatapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Let people see the splash screen
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                showGameMenu();
            }
        }, 5000);   //5 seconds
    }

    protected void showGameMenu(){
        Intent intent = new Intent(this, GameMenu.class);
        startActivity(intent);
    }
}
