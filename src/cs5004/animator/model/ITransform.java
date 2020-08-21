package cs5004.animator.model;

/**
 * This represents a Transformation interface. It represents all the methods needed for a
 * transformation.
 */
public interface ITransform {

  /**
   * Transforms at the current frame.
   *
   * @param currentFrame the frame you are interested in
   */
  void transform(int currentFrame);

  /**
   * Returns if current frame is valid.
   *
   * @param currentFrame the frame you're interested in
   * @return boolean if current frame is within the frame bounds
   */
  boolean isWithinFrame(int currentFrame);

  /**
   * Returns the start frame.
   *
   * @return the start frame
   */
  int getSFrame();

  /**
   * Returns the end frame.
   *
   * @return the end frame
   */
  int getEFrame();

  /**
   * Returns the shape.
   *
   * @return the shape being transformed
   */
  IShape getShape();

  /**
   * Returns the transformation type.
   *
   * @return the type of transformation
   */
  String getTransformType();

  /**
   * Returns the initial x value.
   *
   * @return the current x value
   */
  int getX1T();

  /**
   * Returns the changed x value.
   *
   * @return the new x value
   */
  int getX2T();

  /**
   * Returns the initial y value.
   *
   * @return the current y value
   */
  int getY1T();

  /**
   * Returns the changed y value.
   *
   * @return the new y value
   */
  int getY2T();

  /**
   * Returns the initial r value.
   *
   * @return the
   */
  int getR1T();

  /**
   * Returns the changed r value.
   *
   * @return the new r value
   */
  int getR2T();

  /**
   * Returns the initial b value.
   *
   * @return the current b value
   */
  int getB1Tr();

  /**
   * Returns the changed b value.
   *
   * @return the new b value
   */
  int getB2Tr();

  /**
   * Returns the initial g value.
   *
   * @return the current g value
   */
  int getG1T();

  /**
   * Returns the changed g value.
   *
   * @return the new g value
   */
  int getG2T();

  /**
   * Returns the initial width.
   *
   * @return the current width
   */
  int getW1T();

  /**
   * Returns the changed width.
   *
   * @return the new width
   */
  int getW2T();

  /**
   * Returns the initial height.
   *
   * @return the current height
   */
  int getH1T();

  /**
   * Returns the changed height.
   *
   * @return the new height
   */
  int getH2T();
}
