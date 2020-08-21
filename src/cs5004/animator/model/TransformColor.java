package cs5004.animator.model;


/**
 * The TransformColor class implements the ITransform interface. Each TransformColor object has a
 * shape, initial r, g, b, new r, g, b, as well as start and end frames.
 */
public class TransformColor implements ITransform {
  private IShape shape;
  private int r1;
  private int b1;
  private int g1;
  private int r2;
  private int b2;
  private int g2;
  private int sFrame;
  private int eFrame;

  /**
   * Constructs a TransformColor object and initialize the shape, r1, b1, g1, r2, b2, g2, sFrame,
   * and eFrame.
   *
   * @param shape  the shape you would like to transform the color
   * @param r1     the initial r value
   * @param b1     the initial b value
   * @param g1     the initial g value
   * @param r2     the new r value
   * @param b2     the new b value
   * @param g2     the new g value
   * @param sFrame the start frame
   * @param eFrame the end frame
   */
  public TransformColor(IShape shape, int r1, int b1, int g1, int r2,
                        int b2, int g2, int sFrame, int eFrame) {
    if (r1 < 0 || b1 < 0 || g1 < 0 || r2 < 0 || b2 < 0 || g2 < 0) {
      throw new IllegalArgumentException("red green blue cannot be less than 0");
    }
    this.shape = shape;
    this.r1 = r1;
    this.b1 = b1;
    this.g1 = g1;
    this.r2 = r2;
    this.b2 = b2;
    this.g2 = g2;
    this.sFrame = sFrame;
    this.eFrame = eFrame;
  }

  private float tweeningFunction(int frame, int color1, int color2) {

    float result = color1 * (((float) this.eFrame - frame) / ((float) this.eFrame - this.sFrame))
            + color2 * ((frame - (float) this.sFrame) / ((float) this.eFrame - this.sFrame));

    return result;
  }


  @Override
  public void transform(int currentFrame) {
    float newRed = tweeningFunction(currentFrame, this.r1, this.r2);
    float newBlue = tweeningFunction(currentFrame, this.b1, this.b2);
    float newGreen = tweeningFunction(currentFrame, this.g1, this.g2);
    this.shape.changeColor(newRed, newGreen, newBlue);
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
    return "color";
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
    return 0;
  }

  @Override
  public int getW2T() {
    return 0;
  }

  @Override
  public int getH1T() {
    return 0;
  }

  @Override
  public int getH2T() {
    return 0;
  }

}
