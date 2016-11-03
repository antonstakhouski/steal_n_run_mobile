package view;

import java.util.*;
import model.GameModel;


/**
 * Class MyGLRenderer
 */
public class MyGLRenderer extends Renderer, Renderer, Renderer, Renderer {

  //
  // Fields
  //

  static private String TAG;
  private float[] mMVPMatrix;
  private float[] mProjectionMatrix;
  private float[] mViewMatrix;
  private float[] mRotationMatrix;
  private GameModel gameModel;
  private TextureCreator textureCreator;
  
  //
  // Constructors
  //
  public MyGLRenderer () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Get the value of TAG
   * @return the value of TAG
   */
  private String getTAG () {
    return TAG;
  }

  /**
   * Set the value of mMVPMatrix
   * @param newVar the new value of mMVPMatrix
   */
  private void setMMVPMatrix (float[] newVar) {
    mMVPMatrix = newVar;
  }

  /**
   * Get the value of mMVPMatrix
   * @return the value of mMVPMatrix
   */
  private float[] getMMVPMatrix () {
    return mMVPMatrix;
  }

  /**
   * Set the value of mProjectionMatrix
   * @param newVar the new value of mProjectionMatrix
   */
  private void setMProjectionMatrix (float[] newVar) {
    mProjectionMatrix = newVar;
  }

  /**
   * Get the value of mProjectionMatrix
   * @return the value of mProjectionMatrix
   */
  private float[] getMProjectionMatrix () {
    return mProjectionMatrix;
  }

  /**
   * Set the value of mViewMatrix
   * @param newVar the new value of mViewMatrix
   */
  private void setMViewMatrix (float[] newVar) {
    mViewMatrix = newVar;
  }

  /**
   * Get the value of mViewMatrix
   * @return the value of mViewMatrix
   */
  private float[] getMViewMatrix () {
    return mViewMatrix;
  }

  /**
   * Set the value of mRotationMatrix
   * @param newVar the new value of mRotationMatrix
   */
  private void setMRotationMatrix (float[] newVar) {
    mRotationMatrix = newVar;
  }

  /**
   * Get the value of mRotationMatrix
   * @return the value of mRotationMatrix
   */
  private float[] getMRotationMatrix () {
    return mRotationMatrix;
  }

  /**
   * Set the value of gameModel
   * @param newVar the new value of gameModel
   */
  private void setGameModel (GameModel newVar) {
    gameModel = newVar;
  }

  /**
   * Get the value of gameModel
   * @return the value of gameModel
   */
  private GameModel getGameModel () {
    return gameModel;
  }

  /**
   * Set the value of textureCreator
   * @param newVar the new value of textureCreator
   */
  private void setTextureCreator (TextureCreator newVar) {
    textureCreator = newVar;
  }

  /**
   * Get the value of textureCreator
   * @return the value of textureCreator
   */
  private TextureCreator getTextureCreator () {
    return textureCreator;
  }

  //
  // Other methods
  //

  /**
   * @param        unused
   * @param        config
   */
  public void onSurfaceCreated(GL10 unused, EGLConfig config)
  {
  }


  /**
   * @param        unused
   */
  public void onDrawFrame(GL10 unused)
  {
  }


  /**
   * @param        unused
   * @param        width
   * @param        height
   */
  public void onSurfaceChanged(GL10 unused, int width, int height)
  {
  }


  /**
   * @return       int
   * @param        type
   * @param        shaderCode
   */
  public static int loadShader(int type, String shaderCode)
  {
  }


  /**
   * @param        glOperation
   */
  public static void checkGlError(String glOperation)
  {
  }


}
