/*
 * MIT License
 *
 * Copyright (c) 2016 Anton Stakhouski
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.stakhouski.anton.stealandrun;

import java.util.ArrayList;

/**
 * Created by archer on 11.11.16.
 */

class Player extends Creature {
    enum Action {LEFT, UP, RIGHT, DOWN, DIGLEFT, DIGRIGHT}

    private final int trapNum = 3;
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

    void keyEvent(Action d) {
        action_ = d;
        setUpdateFlag(true);
    }

    private void setTrap(Field field) {
        int trapIterator;
        setTestY(getY() - 1);
        if (getTestY() < 0 || getTestY() >= Field.HEIGHT
                || getTestX() < 0 || getTestX() >= Field.WIDTH) {
            return;
        }
        if (field.getBlock(getTestX(), getTestY()) == Field.Type.BRICK &&
                field.getBlock(getTestX(), getTestY() + 1) != Field.Type.LADDER) {
            //find free traps
            for (trapIterator = 0; trapIterator < trapNum; trapIterator++) {
                if (traps[trapIterator].getTimeRemain() == -1) {
                    break;
                }
            }
            //if all traps are busy
            if (trapIterator == trapNum) {
                return;
            }
            //set traps
            int trapUpdate = 20;
            traps[trapIterator].setTimeRemain(trapUpdate);
            traps[trapIterator].setX(getTestX());
            traps[trapIterator].setY(getTestY());
            field.setBlock(Field.Type.EMPTY, getTestX(), getTestY());
        }
    }

    private boolean checkTraps(Field field, ArrayList<Enemy> enemies) {
        //close traps
        int trapIterator;
        for (trapIterator = 0; trapIterator < trapNum; trapIterator++) {
            //reduce remainTime
            int timeRemain = traps[trapIterator].getTimeRemain();
            if (timeRemain >= 0) {
                traps[trapIterator].setTimeRemain(timeRemain - 1);
            }

            if (timeRemain == 0) {
                //if is goin to close
                //player is in a traps
                if (getX() == traps[trapIterator].getX() &&
                        getY() == traps[trapIterator].getY()) {
                    return false;
                }
                //if trap is empty
                for (Enemy enemy : enemies) {
                    if (traps[trapIterator].getX() == enemy.getX() &&
                            traps[trapIterator].getY() == enemy.getY()) {
                        enemy.setUpdateFlag(false);
                        enemy.setY(enemy.getY() + 1);
                        enemy.setOldX(enemy.getX());
                        enemy.setOldY(enemy.getY());
                        enemy.setUpdateFlag(true);
                    }
                }
                field.setBlock(Field.Type.BRICK, traps[trapIterator].getX(),
                        traps[trapIterator].getY());
            }
        }
        return true;
    }

    boolean tick(Field field, ArrayList<Enemy> enemies) {
        if (!checkTraps(field, enemies)) {
            return false;
        }

        //jump to the next level
        if (field.goldRemain == 0 &&
                getOldBlockType() == Field.Type.LADDER
                && getY() == (Field.HEIGHT - 1)
                ) {
            Field.level++;
            return false;
        }

        if (fallTest(field, Field.Type.PLAYER)) {
            return true;
        }

        if (getUpdateFlag()) {
            setUpdateFlag(false);
            switch (action_) {
                case DIGLEFT:
                    setTestX(getX() + 1);
                    setTrap(field);
                    break;
                case DIGRIGHT:
                    setTestX(getX() - 1);
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
