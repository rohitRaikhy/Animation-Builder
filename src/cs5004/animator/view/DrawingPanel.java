package cs5004.animator.view;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.util.List;

/**
 * The Drawing Panel class extends the JPanel. The Drawing Panel has an x position, y position,
 * width, and height.
 */
public class DrawingPanel extends JPanel {
  // Initialize Instance Variables
  private List<IViewShape> shapes;
  private Color color;

  /**
   * Constructs a Drawing Panel object and initializes it to the given x, y, width, and height.
   *
   * @param x      the x position you would like to pass
   * @param y      the y position you would like to pass
   * @param width  the width you wlike to pass
   * @param height the height you would like to pass
   */
  public DrawingPanel(int x, int y, int width, int height) {
    super();
    // Set preferred size of the screen and initialize shapes and color
    setPreferredSize(new Dimension(width, height));
    shapes = new ArrayList<>();
    color = Color.BLACK;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Draw each shape
    for (IViewShape shape : shapes) {
      shape.draw(g);
    }

    shapes.clear();
  }

  /**
   * Helper function to set the color.
   *
   * @param color the color you would like to set
   */
  public void setColor(Color color) {
    this.color = color;
  }

  /**
   * Helper function to draw the shape.
   *
   * @param shape the shape you would like to draw
   */
  public void drawShape(IViewShape shape) {
    shapes.add(shape);
  }


}
