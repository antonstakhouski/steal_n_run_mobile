package model;

import java.util.*;
import model.Player.Action;


/**
 * Class GameModel
 */
public class GameModel {

  //
  // Fields
  //

  private Field field;
  private model.Player player;
  private ArrayList<Enemy> enemies;
  private Decoder decoder;
  
  //
  // Constructors
  //
  public GameModel () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of field
   * @param newVar the new value of field
   */
  private void setField (Field newVar) {
    field = newVar;
  }

  /**
   * Get the value of field
   * @return the value of field
   */
  private Field getField () {
    return field;
  }

  /**
   * Set the value of player
   * @param newVar the new value of player
   */
  private void setPlayer (model.Player newVar) {
    player = newVar;
  }

  /**
   * Get the value of player
   * @return the value of player
   */
  private model.Player getPlayer () {
    return player;
  }

  /**
   * Set the value of enemies
   * @param newVar the new value of enemies
   */
  private void setEnemies (ArrayList<Enemy> newVar) {
    enemies = newVar;
  }

  /**
   * Get the value of enemies
   * @return the value of enemies
   */
  private ArrayList<Enemy> getEnemies () {
    return enemies;
  }

  /**
   * Set the value of decoder
   * @param newVar the new value of decoder
   */
  private void setDecoder (Decoder newVar) {
    decoder = newVar;
  }

  /**
   * Get the value of decoder
   * @return the value of decoder
   */
  private Decoder getDecoder () {
    return decoder;
  }

  //
  // Other methods
  //

  /**
   */
  public void tick()
  {
  }


  /**
   */
  public void enemyTick()
  {
  }


  /**
   */
  public void Game()
  {
  }


  /**
   * @param
   */
  public void keyEvent(model.Player.Action )
  {
  }


}
