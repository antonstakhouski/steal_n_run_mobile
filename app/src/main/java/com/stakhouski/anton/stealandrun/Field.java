package com.stakhouski.anton.stealandrun;

import java.security.InvalidParameterException;

/**
 * Created by archer on 09.11.16.
 */

public class Field {

    static final int WIDTH = 26, HEIGHT = 16;
    enum Type { EMPTY, BRICK, CONCRETE, LADDER, GOLD, PLAYER ,ENEMY, POLE, BRICK2, LADDER2 }
    static int playerX;
    static int playerY;
    int goldRemain = 0;
    static int level = 1;
    private String levelMap =
            "EEEEEEEEEEEEEEEEE1EEEEEEEE" +
            "EEEEGEEEEEEEEEEEE1EEEEEEEE" +
            "BBBBBBLBBBBBBBEEE1EEEEEEEE" +
            "EEEEEEL33333333331EEEEGEEE" +
            "EEEEEELEEEEBBLEEEBBBBBBLBB" +
            "EEEEEELEEEEBBLEEEEEEEEELEE" +
            "EEEEE4LEEEEBBLEEEEEEEG4LEE" +
            "BBLBBBBEEEEBBBBBBBBLBBBBBB" +
            "EELEEEEEEEEEEEEEEEELEEEEEE" +
            "EELEEEEEEEEEE4EEEEELEEEEEE" +
            "BBBBBBBBLBBBBBBBBBBLEEEEEE" +
            "EEEEEEEELEEEEEEEEEELEEEEEE" +
            "EEEEEEGEL3333333333LEEGEEE" +
            "EEEELBBBBBEEEEEEEEEBBBBBBL" +
            "EEEELEEEEEEEEPEEGEEEEEEEEL" +
            "BBBBBBBBBBBBBBBBBBBBBBBBBB";

    //blocks coordinates
    //for textures
    Type[][] m_ = new Type[HEIGHT][WIDTH];

    private float[] ladderColor = {0.0f, 1.0f, 0.0f, 1.0f};
    private float[] concreteColor = {0.255f, 0.128f, 0.0f, 1.0f};
    private float[] brickColor = {1.0f, 0.0f, 0.0f, 1.0f};
    private float[] goldColor = {1.0f, 1.0f, 0.0f, 1.0f};
    private float[] poleColor = {1.0f, 1.0f, 1.0f, 1.0f};
    private float[] playerColor = {0.0f, 0.0f, 1.0f, 1.0f};
    private float[] enemyColor = {0.1f, 0.3f, 0.4f, 1.0f};

    Field(){
        char[] charArrayMap = levelMap.toCharArray();
        char c;
        for (int y = 0; y < HEIGHT; ++y){
            for (int x = 0; x < WIDTH; ++x){
                c = charArrayMap[(HEIGHT - y) * WIDTH - x -1];
                switch (c){
                    case 'L':
                        m_[y][x] = Type.LADDER;
                        continue;
                    case 'C':
                        m_[y][x] = Type.CONCRETE;
                        continue;
                    case 'B':
                        m_[y][x] = Type.BRICK;
                        continue;
                    case 'E':
                        m_[y][x] = Type.EMPTY;
                        continue;
                    case 'G':
                        m_[y][x] = Type.GOLD;
                        goldRemain++;
                        continue;
                    case '1':
                        m_[y][x] = Type.LADDER2;
                        continue;
                    case '2':
                        m_[y][x] = Type.BRICK2;
                        continue;
                    case '3':
                        m_[y][x] = Type.POLE;
                        continue;
                    case 'P':
                        m_[y][x] = Type.PLAYER;
                        playerY = y;
                        playerX = x;
                        continue;
                    case '4':
                        m_[y][x] = Type.ENEMY;
                        continue;
                    default:
                }
            }
        }
    }

    void setBlock(Type type, int x, int y) {m_[y][x] = type;}

    Type getBlock(int x, int y) {return m_[y][x];}

    void draw(float[] mvpMatrix, Painter painter) {
        for (int y = 0; y < HEIGHT; ++y) {
            for (int x = 0; x < WIDTH; ++x) {
                switch (m_[y][x]) {
                    case EMPTY:
                        break;
                    case LADDER2:
                        break;
                    case BRICK2:
                        break;
                    case LADDER:
                        drawBlock(mvpMatrix, x, y, ladderColor, painter);
                        break;
                    case CONCRETE:
                        drawBlock(mvpMatrix, x, y, concreteColor, painter);
                        break;
                    case BRICK:
                        drawBlock(mvpMatrix, x, y, brickColor, painter);
                        break;
                    case GOLD:
                        drawBlock(mvpMatrix, x, y, goldColor, painter);
                        break;
                    case POLE:
                        drawBlock(mvpMatrix, x, y, poleColor, painter);
                        break;
                    case PLAYER:
                        drawBlock(mvpMatrix, x, y, playerColor, painter);
                        break;
                    case ENEMY:
                        drawBlock(mvpMatrix, x, y, enemyColor, painter);
                        break;
                    default:
                        throw new InvalidParameterException();
                }
            }
        }
    }

    private void drawBlock(float[] mvpMatrix, int x, int y, float[] color, Painter painter)
    {
        int width = WIDTH + 2;
        float xf = ((x / (float)width) * 2 - 1);
        float yf = ((y / (float)width) * 2 - 1);
        float offsetY = 12 / (float)width;
        float offsetX = 2 / (float)width;

        float[] squareCoords = {
                xf + offsetX,           yf + 2/(float)width + offsetY,   0.0f,
                xf + offsetX,           yf + offsetY,             0.0f,
                xf + 2/(float)width + offsetX, yf + offsetY,             0.0f,
                xf + 2/(float)width + offsetX, yf + 2/(float)width + offsetY,   0.0f};
        painter.draw(mvpMatrix, squareCoords, color);
    }

}
