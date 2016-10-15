package com.stakhouski.anton.stealandrun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GamePlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
    }

    public void Pause(View view){
        System.exit(0);
    }
}
