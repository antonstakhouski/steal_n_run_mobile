package com.stakhouski.anton.stealandrun;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 * Created by archer on 15.10.16.
 */

public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context){
        super(context);

        // Create an OpenGL ES 3.0 context
        setEGLContextClientVersion(3);

        mRenderer = new MyGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    private float mPreviousX;
    private float mPreviousY;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - mPreviousX;
                float dy = y - mPreviousY;

                // reverse direction of rotation above the mid-line
                if (Math.abs(dx) > Math.abs(dy)) {
                    // horizontal movement
                    if (dx > 0) {
                        mRenderer.setPlayerKeyEvent(Player.Action.LEFT);
                    }
                    else {
                        mRenderer.setPlayerKeyEvent(Player.Action.RIGHT);
                    }
                }

                else {
                    // vertical movement
                    if (dy > 0) {
                        mRenderer.setPlayerKeyEvent(Player.Action.DOWN);
                    }
                    else {
                        mRenderer.setPlayerKeyEvent(Player.Action.UP);
                    }
                }

                requestRender();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
