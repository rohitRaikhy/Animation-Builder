package cs5004.animator.NewController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import cs5004.animator.NewView.IViewShape2;
import cs5004.animator.controller.Controller;
import cs5004.animator.view.IViewText;
import cs5004.animator.view.TextView;
import cs5004.animator.model.IAnimatorV2;
import cs5004.animator.model.IShape;

/**
 * The Controller2 class implements the IController interface. Each Controller object has a model
 * and view.
 */

public class Controller2 extends Controller implements ActionListener {
  private ArrayList<String> shapesToRemove;
  private Timer timer2;
  private IAnimatorV2 model;
  private IViewShape2 view;
  private int currentFrame = 0;

  /**
   * Constructs a Controller2 object and initializes it to the given model and view.
   *
   * @param model      the model you would like to pass to the Controller.
   * @param jFrameView the JFrame jFrameView you would like to pass to the Controller.
   */
  public Controller2(IAnimatorV2 model, IViewShape2 jFrameView) {
    super(model, jFrameView);
    jFrameView.setListener(this);
    this.model = model;
    this.view = jFrameView;
    this.timer2 = new Timer(10, runAnimation());
    this.shapesToRemove = new ArrayList<String>();
  }

  /**
   * Constructs a Controller2 object and initializes it to the given model, view, and speed.
   *
   * @param model      the model you would like to pass to the Controller
   * @param jFrameView the JFrame view you would like to pass to the Controller
   * @param speed      the speed you would like to pass to the Controller
   */
  public Controller2(IAnimatorV2 model, IViewShape2 jFrameView, int speed) {
    super(model, jFrameView, speed);
    jFrameView.setListener(this);
    int delay = 1000 / speed;
    this.timer2 = new Timer(delay, runAnimation());
    this.model = model;
    this.view = jFrameView;
    this.shapesToRemove = new ArrayList<String>();
  }

  /**
   * Constructs a Controller2 object and initializes it to the given model and view.
   *
   * @param model    the model you would like to pass to the Controller
   * @param textView the textView you would like to pass to the Controller
   */
  public Controller2(IAnimatorV2 model, IViewText textView) {
    super(model, textView);
    this.model = model;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Check")) {
      shapesToRemove.add(view.getSelectedIndex());
    }

    switch (e.getActionCommand()) {
      case "start":
        timer2.start();
        break;
      case "stop":
        timer2.stop();
        break;
      case "play":
        currentFrame = 0;
        timer2.restart();
        //animate();
        timer2.start();
        break;
      case "save":
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int selection = fileChooser.showSaveDialog(this.view.getPanel());

        if (selection == JFileChooser.APPROVE_OPTION) {
          File fileToSave = fileChooser.getSelectedFile();
          Controller textView = null;
          try {
            textView = new Controller2(this.model,
                    new TextView(new FileWriter(fileToSave)));
          } catch (IOException ioException) {
            ioException.printStackTrace();
          }

          System.exit(0);
        }

    }
  }

  @Override
  public void animate() {
    ArrayList<IShape> shapesInit = model.getAllInitShapes();
    for (IShape shapes : shapesInit) {
      view.setList(shapes.getName());
    }
  }

  /**
   * Helper function to help draw the animations for each frame.
   *
   * @return ActionListener with the actionPerformed method overridden
   */
  private ActionListener runAnimation() {

    return new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (currentFrame == model.getLastFrame()) {
          timer2.stop();
          return;
        }

        ArrayList<IShape> shapesToRender = model.getShapesAtFrame(currentFrame++);

        int i;
        int size = shapesToRender.size();
        boolean bk = false;
        for (i = 0; i < size; i++) {
          for (String shapeToRemove : shapesToRemove) {
            if (shapesToRender.get(i).getName().equals(shapeToRemove)) {
              shapesToRender.remove(i);
              bk = true;
            }
          }

          if (bk) {
            break;
          }

        }

        for (IShape shape : shapesToRender) {
          int x = (int) shape.getX();
          int y = (int) shape.getY();
          int width = (int) shape.getWidth();
          int height = (int) shape.getHeight();
          String color = shape.getColor();

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

        view.refreshCanvas();
      }

    };
  }
}
