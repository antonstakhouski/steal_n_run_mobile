package com.stakhouski.anton.stealandrun;

import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import com.zerokol.views.JoystickView;
import com.zerokol.views.JoystickView.OnJoystickMoveListener;


public class GamePlayActivity extends AppCompatActivity {

    private GLSurfaceView mGLView;
    private MyGLRenderer mRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game_play);

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        mGLView = new MyGLSurfaceView(this);
        mRenderer = new MyGLRenderer();
        mGLView.setRenderer(mRenderer);
        JoystickView joystick;

        joystick = (JoystickView)findViewById(R.id.joystickView);

        joystick.setOnJoystickMoveListener(new OnJoystickMoveListener() {
            @Override
            public void onValueChanged(int angle, int power, int direction) {
                switch (direction){
                    case JoystickView.LEFT:
                        mRenderer.setPlayerKeyEvent(Player.Action.LEFT);
                        break;
                    case JoystickView.RIGHT:
                        mRenderer.setPlayerKeyEvent(Player.Action.RIGHT);
                        break;
                    case JoystickView.FRONT:
                        mRenderer.setPlayerKeyEvent(Player.Action.UP);
                        break;
                    case JoystickView.BOTTOM:
                        mRenderer.setPlayerKeyEvent(Player.Action.DOWN);
                        break;
                    case JoystickView.FRONT_RIGHT:
                        mRenderer.setPlayerKeyEvent(Player.Action.RIGHT);
                        mGLView.requestRender();
                        mRenderer.setPlayerKeyEvent(Player.Action.UP);
                        break;
                    case JoystickView.LEFT_FRONT:
                        mRenderer.setPlayerKeyEvent(Player.Action.LEFT);
                        mGLView.requestRender();
                        mRenderer.setPlayerKeyEvent(Player.Action.UP);
                        break;
                    case JoystickView.BOTTOM_LEFT:
                        mRenderer.setPlayerKeyEvent(Player.Action.LEFT);
                        mGLView.requestRender();
                        mRenderer.setPlayerKeyEvent(Player.Action.DOWN);
                        break;
                    case JoystickView.RIGHT_BOTTOM:
                        mRenderer.setPlayerKeyEvent(Player.Action.RIGHT);
                        mGLView.requestRender();
                        mRenderer.setPlayerKeyEvent(Player.Action.DOWN);
                        break;
                }
            }
        }, JoystickView.DEFAULT_LOOP_INTERVAL);

        Button digLeftBtn = (Button)findViewById(R.id.digLeftBtn);
        Button digRightBtn = (Button)findViewById(R.id.digRightBtn);

        digLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRenderer.setPlayerKeyEvent(Player.Action.DIGLEFT);
            }
        });

        digRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRenderer.setPlayerKeyEvent(Player.Action.DIGRIGHT);
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
