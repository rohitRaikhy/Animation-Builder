package cs5004.animator.model;

/**
 * The TransformMove class implements the ITransform interface. Each TransformMove object has a
 * shape, initial x, y, new x, y, as well as start and end frames.
 */
public class TransformMove implements ITransform {
  private IShape shape;
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  private int sFrame;
  private int eFrame;

  /**
   * Constructs a TransformMove object and initializes the shape, x1, x2, y1, y2, sFrame, and
   * eFrame.
   *
   * @param shape  the shape you want to move
   * @param x1     the initial x position
   * @param x2     the new x position
   * @param y1     the initial y position
   * @param y2     the new y position
   * @param sFrame the start frame
   * @param eFrame the end frame
   */
  public TransformMove(IShape shape, int x1, int x2, int y1, int y2, int sFrame, int eFrame) {
    this.shape = shape;
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.sFrame = sFrame;
    this.eFrame = eFrame;
  }


  private float tweeningFunction(int frame, int pos1, int pos2) {

    float result = pos1 * (((float) this.eFrame - frame) / ((float) this.eFrame - this.sFrame))
            + pos2 * ((frame - (float) this.sFrame) / ((float) this.eFrame - this.sFrame));

    return result;
  }

  @Override
  public void transform(int currentFrame) {
    this.shape.setX(tweeningFunction(currentFrame, this.x1, this.x2));
    this.shape.setY(tweeningFunction(currentFrame, this.y1, this.y2));
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
    return "move";
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
