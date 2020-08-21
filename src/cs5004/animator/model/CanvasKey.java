package cs5004.animator.model;

import java.util.Objects;

/**
 * this is a wrapper class for the hashtable canvas. Allows two identifiers within the hashtable
 * canvas.
 */
public class CanvasKey {

  private final double x;
  private final double y;

  /**
   * Constructor for the canvas key.
   *
   * @param x the x position of the shape.
   * @param y the y position of the shape.
   */
  public CanvasKey(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CanvasKey canvasKey = (CanvasKey) o;
    return Double.compare(canvasKey.x, x) == 0
            && Double.compare(canvasKey.y, y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
