package cs5004.simpleanimator.modeltest;

import cs5004.animator.model.Circle;
import cs5004.animator.model.IShape;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Square;
import cs5004.animator.model.Triangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class represents JUnit Tests for the different Shapes.
 */
public class ModelImplTest {
  IShape square;
  IShape circle;
  IShape oval;
  IShape rectangle;
  IShape triangle;

  @org.junit.Before
  public void setUp() {
    square = new Square("square", 200, 200,
            50, 50, "red");
    circle = new Circle("circle", 250, 250, 20, 20, "blue");
    oval = new Oval("oval", 300, 250, 20, 50, "green");
    rectangle = new Rectangle("rectangle", 500, 300,
            50, 70, "blue");
    triangle = new Triangle("triangle", 150, 200,
            20, 30, "red");
  }

  @org.junit.Test
  public void testInitialization() {
    // For Square
    assertEquals("square", square.getName());
    assertEquals("Square", square.getType());
    assertEquals(200.0, square.getX(), 0.01);
    assertEquals(200.0, square.getY(), 0.01);
    assertEquals("(200.0,200.0)", square.getPosition());
    assertEquals(50.0, square.getWidth(), 0.01);
    assertEquals(50.0, square.getHeight(), 0.01);
    assertEquals("(1.0,0.0,0.0)", square.getColor());

    // For Circle
    assertEquals("circle", circle.getName());
    assertEquals("Circle", circle.getType());
    assertEquals(250.0, circle.getX(), 0.01);
    assertEquals(250.0, circle.getY(), 0.01);
    assertEquals("(250.0,250.0)", circle.getPosition());
    assertEquals(20.0, circle.getWidth(), 0.01);
    assertEquals(20.0, circle.getHeight(), 0.01);
    assertEquals("(0.0,0.0,1.0)", circle.getColor());

    // For Oval
    assertEquals("oval", oval.getName());
    assertEquals("Oval", oval.getType());
    assertEquals(300.0, oval.getX(), 0.01);
    assertEquals(250.0, oval.getY(), 0.01);
    assertEquals("(300.0,250.0)", oval.getPosition());
    assertEquals(20.0, oval.getWidth(), 0.01);
    assertEquals(50.0, oval.getHeight(), 0.01);
    assertEquals("(0.0,1.0,0.0)", oval.getColor());

    // For Rectangle
    assertEquals("rectangle", rectangle.getName());
    assertEquals("Rectangle", rectangle.getType());
    assertEquals(500.0, rectangle.getX(), 0.01);
    assertEquals(300.0, rectangle.getY(), 0.01);
    assertEquals("(500.0,300.0)", rectangle.getPosition());
    assertEquals(50.0, rectangle.getWidth(), 0.01);
    assertEquals(70.0, rectangle.getHeight(), 0.01);
    assertEquals("(0.0,0.0,1.0)", rectangle.getColor());

    // For Triangle
    assertEquals("Triangle", triangle.getType());
    assertEquals(150.0, triangle.getX(), 0.01);
    assertEquals(200.0, triangle.getY(), 0.01);
    assertEquals("(150.0,200.0)", triangle.getPosition());
    assertEquals(20.0, triangle.getWidth(), 0.01);
    assertEquals(30.0, triangle.getHeight(), 0.01);
    assertEquals("(1.0,0.0,0.0)", triangle.getColor());
  }

