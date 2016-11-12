package com.stakhouski.anton.stealandrun;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class GamePlayActivity extends AppCompatActivity {

    private GLSurfaceView mGLView;
    private MyGLRenderer mRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game_play);

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        mGLView = new MyGLSurfaceView(this);
        mRenderer = new MyGLRenderer();
        mGLView.setRenderer(mRenderer);

        Button leftBtn = (Button)findViewById(R.id.leftBtn);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRenderer.setPlayerKeyEvent(Player.Action.LEFT);
            }
        });

        Button rightBtn = (Button)findViewById(R.id.rightBtn);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRenderer.setPlayerKeyEvent(Player.Action.RIGHT);
            }
        });

        Button upBtn = (Button)findViewById(R.id.upBtn);
        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRenderer.setPlayerKeyEvent(Player.Action.UP);
            }
        });

        Button downBtn = (Button)findViewById(R.id.downBtn);
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRenderer.setPlayerKeyEvent(Player.Action.DOWN);
            }
        });


        FrameLayout frame = (FrameLayout)findViewById(R.id.activity_game_play);
        setContentView(mGLView);
        addContentView(frame, new
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void Pause(View view){
        System.exit(0);
    }


}
