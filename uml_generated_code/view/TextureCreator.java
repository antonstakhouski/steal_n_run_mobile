package view;

import java.util.*;


/**
 * Class TextureCreator
 */
public class TextureCreator {

  //
  // Fields
  //

  /**
   * storage for one texture  
   */
  private GLuint[] texture;
  private String texPath;
  private int bitmapHeader;
  private int bitmapVersion;
  private int height;
  private int compression;
  private int pixelDataOffset;
  private int sizeImage;
  private int bpp;
  
  //
  // Constructors
  //
  public TextureCreator () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of texture
   * storage for one texture
   * @param newVar the new value of texture
   */
  private void setTexture (GLuint[] newVar) {
    texture = newVar;
  }

  /**
   * Get the value of texture
   * storage for one texture
   * @return the value of texture
   */
  private GLuint[] getTexture () {
    return texture;
  }

  /**
   * Set the value of texPath
   * @param newVar the new value of texPath
   */
  private void setTexPath (String newVar) {
    texPath = newVar;
  }

  /**
   * Get the value of texPath
   * @return the value of texPath
   */
  private String getTexPath () {
    return texPath;
  }

  /**
   * Set the value of bitmapHeader
   * @param newVar the new value of bitmapHeader
   */
  private void setBitmapHeader (int newVar) {
    bitmapHeader = newVar;
  }

  /**
   * Get the value of bitmapHeader
   * @return the value of bitmapHeader
   */
  private int getBitmapHeader () {
    return bitmapHeader;
  }

  /**
   * Set the value of bitmapVersion
   * @param newVar the new value of bitmapVersion
   */
  private void setBitmapVersion (int newVar) {
    bitmapVersion = newVar;
  }

  /**
   * Get the value of bitmapVersion
   * @return the value of bitmapVersion
   */
  private int getBitmapVersion () {
    return bitmapVersion;
  }

  /**
   * Set the value of height
   * @param newVar the new value of height
   */
  private void setHeight (int newVar) {
    height = newVar;
  }

  /**
   * Get the value of height
   * @return the value of height
   */
  private int getHeight () {
    return height;
  }

  /**
   * Set the value of compression
   * @param newVar the new value of compression
   */
  private void setCompression (int newVar) {
    compression = newVar;
  }

  /**
   * Get the value of compression
   * @return the value of compression
   */
  private int getCompression () {
    return compression;
  }

  /**
   * Set the value of pixelDataOffset
   * @param newVar the new value of pixelDataOffset
   */
  private void setPixelDataOffset (int newVar) {
    pixelDataOffset = newVar;
  }

  /**
   * Get the value of pixelDataOffset
   * @return the value of pixelDataOffset
   */
  private int getPixelDataOffset () {
    return pixelDataOffset;
  }

  /**
   * Set the value of sizeImage
   * @param newVar the new value of sizeImage
   */
  private void setSizeImage (int newVar) {
    sizeImage = newVar;
  }

  /**
   * Get the value of sizeImage
   * @return the value of sizeImage
   */
  private int getSizeImage () {
    return sizeImage;
  }

  /**
   * Set the value of bpp
   * @param newVar the new value of bpp
   */
  private void setBpp (int newVar) {
    bpp = newVar;
  }

  /**
   * Get the value of bpp
   * @return the value of bpp
   */
  private int getBpp () {
    return bpp;
  }

  //
  // Other methods
  //

  /**
   */
  public void Painter()
  {
  }


  /**
   */
  public void loadGLTextures()
  {
  }


  /**
   * @return       int
   * @param        filename
   * @param        image
   */
  public int imageLoad(String filename, Image image)
  {
  }


}
