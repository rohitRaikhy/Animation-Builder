package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * This class contains all functionality for creating an animation with the shapes provided in the
 * program. It supports adding a shape, changing the width of a shape, changing the height of a
 * shape, changing the scale of a shape and changing the color of a shape. The animations are
 * presented in a readable format in the model to see how the animations play out. The data
 * structures used to store the shapes that will be presented in a GUI format in later assignments
 * will be placed in a hash map. Other data structures used this model also include a hash map for
 * keeping track of animations and the creation of shapes.
 */

public class AnimatorImpl implements IAnimator {

  protected HashMap<CanvasKey, IShape> canvas;
  protected HashMap<IShape, ArrayList<Integer>> animationMap;
  protected StringBuilder shapeBuilder;
  protected StringBuilder animationBuilder;
  protected StringBuilder output;
  protected HashMap<IShape, ArrayList<Integer>> appearsAtDisappearsAt;

  /**
   * Constructor for AnimatorImpl.
   */
  public AnimatorImpl() {
    canvas = new HashMap<>();
    animationMap = new HashMap<>();
    appearsAtDisappearsAt = new HashMap<>();
    shapeBuilder = new StringBuilder();
    animationBuilder = new StringBuilder();
    output = new StringBuilder();
  }

  /**
   * Checks to see if an animation overlaps.
   *
   * @param xPos      the x position of the shape.
   * @param yPos      the y position of the shape.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   * @return boolean if there is an overlap in times or not between animations.
   */
  private boolean overlapAnimation(double xPos, double yPos, int startTime, int endTime) {
    IShape movedShape = canvas.get(new CanvasKey(xPos, yPos));
    return ((startTime >= animationMap.get(movedShape).get(0)
            && startTime <= animationMap.get(movedShape).get(1))
            || (animationMap.get(movedShape).get(0) >= startTime
            && animationMap.get(movedShape).get(0) <= endTime));
  }

  /**
   * This is a helper method to add animations into a list. List is used to add to the animation
   * hashmap.
   *
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   * @return ArrayList of start and end time.
   */
  private ArrayList addAnimation(int startTime, int endTime) {
    ArrayList<Integer> animationTimes = new ArrayList<>();
    animationTimes.add(startTime);
    animationTimes.add(endTime);
    return animationTimes;
  }

  /**
   * Adds to the animator String.
   *
   * @param movedShape the shape that is moved.
   * @param xPos       the x position of the shape.
   * @param yPos       the y position of the shape.
   * @param toXPos     the x position to be moved to.
   * @param toYPos     the y position to be moved to.
   * @param startTime  the start time of animation.
   * @param endTime    the end time of the animation.
   */
  private void addToAnimatorMove(IShape movedShape, double xPos, double yPos, double toXPos,
                                 double toYPos, int startTime, int endTime) {
    animationBuilder.append("Shape " + movedShape.getName() + " moves from (" + xPos
            + "," + yPos + ") to (" + toXPos + "," + toYPos + ") from t=" + startTime
            + " to t=" + endTime + "\n");
  }

  /**
   * Check for illegal start and end time in relation to the time shape appears and disappears.
   *
   * @param shape     the shape of the animation.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   * @return boolean if there is an invalid animation.
   */
  private boolean illegalAnimationStartAndEndTimes(IShape shape, int startTime, int endTime) {
    int shapeAppearsAt = appearsAtDisappearsAt.get(shape).get(0);
    int shapeDisappearsAt = appearsAtDisappearsAt.get(shape).get(1);
    return (startTime < shapeAppearsAt || startTime > shapeDisappearsAt || endTime < shapeAppearsAt
            || endTime > shapeDisappearsAt);
  }

