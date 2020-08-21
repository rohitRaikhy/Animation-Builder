package cs5004.animator.model;

/**
 * The Abstract Shape class implements the IShape interface. Each Abstract Shape has a name, x and y
 * position, width, height, color (red, green, blue) values respectfully.
 */
public class AbstractShape implements IShape {
  protected String shapeName;
  protected double xPos;
  protected double yPos;
  protected double width;
  protected double height;
  protected String color;
  protected double red;
  protected double green;
  protected double blue;

  /**
   * Constructs an Abstract Shape object and initializes it to the given name, x position, y
   * position, width, height, and color.
   *
   * @param name   the name of the abstract shape
   * @param xPos   the x position of the abstract shape
   * @param yPos   the y position of the abstract shape
   * @param width  the width of the abstract shape
   * @param height the height of the abstract shape
   * @param color  the color of the abstract shape
   * @throws IllegalArgumentException if the name of the shape is null or empty
   */
  public AbstractShape(String name, double xPos, double yPos,
                       double width, double height, String color) throws IllegalArgumentException {

    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("You cannot have a null or empty name");
    } else {
      this.shapeName = name;
    }

    if (xPos >= 0 && xPos <= 2500) {
      this.xPos = xPos;
    } else {
      throw new IllegalArgumentException("Your x position cannot be less than 0 or greater than"
              + " 2500");
    }

    if (yPos >= 0 && yPos <= 2500) {
      this.yPos = yPos;
    } else {
      throw new IllegalArgumentException("Your y position cannot be less than 0 or greater than"
              + " 2500");
    }

    if (width >= 0 && width <= 500) {
      this.width = width;
    } else {
      throw new IllegalArgumentException("You must have a positive width");
    }

    if (height >= 0 && height <= 500) {
      this.height = height;
    } else {
      throw new IllegalArgumentException("You must have a positive height");
    }

    boolean validShape = false;
    for (ShapeColors c : ShapeColors.values()) {
      if (c.toString().equalsIgnoreCase(color)) {
        validShape = true;
      }
    }

    if (validShape) {
      this.color = color;
      setRGB(this.color);
    } else {
      throw new IllegalArgumentException("You have inputted an invalid color");
    }
  }

  private void setRGB(String color) {
    if (color.equalsIgnoreCase("white")) {
      this.red = 1;
      this.green = 1;
      this.blue = 1;
    }

    if (color.equalsIgnoreCase("black")) {
      this.red = 0;
      this.green = 0;
      this.blue = 0;
    }

    if (color.equalsIgnoreCase("red")) {
      this.red = 1;
      this.green = 0;
      this.blue = 0;
    }

    if (color.equalsIgnoreCase("green")) {
      this.red = 0;
      this.green = 1;
      this.blue = 0;
    }

    if (color.equalsIgnoreCase("blue")) {
      this.red = 0;
      this.green = 0;
      this.blue = 1;
    }

    if (color.equalsIgnoreCase("yellow")) {
      this.red = 1;
      this.green = 1;
      this.blue = 0;
    }

    if (color.equalsIgnoreCase("purple")) {
      this.red = 1;
      this.green = 0;
      this.blue = 1;
    }
  }

  @Override
  public double getX() {
    return this.xPos;
  }

  @Override
  public double getY() {
    return yPos;
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public String getColor() {
    String color = "(" + this.red + "," + this.green + "," + this.blue + ")";
    return color;
  }

  @Override
  public String getPosition() {
    String pos = "(" + this.xPos + "," + this.yPos + ")";
    return pos;
  }

  @Override
  public String getType() {
    return null;
  }

  @Override
  public String getName() {
    return shapeName;
  }

  @Override
  public void setX(double x) throws IllegalArgumentException {
    this.xPos = x;
  }

  @Override
  public void setY(double y) throws IllegalArgumentException {
    this.yPos = y;
  }

  @Override
  public void setWidth(double width) throws IllegalArgumentException {
    this.width = width;
  }

  @Override
  public void setHeight(double height) throws IllegalArgumentException {
    this.height = height;
  }

  @Override
  public void changeColor(double red, double green, double blue) throws IllegalArgumentException {
    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Your red value must be between 0 and 1.");
    }

    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Your green value must be between 0 and 1.");
    }

    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Your blue value must be between 0 and 1.");
    }

    this.red = red;
    this.green = green;
    this.blue = blue;

  }

}
