package contoller;

import java.util.*;
import view.MyGLRenderer;


/**
 * Class MyGLSurfaceView
 * 
 * Created by archer on 15.10.16.
 * 
 */
public class MyGLSurfaceView extends GLSurfaceView {

  //
  // Fields
  //

  private view.MyGLRenderer mRenderer;
  
  //
  // Constructors
  //
  public MyGLSurfaceView () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of mRenderer
   * @param newVar the new value of mRenderer
   */
  private void setMRenderer (view.MyGLRenderer newVar) {
    mRenderer = newVar;
  }

  /**
   * Get the value of mRenderer
   * @return the value of mRenderer
   */
  private view.MyGLRenderer getMRenderer () {
    return mRenderer;
  }

  //
  // Other methods
  //

  /**
   * @param        context
   */
  public void MyGLSurfaceView(Context context)
  {
  }


  /**
   * @return       boolean
   * @param        e
   */
  public boolean onTouchEvent(MotionEvent e)
  {
  }


}
