
package cs5004.animator.model;

/**
 * The NoTransform class implements the ITransform interface. Each NoTransform object has a shape,
 * initial width, height new width, height, as well as start and end frames.
 */
public class TransformScale implements ITransform {
  private IShape shape;
  private int width1;
  private int height1;
  private int width2;
  private int height2;
  private int sFrame;
  private int eFrame;

  /**
   * Constructs a TransformScale object and initializes shape, width1, height1, width2, height2,
   * sFrame, and eFrame.
   *
   * @param shape   the shape that you want to scale
   * @param width1  the initial width
   * @param height1 the initial height
   * @param width2  the new width
   * @param height2 the new height
   * @param sFrame  the start frame
   * @param eFrame  the end frame
   */
  public TransformScale(IShape shape, int width1, int height1, int width2, int height2,
                        int sFrame, int eFrame) {
    if (width1 < 0 || height1 < 0) {
      throw new IllegalArgumentException("width or height cannot be less than 0");
    }
    this.shape = shape;
    this.width1 = width1;
    this.height1 = height1;
    this.width2 = width2;
    this.height2 = height2;
    this.sFrame = sFrame;
    this.eFrame = eFrame;
  }

  private float tweeningFunction(int frame, int scale1, int scale2) {
    float result = scale1 * (((float) this.eFrame - frame) / ((float) this.eFrame - this.sFrame))
            + scale2 * ((frame - (float) this.sFrame) / ((float) this.eFrame - this.sFrame));
    return result;
  }

  @Override
  public void transform(int currentFrame) {
    this.shape.setWidth(tweeningFunction(currentFrame, this.width1, this.width2));
    this.shape.setHeight(tweeningFunction(currentFrame, this.height1, this.height2));
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
    return "scale";
  }

  @Override
  public int getX1T() {
    return 0;
  }

  @Override
  public int getX2T() {
    return 0;
  }

  @Override
  public int getY1T() {
    return 0;
  }

  @Override
  public int getY2T() {
    return 0;
  }

  @Override
  public int getR1T() {
    return 0;
  }

  @Override
  public int getR2T() {
    return 0;
  }

  @Override
  public int getB1Tr() {
    return 0;
  }

  @Override
  public int getB2Tr() {
    return 0;
  }

  @Override
  public int getG1T() {
    return 0;
  }

  @Override
  public int getG2T() {
    return 0;
  }

  @Override
  public int getW1T() {
    return width1;
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
