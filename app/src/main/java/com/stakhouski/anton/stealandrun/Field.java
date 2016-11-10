package com.stakhouski.anton.stealandrun;

import java.security.InvalidParameterException;

/**
 * Created by archer on 09.11.16.
 */

public class Field {
    Painter p = new Painter();

    final int WIDTH = 26, HEIGHT = 16;
    final int BLOCK_WIDTH = 40, BLOCK_HEIGHT = 40;
    int step = 16;
    enum Type { EMPTY, BRICK, CONCRETE, LADDER, GOLD, PLAYER ,ENEMY, POLE, BRICK2, LADDER2 }
    int playerX;
    int playerY;
    int goldRemain;
    static int level;
    String levelMap =
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

    char[] charArrayMap = levelMap.toCharArray();

    //blocks coordinates
    //for textures
    private int[] brick = new int[]{ 0,  0};
    private int[] concrete = {brick[0] + step, 0};
    private int[] ladder = {concrete[0] + step , 0};
    private int[] pole = {ladder[0] + step, 0};
    private int[] gold = {96, 0};
    private int[] enemy = {gold[0] + step, 0};
    private int[] player = {enemy[0] + step, 0};
    Type[][] m_ = new Type[HEIGHT][WIDTH];

    float[] ladder_color = {0.0f, 1.0f, 0.0f, 1.0f};
    float[] concrete_color = {0.255f, 0.128f, 0.0f, 1.0f};
    float[] brick_color = {1.0f, 0.0f, 0.0f, 1.0f};
    float[] gold_color = {1.0f, 1.0f, 0.0f, 1.0f};
    float[] pole_color = {1.0f, 1.0f, 1.0f, 1.0f};
    float[] player_color = {0.0f, 0.0f, 1.0f, 1.0f};
    float[] enemy_color = {0.1f, 0.3f, 0.4f, 1.0f};

    float[] squareCoords;
    float[] mvpMatrix;

    Field(){
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
                        continue;
                }
            }
        }
    }

    void setBlock(Type type, int x, int y) {m_[y][x] = type;}

    Type getBlock(int x, int y) {return m_[y][x];}

    void draw(float[] mvpMatrix) {
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
                        drawBlock(mvpMatrix, x, y, ladder_color);
                        break;
                    case CONCRETE:
                        drawBlock(mvpMatrix, x, y, concrete_color);
                        break;
                    case BRICK:
                        drawBlock(mvpMatrix, x, y, brick_color);
                        break;
                    case GOLD:
                        drawBlock(mvpMatrix, x, y, gold_color);
                        break;
                    case POLE:
                        drawBlock(mvpMatrix, x, y, pole_color);
                        break;
                    case PLAYER:
                        drawBlock(mvpMatrix, x, y, player_color);
                        break;
                    case ENEMY:
                        drawBlock(mvpMatrix, x, y, enemy_color);
                        break;
                    default:
                        throw new InvalidParameterException();
                }
            }
        }
    }

    void drawBlock(float[] mvpMatrix, int x, int y, float[] color)
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
        /*float[] squareCoords = {
                xf,           yf + 1/WIDTH,   0.0f,
                xf,           yf,             0.0f,
                xf + 1/WIDTH, yf,             0.0f,
                xf + 1/WIDTH, yf + 1/WIDTH,   0.0f};/*

         /* float squareCoords[] = {
                -1.0f,  1.0f, 0.0f,   // top left
                -1.0f, -1.0f, 0.0f,   // bottom left
                1.0f, -1.0f, 0.0f,   // bottom right
                1.0f,  1.0f, 0.0f }; // top right */
        p.draw(mvpMatrix, squareCoords, color);
    }

}
