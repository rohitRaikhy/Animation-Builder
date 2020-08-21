package cs5004.animator.NewView;

import java.awt.event.ActionListener;

import cs5004.animator.view.DrawingPanel;
import cs5004.animator.view.IViewShape;

/**
 * This IViewShape2 interface extends the IViewShape and includes functionality to set the listener,
 * create list of shapes, get the drawing panel, and get the selected index from the list of
 * shapes.
 */
public interface IViewShape2 extends IViewShape {
  /**
   * Sets the Action Lister for the buttons.
   *
   * @param listener the action listener for the button
   */
  void setListener(ActionListener listener);

  /**
   * Sets the list of shapes on the screen.
   *
   * @param shape the name of the shape shape you would like to add to list
   */
  void setList(String shape);

  /**
   * Gets the current drawing panel.
   *
   * @return the drawing panel
   */
  DrawingPanel getPanel();

  /**
   * Gets the selected index.
   *
   * @return the selected index
   */
  String getSelectedIndex();
}
