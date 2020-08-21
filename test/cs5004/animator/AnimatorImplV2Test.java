package cs5004.animator;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import cs5004.animator.model.MyAnimatorBuilder;
import cs5004.animator.model.AnimationBuilder;
import cs5004.animator.model.AnimationReader;
import cs5004.animator.model.AnimatorImplV2;
import cs5004.animator.model.IAnimatorV2;
import cs5004.animator.model.IShape;

import static org.junit.Assert.assertEquals;


/**
 * JUnit Tests for the AnimatorImplV2 Model.
 */
public class AnimatorImplV2Test {

  private IAnimatorV2 model;

  @Before
  public void setUp() throws FileNotFoundException {
    model = new AnimatorImplV2();
    AnimationBuilder<IAnimatorV2> animationBuilder = new MyAnimatorBuilder(model);
    AnimationReader reader = new AnimationReader();
    model = reader.parseFile(new FileReader("/Users/rohitraikhy/Downloads/code 4/toh-3.txt"), animationBuilder);
  }

  @Test
  public void addShape() {
    assertEquals("", model.getNames());
  }

  @Test
  public void addTransformMove() {
    ArrayList<IShape> shapes = model.getShapesAtFrame(11);
    assertEquals(202.5, shapes.get(0).getX(), 0.01);
    assertEquals(202.5, shapes.get(0).getY(), 0.01);
  }

  @Test
  public void addTransformMove2() {
    ArrayList<IShape> shapes = model.getShapesAtFrame(100);
    assertEquals(200, shapes.get(0).getX(), 0.01);
    assertEquals(200, shapes.get(0).getY(), 0.01);
    assertEquals(440, shapes.get(1).getX(), 0.01);
    assertEquals(370, shapes.get(1).getY(), 0.01);
  }

  @Test
  public void addTransformColor() {
    ArrayList<IShape> shapes = model.getShapesAtFrame(51);
    assertEquals("", shapes.get(1).getColor());

  }

  @Test
  public void addTransformScale() {
    ArrayList<IShape> shapes = model.getShapesAtFrame(70);
    assertEquals(100, shapes.get(1).getHeight(), 0.01);
    assertEquals(25, shapes.get(1).getWidth(), 0.01);
    assertEquals(100, shapes.get(0).getHeight(), 0.01);
    assertEquals(25, shapes.get(0).getWidth(), 0.01);
    assertEquals(120, shapes.get(2).getWidth(), 0.01);
    assertEquals(4, shapes.size());
    assertEquals(60, shapes.get(2).getHeight(), 0.01);
    assertEquals(60, shapes.get(3).getWidth(), 0.01);
    assertEquals(60, shapes.get(3).getHeight(), 0.01);

  }

  @Test
  public void getLastFrame() {
    assertEquals(100, model.getLastFrame());
  }

  @Test
  public void getShapesAtFrame() {
    ArrayList<IShape> shapes = model.getShapesAtFrame(55);
    assertEquals("R", shapes.get(0).getName());
    assertEquals("C", shapes.get(1).getName());
    assertEquals(2, shapes.size());
  }

  @Test
  public void getShapesAtFrame2() {
    ArrayList<IShape> shapes = model.getShapesAtFrame(80);
    assertEquals("R", shapes.get(0).getName());
    assertEquals("C", shapes.get(1).getName());
    assertEquals(300, shapes.get(1).getX(), 0.01);
    assertEquals(2, shapes.size());
  }

  @Test
  public void getAllStartEndTimes() {
    HashMap<String, ArrayList<Integer>> startEndTimes = model.getAllStartEndTimes();
    ArrayList<Integer> frames = startEndTimes.get("R");
    int sFrame = frames.get(0);
    int eFrame = frames.get(1);
    assertEquals(1, sFrame);
    assertEquals(100, eFrame);
  }

  @Test
  public void testGetAllInits() {
    ArrayList<IShape> initShapes = model.getAllInitShapes();
    assertEquals(2, initShapes.size());
    assertEquals(10, initShapes.get(0).getHeight(), 0.01);
  }

  @Test

  public void allTransform() {
    assertEquals(1, model.getAllTransformations().size());
  }

}
