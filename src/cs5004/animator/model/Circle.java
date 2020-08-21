package cs5004.animator.model;

/**
 * This class represents a Circle. It has all of the operations mandated by the IShape interface and
 * extends the Abstract Shape implementation.
 */
public class Circle extends AbstractShape {

  /**
   * Constructs a Circle object with a name, x position, y position, width, height, and color.
   *
   * @param name   the name of the shape
   * @param xPos   the x position of the shape
   * @param yPos   the y position of the shape
   * @param width  the width of the shape
   * @param height the height of the shape
   * @param color  the color of the shape
   * @throws IllegalArgumentException if the name of the shape is null/empty or if the width and
   *                                  height are not equal
   */
  public Circle(String name, double xPos, double yPos,
                double width, double height, String color) throws IllegalArgumentException {
    super(name, xPos, yPos, width, height, color);

    if (width != height) {
      throw new IllegalArgumentException("Your width and height should be the same in a circle");
    }

  }

  @Override
  public String getType() {
    return "Circle";
  }
}
