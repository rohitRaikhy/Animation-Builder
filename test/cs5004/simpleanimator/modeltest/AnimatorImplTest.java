package cs5004.simpleanimator.modeltest;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.AnimatorImpl;
import cs5004.animator.model.Circle;
import cs5004.animator.model.IShape;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Square;
import cs5004.animator.model.Triangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * test suite for the animatorImpl class.
 */

public class AnimatorImplTest {

  private AnimatorImpl animatorOne;

  @Before
  public void setUp() {
    animatorOne = new AnimatorImpl();
  }

  /**
   * test adding a shape to canvas.
   */
  @Test
  public void addShape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "red");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    assertEquals("[" + circle + "]", animatorOne.getNames().toString());
  }

  /**
   * test add shape with bad input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void add2Shape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "red");
    animatorOne.addShape(circle, -1, 10, 100, 200);
    assertEquals(circle, animatorOne.getNames());
  }

  /**
   * test add shape with bad input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void add3Shape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "red");
    animatorOne.addShape(circle, 1, -10, 100, 200);
    assertEquals(circle, animatorOne.getNames());
  }

  /**
   * test add shape with bad input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void add4Shape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "red");
    animatorOne.addShape(circle, 1, 10, -100, 200);
    assertEquals(circle, animatorOne.getNames());
  }

  /**
   * test add shape with bad input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void add5Shape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "red");
    animatorOne.addShape(circle, 1, 10, 100, -200);
    assertEquals(circle, animatorOne.getNames());
  }

  /**
   * test addShape with shape in same position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void add6Shape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "red");
    animatorOne.addShape(circle, 1, 10, 100, 200);
    animatorOne.addShape(circle, 1, 10, 100, 200);
    assertEquals(circle, animatorOne.getNames());
  }

  /**
   * test the changeColor animation from red to green.
   */
  @Test
  public void changeColor() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "red");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeColor(10, 10, 0, 1,
            0, 120, 190);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals("(0.0,1.0,0.0)", checkShape.getColor());
  }

  /**
   * test the changeColor animation from green to red.
   */
  @Test
  public void change2Color() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals("(0.0,1.0,0.0)", circle.getColor());
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeColor(10, 10, 1, 0,
            0, 120, 190);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals("(1.0,0.0,0.0)", checkShape.getColor());
  }

  /**
   * test the changeColor animation from green to blue.
   */
  @Test
  public void change3Color() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals("(0.0,1.0,0.0)", circle.getColor());
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeColor(10, 10, 0, 0,
            1, 120, 190);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals("(0.0,0.0,1.0)", checkShape.getColor());
  }

  /**
   * test the scale by 10.
   */
  @Test
  public void scaleTest() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    assertEquals(5, animatorOne.getShape(10, 10).getHeight(), 0.01);
    assertEquals(5, animatorOne.getShape(10, 10).getWidth(), 0.01);
    animatorOne.scaleShape(10, 10, 10, 10, 100, 102);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(10, checkShape.getHeight(), 0.01);
    assertEquals(10, checkShape.getWidth(), 0.01);
  }

  /**
   * test the scale by the same width and height.
   */
  @Test
  public void scale2Test() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    assertEquals(5, animatorOne.getShape(10, 10).getHeight(), 0.01);
    assertEquals(5, animatorOne.getShape(10, 10).getWidth(), 0.01);
    animatorOne.scaleShape(5, 5, 10, 10, 105, 110);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(5, checkShape.getHeight(), 0.01);
    assertEquals(5, checkShape.getWidth(), 0.01);
  }

  /**
   * test the scale by the same negative height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void scale3Test() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    assertEquals(5, animatorOne.getShape(10, 10).getHeight(), 0.01);
    assertEquals(5, animatorOne.getShape(10, 10).getWidth(), 0.01);
    animatorOne.scaleShape(-5, 5, 10, 10, 105, 102);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(5, checkShape.getHeight(), 0.01);
    assertEquals(5, checkShape.getWidth(), 0.01);
  }

  /**
   * test the scale by the same negative width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void scale4Test() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.scaleShape(5, -5, 10, 10, 105, 102);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(5, checkShape.getHeight(), 0.01);
    assertEquals(5, checkShape.getWidth(), 0.01);
  }

  /**
   * test the scale by the same negative width and height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void scale5Test() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.scaleShape(-5, -5, 10, 10, 105, 102);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(5, checkShape.getHeight(), 0.01);
    assertEquals(5, checkShape.getWidth(), 0.01);
  }

  /**
   * test the scale by shape not at position on canvas.
   */
  @Test(expected = IllegalArgumentException.class)
  public void scale6Test() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.scaleShape(20, 20, 5, 5, 105, 102);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(10, checkShape.getHeight(), 0.01);
    assertEquals(10, checkShape.getWidth(), 0.01);
  }

  /**
   * test the change height.
   */
  @Test
  public void changeHeight() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getHeight(), 0.1);
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeHeight(10, 10, 120, 150, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getHeight(), 0.01);
  }

  /**
   * test the change height negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change2Height() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getHeight(), 0.1);
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeHeight(10, 10, 20, 5, -20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getHeight(), 0.01);
  }

  /**
   * test the change height with no shape at position wrong x.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change3Height() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getHeight(), 0.1);
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeHeight(5, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getHeight(), 0.01);
  }

  /**
   * test the change height with no shape at position wrong y.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change4Height() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getHeight(), 0.1);
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeHeight(10, 5, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getHeight(), 0.01);
  }

  /**
   * test the change height with no shape at position negative startTime.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change5Height() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getHeight(), 0.1);
    animatorOne.addShape(circle, 10, 10, -10, 200);
    animatorOne.changeHeight(10, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getHeight(), 0.01);
  }

  /**
   * test the change height with no shape at position negative startTime.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change6Height() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getHeight(), 0.1);
    animatorOne.addShape(circle, 10, 10, 10, -200);
    animatorOne.changeHeight(10, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getHeight(), 0.01);
  }

  /**
   * test the change height with no shape at position negative startTime and end time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change7Height() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getHeight(), 0.1);
    animatorOne.addShape(circle, 10, 10, -10, -200);
    animatorOne.changeHeight(10, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getHeight(), 0.01);
  }

  /**
   * test change height on same shape at between time interval.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 20, 250);
    animatorOne.moveShape(20, 10, 0, 10, 20, 220);
    IShape checkShape2 = animatorOne.getShape(0, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at same time interval.
   */
  @Test(expected = IllegalArgumentException.class)
  public void move2ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 20, 250);
    animatorOne.moveShape(20, 10, 0, 10, 20, 250);
    IShape checkShape2 = animatorOne.getShape(0, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval.
   */
  @Test(expected = IllegalArgumentException.class)
  public void move3ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 20, 250);
    animatorOne.moveShape(20, 10, 0, 10, 30, 240);
    IShape checkShape2 = animatorOne.getShape(0, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }


  /**
   * test move change x pos and y pos.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveShapeXposYpos() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 20, 250);
    animatorOne.moveShape(10, 10, 0, 10, 260, 10009);
    fail("Should not move at this position");
  }

  /**
   * test change height on same shape at between time interval.
   */
  @Test(expected = IllegalArgumentException.class)
  public void move4ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 20, 250);
    animatorOne.moveShape(20, 10, 0, 10, 10, 100);
    IShape checkShape2 = animatorOne.getShape(0, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval.
   */
  @Test(expected = IllegalArgumentException.class)
  public void move5ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 20, 250);
    animatorOne.moveShape(20, 10, 0, 10, 10, 100);
    IShape checkShape2 = animatorOne.getShape(0, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void move6ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 10, 100);
    animatorOne.moveShape(20, 10, 0, 10, 20, 250);
    IShape checkShape2 = animatorOne.getShape(0, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void move7ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 10, 100);
    animatorOne.moveShape(20, 10, 0, 10, 80, 100);
    IShape checkShape2 = animatorOne.getShape(0, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void move8ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.moveShape(10, 10, 20, 10, 10, 50);
    animatorOne.moveShape(20, 10, 0, 10, 5, 100);
    IShape checkShape2 = animatorOne.getShape(0, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeWidthShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(10, 10, 20, 10, 10);
    animatorOne.changeWidth(20, 10, 0, 10, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeWidth2ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(10, 10, 20, 10, 50);
    animatorOne.changeWidth(20, 10, 0, 5, 100);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeWidth3ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(10, 10, 20, 10, 100);
    animatorOne.changeWidth(20, 10, 0, 80, 100);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeWidth4ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(10, 10, 20, 10, 100);
    animatorOne.changeWidth(20, 10, 0, 10, 250);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeWidth5ShapeOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(10, 10, 20, 20, 250);
    animatorOne.changeWidth(20, 10, 0, 10, 100);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeHeightOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeHeight(10, 10, 20, 20, 250);
    animatorOne.changeHeight(20, 10, 0, 10, 100);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeHeight2Overlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeHeight(10, 10, 20, 10, 100);
    animatorOne.changeHeight(20, 10, 0, 10, 250);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeHeight3Overlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeHeight(10, 10, 20, 10, 100);
    animatorOne.changeHeight(20, 10, 0, 80, 100);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeHeight4Overlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeHeight(10, 10, 20, 10, 10);
    animatorOne.changeHeight(20, 10, 0, 10, 10);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeScaleOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.scaleShape(10, 10, 10, 10, 250, 300);
    animatorOne.scaleShape(20, 10, 10, 10, 250, 300);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change2ScaleOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.scaleShape(10, 10, 10, 10, 250, 300);
    animatorOne.scaleShape(20, 10, 10, 10, 280, 290);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeColorOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeColor(10, 10, 0, 0,
            1, 2, 2);
    animatorOne.changeColor(20, 10, 0, 0,
            1, 2, 2);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case. end time of one equals
   * start time of the other. Should not be able to start an animation at same time an animation
   * ends. This can be changed in the next assignment.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change2ColorOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeColor(10, 10, 0, 0,
            1, 0, 2);
    animatorOne.changeColor(20, 10, 0, 0,
            1, 2, 4);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test change height on same shape at between time interval edge case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change3ColorOverlap() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeColor(10, 10, 0, 0,
            1, 10, 20);
    animatorOne.changeColor(20, 10, 0, 0,
            1, 5, 15);
    fail("Should not allow a shape to have two animations in the same time interval.");
  }

  /**
   * test if start is greater than end time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testStartAndEndTimesValid() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getHeight(), 0.1);
    animatorOne.addShape(circle, 10, 10, 10, 200);
    animatorOne.changeHeight(10, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getHeight(), 0.01);
  }

  /**
   * test the move animation string.
   */
  @Test
  public void testStringBuilder() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    IShape rectangle = new Rectangle("R", 10,
            10, 5, 5, "green");
    animatorOne.addShape(rectangle, 40, 50, 10, 200);
    animatorOne.addShape(circle, 50, 60, 10, 100);
    animatorOne.changeWidth(50, 60, 10, 40, 60);
    animatorOne.moveShape(50, 60, 10, 20, 15, 19);
    animatorOne.changeHeight(10, 20, 80, 90, 100);
    animatorOne.scaleShape(10, 20, 10, 20, 92, 95);
    animatorOne.changeColor(10, 20, 1, 0, 0, 11, 12);

    String expected = "Shapes:\n"
            + "Name: R\n"
            + "Type: Rectangle\n"
            + "Min corner: (40.0,50.0), Width: 5.0, Height: 5.0, Color: (0.0,1.0,0.0)\n"
            + "Appears at t=10\n"
            + "Disappears at t=200\n"
            + "\n"
            + "Name: C\n"
            + "Type: Circle\n"
            + "Min corner: (50.0,60.0), Width: 5.0, Height: 5.0, Color: (0.0,1.0,0.0)\n"
            + "Appears at t=10\n"
            + "Disappears at t=100\n"
            + "\n"
            + "Shape C changes width from 5.0 to 10.0 from time t=40 to t=60\n"
            + "Shape C moves from (50.0,60.0) to (10.0,20.0) from t=15 to t=19\n"
            + "Shape C changes height from 5.0 to 100.0 from time t=80 to t=90\n"
            + "Shape C scales from Width: 10.0, Height: 100.0 to Width: 20.0, Height: 10.0 "
            + "from t=92 to t=95\n"
            + "Shape C changes color from (0.0,1.0,0.0) to (1.0,0.0,0.0) from t=11 to=12";

    assertEquals(expected, animatorOne.toString());
  }

  /**
   * test the to string with no shapes added.
   */
  @Test
  public void testToString() {
    assertEquals("There are no shapes on the canvas.", animatorOne.toString());
  }

  /**
   * test the move animation string.
   */
  @Test
  public void test2StringBuilder() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    IShape rectangle = new Rectangle("R", 10,
            10, 5, 5, "green");
    IShape triangle = new Triangle("Triangle", 150, 200,
            20, 30, "red");
    IShape square = new Square("square", 200, 200,
            50, 50, "red");
    IShape oval = new Oval("Oval", 300, 250, 20, 50, "green");


    animatorOne.addShape(rectangle, 40, 50, 10, 20);
    animatorOne.addShape(circle, 50, 60, 1, 200);
    animatorOne.addShape(triangle, 60, 70, 10, 20);
    animatorOne.addShape(square, 80, 90, 10, 20);
    animatorOne.addShape(oval, 90, 100, 10, 20);

    animatorOne.changeWidth(50, 60, 10, 11, 12);
    animatorOne.moveShape(50, 60, 10, 20, 13, 19);
    animatorOne.changeHeight(10, 20, 100, 190, 100);
    animatorOne.scaleShape(10, 20, 10, 20, 192, 198);
    animatorOne.changeColor(10, 20, 1, 0, 0, 2, 5);

    String expected =
            "Shapes:\n"
                    + "Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (40.0,50.0), Width: 5.0, Height: 5.0, Color: (0.0,1.0,0.0)\n"
                    + "Appears at t=10\n"
                    + "Disappears at t=20\n"
                    + "\n"
                    + "Name: C\n"
                    + "Type: Circle\n"
                    + "Min corner: (50.0,60.0), Width: 5.0, Height: 5.0, Color: (0.0,1.0,0.0)\n"
                    + "Appears at t=1\n"
                    + "Disappears at t=200\n"
                    + "\n"
                    + "Name: Triangle\n"
                    + "Type: Triangle\n"
                    + "Min corner: (60.0,70.0), Width: 20.0, Height: 30.0, Color: (1.0,0.0,0.0)\n"
                    + "Appears at t=10\n"
                    + "Disappears at t=20\n"
                    + "\n"
                    + "Name: square\n"
                    + "Type: Square\n"
                    + "Min corner: (80.0,90.0), Width: 50.0, Height: 50.0, Color: (1.0,0.0,0.0)\n"
                    + "Appears at t=10\n"
                    + "Disappears at t=20\n"
                    + "\n"
                    + "Name: Oval\n"
                    + "Type: Oval\n"
                    + "Min corner: (90.0,100.0), Width: 20.0, Height: 50.0, Color: (0.0,1.0,0.0)\n"
                    + "Appears at t=10\n"
                    + "Disappears at t=20\n"
                    + "\n"
                    + "Shape C changes width from 5.0 to 10.0 from time t=11 to t=12\n"
                    + "Shape C moves from (50.0,60.0) to (10.0,20.0) from t=13 to t=19\n"
                    + "Shape C changes height from 5.0 to 100.0 from time t=100 to t=190\n"
                    + "Shape C scales from Width: 10.0, Height: 100.0 to Width: 20.0, Height: 10.0 "
                    + "from t=192 to t=198\n"
                    + "Shape C changes color from (0.0,1.0,0.0) to (1.0,0.0,0.0) from t=2 to=5";

    assertEquals(expected, animatorOne.toString());
  }

  /**
   * test the move shape animation with invalid appears.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalidAppears() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 10, 20);
    animatorOne.moveShape(50, 60, 60, 70, 5, 20);
  }

  /**
   * test the move shape animation with invalid disappears.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test2MoveInvalidAppears() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 10, 20);
    animatorOne.moveShape(50, 60, 60, 70, 10, 25);
  }

  /**
   * test the move shape animation with invalid appears and disappears.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test3MoveInvalidAppears() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 10, 20);
    animatorOne.moveShape(50, 60, 60, 70, 5, 25);
  }

  /**
   * test the move shape animation with invalid appears.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test4MoveInvalidAppears() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 20);
    animatorOne.moveShape(50, 60, 60, 70, 10, 20);
  }

  /**
   * test the move shape animation with invalid disappears.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test5MoveInvalidAppears() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 17);
    animatorOne.moveShape(50, 60, 60, 70, 10, 20);
  }

  /**
   * test the move shape animation with invalid disappears.
   */
  @Test
  public void testValidMove() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 17);
    animatorOne.moveShape(50, 60, 60, 70, 15, 16);
    IShape checkShape = animatorOne.getShape(60, 70);
    assertEquals("(60.0,70.0)", checkShape.getPosition());
  }

  /**
   * test the change width shape animation with invalid start time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testValidWidth() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 17);
    animatorOne.changeWidth(50, 60, 10, 11, 12);
    fail("should not do this");
  }

  /**
   * test the change width shape animation with invalid end time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test2ValidWidth() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 17);
    animatorOne.changeWidth(50, 60, 10, 15, 20);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid appears time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test3ValidWidth() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 16, 20);
    animatorOne.changeWidth(50, 60, 10, 15, 20);
    fail("should not do this");
  }

  /**
   * test the change width shape animation with invalid disappears time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test4ValidWidth() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 17);
    animatorOne.changeWidth(50, 60, 10, 15, 20);
    fail("should not do this");
  }

  /**
   * test the change height shape animation with invalid disappears time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHeight() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 17);
    animatorOne.changeHeight(50, 60, 10, 15, 20);
    fail("should not do this");
  }

  /**
   * test the change width shape animation with invalid appears time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test2InvalidHeight() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 16, 20);
    animatorOne.changeHeight(50, 60, 10, 15, 20);
    fail("should not do this");
  }

  /**
   * test the change width shape animation with invalid start time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test3InvalidHeight() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 17);
    animatorOne.changeHeight(50, 60, 10, 11, 12);
    fail("should not do this");
  }

  /**
   * test the change width shape animation with invalid end time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test4InvalidHeight() {
    IShape circle = new Circle("C", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 50, 60, 15, 17);
    animatorOne.changeHeight(50, 60, 10, 15, 20);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid start time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void scaleInvalid() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.scaleShape(5, -5, 10, 10, 90, 102);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid end time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void scale2Invalid() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.scaleShape(5, -5, 10, 10, 102, 202);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid appears at time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void scale3Invalid() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 105, 200);
    animatorOne.scaleShape(5, -5, 10, 10, 102, 202);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid disappears at time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void scale4Invalid() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 100, 150);
    animatorOne.scaleShape(5, -5, 10, 10, 102, 202);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid start time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidChangeColor() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals("(0.0,1.0,0.0)", circle.getColor());
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeColor(10, 10, 0, 0,
            1, 90, 190);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid end time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalid2ChangeColor() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals("(0.0,1.0,0.0)", circle.getColor());
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeColor(10, 10, 0, 0,
            1, 100, 220);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid appears time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalid3ChangeColor() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals("(0.0,1.0,0.0)", circle.getColor());
    animatorOne.addShape(circle, 10, 10, 105, 200);
    animatorOne.changeColor(10, 10, 0, 0,
            1, 100, 190);
    fail("should not do this.");
  }

  /**
   * test the change width shape animation with invalid appears time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalid4ChangeColor() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals("(0.0,1.0,0.0)", circle.getColor());
    animatorOne.addShape(circle, 10, 10, 90, 170);
    animatorOne.changeColor(10, 10, 0, 0,
            1, 100, 190);
    fail("should not do this.");
  }

  /**
   * test the change width with no shape at position negative startTime.
   */
  @Test(expected = IllegalArgumentException.class)
  public void changeWidth() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getWidth(), 0.1);
    animatorOne.addShape(circle, 10, 10, 10, -200);
    animatorOne.changeWidth(10, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getWidth(), 0.01);
  }


  /**
   * test the change width.
   */
  @Test
  public void change2Width() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getWidth(), 0.1);
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(10, 10, 120, 150, 180);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(120, checkShape.getWidth(), 0.01);
  }

  /**
   * test the change width negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change3Width() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getWidth(), 0.1);
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(10, 10, 20, 5, -20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getWidth(), 0.01);
  }

  /**
   * test the change width with no shape at position wrong x.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change4Width() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getWidth(), 0.1);
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(5, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getWidth(), 0.01);
  }

  /**
   * test the change width with no shape at position wrong y.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change5Width() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getWidth(), 0.1);
    animatorOne.addShape(circle, 10, 10, 100, 200);
    animatorOne.changeWidth(10, 5, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getWidth(), 0.01);
  }

  /**
   * test the change width with no shape at position negative startTime.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change6Width() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getWidth(), 0.1);
    animatorOne.addShape(circle, 10, 10, -10, 200);
    animatorOne.changeWidth(10, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getWidth(), 0.01);
  }

  /**
   * test the change width with no shape at position negative startTime.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change7Width() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getWidth(), 0.1);
    animatorOne.addShape(circle, 10, 10, 10, -200);
    animatorOne.changeWidth(10, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getWidth(), 0.01);
  }

  /**
   * test the change width with no shape at position negative startTime and end time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void change8Width() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    assertEquals(5, circle.getWidth(), 0.1);
    animatorOne.addShape(circle, 10, 10, -10, -200);
    animatorOne.changeWidth(10, 10, 20, 5, 20);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals(20, checkShape.getWidth(), 0.01);
  }

  /**
   * test the get shape with valid input.
   */
  @Test
  public void testGetShape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 10, 200);
    IShape checkShape = animatorOne.getShape(10, 10);
    assertEquals("Circle", checkShape.getName());
  }

  /**
   * test the get shape with invalid input xpos.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test2GetShape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 10, 200);
    animatorOne.getShape(20, 10);
    fail("should not do this.");
  }

  /**
   * test the get shape with invalid input ypos.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test3GetShape() {
    IShape circle = new Circle("Circle", 10,
            10, 5, 5, "green");
    animatorOne.addShape(circle, 10, 10, 10, 200);
    animatorOne.getShape(10, 20);
    fail("should not do this.");
  }
}