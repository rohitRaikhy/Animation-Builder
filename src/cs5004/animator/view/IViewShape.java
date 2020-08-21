package cs5004.animator.view;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * This is the interface for the IViewShape. It extends the IView interface and includes methods
 * needed to draw shapes on the canvas.
 */
public interface IViewShape extends IView {
  /**
   * Draws animation graphics on the screen.
   *
   * @param g the graphics object you would like to manipulate.
   */
  void draw(Graphics g);

  /**
   * Draws a rectangle on the panel.
   *
   * @param x     the x position of the rectangle
   * @param y     the y position of the rectangle
   * @param w     the width of the rectangle
   * @param h     the height of the rectangle
   * @param color the color of the rectangle
   */
  void drawRectangle(int x, int y, int w, int h, Color color);

  /**
   * Draws an oval on the panel.
   *
   * @param x     the x position of the oval
   * @param y     the y position of the oval
   * @param w     the width of the oval
   * @param h     the height of the oval
   * @param color the color of the rectangle
   */
  void drawOval(int x, int y, int w, int h, Color color);

  /**
   * Refreshes the panel.
   */
  void refreshCanvas();

}
