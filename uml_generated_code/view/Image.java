package view;

import java.util.*;


/**
 * Class Image
 * Image type - contains height, width, and data
 */
public class Image {

  //
  // Fields
  //

  public int sizeX;
  public int sizeY;
  public byte data;
  
  //
  // Constructors
  //
  public Image () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of sizeX
   * @param newVar the new value of sizeX
   */
  public void setSizeX (int newVar) {
    sizeX = newVar;
  }

  /**
   * Get the value of sizeX
   * @return the value of sizeX
   */
  public int getSizeX () {
    return sizeX;
  }

  /**
   * Set the value of sizeY
   * @param newVar the new value of sizeY
   */
  public void setSizeY (int newVar) {
    sizeY = newVar;
  }

  /**
   * Get the value of sizeY
   * @return the value of sizeY
   */
  public int getSizeY () {
    return sizeY;
  }

  /**
   * Set the value of data
   * @param newVar the new value of data
   */
  public void setData (byte newVar) {
    data = newVar;
  }

  /**
   * Get the value of data
   * @return the value of data
   */
  public byte getData () {
    return data;
  }

  //
  // Other methods
  //

}