  @Override
  public void moveShape(double xPos, double yPos, double toXPos, double toYPos,
                        int startTime, int endTime)
          throws IllegalArgumentException {
    if (startTime < 0 || endTime < 0 || toXPos < 0 || toYPos < 0 || startTime > endTime) {
      throw new IllegalArgumentException("arguments cannot be less than 0 or start time cannot"
              + "be less than end time.");
    }
    if (canvas.containsKey(new CanvasKey(xPos, yPos))) {
      IShape movedShape = canvas.get(new CanvasKey(xPos, yPos));
      if (illegalAnimationStartAndEndTimes(movedShape, startTime, endTime)) {
        throw new IllegalArgumentException("The animation cannot start or end when the shape has "
                + "either not yet disappeared or appeared.");
      }
      if (animationMap.containsKey(movedShape)) {
        if (overlapAnimation(xPos, yPos, startTime, endTime)) {
          throw new IllegalArgumentException("Cannot animate shape that is in the same time "
                  + "interval.");
        }
      }
      canvas.remove(new CanvasKey(xPos, yPos));
      movedShape.setX(toXPos);
      movedShape.setY(toYPos);
      canvas.put(new CanvasKey(movedShape.getX(), movedShape.getY()), movedShape);
      ArrayList animationTimes = addAnimation(startTime, endTime);
      animationMap.put(movedShape, animationTimes);
      addToAnimatorMove(movedShape, xPos, yPos, toXPos, toYPos, startTime, endTime);
    } else {
      throw new IllegalArgumentException("No shape at the given position.");
    }
  }

  /**
   * Adds to the animation builder for move animation.
   *
   * @param shape     the shape to be changed.
   * @param newWidth  the new width of the shape.
   * @param oldWidth  the old width of the shape.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   */
  private void addToAnimatorWidth(IShape shape, double newWidth, double oldWidth,
                                  int startTime, int endTime) {
    animationBuilder.append("Shape " + shape.getName() + " changes width from " + oldWidth + " to "
            + newWidth + " from time t=" + startTime + " to t=" + endTime + "\n");
  }


  @Override
  public void changeWidth(double posX, double posY, double newWidth, int startTime, int endTime)
          throws IllegalArgumentException {
    if (startTime < 0 || endTime < 0 || startTime > endTime || newWidth < 0) {
      throw new IllegalArgumentException("arguments cannot be less than 0 or "
              + "start time cannot be less than end time.");
    }
    if (canvas.containsKey(new CanvasKey(posX, posY))) {
      IShape scaledShape = canvas.get(new CanvasKey(posX, posY));
      if (illegalAnimationStartAndEndTimes(scaledShape, startTime, endTime)) {
        throw new IllegalArgumentException("The animation cannot start or end when the shape has "
                + "either not yet disappeared or appeared.");
      }
      if (animationMap.containsKey(scaledShape)) {
        if (overlapAnimation(posX, posY, startTime, endTime)) {
          throw new IllegalArgumentException("Cannot animate shape that is in the same time "
                  + "interval.");
        }
      }
      double oldWidth = scaledShape.getWidth();
      canvas.remove(new CanvasKey(posX, posY));
      scaledShape.setWidth(newWidth);
      canvas.put(new CanvasKey(posX, posY), scaledShape);
      ArrayList animationTimes = addAnimation(startTime, endTime);
      animationMap.put(scaledShape, animationTimes);
      addToAnimatorWidth(scaledShape, newWidth, oldWidth, startTime, endTime);
    } else {
      throw new IllegalArgumentException("No shape at the given position.");
    }
  }

  /**
   * Adds to the animation string builder for the change height animation.
   *
   * @param shape     the shape to be changed.
   * @param height    the height that will be changed to.
   * @param oldHeight the old height.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   */
  private void addToAnimatorHeight(IShape shape, double height, double oldHeight,
                                   int startTime, int endTime) {
    animationBuilder.append("Shape " + shape.getName() + " changes height from " + oldHeight
            + " to " + height + " from time t=" + startTime + " to t=" + endTime + "\n");
  }


