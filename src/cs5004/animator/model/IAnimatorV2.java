package cs5004.animator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * This interface represents a re-do for our model. It supports specifications for an animation
 * including adding/getting a shape, getting the names of the shapes, adding transformations, and
 * getting frames for the shapes.
 */
public interface IAnimatorV2 {

  /**
   * Adds a shape to the animation canvas.
   *
   * @param shape        the shape to be added.
   * @param xPos         the x position of the shape.
   * @param yPos         the y position of the shape.
   * @param appearsAt    when the shape appears.
   * @param disappearsAt when the shape disappears.
   */
  void addShape(IShape shape, double xPos, double yPos, int appearsAt, int disappearsAt,
                String shapeName)
          throws IllegalArgumentException;

  /**
   * Get shape names on the canvas.
   *
   * @return set of names of objects.
   */
  Set<String> getNames();


  /**
   * Gets a shape from the animation canvas.
   *
   * @param name the name of the shape you want to retrieve
   * @return the shape object
   * @throws IllegalArgumentException if the shape is not in the canvas.
   */
  IShape getShape(String name) throws IllegalArgumentException;

  /**
   * Adds the move transformation.
   *
   * @param name   the name of the shape you want to move
   * @param sFrame the start frame of the move
   * @param eFrame the end frame of the move
   * @param x1     the from x position
   * @param y1     the from y position
   * @param x2     the to x position
   * @param y2     the to y position
   */
  void addTransformMove(String name, int sFrame, int eFrame, int x1, int y1, int x2, int y2);

  /**
   * Adds the change color transformation.
   *
   * @param name   the name of the shape you want to change the color of
   * @param r1     the initial r value
   * @param b1     the initial b value
   * @param g1     the initial g value
   * @param r2     the changed r value
   * @param b2     the changed b value
   * @param g2     the changed g value
   * @param sFrame the start frame of the transformation
   * @param eFrame the end frame of the transformation
   */
  void addTransformColor(String name, int r1, int b1, int g1, int r2,
                         int b2, int g2, int sFrame, int eFrame);

  /**
   * Adds the change scale transformation.
   *
   * @param name    the name of the shape you want to change the scale of
   * @param width1  the initial width
   * @param height1 the initial height
   * @param width2  the changed width
   * @param height2 the changed height
   * @param sFrame  the start frame of the transformation
   * @param eFrame  the end frame of the transformation
   */
  void addTransformScale(String name, int width1, int height1, int width2, int height2,
                         int sFrame, int eFrame);

  /**
   * Gets the last frame of the animation.
   *
   * @return the last frame
   */
  int getLastFrame();

  /**
   * Returns the list of shapes at the given frame.
   *
   * @param frame the frame you want to get the shapes for
   * @return the list of shapes at the frame
   */
  ArrayList<IShape> getShapesAtFrame(int frame);

  /**
   * Adds no transformation to the shape.
   *
   * @param name    the name of the shape
   * @param x1      the initial x position of the shape
   * @param x2      the same x position of the shape
   * @param y1      the initial y position of the shape
   * @param y2      the same y position of the shape
   * @param width1  the initial width of the shape
   * @param width2  the same width of the shape
   * @param height1 the initial height of the shape
   * @param height2 the same height of the shape
   * @param r1      the initial r value of the shape
   * @param r2      the same r value of the shape
   * @param b1      the initial b value of the shape
   * @param b2      the same b value of the shape
   * @param g1      the initial g value of the shape
   * @param g2      the same g value of the shape
   * @param sFrame  the start frame
   * @param eFrame  the end frame
   */
  void addNoTransform(String name, int x1, int x2, int y1, int y2, int width1, int width2,
                      int height1, int height2, int r1, int r2, int b1,
                      int b2, int g1, int g2, int sFrame, int eFrame);


  /**
   * Returns all the initialized shapes.
   *
   * @return the list of initialized shapes
   */
  ArrayList<IShape> getAllInitShapes();

  /**
   * Returns all the start and end times of the shapes.
   *
   * @return HashMap with the nape of the shape and its start and end times
   */
  HashMap<String, ArrayList<Integer>> getAllStartEndTimes();

  /**
   * Returns all the transformations on the canvas.
   *
   * @return list of transformations that took place
   */
  ArrayList<ITransform> getAllTransformations();
}
