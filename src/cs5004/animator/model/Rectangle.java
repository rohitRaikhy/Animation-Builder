package cs5004.animator.model;

/**
 * This class represents a Rectangle. It has all of the operations mandated by the IShape interface
 * and extends the Abstract Shape implementation.
 */
public class Rectangle extends AbstractShape {

  /**
   * Constructs a Rectangle object with a name, x position, y position, width, height, and color.
   *
   * @param name   the name of the shape
   * @param xPos   the x position of the shape
   * @param yPos   the y position of the shape
   * @param width  the width of the shape
   * @param height the height of the shape
   * @param color  the color of the shape
   * @throws IllegalArgumentException if the name of the shape is null or empty
   */
  public Rectangle(String name, double xPos, double yPos,
                   double width, double height, String color) throws IllegalArgumentException {
    super(name, xPos, yPos, width, height, color);

  }

  @Override
  public String getType() {
    return "Rectangle";
  }
}
