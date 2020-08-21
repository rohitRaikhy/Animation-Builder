package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;


/**
 * The MyRectangle class extends the AbstractViewShape and implements IViewShape. MyRectangle has an
 * x position, y position, width, height, and color.
 */
public class MyRectangle extends AbstractViewShape implements IViewShape {

  /**
   * Constructs a MyRectangle object and initializes it with the given x position, y position,
   * width, height, and color.
   *
   * @param x      the x position for the rectangle
   * @param y      the y position for the rectangle
   * @param width  the width of the rectangle
   * @param height the height of the rectangle
   * @param color  the color of the rectangle
   */
  public MyRectangle(int x, int y, int width, int height, Color color) {
    super(x, y, width, height, color);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x, y, width, height);

  }
}
