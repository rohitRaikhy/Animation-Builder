package cs5004.animator.model;

/**
 * This interface contains all operations that all types of shapes should support.
 */
public interface IShape {

  /**
   * Returns the x position of the shape.
   *
   * @return the shape's x position
   */
  double getX();

  /**
   * Returns the y position of the shape.
   *
   * @return the shape's y position
   */
  double getY();

  /**
   * Returns the width of the shape.
   *
   * @return the shape's width
   */
  double getWidth();

  /**
   * Returns the height of the shape.
   *
   * @return the shape's height
   */
  double getHeight();

  /**
   * Returns the color of the shape.
   *
   * @return the shape's color
   */
  String getColor();

  /**
   * Returns the current position of the shape.
   *
   * @return the shape's color
   */
  String getPosition();

  /**
   * Returns the type of the shape.
   *
   * @return the shape type
   */
  String getType();

  /**
   * Returns the name of the shape.
   *
   * @return the shape's name
   */
  String getName();


  /**
   * Sets the x position of the shape.
   *
   * @param x the x position you want to set the shape to
   */
  void setX(double x);

  /**
   * Sets the y position of the shape.
   *
   * @param y the y position you want to set the shape to
   */
  void setY(double y);


  /**
   * Sets the width of the shape.
   *
   * @param width the width you want to set the shape to
   */
  void setWidth(double width);


  /**
   * Sets the height of the shape.
   *
   * @param height the height you want to set the shape to
   */
  void setHeight(double height);

  /**
   * Changes the color of the shape.
   *
   * @param red   the red value of the RGB you want to change to
   * @param green the green value of the RGB you want to change to
   * @param blue  the blue value of the RGB you want to change to
   * @throws IllegalArgumentException if either the red, green, or blue parameters are less than
   *                                  zero or greater than one
   */
  void changeColor(double red, double green, double blue) throws IllegalArgumentException;


}
