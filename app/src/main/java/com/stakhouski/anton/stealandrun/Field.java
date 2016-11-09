package com.stakhouski.anton.stealandrun;

/**
 * Created by archer on 09.11.16.
 */

public class Field {
    Painter p = new Painter();

    final int WIDTH = 26, HEIGHT = 16;
    final int BLOCK_WIDTH = 40, BLOCK_HEIGHT = 40;
    int step = 16;
    enum Type { EMPTY, BRICK, CONCRETE, LADDER, GOLD, PLAYER ,ENEMY, POLE, BRICK2, LADDER2 };
    int playerX;
    int playerY;
    int goldRemain;
    static int level;
    //vectors for enemies
    //std::vector<int> xvec;
    //std::vector<int> yvec;

    //blocks coordinates
    //for textures
    private int[] brick = new int[]{ 0,  0};
    private int[] concrete = {brick[0] + step, 0};
    private int[] ladder = {concrete[0] + step , 0};
    private int[] pole = {ladder[0] + step, 0};
    private int[] gold = {96, 0};
    private int[] enemy = {gold[0] + step, 0};
    private int[] player = {enemy[0] + step, 0};
    private Type[][] m_ = new Type[HEIGHT][WIDTH];

    float[] ladder_color = new float[]{0.0f, 1.0f, 0.0f, 1.0f};
    float[] concrete_color = new float[]{0.255f, 0.128f, 0.0f, 1.0f};
    float[] brick_color = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
    float[] gold_color = new float[]{1.0f, 1.0f, 0.0f, 1.0f};
    float[] pole_color = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
    float[] player_color = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
    float[] enemy_color = new float[]{0.1f, 0.3f, 0.4f, 1.0f};

    float[] squareCoords;

    void setBlock(Type type, int x, int y) {m_[y][x] = type;}
    Type getBlock(int x, int y) {return m_[y][x];}
    void draw() {
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
                        drawBlock(x, y, ladder_color);
                        break;
                    case CONCRETE:
                        drawBlock(x, y, concrete_color);
                        break;
                    case BRICK:
                        drawBlock(x, y, brick_color);
                        break;
                    case GOLD:
                        drawBlock(x, y, gold_color);
                        break;
                    case POLE:
                        drawBlock(x, y, pole_color);
                        break;
                    case PLAYER:
                        drawBlock(x, y, player_color);
                        break;
                    case ENEMY:
                        drawBlock(x, y, enemy_color);
                        break;
                }
            }
        }
    }
    void drawBlock(int x, int y, float[] color)
    {
        float[] sqareCoords = new float[]{
                x * BLOCK_WIDTH, (y + 1) * BLOCK_HEIGHT, 0.0f,
                x * BLOCK_WIDTH, (y + 1) * BLOCK_HEIGHT, 0.0f,
                (x + 1) * BLOCK_WIDTH, (y + 1) * BLOCK_HEIGHT}
        p.draw(int x, int y, float[] color);
    }

}
