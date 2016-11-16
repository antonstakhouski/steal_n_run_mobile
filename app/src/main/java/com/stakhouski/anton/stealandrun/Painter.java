/*
 * MIT License
 *
 * Copyright (c) 2016 Anton Stakhouski
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.stakhouski.anton.stealandrun;

import android.opengl.GLES31;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Created by archer on 10.11.16.
 */

class Painter {

    private final FloatBuffer vertexBuffer;
    private final ShortBuffer drawListBuffer;
    private final int mProgram;

    // number of coordinates per vertex in this array
    private static final int COORDS_PER_VERTEX = 3;
    private float[] squareCoords = new float[12];
    private final short[] drawOrder = {0, 1, 2, 0, 2, 3}; // order to draw vertices

    /**
     * Sets up the drawing object data for use in an OpenGL ES context.
     */
    Painter() {
        // initialize vertex byte buffer for shape coordinates
        ByteBuffer bb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 4 bytes per float)
                squareCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();

        // initialize byte buffer for the draw list
        ByteBuffer dlb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 2 bytes per short)
                drawOrder.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        drawListBuffer = dlb.asShortBuffer();
        drawListBuffer.put(drawOrder);
        drawListBuffer.position(0);

        // prepare shaders and OpenGL program
/*        String vertexShaderCode = "uniform mat4 uMVPMatrix;" +
                "attribute vec4 vPosition;" +
                "void main() {" +
                // The matrix must be included as a modifier of gl_Position.
                // Note that the uMVPMatrix factor *must be first* in order
                // for the matrix multiplication product to be correct.
                "  gl_Position = uMVPMatrix * vPosition;" +
                "}";*/
        String vertexShaderCode = "uniform mat4 u_MVPMatrix;" +
                "// A constant representing the combined model/view/projection matrix." +
                "uniform mat4 u_MVMatrix;" +
                "// A constant representing the combined model/view matrix." +
                "attribute vec4 a_Position;" +
                "// Per-vertex position information we will pass in." +
                "attribute vec4 a_Color;  " +
                "// Per-vertex color information we will pass in." +
                "attribute vec3 a_Normal; " +
                "// Per-vertex normal information we will pass in." +
                "varying vec3 v_Position;" +
                "// This will be passed into the fragment shader." +
                "varying vec4 v_Color;" +
                "// This will be passed into the fragment shader." +
                "varying vec3 v_Normal;" +
                " // This will be passed into the fragment shader." +
                "// The entry point for our vertex shader." +
                "void main(){" +
                "   // Transform the vertex into eye space." +
                "   v_Position = vec3(u_MVMatrix * a_Position);" +
                "   // Pass through the color." +
                "   v_Color = a_Color;" +
                "   // Transform the normal's orientation into eye space." +
                "   v_Normal = vec3(u_MVMatrix * vec4(a_Normal, 0.0));" +
                "   // gl_Position is a special variable used to store the final position." +
                "   // Multiply the vertex by the matrix to get " +
                "   //the final point in normalized screen coordinates." +
                "   gl_Position = u_MVPMatrix * a_Position;" +
                "}";

        int vertexShader = MyGLRenderer.loadShader(
                GLES31.GL_VERTEX_SHADER,
                vertexShaderCode);
        String fragmentShaderCode = "precision mediump float;" +
                "uniform vec4 vColor;" +
                "void main() {" +
                "  gl_FragColor = vColor;" +
                "}";

        int fragmentShader = MyGLRenderer.loadShader(
                GLES31.GL_FRAGMENT_SHADER,
                fragmentShaderCode);

        mProgram = GLES31.glCreateProgram();             // create empty OpenGL Program
        GLES31.glAttachShader(mProgram, vertexShader);   // add the vertex shader to program
        GLES31.glAttachShader(mProgram, fragmentShader); // add the fragment shader to program
        GLES31.glLinkProgram(mProgram);                  // create OpenGL program executables
    }

    /**
     * Encapsulates the OpenGL ES instructions for drawing this shape.
     *
     * @param mvpMatrix - The Model View Project matrix in which to draw this shape.
     */
    void draw(float[] mvpMatrix, float[] squareCoords_, float[] color_) {

        squareCoords = squareCoords_;

        vertexBuffer.clear();
        vertexBuffer.put(squareCoords);
        vertexBuffer.position(0);

        // Add program to OpenGL environment
        GLES31.glUseProgram(mProgram);

        // get handle to vertex shader's vPosition member
        int mPositionHandle = GLES31.glGetAttribLocation(mProgram, "vPosition");

        // Enable a handle to the triangle vertices
        GLES31.glEnableVertexAttribArray(mPositionHandle);

        // Prepare the triangle coordinate data
        int vertexStride = COORDS_PER_VERTEX * 4;
        GLES31.glVertexAttribPointer(
                mPositionHandle, COORDS_PER_VERTEX,
                GLES31.GL_FLOAT, false,
                vertexStride, vertexBuffer);

        // get handle to fragment shader's vColor member
        int mColorHandle = GLES31.glGetUniformLocation(mProgram, "vColor");

        // Set color for drawing the triangle
        GLES31.glUniform4fv(mColorHandle, 1, color_, 0);

        // get handle to shape's transformation matrix
        int mMVPMatrixHandle = GLES31.glGetUniformLocation(mProgram, "uMVPMatrix");
        MyGLRenderer.checkGlError("glGetUniformLocation");

        // Apply the projection and view transformation
        GLES31.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);
        MyGLRenderer.checkGlError("glUniformMatrix4fv");

        // Draw the square
        GLES31.glDrawElements(
                GLES31.GL_TRIANGLES, drawOrder.length,
                GLES31.GL_UNSIGNED_SHORT, drawListBuffer);

        // Disable vertex array
        GLES31.glDisableVertexAttribArray(mPositionHandle);
    }
}
