package cs5004.animator;

import java.io.FileReader;
import java.io.IOException;

import cs5004.animator.model.MyAnimatorBuilder;
import cs5004.animator.model.AnimationBuilder;
import cs5004.animator.model.AnimationReader;
import cs5004.animator.controller.Controller;
import cs5004.animator.controller.IController;
import cs5004.animator.view.IViewText;
import cs5004.animator.view.TextView;
import cs5004.animator.model.AnimatorImplV2;
import cs5004.animator.model.IAnimatorV2;

import static org.junit.Assert.assertEquals;

/**
 * JUNIT Tests for the TextView
 */
public class MVCTest {
  private IAnimatorV2 model;
  private IViewText textView;
  private IController controller;
  private AnimationBuilder<IAnimatorV2> animatorBuilder;
  private AnimationReader reader;
  private Appendable s;

  @org.junit.Before
  public void setUp() {
    model = new AnimatorImplV2();
    animatorBuilder = new MyAnimatorBuilder(model);
    reader = new AnimationReader();
    s = new StringBuilder();
    textView = new TextView(s);
  }

  @org.junit.Test
  public void testNoAnimation() {
    controller = new Controller(model, textView);
    String testNoAnimation = "";
    assertEquals(testNoAnimation, s.toString());
  }


  @org.junit.Test
  public void testSmallAnimation() {
    try {
      model = reader.parseFile(new FileReader("./simpleAnimator/test/smalldemo.txt"),
              animatorBuilder);
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }

    controller = new Controller(model, textView);

    String testSmallDemo = "Name: R\nType: Rectangle\nMin corner: (300,300), Width: 50, Height: "
            + "100, Color: (255.0,0.0,0.0)\nAppears at t=1\nDisappears at t=100\n\n"
            + "Name: C\nType: Oval\nMin corner: (440,370), Width: 120, Height: 60, Color: "
            + "(0.0,255.0,0.0)\nAppears at t=6\nDisappears at t=100\n\n"
            + "Shape R moves from (200,200) to (300,300) from t=10 to t=50\n"
            + "Shape R scales from Width: 50, Height: 100 to Width: 25, Height: 100 "
            + "from t=51 to t=70\nShape R moves from (300,300) to (200,200) from t=70 to t=100\n"
            + "Shape C moves from (440,70) to (440,250) from t=20 to t=50\n"
            + "Shape C moves from (440,250) to (440,370) from t=50 to t=70\n"
            + "Shape C changes color from (0,0,255) to (0,170,85) from t=50 to=70\n"
            + "Shape C changes color from (0,170,85) to (0,255,0) from t=70 to=80\n";

    assertEquals(testSmallDemo, s.toString());
  }


}
