package cs5004.animator.model;

import cs5004.animator.model.AnimationBuilder;
import cs5004.animator.model.IAnimatorV2;
import cs5004.animator.model.Circle;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Square;
import cs5004.animator.model.Triangle;

/**
 * This MyAnimatorBuilder class implements the AnimationBuilder. Each MyAnimationBuilder has a model
 * passed to it and builds the animations into it.
 */
public class MyAnimatorBuilder implements AnimationBuilder<IAnimatorV2> {
  private final IAnimatorV2 model;

  /**
   * Constructs a MyAnimatorBuilder object and initializes the model.
   *
   * @param model the model you would like to pass into the MyAnimationBuilder
   */
  public MyAnimatorBuilder(IAnimatorV2 model) {
    this.model = model;
  }

  @Override
  public IAnimatorV2 build() {
    return this.model;
  }

  @Override
  public AnimationBuilder<IAnimatorV2> setBounds(int x, int y, int width, int height) {
    return null;
  }

  @Override
  public AnimationBuilder<IAnimatorV2> declareShape(String name, String type) {
    switch (type) {
      case "rectangle":
        this.model.addShape(new Rectangle(name, 0, 0, 0, 0, "Red"),
                0, 0, 0,
                0, name);
        break;
      case "ellipse":
        this.model.addShape(new Oval(name, 0, 0, 0, 0, "Red"),
                0, 0, 0,
                0, name);
        break;

      case "circle":
        this.model.addShape(new Circle(name, 0, 0, 0, 0, "Red"),
                0, 0, 0,
                0, name);
        break;
      case "square":
        this.model.addShape(new Square(name, 0, 0, 0, 0, "Red"),
                0, 0, 0,
                0, name);
        break;

      case "triangle":
        this.model.addShape(new Triangle(name, 0, 0, 0, 0, "Red"),
                0, 0, 0,
                0, name);
        break;

      default:
        // Do nothing if not one of those cases
        break;
    }
    return null;
  }

  // added the animations into a array list
  @Override
  public AnimationBuilder<IAnimatorV2> addMotion(String name, int t1, int x1, int y1, int w1,
                                                 int h1, int r1, int g1, int b1, int t2, int x2,
                                                 int y2, int w2, int h2, int r2, int g2, int b2) {

    if (x1 != x2 || y1 != y2) {
      this.model.addTransformMove(name, t1, t2, x1, y1, x2, y2);
    }

    if (r1 != r2 || b1 != b2 || g1 != g2) {
      this.model.addTransformColor(name, r1, b1, g1, r2, b2, g2, t1, t2);
    }

    if (w1 != w2 || h1 != h2) {
      this.model.addTransformScale(name, w1, h1, w2, h2, t1, t2);
    }

    if (x1 == x2 && y1 == y2 && w1 == w2 && h1 == h2 && r1 == r2 && g1 == g2 && b1 == b2) {
      this.model.addNoTransform(name, x1, x2, y1, y2, w1, w2, h1, h2, r1, r2, b1, b2,
              g1, g2, t1, t2);
    }

    return null;
  }
}



