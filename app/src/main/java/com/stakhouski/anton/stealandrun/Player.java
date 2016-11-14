package com.stakhouski.anton.stealandrun;

/**
 * Created by archer on 11.11.16.
 */

public class Player extends Creature {
    enum Action { LEFT, UP, RIGHT, DOWN, DIGLEFT, DIGRIGHT};

    Player() {
        //remember start player pos
        setUpdateFlag(false);
        setX(Field.playerX);
        setY(Field.playerY);
        //data backup to restore after movement from this block
        setOldX(getX());
        setOldY(getY());
        setOldBlockType(Field.Type.EMPTY);
    }

    //struct digData* trap;
    private Action action_;
    //int trapIterator;

    void keyEvent(Action d)
    {
        action_ = d;
        setUpdateFlag(true);
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