  @Override
  public void changeHeight(double posX, double posY, int startTime, int endTime, double height)
          throws IllegalArgumentException {
    if (startTime < 0 || endTime < 0 || posX < 0 || posY < 0 || height < 0 || startTime > endTime) {
      throw new IllegalArgumentException("arguments cannot be less than 0 or start time "
              + "cannot be less than end time.");
    }
    if (!(canvas.containsKey(new CanvasKey(posX, posY)))) {
      throw new IllegalArgumentException("Shape is not at this position.");
    }
    if (canvas.containsKey(new CanvasKey(posX, posY))) {
      IShape shapeHeightAlter = canvas.get(new CanvasKey(posX, posY));
      if (illegalAnimationStartAndEndTimes(shapeHeightAlter, startTime, endTime)) {
        throw new IllegalArgumentException("The animation cannot start or end when the shape has "
                + "either not yet disappeared or appeared.");
      }
      if (animationMap.containsKey(shapeHeightAlter)) {
        if (overlapAnimation(posX, posY, startTime, endTime)) {
          throw new IllegalArgumentException("Cannot animate shape that is in the same time "
                  + "interval.");
        }
      }
      double oldHeight = shapeHeightAlter.getHeight();
      canvas.remove(new CanvasKey(posX, posY));
      shapeHeightAlter.setHeight(height);
      canvas.put(new CanvasKey(posX, posY), shapeHeightAlter);
      ArrayList animationTimes = addAnimation(startTime, endTime);
      animationMap.put(shapeHeightAlter, animationTimes);
      addToAnimatorHeight(shapeHeightAlter, height, oldHeight, startTime, endTime);
    }
  }

  /**
   * Add to the animator builder for scale.
   *
   * @param shape     the shape to be scaled.
   * @param toHeight  the ne height.
   * @param toWidth   the new width.
   * @param startTime the start time.
   * @param endTime   the end time.
   */
  private void addToAnimatorScale(IShape shape, double toHeight, double toWidth,
                                  int startTime, int endTime) {
    animationBuilder.append("Shape " + shape.getName() + " scales from Width: " + shape.getWidth()
            + ", Height: " + shape.getHeight() + " to Width: " + toWidth + ", Height: " + toHeight
            + " from t=" + startTime + " to t=" + endTime + "\n");
  }

  @Override
  public void scaleShape(double toHeight, double toWidth, double xPos, double yPos,
                         int startTime, int endTime) throws IllegalArgumentException {
    if (startTime < 0 || endTime < 0 || toHeight < 0 || toWidth < 0 || startTime > endTime) {
      throw new IllegalArgumentException("arguments cannot be less than 0 or start time "
              + "cannot be less than end time.");
    }
    if (!(canvas.containsKey(new CanvasKey(xPos, yPos)))) {
      throw new IllegalArgumentException("The shape is not at this position.");
    }
    if (canvas.containsKey(new CanvasKey(xPos, yPos))) {
      IShape scaledShape = canvas.get(new CanvasKey(xPos, yPos));
      if (illegalAnimationStartAndEndTimes(scaledShape, startTime, endTime)) {
        throw new IllegalArgumentException("The animation cannot start or end when the shape has "
                + "either not yet disappeared or appeared.");
      }
      if (animationMap.containsKey(scaledShape)) {
        if (overlapAnimation(xPos, yPos, startTime, endTime)) {
          throw new IllegalArgumentException("Cannot animate shape that is in the same time "
                  + "interval.");
        }
      }
      canvas.remove(new CanvasKey(xPos, yPos));
      addToAnimatorScale(scaledShape, toHeight, toWidth, startTime, endTime);
      scaledShape.setHeight(toHeight);
      scaledShape.setWidth(toWidth);
      canvas.put(new CanvasKey(xPos, yPos), scaledShape);
      ArrayList animationTimes = addAnimation(startTime, endTime);
      animationMap.put(scaledShape, animationTimes);
    }
  }

  /**
   * Add to the animator builder for change color animation.
   *
   * @param shape     the shape to be changed.
   * @param red       the rgb of color red.
   * @param green     the rgb of color green.
   * @param blue      the rgb of color blue.
   * @param startTime the start time of the animation.
   * @param endTime   the end time of the animation.
   */
  private void addToAnimationColor(IShape shape, double red, double green, double blue,
                                   int startTime, int endTime) {
    animationBuilder.append("Shape " + shape.getName() + " changes color from "
            + shape.getColor() + " to " + "(" + red + "," + green + "," + blue + ")" + " from t="
            + startTime + " to=" + endTime + "\n");
  }

