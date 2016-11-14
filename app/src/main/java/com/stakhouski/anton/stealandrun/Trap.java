package com.stakhouski.anton.stealandrun;

/**
 * Created by archer on 14.11.16.
 */

public class Trap {
    private int timeRemain;
    private int x;
    private int y;

    Trap(){
        timeRemain = -1;
    }
    public int getTimeRemain(){
        return timeRemain;
    };
    public int getX(){
        return x;
    };
    public int getY(){
        return y;
    };

    public void setTimeRemain(int time){
        timeRemain = time;
    }
    public void setX(int x_){
        x = x_;
    }
    public void setY(int y_){
        y = y_;
    }
}
