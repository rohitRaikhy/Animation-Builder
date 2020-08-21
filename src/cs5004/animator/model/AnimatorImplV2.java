package cs5004.animator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * This AnimatorImplV2 class implements the IAnimatorV2 interface. Each object has a canvas hashmap,
 * animation hashmap, shape builder, animation builder, output, appearsAtDisappearsAt hashmap, and
 * transformations list.
 */
public class AnimatorImplV2 implements IAnimatorV2 {
  private HashMap<String, IShape> canvas;
  private StringBuilder shapeBuilder;
  private StringBuilder animationBuilder;
  private HashMap<IShape, ArrayList<Integer>> appearsAtDisappearsAt;
  private ArrayList<ITransform> transformationsList;


  /**
   * Constructs an AnimatorImplV2 object and initializes the canvas, animationMap,
   * appearsAtDisappearsAt, shapeBuilder, animationBuilder, output, and transformationsList.
   */
  public AnimatorImplV2() {
    canvas = new HashMap<>();
    appearsAtDisappearsAt = new HashMap<>();
    shapeBuilder = new StringBuilder();
    animationBuilder = new StringBuilder();
    //add the array list for transformations.
    transformationsList = new ArrayList<>();

  }

  /**
   * Helper method for add shapes string builder.
   *
   * @param shape        the shape to be added.
   * @param xPos         the x position of the shape.
   * @param yPos         the y position of the shape.
   * @param appearsAt    when the shape appears on the canvas.
   * @param disappearsAt when the shape disappears on the canvas.
   */
  private void addToShapeString(IShape shape, double xPos, double yPos, int appearsAt,
                                int disappearsAt) {

    if (canvas.size() == 1) {
      shapeBuilder.append("Shapes:" + "\n" + "Name: " + shape.getName() + "\n" + "Type: "
              + shape.getType() + "\n" + "Min corner: (" + xPos + "," + yPos + "), Width: "
              + shape.getWidth()
              + ", Height: " + shape.getHeight() + ", Color: " + shape.getColor()
              + "\nAppears at t=" + appearsAt + "\nDisappears at t=" + disappearsAt);
    } else {
      shapeBuilder.append("\n\n" + "Name: " + shape.getName() + "\n" + "Type: "
              + shape.getType() + "\n" + "Min corner: (" + xPos + "," + yPos + "), Width: "
              + shape.getWidth()
              + ", Height: " + shape.getHeight() + ", Color: " + shape.getColor()
              + "\nAppears at t=" + appearsAt + "\nDisappears at t=" + disappearsAt);
    }
  }

  /**
   * Helper method to add to the list of start and end times.
   *
   * @param appearsAt    the time the shape appears
   * @param disappearsAt the time the shape disappears
   * @return the list of appears and disappears.
   */
  private ArrayList addToAppearsAtHashMap(int appearsAt, int disappearsAt) {
    ArrayList<Integer> appearsAndDisappears = new ArrayList<>();
    appearsAndDisappears.add(appearsAt);
    appearsAndDisappears.add(disappearsAt);
    return appearsAndDisappears;
  }

  @Override
  public void addShape(IShape shape, double xPos, double yPos, int appearsAt, int disappearsAt,
                       String shapeName) {
    if (canvas.containsKey(shapeName)) {
      throw new IllegalArgumentException("Shape is already in the canvas.");
    }
    if (xPos < 0 || yPos < 0 || appearsAt < 0 || disappearsAt < 0 || appearsAt > disappearsAt) {
      throw new IllegalArgumentException("arguments cannot be less than 0.");
    } else {
      canvas.put(shapeName, shape);
      ArrayList appearsAndDisappears = addToAppearsAtHashMap(appearsAt, disappearsAt);
      appearsAtDisappearsAt.put(shape, appearsAndDisappears);
    }
    addToShapeString(shape, xPos, yPos, appearsAt, disappearsAt);
  }

  @Override
  public void addTransformMove(String name, int sFrame, int eFrame, int x1, int y1, int x2,
                               int y2) {

    IShape shape = getShape(name);
    ITransform transformMove = new TransformMove(shape, x1, x2, y1, y2, sFrame, eFrame);
    transformationsList.add(transformMove);
  }

  @Override
  public void addTransformColor(String name, int r1, int b1, int g1, int r2,
                                int b2, int g2, int sFrame, int eFrame) {

    IShape shape = getShape(name);
    ITransform transformColor = new TransformColor(shape, r1, b1, g1, r2,
            b2, g2, sFrame, eFrame);
    transformationsList.add(transformColor);
  }

