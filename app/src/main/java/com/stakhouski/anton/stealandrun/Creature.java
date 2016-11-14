package com.stakhouski.anton.stealandrun;

/**
 * Created by archer on 11.11.16.
 */

public abstract class Creature {

    //private section
    private int x;
    private int y;
    private boolean updateFlag;
    private int oldX;
    private int oldY;
    private int testX;
    private int testY;
    Field.Type oldBlockType;
    Field.Type testBlockType;

    //public:
    boolean testMovement(Field field, Field.Type creatueType)
    {
        if (
                testX >= Field.WIDTH || testX < 0 ||
                        testY >= Field.HEIGHT || testY < 0)
            return false;

        testBlockType = field.getBlock(testX, testY);
        if (
                testBlockType == Field.Type.BRICK ||
                        testBlockType == Field.Type.CONCRETE ||
                        testBlockType == Field.Type.ENEMY)
        {
            return false;
        }
        else
        {
            x = testX;
            y = testY;
            updateBlocks(field, creatueType);
            return true;
        }
    }

    boolean fallTest(Field field, Field.Type creatueType)
    {
        testX = x;
        testY = y - 1;
        if (
                testX >= Field.WIDTH || testX < 0 ||
                        testY >= Field.HEIGHT || testY < 0)
            return false;
        testBlockType = field.getBlock(testX, testY);
        if (
                (
                        testBlockType == Field.Type.EMPTY ||
                                testBlockType == Field.Type.BRICK2 ||
                                testBlockType == Field.Type.LADDER2 ||
                                testBlockType == Field.Type.POLE ||
                                testBlockType == Field.Type.GOLD) &&
                        oldBlockType != Field.Type.POLE
                )
        {
            testMovement(field, creatueType);
            return true;
        }
        else
            return false;
    }

    void updateBlocks(Field field, Field.Type creatueType)
    {
        field.setBlock(oldBlockType, oldX, oldY);
        oldBlockType = field.getBlock(x, y);
        if (oldBlockType == Field.Type.GOLD &&
                creatueType == Field.Type.PLAYER)
        {
            oldBlockType = Field.Type.EMPTY;
            field.goldRemain--;
        }
        oldX = x;
        oldY = y;
        field.setBlock(creatueType, x, y);
    }

    boolean jumpTest(Field field)
    {
        //"fly" and "jump" fix
        testBlockType = field.getBlock(testX, testY);
        return  ((
                oldBlockType != Field.Type.LADDER && testBlockType == Field.Type.EMPTY) ||
                (
                        oldBlockType == Field.Type.LADDER2 && testBlockType == Field.Type.LADDER2
                ));
    }

//------------------getters------------

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

    int getOldX()
    {
        return oldX;
    }

    int getOldY()
    {
        return oldY;
    }

    boolean getUpdateFlag()
    {
        return updateFlag;
    }

    int getTestX()
    {
        return testX;
    }

    int getTestY()
    {
        return testY;
    }

    Field.Type getOldBlockType()
    {
        return oldBlockType;
    }

    Field.Type getTestBlockType()
    {
        return testBlockType;
    }



//------------------setters------------

    void setX(int value)
    {
        x = value;
    }

    void setY(int value)
    {
        y = value;
    }

    void setOldX(int value)
    {
        oldX = value;
    }

    void setOldY(int value)
    {
        oldY = value;
    }

    void setUpdateFlag(boolean value)
    {
        updateFlag = value;
    }

    void setTestX(int value)
    {
        testX = value;
    }

    void setTestY(int value)
    {
        testY = value;
    }

    void setOldBlockType(Field.Type value)
    {
        oldBlockType = value;
    }

    void setTestBlockType(Field.Type value)
    {
        testBlockType = value;
    }
}
