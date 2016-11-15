package com.stakhouski.anton.stealandrun;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archer on 12.11.16.
 */

public class Game {
    private Painter painter;
    private Field field;
    private Player player;
    private ArrayList<Enemy> enemies;

    Game() {
        painter = new Painter();
        field = new Field();
        player = new Player();
        enemies = new ArrayList<>();
        for (int[] coords : field.getEnemiesCoords()) {
            enemies.add(new Enemy(coords[0], coords[1]));

        }
        //enemies.add(new Enemy(x, y));
    }

    void draw(float[] mvpMatrix) {
        field.draw(mvpMatrix, painter);
    }

    void keyEvent(Player.Action action) {
        player.keyEvent(action);
    }

    void tick() {
        for (Enemy enemy : enemies) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!enemy.tick(field, player)){
                restartGame();
                return;
            }
        }

        //stairway to heaven
        //no. it is just stairway to the next level
        if (field.goldRemain == 0) {
            for (int y = 0; y < Field.HEIGHT; ++y) {
                for (int x = 0; x < Field.WIDTH; ++x) {
                    if (field.getBlock(x, y) == Field.Type.LADDER2)
                        field.setBlock(Field.Type.LADDER, x, y);
                    if (field.getBlock(x, y) == Field.Type.BRICK2)
                        field.setBlock(Field.Type.BRICK, x, y);
                }
            }
        }

        if (!player.tick(field, enemies)) {
            restartGame();
        }
    }

    void restartGame(){
        enemies.clear();
        field = new Field();
        for (int[] coords : field.getEnemiesCoords()) {
            enemies.add(new Enemy(coords[0], coords[1]));
        }
        //player.deleteTraps();
        player = new Player();
    }
}
