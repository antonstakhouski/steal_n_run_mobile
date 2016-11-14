package com.stakhouski.anton.stealandrun;

/**
 * Created by archer on 11.11.16.
 */

public class Player extends Creature {
    enum Action { LEFT, UP, RIGHT, DOWN, DIGLEFT, DIGRIGHT};
    private final int trapNum = 3;
    private final int  trapUpdate = 500;
    private Trap[] traps;
    private Action action_;

    Player() {
        traps = new Trap[trapNum];
        for (int i = 0; i < trapNum; i++) {
            traps[i] = new Trap();
        }
        //remember start player pos
        setUpdateFlag(false);
        setX(Field.playerX);
        setY(Field.playerY);
        //data backup to restore after movement from this block
        setOldX(getX());
        setOldY(getY());
        setOldBlockType(Field.Type.EMPTY);

    }

    void keyEvent(Action d)
    {
        action_ = d;
        setUpdateFlag(true);
    }

    private void setTrap(Field field)
    {
        int trapIterator;
        setTestY(getY() - 1);
        if (field.getBlock(getTestX(), getTestY()) == Field.Type.BRICK &&
                field.getBlock(getTestX(), getTestY() + 1) != Field.Type.LADDER) {
            //find free traps
            for (trapIterator = 0; trapIterator < trapNum; trapIterator++) {
                if (traps[trapIterator].getTimeRemain() == -1)
                    break;
            }
            //if all traps are busy
            if (trapIterator == trapNum)
                return;
            //set traps
            traps[trapIterator].setTimeRemain(trapUpdate);
            traps[trapIterator].setX(getTestX());
            traps[trapIterator].setY(getTestY());
            field.setBlock(Field.Type.EMPTY, getTestX(), getTestY());
        }
    }

    boolean checkTraps(Field field)
    {
        //close traps
        int trapIterator;
        for (trapIterator = 0; trapIterator < trapNum; trapIterator++){
            //reduce remainTime
            int timeRemain = traps[trapIterator].getTimeRemain();
            if (timeRemain >= 0)
                traps[trapIterator].setTimeRemain(timeRemain - 1);

            if (timeRemain == 0){
                //if is goin to close
                //player is in a traps
                if (getX() == traps[trapIterator].getX() &&
                        getY() == traps[trapIterator].getY())
                    return false;
                //if traps is empty
                field.setBlock(Field.Type.BRICK, traps[trapIterator].getX(),
                        traps[trapIterator].getY());
            }
        }
        return true;
    }

    boolean tick(Field field)
    {
        //jump to the next level
        if(field.goldRemain == 0 &&
                getOldBlockType() == Field.Type.LADDER
                && getY() == (Field.HEIGHT - 1)
                )
        {
            Field.level++;
            return false;
        }

        if (fallTest(field, Field.Type.PLAYER))
            return true;

        if (getUpdateFlag()){
            setUpdateFlag(false);
            switch (action_)
            {
                case DIGLEFT:
                    setTestX(getX() - 1);
                    setTrap(field);
                    break;
                case DIGRIGHT:
                    setTestX(getX() + 1);
                    setTrap(field);
                    break;
                case LEFT:
                    setTestY(getY());
                    setTestX(getX() - 1);
                    testMovement(field, Field.Type.PLAYER);
                    break;
                case UP:
                    setTestX(getX());
                    setTestY(getY() + 1);
                    if (jumpTest(field))
                        return true;
                    testMovement(field, Field.Type.PLAYER);
                    break;
                case RIGHT:
                    setTestY(getY());
                    setTestX(getX() + 1);
                    testMovement(field, Field.Type.PLAYER);
                    break;
                case DOWN:
                    setTestX(getX());
                    setTestY(getY() - 1);
                    testMovement(field, Field.Type.PLAYER);
                    break;
            }
        }
        return true;
    }
}
