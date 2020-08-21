package cs5004.animator.view;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The TextView class implements the IViewTextView interface. Each TextView objects has a
 * StringBuilder that holds the text view.
 */
public class TextView implements IViewText {
  // Initialize the instance variables
  private Appendable s;

  /**
   * Constructs a TextView object and initializes a new StringBuilder object.
   */
  public TextView() {
    s = new StringBuilder();
  }

  /**
   * Constructs a TextView object and initializes new Appendable object.
   */
  public TextView(Appendable a) {
    s = a;
  }

  @Override
  public void display() {
    if (s instanceof FileWriter) {
      try {
        ((FileWriter) s).close();
      } catch (IOException e) {
        System.out.println("An error occurred.");
      }
    }

  }


  @Override
  public void addTextShapeBuilder(String name, String type, int xPos, int yPos,
                                  int width, int height, String color, int appearsAt,
                                  int disappearsAt) {
    try {
      s.append("Name: " + name + "\n" + "Type: "
              + type + "\n" + "Min corner: (" + xPos + "," + yPos + "), Width: "
              + width
              + ", Height: " + height + ", Color: " + color
              + "\nAppears at t=" + appearsAt + "\nDisappears at t=" + disappearsAt + "\n\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
  }

  @Override
  public void addMoveText(String name, String typeAnimation, int x1, int y1, int x2, int y2,
                          int sFrame, int eFrame) {
    try {
      s.append("Shape " + name + " moves from (" + x1
              + "," + y1 + ") to (" + x2 + "," + y2 + ") from t=" + sFrame
              + " to t=" + eFrame + "\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
  }

  @Override
  public void addColorText(String name, String typeAnimation, int r1, int g1, int b1, int r2,
                           int g2, int b2, int sFrame, int eFrame) {
    try {
      s.append("Shape " + name + " changes color from "
              + "(" + r1 + "," + g1 + "," + b1 + ")" + " to " + "("
              + r2 + "," + g2 + "," + b2 + ")" + " from t="
              + sFrame + " to=" + eFrame + "\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }

  }

  @Override
  public void addScaleText(String name, String typeAnimation, int width1, int height1,
                           int width2, int height2, int sFrame, int eFrame) {
    try {
      s.append("Shape " + name + " scales from Width: " + width1
              + ", Height: " + height1 + " to Width: " + width2 + ", Height: " + height2
              + " from t=" + sFrame + " to t=" + eFrame + "\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
  }

}