  @Override
  public void changeColor(double xPos, double yPos, double red, double green,
                          double blue, int startTime, int endTime) throws IllegalArgumentException {
    if (startTime < 0 || endTime < 0 || startTime > endTime) {
      throw new IllegalArgumentException("arguments cannot be less than 0.");
    }
    if (!(canvas.containsKey(new CanvasKey(xPos, yPos)))) {
      throw new IllegalArgumentException("The shape is not at this position.");
    }
    if (canvas.containsKey(new CanvasKey(xPos, yPos))) {
      IShape colorShape = canvas.get(new CanvasKey(xPos, yPos));
      if (illegalAnimationStartAndEndTimes(colorShape, startTime, endTime)) {
        throw new IllegalArgumentException("The animation cannot start or end when the shape has "
                + "either not yet disappeared or appeared.");
      }
      if (animationMap.containsKey(colorShape)) {
        if (overlapAnimation(xPos, yPos, startTime, endTime)) {
          throw new IllegalArgumentException("Cannot animate shape that is in the same time "
                  + "interval.");
        }
      }
      canvas.remove(new CanvasKey(xPos, yPos));
      addToAnimationColor(colorShape, red, green, blue, startTime, endTime);
      colorShape.changeColor(red, green, blue);
      canvas.put(new CanvasKey(xPos, yPos), colorShape);
      ArrayList animationTimes = addAnimation(startTime, endTime);
      animationMap.put(colorShape, animationTimes);
    }
  }

  /**
   * Helper method for add shapes string builder.
   *
   * @param shape        the shape to be added.
   * @param xPos         the x position of the shape.
   * @param yPos         the y position of the shape.
   * @param appearsAt    when the shape appears on the canvas.
   * @param disappearsAt when the shape disappears on the canvas.
   */
  private void addToShapeString(IShape shape, double xPos, double yPos, int appearsAt,
                                int disappearsAt) {

    if (canvas.size() == 1) {
      shapeBuilder.append("Shapes:" + "\n" + "Name: " + shape.getName() + "\n" + "Type: "
              + shape.getType() + "\n" + "Min corner: (" + xPos + "," + yPos + "), Width: "
              + shape.getWidth()
              + ", Height: " + shape.getHeight() + ", Color: " + shape.getColor()
              + "\nAppears at t=" + appearsAt + "\nDisappears at t=" + disappearsAt);
    } else {
      shapeBuilder.append("\n\n" + "Name: " + shape.getName() + "\n" + "Type: "
              + shape.getType() + "\n" + "Min corner: (" + xPos + "," + yPos + "), Width: "
              + shape.getWidth()
              + ", Height: " + shape.getHeight() + ", Color: " + shape.getColor()
              + "\nAppears at t=" + appearsAt + "\nDisappears at t=" + disappearsAt);
    }
  }

  private ArrayList addToAppearsAtHashMap(int appearsAt, int disappearsAt) {
    ArrayList<Integer> appearsAndDisappears = new ArrayList<>();
    appearsAndDisappears.add(appearsAt);
    appearsAndDisappears.add(disappearsAt);
    return appearsAndDisappears;
  }

  @Override
  public void addShape(IShape shape, double xPos, double yPos, int appearsAt, int disappearsAt) {
    if (canvas.containsKey(new CanvasKey(xPos, yPos))) {
      throw new IllegalArgumentException("Shape is already in the canvas.");
    }
    if (xPos < 0 || yPos < 0 || appearsAt < 0 || disappearsAt < 0 || appearsAt > disappearsAt) {
      throw new IllegalArgumentException("arguments cannot be less than 0.");
    } else {
      canvas.put(new CanvasKey(xPos, yPos), shape);
      ArrayList appearsAndDisappears = addToAppearsAtHashMap(appearsAt, disappearsAt);
      appearsAtDisappearsAt.put(shape, appearsAndDisappears);
    }
    addToShapeString(shape, xPos, yPos, appearsAt, disappearsAt);
  }


  @Override
  public Collection<IShape> getNames() {
    return canvas.values();
  }

  @Override
  public IShape getShape(double xPos, double yPos) {
    if (canvas.containsKey(new CanvasKey(xPos, yPos))) {
      return canvas.get(new CanvasKey(xPos, yPos));
    } else {
      throw new IllegalArgumentException("Shape not in the canvas.");
    }
  }

  @Override
  public String toString() {
    if (canvas.size() == 0) {
      return "There are no shapes on the canvas.";
    } else {
      return shapeBuilder.toString() + "\n\n"
              + animationBuilder.substring(0, animationBuilder.lastIndexOf("\n"));
    }
  }
}
