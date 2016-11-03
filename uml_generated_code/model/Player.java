package model;
import model.Player.Action;


/**
 * Class Player
 */
public class Player extends Creature {

  //
  // Fields
  //

  private model.digData trap;
  private Action action_;
  private int trapIterator;
  
  //
  // Constructors
  //
  public Player () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of trap
   * @param newVar the new value of trap
   */
  private void setTrap (model.digData newVar) {
    trap = newVar;
  }

  /**
   * Get the value of trap
   * @return the value of trap
   */
  private model.digData getTrap () {
    return trap;
  }

  /**
   * Set the value of action_
   * @param newVar the new value of action_
   */
  private void setAction_ (Action newVar) {
    action_ = newVar;
  }

  /**
   * Get the value of action_
   * @return the value of action_
   */
  private Action getAction_ () {
    return action_;
  }

  /**
   * Set the value of trapIterator
   * @param newVar the new value of trapIterator
   */
  private void setTrapIterator (int newVar) {
    trapIterator = newVar;
  }

  /**
   * Get the value of trapIterator
   * @return the value of trapIterator
   */
  private int getTrapIterator () {
    return trapIterator;
  }

  //
  // Other methods
  //

  /**
   */
  public void _Player()
  {
  }


  /**
   * @param        field
   */
  public void Player(Field& field)
  {
  }


  /**
   */
  public void deleteTrap()
  {
  }


  /**
   * @return       boolean
   * @param
   * @param        new_object
   */
  public boolean tick(Field& , ArrayList< Enemy >& new_object)
  {
  }


  /**
   * @param
   */
  public void keyEvent(model.Player.Action )
  {
  }


  /**
   * @param        field
   */
  public void setTrap(Field& field)
  {
  }


  /**
   * @return       boolean
   * @param
   * @param
   */
  public boolean checkTraps(Field& , std::vector< Enemy >& )
  {
  }


}
