package com.stakhouski.anton.stealandrun;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Exit button */
    public void Exit(View view) {
        System.exit(0);
    }

    /** Called when the user clicks the Exit button */
    public void StartNewGame(View view) {
        Intent intent = new Intent(this, GamePlayActivity.class);
        startActivity(intent);
    }
}
