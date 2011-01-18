/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.opencv.jni;

/** Wrapper for the OpenCV Size object. Good for setting dimensions of cv::Mat...
*/
public class Size {
  private long swigCPtr;
  protected boolean swigCMemOwn;
  public Size(long cPtr, boolean cMemoryOwn) {
	swigCMemOwn = cMemoryOwn;
	swigCPtr = cPtr;
  }
  public static long getCPtr(Size obj) {
	return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opencvJNI.delete_Size(swigCPtr);
    }
    swigCPtr = 0;
  }

  public Size(int width, int height) {
    this(opencvJNI.new_Size(width, height), true);
  }

  public void setWidth(int value) {
    opencvJNI.Size_width_set(swigCPtr, this, value);
  }

  public int getWidth() {
    return opencvJNI.Size_width_get(swigCPtr, this);
  }

  public void setHeight(int value) {
    opencvJNI.Size_height_set(swigCPtr, this, value);
  }

  public int getHeight() {
    return opencvJNI.Size_height_get(swigCPtr, this);
  }

}