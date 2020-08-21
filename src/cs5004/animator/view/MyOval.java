package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The MyOval class extends the AbstractViewShape and implements IViewShape. MyOval has an x
 * position, y position, width, height, and color.
 */
public class MyOval extends AbstractViewShape implements IViewShape {

  /**
   * Constructs a MyOval object and initializes it with the given x position, y position, width,
   * height, and color.
   *
   * @param x      the x position of the oval
   * @param y      the y position of the oval
   * @param width  the width of the oval
   * @param height the height of the oval
   * @param color  the color of the oval
   */
  public MyOval(int x, int y, int width, int height, Color color) {
    super(x, y, width, height, color);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillOval(x, y, width, height);
  }
}