  /* Test Invalid Name */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameSquareNULL() {
    square = new Square(null, 200, 200,
            50, 50, "red");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameSquareEmpty() {
    square = new Square("", 200, 200,
            50, 50, "red");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameCircleNULL() {
    circle = new Circle(null, 250, 250, 20, 20, "blue");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameCircleEmpty() {
    circle = new Circle("", 250, 250, 20, 20, "blue");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameOvalNULL() {
    oval = new Oval(null, 300, 250, 20, 50, "green");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameOvalEmpty() {
    oval = new Oval("", 300, 250, 20, 50, "green");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameRectangleNULL() {
    rectangle = new Rectangle(null, 500, 300,
            50, 70, "blue");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameRectangleEmpty() {
    rectangle = new Rectangle("", 500, 300,
            50, 70, "blue");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameTriangleNULL() {
    triangle = new Triangle(null, 150, 200,
            20, 30, "red");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidNameTriangleEmpty() {
    triangle = new Triangle("", 150, 200,
            20, 30, "red");
    fail("You have constructed this shape with an invalid name. An exception should be thrown ");
  }

  /*Tests for XPosition */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosSquareLessThan0() {
    square = new Square("square", -1, 200,
            50, 50, "red");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosSquareGreaterThan2500() {
    square = new Square("square", 2501, 200,
            50, 50, "red");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }


  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosCircleLessThan0() {
    circle = new Circle("circle", -1, 250, 20, 20, "blue");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosCircleGreaterThan2500() {
    circle = new Circle("circle", 2501, 250, 20, 20, "blue");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }


  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosOvalLessThan0() {
    oval = new Oval("oval", -1, 250, 20, 50, "green");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosOvalGreaterThan2500() {
    oval = new Oval("oval", 2501, 250, 20, 50, "green");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosRectangleLessThan0() {
    rectangle = new Rectangle("rectangle", -1, 300,
            50, 70, "blue");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosRectangleGreaterThan2500() {
    rectangle = new Rectangle("rectangle", 2501, 300,
            50, 70, "blue");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosTriangleLessThan0() {
    triangle = new Triangle("triangle", -1, 200,
            20, 30, "red");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidXPosTriangleGreaterThan2500() {
    triangle = new Triangle("triangle", 2501, 200,
            20, 30, "red");
    fail("You have constructed this shape with an invalid x pos. An exception should be thrown ");
  }

  /* Tests for Y Pos*/
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosSquareLessThan0() {
    square = new Square("square", 200, -1,
            50, 50, "red");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosSquareGreaterThan2500() {
    square = new Square("square", 200, 2501,
            50, 50, "red");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosCircleLessThan0() {
    circle = new Circle("circle", 250, -1, 20, 20, "blue");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosCircleGreaterThan2500() {
    circle = new Circle("circle", 250, 2501, 20, 20, "blue");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }


  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosOvalLessThan0() {
    oval = new Oval("oval", 300, -1, 20, 50, "green");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosOvalGreaterThan2500() {
    oval = new Oval("oval", 300, 2501, 20, 50, "green");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosRectangleLessThan0() {
    rectangle = new Rectangle("rectangle", 500, -1,
            50, 70, "blue");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosRectangleGreaterThan2500() {
    rectangle = new Rectangle("rectangle", 500, 2501,
            50, 70, "blue");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosTriangleLessThan0() {
    triangle = new Triangle("triangle", 150, -1,
            20, 30, "red");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidYPosTriangleGreaterThan2500() {
    triangle = new Triangle("triangle", 150, 2501,
            20, 30, "red");
    fail("You have constructed this shape with an invalid y pos. An exception should be thrown ");
  }

  /* Tests for Invalid Width */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthSquareLessThan0() {
    square = new Square("square", 200, 200,
            -1, -1, "red");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthSquareAt0() {
    square = new Square("square", 200, 200,
            0, 0, "red");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthSquareGreaterThan500() {
    square = new Square("square", 200, 200,
            501, 501, "red");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthCircleLessThan0() {
    circle = new Circle("circle", 250, 250, -1, -1, "blue");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthCircleAt0() {
    circle = new Circle("circle", 250, 250, 0, 0, "blue");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthCircleGreaterThan500() {
    circle = new Circle("circle", 250, 250, 501, 501, "blue");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }


  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthOvalLessThan0() {
    oval = new Oval("oval", 300, 250, -1, 50, "green");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthOvalLessAt0() {
    oval = new Oval("oval", 300, 250, 0, 50, "green");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthOvalGreaterThan500() {
    oval = new Oval("oval", 300, 250, 501, 50, "green");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthRectangleLessThan0() {
    rectangle = new Rectangle("rectangle", 500, 300,
            -1, 70, "blue");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthRectangleAt0() {
    rectangle = new Rectangle("rectangle", 500, 300,
            0, 70, "blue");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthRectangleGreaterThan500() {
    rectangle = new Rectangle("rectangle", 500, 300,
            501, 70, "blue");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthTriangleLessThan0() {
    triangle = new Triangle("triangle", 150, 200,
            -1, 30, "red");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthTriangleAt0() {
    triangle = new Triangle("triangle", 150, 200,
            0, 30, "red");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthTriangleGreaterThan500() {
    triangle = new Triangle("triangle", 150, 200,
            501, 30, "red");
    fail("You have constructed this shape with an invalid width. An exception should be thrown ");
  }

  /* Tests for Invalid Height */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightSquareLessThan0() {
    square = new Square("square", 200, 200,
            -1, -1, "red");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightSquareAt0() {
    square = new Square("square", 200, 200,
            0, 0, "red");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightSquareGreaterThan500() {
    square = new Square("square", 200, 200,
            501, 501, "red");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightCircleLessThan0() {
    circle = new Circle("circle", 250, 250, -1, -1, "blue");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightCircleAt0() {
    circle = new Circle("circle", 250, 250, 0, 0, "blue");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightCircleGreaterThan500() {
    circle = new Circle("circle", 250, 250, 501, 501, "blue");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightOvalLessThan0() {
    oval = new Oval("oval", 300, 250, 20, -1, "green");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightOvalAt0() {
    oval = new Oval("oval", 300, 250, 20, 0, "green");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightOvalGreaterThan500() {
    oval = new Oval("oval", 300, 250, 20, 501, "green");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightRectangleLessThan0() {
    rectangle = new Rectangle("rectangle", 500, 300,
            50, -1, "blue");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightRectangleAt0() {
    rectangle = new Rectangle("rectangle", 500, 300,
            50, 0, "blue");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightRectangleGreaterThan500() {
    rectangle = new Rectangle("rectangle", 500, 300,
            50, 501, "blue");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightTriangleLessThan0() {
    triangle = new Triangle("triangle", 150, 200,
            20, -1, "red");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightTriangleAt0() {
    triangle = new Triangle("triangle", 150, 200,
            20, 0, "red");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightTriangleGreaterThan500() {
    triangle = new Triangle("triangle", 150, 200,
            20, 501, "red");
    fail("You have constructed this shape with an invalid height. An exception should be thrown ");
  }

  /* Tests for Invalid Size of Square and Circle */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSizeSquare() {
    square = new Square("square", 200, 200,
            50, 60, "red");
    fail("Your width and height should be the same. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSizeCircle() {
    circle = new Circle("circle", 250, 250, 30, 20, "blue");
    fail("Your width and height should be the same. An exception should be thrown ");
  }

  /* Test Invalid Colors */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidColorSquare() {
    square = new Square("square", 200, 200,
            50, 50, "pink");
    fail("Your color is not a valid selection. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidColorCircle() {
    circle = new Circle("circle", 250, 250, 20, 20, "orange");
    fail("Your color is not a valid selection. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidColorOval() {
    oval = new Oval("oval", 300, 250, 20, 50, "gold");
    fail("Your color is not a valid selection. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidColorRectangle() {
    rectangle = new Rectangle("rectangle", 500, 300,
            50, 70, "emerald");
    fail("Your color is not a valid selection. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidColorTriangle() {
    triangle = new Triangle("triangle", 150, 200,
            20, 30, "rose");
    fail("Your color is not a valid selection. An exception should be thrown ");
  }

  /* Test Set X */
  @org.junit.Test
  public void testChangeX() {
    assertEquals(200.0, square.getX(), 0.01);
    square.setX(250);
    assertEquals(250.0, square.getX(), 0.01);

    assertEquals(250.0, circle.getX(), 0.01);
    circle.setX(100);
    assertEquals(100.0, circle.getX(), 0.01);

    assertEquals(300.0, oval.getX(), 0.01);
    oval.setX(540);
    assertEquals(540.0, oval.getX(), 0.01);

    assertEquals(500.0, rectangle.getX(), 0.01);
    rectangle.setX(40);
    assertEquals(40.0, rectangle.getX(), 0.01);

    assertEquals(150.0, triangle.getX(), 0.01);
    triangle.setX(305);
    assertEquals(305.0, triangle.getX(), 0.01);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosSquareLessThan0() {
    square.setX(-1);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosSquareGreaterThan2500() {
    square.setX(2501);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosCircleLessThan0() {
    circle.setX(-1);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosCircleGreaterThan2500() {
    circle.setX(2501);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }


  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosOvalLessThan0() {
    oval.setX(-1);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosOvalGreaterThan2500() {
    oval.setX(2501);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosRectangleLessThan0() {
    rectangle.setX(-1);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosRectangleGreaterThan2500() {
    rectangle.setX(2501);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosTriangleLessThan0() {
    triangle.setX(-1);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetXPosTriangleGreaterThan2500() {
    triangle.setX(2501);
    fail("You have set this shape to an invalid x pos. An exception should be thrown ");
  }

  /* Test Set Y */
  @org.junit.Test
  public void testChangeY() {
    assertEquals(200.0, square.getY(), 0.01);
    square.setY(100);
    assertEquals(100.0, square.getY(), 0.01);

    assertEquals(250.0, circle.getY(), 0.01);
    circle.setY(50);
    assertEquals(50.0, circle.getY(), 0.01);

    assertEquals(250.0, oval.getY(), 0.01);
    oval.setY(500);
    assertEquals(500.0, oval.getY(), 0.01);

    assertEquals(300.0, rectangle.getY(), 0.01);
    rectangle.setY(125);
    assertEquals(125.0, rectangle.getY(), 0.01);

    assertEquals(200.0, triangle.getY(), 0.01);
    triangle.setY(400);
    assertEquals(400.0, triangle.getY(), 0.01);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosSquareLessThan0() {
    square.setY(-1);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosSquareGreaterThan2500() {
    square.setY(2501);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosCircleLessThan0() {
    circle.setY(-1);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosCircleGreaterThan2500() {
    circle.setY(2501);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }


  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosOvalLessThan0() {
    oval.setY(-1);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosOvalGreaterThan2500() {
    oval.setY(2501);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosRectangleLessThan0() {
    rectangle.setY(-1);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosRectangleGreaterThan2500() {
    rectangle.setY(2501);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosTriangleLessThan0() {
    triangle.setY(-1);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetYPosTriangleGreaterThan2500() {
    triangle.setY(2501);
    fail("You have set this shape to an invalid y pos. An exception should be thrown ");
  }

  /* Test Set Width */
  @org.junit.Test
  public void testChangeWidth() {
    assertEquals(50.0, square.getWidth(), 0.01);
    square.setWidth(75);
    assertEquals(75.0, square.getWidth(), 0.01);

    assertEquals(20.0, circle.getWidth(), 0.01);
    circle.setWidth(95);
    assertEquals(95.0, circle.getWidth(), 0.01);

    assertEquals(20.0, oval.getWidth(), 0.01);
    oval.setWidth(37);
    assertEquals(37.0, oval.getWidth(), 0.01);

    assertEquals(50.0, rectangle.getWidth(), 0.01);
    rectangle.setWidth(83);
    assertEquals(83.0, rectangle.getWidth(), 0.01);

    assertEquals(20.0, triangle.getWidth(), 0.01);
    triangle.setWidth(75);
    assertEquals(75.0, triangle.getWidth(), 0.01);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthSquareLessThan0() {
    square.setWidth(-1);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthSquareAt0() {
    square.setWidth(0);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthSquareGreaterThan500() {
    square.setWidth(501);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthCircleLessThan0() {
    circle.setWidth(-1);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthCircleAt0() {
    circle.setWidth(0);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthCircleGreaterThan500() {
    circle.setWidth(501);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }


  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthOvalLessThan0() {
    oval.setWidth(-1);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthOvalLessAt0() {
    oval.setWidth(0);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthOvalGreaterThan500() {
    oval.setWidth(501);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthRectangleLessThan0() {
    rectangle.setWidth(-1);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthRectangleAt0() {
    rectangle.setWidth(0);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthRectangleGreaterThan2500() {
    rectangle.setWidth(501);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthTriangleLessThan0() {
    triangle.setWidth(-1);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthTriangleAt0() {
    triangle.setWidth(0);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetWidthTriangleGreaterThan500() {
    triangle.setWidth(501);
    fail("You have set this shape to an invalid width. An exception should be thrown ");
  }

  /* Test Set Height */
  @org.junit.Test
  public void testChangeHeight() {
    assertEquals(50.0, square.getHeight(), 0.01);
    square.setHeight(20);
    assertEquals(20.0, square.getHeight(), 0.01);

    assertEquals(20.0, circle.getHeight(), 0.01);
    circle.setHeight(46);
    assertEquals(46.0, circle.getHeight(), 0.01);

    assertEquals(50.0, oval.getHeight(), 0.01);
    oval.setHeight(324);
    assertEquals(324.0, oval.getHeight(), 0.01);

    assertEquals(70.0, rectangle.getHeight(), 0.01);
    rectangle.setHeight(59);
    assertEquals(59.0, rectangle.getHeight(), 0.01);

    assertEquals(30.0, triangle.getHeight(), 0.01);
    triangle.setHeight(42);
    assertEquals(42.0, triangle.getHeight(), 0.01);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightSquareLessThan0() {
    square.setHeight(-1);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightSquareAt0() {
    square.setHeight(0);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightSquareGreaterThan500() {
    square.setHeight(501);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightCircleLessThan0() {
    circle.setHeight(-1);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightCircleAt0() {
    circle.setHeight(0);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightCircleGreaterThan500() {
    circle.setHeight(501);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightOvalLessThan0() {
    oval.setHeight(-1);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightOvalAt0() {
    oval.setHeight(0);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightOvalGreaterThan500() {
    oval.setHeight(501);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightRectangleLessThan0() {
    rectangle.setHeight(-1);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightRectangleAt0() {
    rectangle.setHeight(0);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightRectangleGreaterThan500() {
    rectangle.setHeight(501);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightTriangleLessThan0() {
    triangle.setHeight(-1);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightTriangleAt0() {
    triangle.setHeight(0);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidSetHeightTriangleGreaterThan500() {
    triangle.setHeight(501);
    fail("You have set this shape to an invalid height. An exception should be thrown ");
  }

  /* Test Set Color */
  @org.junit.Test
  public void testChangeColor() {
    assertEquals("(1.0,0.0,0.0)", square.getColor());
    square.changeColor(0, 1, 0);
    assertEquals("(0.0,1.0,0.0)", square.getColor());

    assertEquals("(0.0,0.0,1.0)", circle.getColor());
    circle.changeColor(1, 1, 0);
    assertEquals("(1.0,1.0,0.0)", circle.getColor());

    assertEquals("(0.0,1.0,0.0)", oval.getColor());
    oval.changeColor(1, 0, 1);
    assertEquals("(1.0,0.0,1.0)", oval.getColor());

    assertEquals("(0.0,0.0,1.0)", rectangle.getColor());
    rectangle.changeColor(1, 1, 0);
    assertEquals("(1.0,1.0,0.0)", rectangle.getColor());

    assertEquals("(1.0,0.0,0.0)", triangle.getColor());
    triangle.changeColor(0, 1, 1);
    assertEquals("(0.0,1.0,1.0)", triangle.getColor());
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedBelow0Square() {
    assertEquals("(1.0,0.0,0.0)", square.getColor());
    square.changeColor(-1, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedAbove1Square() {
    assertEquals("(1.0,0.0,0.0)", square.getColor());
    square.changeColor(2, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenBelow0Square() {
    assertEquals("(1.0,0.0,0.0)", square.getColor());
    square.changeColor(0, -1, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenAbove1Square() {
    assertEquals("(1.0,0.0,0.0)", square.getColor());
    square.changeColor(0, 2, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueBelow0Square() {
    assertEquals("(1.0,0.0,0.0)", square.getColor());
    square.changeColor(0, 1, -1);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueAbove1Square() {
    assertEquals("(1.0,0.0,0.0)", square.getColor());
    square.changeColor(0, 1, 2);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedBelow0Circle() {
    assertEquals("(0.0,0.0,1.0)", circle.getColor());
    circle.changeColor(-1, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedAbove1Circle() {
    assertEquals("(0.0,0.0,1.0)", circle.getColor());
    circle.changeColor(2, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenBelow0Circle() {
    assertEquals("(0.0,0.0,1.0)", circle.getColor());
    circle.changeColor(0, -1, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenAbove1Circle() {
    assertEquals("(0.0,0.0,1.0)", circle.getColor());
    circle.changeColor(0, 2, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueBelow0Circle() {
    assertEquals("(0.0,0.0,1.0)", circle.getColor());
    circle.changeColor(0, 1, -1);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueAbove1Circle() {
    assertEquals("(0.0,0.0,1.0)", circle.getColor());
    circle.changeColor(0, 1, 2);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedBelow0Oval() {
    assertEquals("(0.0,1.0,0.0)", oval.getColor());
    oval.changeColor(-1, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedAbove1Oval() {
    assertEquals("(0.0,1.0,0.0)", oval.getColor());
    oval.changeColor(2, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenBelow0Oval() {
    assertEquals("(0.0,1.0,0.0)", oval.getColor());
    oval.changeColor(0, -1, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenAbove1Oval() {
    assertEquals("(0.0,1.0,0.0)", oval.getColor());
    oval.changeColor(0, 2, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueBelow0Oval() {
    assertEquals("(0.0,1.0,0.0)", oval.getColor());
    oval.changeColor(0, 1, -1);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueAbove1Oval() {
    assertEquals("(0.0,1.0,0.0)", oval.getColor());
    oval.changeColor(0, 1, 2);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedBelow0Rectangle() {
    assertEquals("(0.0,0.0,1.0)", rectangle.getColor());
    rectangle.changeColor(-1, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedAbove1Rectangle() {
    assertEquals("(0.0,0.0,1.0)", rectangle.getColor());
    rectangle.changeColor(2, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenBelow0Rectangle() {
    assertEquals("(0.0,0.0,1.0)", rectangle.getColor());
    rectangle.changeColor(0, -1, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenAbove1Rectangle() {
    assertEquals("(0.0,0.0,1.0)", rectangle.getColor());
    rectangle.changeColor(0, 2, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueBelow0Rectangle() {
    assertEquals("(0.0,0.0,1.0)", rectangle.getColor());
    rectangle.changeColor(0, 1, -1);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueAbove1Rectangle() {
    assertEquals("(0.0,0.0,1.0)", rectangle.getColor());
    rectangle.changeColor(0, 1, 2);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedBelow0Triangle() {
    assertEquals("(1.0,0.0,0.0)", triangle.getColor());
    triangle.changeColor(-1, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeRedAbove1Triangle() {
    assertEquals("(1.0,0.0,0.0)", triangle.getColor());
    triangle.changeColor(2, 1, 0);
    fail("Invalid red value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenBelow0Triangle() {
    assertEquals("(1.0,0.0,0.0)", triangle.getColor());
    triangle.changeColor(0, -1, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeGreenAbove1Triangle() {
    assertEquals("(1.0,0.0,0.0)", triangle.getColor());
    triangle.changeColor(0, 2, 0);
    fail("Invalid green value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueBelow0Triangle() {
    assertEquals("(1.0,0.0,0.0)", triangle.getColor());
    triangle.changeColor(0, 1, -1);
    fail("Invalid blue value, an exception should have been called.");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidChangeBlueAbove1Triangle() {
    assertEquals("(1.0,0.0,0.0)", triangle.getColor());
    triangle.changeColor(0, 1, 2);
    fail("Invalid blue value, an exception should have been called.");
  }

}