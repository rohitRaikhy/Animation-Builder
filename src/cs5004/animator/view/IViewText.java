package cs5004.animator.view;

/**
 * This is the interface for the IViewText. It extends the IView interface and includes methods
 * needed to write text view.
 */
public interface IViewText extends IView {

  /**
   * Adds the shape information to the textView builder.
   *
   * @param name         the name of the shape
   * @param type         the type of the shape
   * @param xPos         the x position of the shape
   * @param yPos         the y position of the shape
   * @param width        the width of the shape
   * @param height       the height of the shape
   * @param color        the color of the shape
   * @param appearsAt    the time the shape appears
   * @param disappearsAt the time the shape disappears
   */
  void addTextShapeBuilder(String name, String type, int xPos, int yPos,
                           int width, int height, String color, int appearsAt,
                           int disappearsAt);

  /**
   * Adds the motion text to the textView builder.
   *
   * @param name          the name of the shape
   * @param typeAnimation the type of animation
   * @param x1            the from x position
   * @param y1            the from y position
   * @param x2            the to x position
   * @param y2            the to y position
   * @param sFrame        the start frame
   * @param eFrame        the end frame
   */
  void addMoveText(String name, String typeAnimation, int x1, int y1, int x2, int y2, int sFrame,
                   int eFrame);

  /**
   * Adds the color text to the textView builder.
   *
   * @param name          the name of the shape
   * @param typeAnimation the type of animation
   * @param r1            the from r value
   * @param g1            the from g value
   * @param b1            the from b value
   * @param r2            the to r value
   * @param g2            the to g value
   * @param b2            the to b value
   * @param sFrame        the start frame
   * @param eFrame        the end frame
   */
  void addColorText(String name, String typeAnimation, int r1, int g1, int b1, int r2,
                    int g2, int b2, int sFrame, int eFrame);

  /**
   * Adds the scale text to the textView builder.
   *
   * @param name          the name of the shape
   * @param typeAnimation the type of the animation
   * @param width1        the from width
   * @param height1       the from height
   * @param width2        the to width
   * @param height2       the to height
   * @param sFrame        the start frame
   * @param eFrame        the end frame
   */
  void addScaleText(String name, String typeAnimation, int width1, int height1,
                    int width2, int height2, int sFrame, int eFrame);

}



