package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs5004.animator.controller.Controller;

/**
 * The JFrame View class extends JFrame and implements the IViewShape interface. The JFrame View has
 * an x position, y position, width, and height.
 */
public class JFrameView extends JFrame implements IViewShape {
  // Initialize instance variables
  private DrawingPanel panel;
  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * Constructs a JFrame View object and initializes it to the given x position, y position, width,
   * and height.
   *
   * @param x      the x position you would like to pass
   * @param y      the y position you would like to pass
   * @param width  the width you would like to pass
   * @param height the height you would like to pass
   */
  public JFrameView(int x, int y, int width, int height) {
    super();
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    display();
  }

  @Override
  public void display() {
    // set the screen settings
    setSize(1000, 1000);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // initialize a drawing panel and scroll plane
    panel = new DrawingPanel(this.x, this.y, this.width, this.height);
    JScrollPane scrollPane = new JScrollPane(panel);


    // add the scroll and make display visible
    add(scrollPane);
    setVisible(true);
  }

  @Override
  public void draw(Graphics g) {
    // NEEDED TO IMPLEMENT IVIEWSHAPE BUT DIDN'T NEED THE METHOD
  }

  @Override
  public void drawRectangle(int x, int y, int w, int h, Color color) {
    panel.drawShape(new MyRectangle(x, y, w, h, color));
  }

  @Override
  public void drawOval(int x, int y, int w, int h, Color color) {
    panel.drawShape(new MyOval(x, y, w, h, color));
  }

  @Override
  public void refreshCanvas() {
    panel.repaint();
  }

}
