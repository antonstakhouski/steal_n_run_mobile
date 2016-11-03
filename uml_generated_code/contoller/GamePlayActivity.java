package contoller;

import java.util.*;


/**
 * Class GamePlayActivity
 */
public class GamePlayActivity {

  //
  // Fields
  //

  private GLSurfaceView mGLView;
  
  //
  // Constructors
  //
  public GamePlayActivity () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of mGLView
   * @param newVar the new value of mGLView
   */
  private void setMGLView (GLSurfaceView newVar) {
    mGLView = newVar;
  }

  /**
   * Get the value of mGLView
   * @return the value of mGLView
   */
  private GLSurfaceView getMGLView () {
    return mGLView;
  }

  //
  // Other methods
  //

  /**
   * @param        view
   */
  public void Pause(View view)
  {
  }


  /**
   * @param        savedInstanceState
   */
  protected void onCreate(Bundle savedInstanceState)
  {
  }


}
