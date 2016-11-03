package model;


/**
 * Class digData
 */
public class digData {

  //
  // Fields
  //

  public int timeRemain;
  public int x;
  public int y;
  public Type oldBlockType;
  
  //
  // Constructors
  //
  public digData () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of timeRemain
   * @param newVar the new value of timeRemain
   */
  public void setTimeRemain (int newVar) {
    timeRemain = newVar;
  }

  /**
   * Get the value of timeRemain
   * @return the value of timeRemain
   */
  public int getTimeRemain () {
    return timeRemain;
  }

  /**
   * Set the value of x
   * @param newVar the new value of x
   */
  public void setX (int newVar) {
    x = newVar;
  }

  /**
   * Get the value of x
   * @return the value of x
   */
  public int getX () {
    return x;
  }

  /**
   * Set the value of y
   * @param newVar the new value of y
   */
  public void setY (int newVar) {
    y = newVar;
  }

  /**
   * Get the value of y
   * @return the value of y
   */
  public int getY () {
    return y;
  }

  /**
   * Set the value of oldBlockType
   * @param newVar the new value of oldBlockType
   */
  public void setOldBlockType (Type newVar) {
    oldBlockType = newVar;
  }

  /**
   * Get the value of oldBlockType
   * @return the value of oldBlockType
   */
  public Type getOldBlockType () {
    return oldBlockType;
  }

  //
  // Other methods
  //

}
