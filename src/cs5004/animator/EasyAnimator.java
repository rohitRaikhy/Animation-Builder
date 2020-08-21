package cs5004.animator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

import cs5004.animator.model.MyAnimatorBuilder;
import cs5004.animator.NewView.IViewShape2;
import cs5004.animator.controller.Controller;
import cs5004.animator.NewController.Controller2;
import cs5004.animator.view.IViewText;
import cs5004.animator.view.TextView;
import cs5004.animator.NewView.View2;
import cs5004.animator.model.AnimationBuilder;
import cs5004.animator.model.AnimationReader;
import cs5004.animator.model.AnimatorImplV2;
import cs5004.animator.model.IAnimatorV2;

/**
 * This class represents an Easy Animator class. The Easy Animator has a main method that serves as
 * a ModelViewController implementation of the assignment.
 */
public class EasyAnimator {
  /**
   * Runs the MVC implementation.
   *
   * @param args the command line arguments
   * @throws IOException if an invalid output is passed
   */
  public static void main(String[] args) throws IOException {
    String input = "";
    String view = "";
    String output = "";
    int speed = 1;

    int index = 0;

    for (String s : args) {
      Scanner scan = new Scanner(s);
      if (s.equals("-in")) {
        input = args[index + 1];
      }

      if (s.equals("-view")) {
        view = args[index + 1];
      }

      if (s.equals("-out")) {
        output = args[index + 1];
      }

      if (s.equals("-speed")) {
        speed = Integer.parseInt(args[index + 1]);
      }

      index++;
    }

    IAnimatorV2 model = new AnimatorImplV2();
    AnimationBuilder<IAnimatorV2> animatorBuilder = new MyAnimatorBuilder(model);
    AnimationReader reader = new AnimationReader();

    try {
      model = reader.parseFile(new FileReader(input), animatorBuilder);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(new JInternalFrame(),
              "Your input selection is invalid");
      return;
    }

    if (!view.equalsIgnoreCase("text")
            && !view.equalsIgnoreCase("visual")) {
      JOptionPane.showMessageDialog(new JInternalFrame(), "Your view selection is invalid");
      return;
    }

    Controller controller;

    if (view.equalsIgnoreCase("text")) {
      IViewText textView;
      if (output.isEmpty() || output.equalsIgnoreCase("out")) {
        textView = new TextView(System.out);
      } else {
        textView = new TextView(new FileWriter(output));
      }
      controller = new Controller2(model, textView);

    } else {
      IViewShape2 jView = new View2(0, 0, 1000, 1000);

      if (speed == 1) {
        controller = new Controller2(model, jView);
      } else {
        controller = new Controller2(model, jView, speed);
      }
      controller.animate();

    }
  }
}
