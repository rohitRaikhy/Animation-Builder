package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

/**
 * The Abstract View Shape class implements the IViewShape interface. The Abstract View Shape has an
 * x position, y position, width, height, and color.
 */
public class AbstractViewShape implements IViewShape {
  // Initialize final variables
  protected final int x;
  protected final int y;
  protected final int width;
  protected final int height;
  protected final Color color;

  /**
   * Constructs an Abstract View Shape object and initializes it with an x position, y position,
   * width, height, and color.
   *
   * @param x      the x position of the shape
   * @param y      the y position of the shape
   * @param width  the width of the shape
   * @param height the height of the shape
   * @param color  the color of the shape
   */
  public AbstractViewShape(int x, int y, int width, int height, Color color) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.color = color;
  }

  @Override
  public void draw(Graphics g) {
    // NEEDED TO OVERRIDE TO ABSTRACT X, Y, WIDTH, HEIGHT, COLOR
  }

  @Override
  public void drawRectangle(int x, int y, int w, int h, Color color) {
    // NEEDED TO OVERRIDE TO ABSTRACT X, Y, WIDTH, HEIGHT, COLOR
  }

  @Override
  public void drawOval(int x, int y, int w, int h, Color color) {
    // NEEDED TO OVERRIDE TO ABSTRACT X, Y, WIDTH, HEIGHT, COLOR
  }

  @Override
  public void refreshCanvas() {
    // NEEDED TO OVERRIDE TO ABSTRACT X, Y, WIDTH, HEIGHT, COLOR
  }

  @Override
  public void display() {
    // NEEDED TO OVERRIDE TO ABSTRACT X, Y, WIDTH, HEIGHT, COLOR
  }
}
