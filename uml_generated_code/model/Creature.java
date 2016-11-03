package model;


/**
 * Class Creature
 */
abstract public class Creature {

  //
  // Fields
  //

  private int x;
  private int y;
  private boolean updateFlag;
  private int oldX;
  private int oldY;
  private int testX;
  private int testY;
  private Type oldBlockType;
  private Type testBlockType;
  
  //
  // Constructors
  //
  public Creature () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of x
   * @param newVar the new value of x
   */
  private void setX (int newVar) {
    x = newVar;
  }

  /**
   * Get the value of x
   * @return the value of x
   */
  private int getX () {
    return x;
  }

  /**
   * Set the value of y
   * @param newVar the new value of y
   */
  private void setY (int newVar) {
    y = newVar;
  }

  /**
   * Get the value of y
   * @return the value of y
   */
  private int getY () {
    return y;
  }

  /**
   * Set the value of updateFlag
   * @param newVar the new value of updateFlag
   */
  private void setUpdateFlag (boolean newVar) {
    updateFlag = newVar;
  }

  /**
   * Get the value of updateFlag
   * @return the value of updateFlag
   */
  private boolean getUpdateFlag () {
    return updateFlag;
  }

  /**
   * Set the value of oldX
   * @param newVar the new value of oldX
   */
  private void setOldX (int newVar) {
    oldX = newVar;
  }

  /**
   * Get the value of oldX
   * @return the value of oldX
   */
  private int getOldX () {
    return oldX;
  }

  /**
   * Set the value of oldY
   * @param newVar the new value of oldY
   */
  private void setOldY (int newVar) {
    oldY = newVar;
  }

  /**
   * Get the value of oldY
   * @return the value of oldY
   */
  private int getOldY () {
    return oldY;
  }

  /**
   * Set the value of testX
   * @param newVar the new value of testX
   */
  private void setTestX (int newVar) {
    testX = newVar;
  }

  /**
   * Get the value of testX
   * @return the value of testX
   */
  private int getTestX () {
    return testX;
  }

  /**
   * Set the value of testY
   * @param newVar the new value of testY
   */
  private void setTestY (int newVar) {
    testY = newVar;
  }

  /**
   * Get the value of testY
   * @return the value of testY
   */
  private int getTestY () {
    return testY;
  }

  /**
   * Set the value of oldBlockType
   * @param newVar the new value of oldBlockType
   */
  private void setOldBlockType (Type newVar) {
    oldBlockType = newVar;
  }

  /**
   * Get the value of oldBlockType
   * @return the value of oldBlockType
   */
  private Type getOldBlockType () {
    return oldBlockType;
  }

  /**
   * Set the value of testBlockType
   * @param newVar the new value of testBlockType
   */
  private void setTestBlockType (Type newVar) {
    testBlockType = newVar;
  }

  /**
   * Get the value of testBlockType
   * @return the value of testBlockType
   */
  private Type getTestBlockType () {
    return testBlockType;
  }

  //
  // Other methods
  //

  /**
   */
  public void Creature()
  {
  }


  /**
   */
  abstract public void _Creature();


  /**
   * @return       boolean
   * @param
   * @param
   */
  public boolean testMovement(Field& , Type )
  {
  }


  /**
   * @return       boolean
   * @param
   * @param
   */
  public boolean fallTest(Field& , Type )
  {
  }


  /**
   * @param
   * @param
   */
  public void updateBlocks(Field& , Type )
  {
  }


  /**
   * @return       boolean
   * @param
   */
  public boolean jumpTest(Field& )
  {
  }


  /**
   * getters
   * @return       int
   */
  public int getX()
  {
  }


  /**
   * @return       int
   */
  public int getY()
  {
  }


  /**
   * @return       boolean
   */
  public boolean getUpdateFlag()
  {
  }


  /**
   * @return       int
   */
  public int getOldX()
  {
  }


  /**
   * @return       int
   */
  public int getOldY()
  {
  }


  /**
   * @return       int
   */
  public int getTestX()
  {
  }


  /**
   * @return       int
   */
  public int getTestY()
  {
  }


  /**
   * @return       Type
   */
  public Type getOldBlockType()
  {
  }


  /**
   * @return       Type
   */
  public Type getTestBlockType()
  {
  }


  /**
   * setters
   * @param
   */
  public void setX(int )
  {
  }


  /**
   * @param
   */
  public void setY(int )
  {
  }


  /**
   * @param
   */
  public void setUpdateFlag(boolean )
  {
  }


  /**
   * @param
   */
  public void setOldX(int )
  {
  }


  /**
   * @param
   */
  public void setOldY(int )
  {
  }


  /**
   * @param
   */
  public void setTestX(int )
  {
  }


  /**
   * @param
   */
  public void setTestY(int )
  {
  }


  /**
   * @param
   */
  public void setOldBlockType(Type )
  {
  }


  /**
   * @param
   */
  public void setTestBlockType(Type )
  {
  }


}
