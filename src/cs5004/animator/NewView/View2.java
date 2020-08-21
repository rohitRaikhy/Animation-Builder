package cs5004.animator.NewView;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import cs5004.animator.view.DrawingPanel;
import cs5004.animator.view.MyOval;
import cs5004.animator.view.MyRectangle;

/**
 * This View2 class extends JFrame and implements the IViewShape2 interface. It includes added
 * features to our view including game buttons, file menus, and the list of shapes on the canvas.
 */
public class View2 extends JFrame implements IViewShape2 {
  private JButton playButton;
  private JButton startButton;
  private JButton stopButton;
  private JButton checkButton;
  private JList listShapes;
  private JMenuItem saveAs;
  private DrawingPanel panel;
  private DefaultListModel listModel;
  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * This constructs a View2 object and initializes it to the given x, y, width, height.
   *
   * @param x      the x position of the frame
   * @param y      the y position of the frame
   * @param width  the width of the frame
   * @param height the height of the frame
   */
  public View2(int x, int y, int width, int height) {
    super();
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    display();
  }

  @Override
  public void display() {
    // set the screen settings
    setSize(1000, 1000);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // initialize a drawing panel and scroll plane
    panel = new DrawingPanel(this.x, this.y, this.width, this.height);
    JScrollPane scrollPane = new JScrollPane(panel);


    // set layout
    setLayout(new FlowLayout());

    // make a button play
    playButton = new JButton("Play");
    this.add(playButton);
    playButton.setActionCommand("play");

    stopButton = new JButton("Stop");
    this.add(stopButton);
    stopButton.setActionCommand("stop");

    startButton = new JButton("Start");
    this.add(startButton);
    startButton.setActionCommand("start");

    // add menu options
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    JMenu fileMenu = new JMenu("File");
    menuBar.add(fileMenu);
    saveAs = new JMenuItem("Save As");
    fileMenu.add(saveAs);
    saveAs.setActionCommand("save");

    // add list of shapes on the canvas, in order to help with the remove options.
    listModel = new DefaultListModel();
    listShapes = new JList(listModel);
    this.add(listShapes);
    JScrollPane listScrollPane = new JScrollPane(listShapes);
    this.add(listScrollPane);
    listShapes.setVisibleRowCount(4);
    checkButton = new JButton("Check");
    this.add(checkButton);
    checkButton.setActionCommand("Check");

    // add the scroll and make display visible
    add(scrollPane);
    setVisible(true);
  }

  @Override
  public void draw(Graphics g) {
    // NEEDED TO IMPLEMENT IVIEWSHAPE BUT DIDN'T NEED THE METHOD
  }

  @Override
  public void drawRectangle(int x, int y, int w, int h, Color color) {
    panel.drawShape(new MyRectangle(x, y, w, h, color));
  }

  @Override
  public void drawOval(int x, int y, int w, int h, Color color) {
    panel.drawShape(new MyOval(x, y, w, h, color));
  }

  @Override
  public void refreshCanvas() {
    panel.repaint();
  }

  @Override
  public void setListener(ActionListener listener) {
    playButton.addActionListener(listener);
    startButton.addActionListener(listener);
    stopButton.addActionListener(listener);
    saveAs.addActionListener(listener);
    checkButton.addActionListener(listener);
  }

  @Override
  public void setList(String shape) {
    listModel.addElement(shape);
  }

  @Override
  public DrawingPanel getPanel() {
    return panel;
  }

  @Override
  public String getSelectedIndex() {
    int index = listShapes.getSelectedIndex();
    return listModel.get(index).toString();
  }

}


