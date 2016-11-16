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

/**
 * Created by archer on 12.11.16.
 */

class Enemy extends Creature {
    Enemy(int xVal, int yVal) {
        setX(xVal);
        setY(yVal);
        setOldBlockType(Field.Type.EMPTY);
        setOldX(getX());
        setOldY(getY());
        setUpdateFlag(true);
    }

    private boolean playerCatched(Field field) {
        setTestBlockType(field.getBlock(getTestX(), getTestY()));
        return (getTestBlockType() == Field.Type.PLAYER);
    }

    boolean tick(Field field, Player player) {
        if (!getUpdateFlag()) {
            return true;
        }

        if (fallTest(field, Field.Type.ENEMY)) {
            return true;
        }

        setTestX(getX());
        setTestY(getY());

        //go to player quickly
        if (Math.abs(player.getX() - getX()) <
                Math.abs(player.getY() - getY())) {
            if (player.getX() - getX() >= 0) {
                setTestX(getTestX() + 1);
            } else {
                setTestX(getTestX() - 1);
            }
            if (playerCatched(field)) {
                return false;
            }

            //check testMove at first
            if (!testMovement(field, Field.Type.ENEMY)) {
                setTestX(getX());
                if (player.getY() - getY() >= 0) {
                    setTestY(getTestY() + 1);
                    if (jumpTest(field)) {
                        return true;
                    }
                } else {
                    setTestY(getTestY() - 1);
                }

                if (playerCatched(field)) {
                    return false;
                }

                testMovement(field, Field.Type.ENEMY);
            } else {
                return true;
            }
        } else {
            if (!(player.getY() - getY() >= 0)) {
                setTestY(getTestY() - 1);
            } else {
                setTestY(getTestY() + 1);
                if (jumpTest(field)) {
                    return !ySecondTest(field, player);
                }
            }

            if (playerCatched(field)) {
                return false;
            }

            //check testMove at first
            if (!testMovement(field, Field.Type.ENEMY)) {
                if (ySecondTest(field, player)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private boolean ySecondTest(Field field, Player player) {
        setTestY(getY());
        if (player.getX() - getX() >= 0) {
            setTestX(getTestX() + 1);
        }
        else {
            setTestX(getTestX() - 1);
        }
        if (playerCatched(field)) {
            return true;
        }
        testMovement(field, Field.Type.ENEMY);
        return false;
    }
}
