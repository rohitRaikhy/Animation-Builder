package cs5004.animator.model;

import java.util.Collection;

/**
 * This is the interface the animations model. It supports adding a shape, changing the width of a
 * shape, changing the height of a shape, changing the scale of a shape and changing the color of a
 * shape. The animations are presented in a readable format in the model to see how the animations
 * play out.
 */

public interface IAnimator {

  /**
   * Moves a shape on the canvas.
   *
   * @param xPos      the x position of the shape.
   * @param yPos      the y position of the shape.
   * @param toXPos    the x position to be moved to.
   * @param toYPos    the y position to be moved to.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   * @throws IllegalArgumentException if the arguments are invalid.
   */
  void moveShape(double xPos, double yPos, double toXPos, double toYPos, int startTime,
                 int endTime) throws IllegalArgumentException;

  /**
   * Changes the width of a shape.
   *
   * @param posX      the x position of the shape.
   * @param posY      the y position of the shape.
   * @param newWidth  the new width.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   * @throws IllegalArgumentException if the arguments are invalid.
   */
  void changeWidth(double posX, double posY, double newWidth, int startTime, int endTime)
          throws IllegalArgumentException;

  /**
   * Changes the height of a shape.
   *
   * @param posX      the x position of the shape.
   * @param posY      the y position of the shape.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   * @param height    the height to be changed to.
   * @throws IllegalArgumentException if the arguments are invalid.
   */
  void changeHeight(double posX, double posY, int startTime, int endTime, double height)
          throws IllegalArgumentException;

  /**
   * Scales a shape by height and width.
   *
   * @param toHeight  the height to be changed to.
   * @param toWidth   the width to be changed to.
   * @param xPos      the x position of the shape.
   * @param yPos      the y position of the shape.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   * @throws IllegalArgumentException if the arguments are invalid.
   */
  void scaleShape(double toHeight, double toWidth,
                  double xPos, double yPos,
                  int startTime, int endTime) throws IllegalArgumentException;

  /**
   * Changes the color of a shape.
   *
   * @param xPos      the x position of the shape.
   * @param yPos      the y position of the shape.
   * @param red       the rgb red color to be changed.
   * @param green     the rgb green color to be changed.
   * @param blue      the rgb blue color to be changed.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   */
  void changeColor(double xPos, double yPos, double red, double green, double blue,
                   int startTime, int endTime) throws IllegalArgumentException;

  /**
   * Output of the animation that shows how the animation is played in a readable format.
   *
   * @return a string representation of how the animation is played in a readable format.
   */
  String toString();


  /**
   * Adds a shape to the animation canvas.
   *
   * @param shape        the shape to be added.
   * @param xPos         the x position of the shape.
   * @param yPos         the y position of the shape.
   * @param appearsAt    when the shape appears.
   * @param disappearsAt when the shape disappears.
   */
  void addShape(IShape shape, double xPos, double yPos, int appearsAt, int disappearsAt)
          throws IllegalArgumentException;

  /**
   * Get shape names on the canvas.
   *
   * @return Collection names of objects. need to test. WILL REMOVE AT END.
   */
  Collection<IShape> getNames();

  /**
   * Gets a shape from the animation canvas.
   *
   * @param xPos the x position of the shape.
   * @param yPos the y position of the shape.
   * @return the shape at the given x position and y position on the canvas.
   */
  IShape getShape(double xPos, double yPos) throws IllegalArgumentException;
}
