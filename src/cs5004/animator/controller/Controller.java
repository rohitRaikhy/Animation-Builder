package cs5004.animator.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Timer;

import cs5004.animator.model.IAnimatorV2;
import cs5004.animator.view.IViewShape;
import cs5004.animator.view.IViewText;
import cs5004.animator.model.IShape;
import cs5004.animator.model.ITransform;

/**
 * The Controller class implements the IController interface. Each Controller object has a model and
 * view.
 */
public class Controller implements IController {
  // Initialize Variables
  private IAnimatorV2 model;
  private IViewShape view;
  private Timer timer;

  /**
   * Constructs a Controller object and initializes it to the given model and view.
   *
   * @param model      the model you would like to pass to the Controller
   * @param jFrameView the JFrame jFrameView you would like to pass to the Controller
   */
  public Controller(IAnimatorV2 model, IViewShape jFrameView) {
    this.model = model;
    this.view = jFrameView;
    this.timer = new Timer(400, runAnimation());
  }

  /**
   * Constructs a Controller object and initializes it to the given model, view, and speed.
   *
   * @param model      the model you would like to pass to the Controller
   * @param jFrameView the JFrame view you would like to pass to the Controller
   * @param speed      the speed you would like to pass to the Controller
   */
  public Controller(IAnimatorV2 model, IViewShape jFrameView, int speed) {
    this.model = model;
    this.view = jFrameView;

    int delay = 1000 / speed;

    this.timer = new Timer(delay, runAnimation());
  }

  /**
   * Constructs a Controller object and initializes it to the given model and view.
   *
   * @param model    the model you would like to pass to the Controller
   * @param textView the textView you would like to pass to the Controller
   */
  public Controller(IAnimatorV2 model, IViewText textView) {
    this.model = model;
    IViewText text = textView;

    // Initialize HashMap for Start/End Times
    HashMap<String, ArrayList<Integer>> startEndTimes = model.getAllStartEndTimes();
    // Initialize ArrayList of Shapes
    ArrayList<IShape> shapesInit = model.getAllInitShapes();

    for (IShape inits : shapesInit) {
      // Get the Characteristics for Each Shape
      String name = inits.getName();
      String type = inits.getType();
      int x = (int) inits.getX();
      int y = (int) inits.getY();
      int width = (int) inits.getWidth();
      int height = (int) inits.getHeight();
      String color = inits.getColor();

      // Get the Frames
      ArrayList<Integer> frames = startEndTimes.get(name);
      int sFrame = frames.get(0);
      int eFrame = frames.get(1);

      // Add to the TextView
      textView.addTextShapeBuilder(name, type, x, y, width, height, color, sFrame, eFrame);
    }

    for (ITransform transforms : model.getAllTransformations()) {
      String transformType = transforms.getTransformType();
      switch (transformType) {
        case "move":
          String nameM = transforms.getShape().getName();
          int x1 = transforms.getX1T();
          int x2 = transforms.getX2T();
          int y1 = transforms.getY1T();
          int y2 = transforms.getY2T();
          int sFrameM = transforms.getSFrame();
          int eFrameM = transforms.getEFrame();
          textView.addMoveText(nameM, transformType, x1, y1, x2, y2, sFrameM, eFrameM);
          break;
        case "color":
          String nameC = transforms.getShape().getName();
          int r1 = transforms.getR1T();
          int g1 = transforms.getG1T();
          int b1 = transforms.getB1Tr();
          int r2 = transforms.getR2T();
          int g2 = transforms.getG2T();
          int b2 = transforms.getB2Tr();
          int sFrameC = transforms.getSFrame();
          int eFrameC = transforms.getEFrame();
          textView.addColorText(nameC, transformType, r1, g1, b1, r2, g2, b2, sFrameC, eFrameC);
          break;
        case "scale":
          String nameS = transforms.getShape().getName();
          int w1 = transforms.getW1T();
          int h1 = transforms.getH1T();
          int w2 = transforms.getW2T();
          int h2 = transforms.getH2T();
          int sFrameS = transforms.getSFrame();
          int eFrameS = transforms.getEFrame();
          textView.addScaleText(nameS, transformType, w1, h1, w2, h2, sFrameS, eFrameS);
          break;

        default:
          // Do Nothing
          break;
      }
    }

    // Show the TextView
    text.display();
  }

  @Override
  public void animate() {
    /**
     * what if i put the play button action performed in here?
     * will need to delete this and make a new implementation for SOLID.
     */
    timer.start();
  }

  /**
   * Helper function to help draw the animations for each frame.
   *
   * @return ActionListener with the actionPerformed method overridden
   */
  private ActionListener runAnimation() {

    return new ActionListener() {
      // Initialize currentFrame

      int currentFrame = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
        // Stop timer when it gets to the model's last frame
        if (currentFrame == model.getLastFrame()) {
          timer.stop();
          return;
        }

        // Initialize list of Shapes to Render
        ArrayList<IShape> shapesToRender = model.getShapesAtFrame(currentFrame++);

        // For Each Shape being rendered
        for (IShape shape : shapesToRender) {
          // Get Shape Characteristics
          int x = (int) shape.getX();
          int y = (int) shape.getY();
          int width = (int) shape.getWidth();
          int height = (int) shape.getHeight();
          String color = shape.getColor();

          // Process the Color
          String[] rgb = color.split(",");
          float r = Float.parseFloat(rgb[0].substring(1)) / 255;
          float g = Float.parseFloat(rgb[1]) / 255;
          float b = Float.parseFloat(rgb[2].substring(0, rgb[2].length() - 1)) / 255;
          String type = shape.getType();


          if (type.equalsIgnoreCase("Oval")) {
            view.drawOval(x, y, width, height, new Color(r, g, b));
          }

          if (type.equalsIgnoreCase("Rectangle")) {
            view.drawRectangle(x, y, width, height, new Color(r, g, b));
          }

        }

        // Refresh Canvas
        view.refreshCanvas();
      }
    };

  }

}
