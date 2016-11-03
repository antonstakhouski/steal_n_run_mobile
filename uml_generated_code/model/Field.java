package model;

import java.util.*;


/**
 * Class Field
 */
public class Field {

  //
  // Fields
  //

  static public int level = 1;
  public int step = 15;
  public int playerX;
  public int playerY;
  public int goldRemain = 0;
  public ArrayList<int> xEnemy;
  public ArrayList <int> yEnemy;
  /**
   * blocks coordinates
   */
  private int[2] brickTextCoord;
  private int[2] concreteTextCoord;
  private int[2] ladderTextCoord;
  private int[2] poleTextCoord;
  private int[2] goldTextCoord;
  private int[2] enemyTextCoord;
  private int[2] playerTextCoord;  
  /*
   *
   * int brick[2] 	= { 0,  0};
   * int concrete[2] = {16, 0};
   * int ladder[2] 	= {32 , 0};
   * int pole[2]		= {ladder[0] + step, 0};
   * int gold[2]		= {96, 0};
   * int enemy[2] 	= {gold[0] + step + 1, 0};
   * int player[2] 	= {enemy[0] + step + 1, 0};   */

  private Type[][] map_block;
  
  //
  // Constructors
  //
  public Field () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Get the value of level
   * @return the value of level
   */
  public int getLevel () {
    return level;
  }

  /**
   * Set the value of step
   * @param newVar the new value of step
   */
  public void setStep (int newVar) {
    step = newVar;
  }

  /**
   * Get the value of step
   * @return the value of step
   */
  public int getStep () {
    return step;
  }

  /**
   * Set the value of playerX
   * @param newVar the new value of playerX
   */
  public void setPlayerX (int newVar) {
    playerX = newVar;
  }

  /**
   * Get the value of playerX
   * @return the value of playerX
   */
  public int getPlayerX () {
    return playerX;
  }

  /**
   * Set the value of playerY
   * @param newVar the new value of playerY
   */
  public void setPlayerY (int newVar) {
    playerY = newVar;
  }

  /**
   * Get the value of playerY
   * @return the value of playerY
   */
  public int getPlayerY () {
    return playerY;
  }

  /**
   * Set the value of goldRemain
   * @param newVar the new value of goldRemain
   */
  public void setGoldRemain (int newVar) {
    goldRemain = newVar;
  }

  /**
   * Get the value of goldRemain
   * @return the value of goldRemain
   */
  public int getGoldRemain () {
    return goldRemain;
  }

  /**
   * Set the value of xEnemy
   * @param newVar the new value of xEnemy
   */
  public void setXEnemy (ArrayList<int> newVar) {
    xEnemy = newVar;
  }

  /**
   * Get the value of xEnemy
   * @return the value of xEnemy
   */
  public ArrayList<int> getXEnemy () {
    return xEnemy;
  }

  /**
   * Set the value of yEnemy
   * @param newVar the new value of yEnemy
   */
  public void setYEnemy (ArrayList <int> newVar) {
    yEnemy = newVar;
  }

  /**
   * Get the value of yEnemy
   * @return the value of yEnemy
   */
  public ArrayList <int> getYEnemy () {
    return yEnemy;
  }

  /**
   * Set the value of brickTextCoord
   * blocks coordinates
   * @param newVar the new value of brickTextCoord
   */
  private void setBrickTextCoord (int[2] newVar) {
    brickTextCoord = newVar;
  }

  /**
   * Get the value of brickTextCoord
   * blocks coordinates
   * @return the value of brickTextCoord
   */
  private int[2] getBrickTextCoord () {
    return brickTextCoord;
  }

  /**
   * Set the value of concreteTextCoord
   * @param newVar the new value of concreteTextCoord
   */
  private void setConcreteTextCoord (int[2] newVar) {
    concreteTextCoord = newVar;
  }

  /**
   * Get the value of concreteTextCoord
   * @return the value of concreteTextCoord
   */
  private int[2] getConcreteTextCoord () {
    return concreteTextCoord;
  }

  /**
   * Set the value of ladderTextCoord
   * @param newVar the new value of ladderTextCoord
   */
  private void setLadderTextCoord (int[2] newVar) {
    ladderTextCoord = newVar;
  }

  /**
   * Get the value of ladderTextCoord
   * @return the value of ladderTextCoord
   */
  private int[2] getLadderTextCoord () {
    return ladderTextCoord;
  }

  /**
   * Set the value of poleTextCoord
   * @param newVar the new value of poleTextCoord
   */
  private void setPoleTextCoord (int[2] newVar) {
    poleTextCoord = newVar;
  }

  /**
   * Get the value of poleTextCoord
   * @return the value of poleTextCoord
   */
  private int[2] getPoleTextCoord () {
    return poleTextCoord;
  }

  /**
   * Set the value of goldTextCoord
   * @param newVar the new value of goldTextCoord
   */
  private void setGoldTextCoord (int[2] newVar) {
    goldTextCoord = newVar;
  }

  /**
   * Get the value of goldTextCoord
   * @return the value of goldTextCoord
   */
  private int[2] getGoldTextCoord () {
    return goldTextCoord;
  }

  /**
   * Set the value of enemyTextCoord
   * @param newVar the new value of enemyTextCoord
   */
  private void setEnemyTextCoord (int[2] newVar) {
    enemyTextCoord = newVar;
  }

  /**
   * Get the value of enemyTextCoord
   * @return the value of enemyTextCoord
   */
  private int[2] getEnemyTextCoord () {
    return enemyTextCoord;
  }

  /**
   * Set the value of playerTextCoord
   * @param newVar the new value of playerTextCoord
   */
  private void setPlayerTextCoord (int[2] newVar) {
    playerTextCoord = newVar;
  }

  /**
   * Get the value of playerTextCoord
   * @return the value of playerTextCoord
   */
  private int[2] getPlayerTextCoord () {
    return playerTextCoord;
  }

  /**
   * Set the value of map_block
   * int brick[2] 	= { 0,  0};
   * int concrete[2] = {16, 0};
   * int ladder[2] 	= {32 , 0};
   * int pole[2]		= {ladder[0] + step, 0};
   * int gold[2]		= {96, 0};
   * int enemy[2] 	= {gold[0] + step + 1, 0};
   * int player[2] 	= {enemy[0] + step + 1, 0};
   * @param newVar the new value of map_block
   */
  private void setMap_block (Type[][] newVar) {
    map_block = newVar;
  }

  /**
   * Get the value of map_block
   * int brick[2] 	= { 0,  0};
   * int concrete[2] = {16, 0};
   * int ladder[2] 	= {32 , 0};
   * int pole[2]		= {ladder[0] + step, 0};
   * int gold[2]		= {96, 0};
   * int enemy[2] 	= {gold[0] + step + 1, 0};
   * int player[2] 	= {enemy[0] + step + 1, 0};
   * @return the value of map_block
   */
  private Type[][] getMap_block () {
    return map_block;
  }

  //
  // Other methods
  //

  /**
   */
  public void Field()
  {
  }


  /**
   * @param        type
   * @param        x
   * @param        y
   */
  public void setBlock(Type type, float x, float y)
  {
  }


  /**
   * @return       Type
   * @param        x
   * @param        y
   */
  public Type getBlock(float x, float y)
  {
  }


}
