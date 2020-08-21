package cs5004.animator.model;

/**
 * The NoTransform class implements the ITransform interface. Each NoTransform object has a shape,
 * initial x, y, width, height, r, g, b, new x, y, width, height, r, g, b, as well as start and end
 * frames.
 */
public class NoTransform implements ITransform {

  private IShape shape;
  private int r1;
  private int b1;
  private int g1;
  private int r2;
  private int b2;
  private int g2;
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  private int width1;
  private int height1;
  private int width2;
  private int height2;
  private int sFrame;
  private int eFrame;

  /**
   * Constructs an object for the NoTransformation class and initializes a shape, x1, x2, y1, y2,
   * width1, width2, height1, height2, r1, r2, b1, b2, g1, g2, sFrame, and eFrame.
   *
   * @param shape   the shape you want to not transform
   * @param x1      the initial x position
   * @param x2      the same x position
   * @param y1      the initial y position
   * @param y2      the same y position
   * @param width1  the initial width
   * @param width2  the same width
   * @param height1 the initial height
   * @param height2 the same height
   * @param r1      the initial r value
   * @param r2      the same r value
   * @param b1      the initial b value
   * @param b2      the same b value
   * @param g1      the initial g value
   * @param g2      the same g value
   * @param sFrame  the start frame
   * @param eFrame  the end frame
   */
  public NoTransform(IShape shape, int x1, int x2, int y1, int y2, int width1, int width2,
                     int height1, int height2, int r1, int r2, int b1,
                     int b2, int g1, int g2, int sFrame, int eFrame) {

    this.shape = shape;
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.r1 = r1;
    this.b1 = b1;
    this.g1 = g1;
    this.r2 = r2;
    this.b2 = b2;
    this.g2 = g2;
    this.sFrame = sFrame;
    this.eFrame = eFrame;
    this.width1 = width1;
    this.height1 = height1;
    this.width2 = width2;
    this.height2 = height2;

  }

  @Override
  public void transform(int currentFrame) {

    this.shape.setX((this.x2));
    this.shape.setY((this.y2));
    this.shape.setWidth(this.width2);
    this.shape.setHeight(this.height2);
    this.shape.changeColor(this.r2, this.g2, this.b2);
  }

  @Override
  public boolean isWithinFrame(int currentFrame) {
    return currentFrame >= sFrame && currentFrame <= eFrame;
  }

  @Override
  public int getSFrame() {
    return this.sFrame;
  }

  @Override
  public int getEFrame() {
    return this.eFrame;
  }

  @Override
  public IShape getShape() {
    return this.shape;
  }

  @Override
  public String getTransformType() {
    return "no transform";
  }

  @Override
  public int getX1T() {
    return this.x1;
  }

  @Override
  public int getX2T() {
    return this.x2;
  }

  @Override
  public int getY1T() {
    return this.y1;
  }

  @Override
  public int getY2T() {
    return this.y2;
  }

  @Override
  public int getR1T() {
    return this.r1;
  }

  @Override
  public int getR2T() {
    return this.r2;
  }

  @Override
  public int getB1Tr() {
    return this.b1;
  }

  @Override
  public int getB2Tr() {
    return this.b2;
  }

  @Override
  public int getG1T() {
    return this.g1;
  }

  @Override
  public int getG2T() {
    return this.g2;
  }

  @Override
  public int getW1T() {
    return this.width1;
  }

  @Override
  public int getW2T() {
    return this.width2;
  }

  @Override
  public int getH1T() {
    return this.height1;
  }

  @Override
  public int getH2T() {
    return this.height2;
  }
}