  @Override
  public void addTransformScale(String name, int width1, int height1, int width2, int height2,
                                int sFrame, int eFrame) {
    IShape shape = getShape(name);
    ITransform transformScale = new TransformScale(shape, width1, height1, width2, height2, sFrame,
            eFrame);
    transformationsList.add(transformScale);
  }

  @Override
  public void addNoTransform(String name, int x1, int x2, int y1, int y2, int width1, int width2,
                             int height1, int height2, int r1, int r2, int b1,
                             int b2, int g1, int g2, int sFrame, int eFrame) {
    IShape shape = getShape(name);
    ITransform noTransform = new NoTransform(shape, x1, x2, y1, y2, width1, width2,
            height1, height2, r1, r2, b1, b2, g1, g2, sFrame, eFrame);
    transformationsList.add(noTransform);
  }

  @Override
  public int getLastFrame() {
    int maxFrame = 0;
    for (ITransform transformation : transformationsList) {
      if (transformation.getEFrame() > maxFrame) {
        maxFrame = transformation.getEFrame();
      }
    }
    return maxFrame;
  }

  @Override
  public ArrayList<IShape> getShapesAtFrame(int frame) {
    //this is for the shapesAtFrameList
    ArrayList<IShape> shapesAtFrameList = new ArrayList<>();
    for (ITransform transformation : transformationsList) {
      if (transformation.isWithinFrame(frame)) {
        transformation.transform(frame);
        // add the shape to the list.
        shapesAtFrameList.add(transformation.getShape());
      }
    }
    return shapesAtFrameList;
  }

  @Override
  public Set<String> getNames() {
    return canvas.keySet();
  }

  @Override
  public IShape getShape(String shapeName) {
    if (canvas.containsKey(shapeName)) {
      return canvas.get(shapeName);
    } else {
      throw new IllegalArgumentException("Shape not in the canvas.");
    }
  }

  @Override
  public String toString() {
    if (canvas.size() == 0) {
      return "There are no shapes on the canvas.";
    } else {
      return shapeBuilder.toString() + "\n\n"
              + animationBuilder.substring(0, animationBuilder.lastIndexOf("\n"));
    }
  }

  @Override
  public ArrayList<IShape> getAllInitShapes() {
    ArrayList<IShape> initShapes = new ArrayList<>();
    for (ITransform transformation : transformationsList) {

      transformation.transform(transformation.getSFrame());

      IShape initShape = transformation.getShape();
      if (!(initShapes.contains(initShape))) {
        initShapes.add(initShape);
      }
    }
    return initShapes;
  }

  @Override
  public HashMap<String, ArrayList<Integer>> getAllStartEndTimes() {
    HashMap<String, ArrayList<Integer>> startEndTimes = new HashMap<>();
    for (ITransform transformation : transformationsList) {
      IShape shape = transformation.getShape();
      ArrayList<Integer> appearsAndDisappears = new ArrayList<>();
      appearsAndDisappears.add(transformation.getSFrame());
      appearsAndDisappears.add(transformation.getEFrame());
      startEndTimes.putIfAbsent(shape.getName(), appearsAndDisappears);
    }
    // now iterate over the transformations again and update sframe and eframe to min max.
    for (ITransform transformation : transformationsList) {
      ArrayList<Integer> newAppearsAndDisappears = new ArrayList<>();
      IShape shape = transformation.getShape();
      int sFrameMap = startEndTimes.get(shape.getName()).get(0);
      int eFrameMap = startEndTimes.get(shape.getName()).get(1);
      if (transformation.getSFrame() < sFrameMap) {
        sFrameMap = transformation.getSFrame();
      }
      if (transformation.getEFrame() > eFrameMap) {
        eFrameMap = transformation.getEFrame();
      }
      newAppearsAndDisappears.add(sFrameMap);
      newAppearsAndDisappears.add(eFrameMap);
      startEndTimes.replace(shape.getName(), newAppearsAndDisappears);
    }
    return startEndTimes;
  }

  @Override
  public ArrayList<ITransform> getAllTransformations() {
    ArrayList<ITransform> allTransformList = new ArrayList<>();
    for (ITransform transformation : transformationsList) {
      allTransformList.add(transformation);
    }
    return allTransformList;
  }
}
