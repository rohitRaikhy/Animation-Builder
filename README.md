# Animation-Builder

# Context

A picture is worth a thousand words, and moving pictures are worth many more.

Pictures and moving pictures (animations) can be used to succinctly and effectively illustrate many things. For example, a stationary histogram visually depicts the distribution of some data points. A histogram with moving bar heights visually depicts music (e.g. a music equalizer). Animating graphs can be used to show useful trends in data much more effectively than presenting the same reasoning using raw numbers and text (see here for a visualization of the trend of life expectancy with GDP over time using only circles). A fireworks display is simply a bunch of points moving in certain ways. The Towers of Hanoi problem can be illustrated more effectively as an animation solving it, rather than a description of steps of an algorithm. Many algorithms can be similarly visualized in a way that illustrates how they work more succinctly than descriptions or code. Here are some examples of such visualizations:

![smalldemo](https://user-images.githubusercontent.com/35156624/90906126-2ba8a800-e39f-11ea-9ab0-58348f7423d8.gif)
![toh-5](https://user-images.githubusercontent.com/35156624/90906131-2cd9d500-e39f-11ea-875c-47f4c73e33ea.gif)
![night](https://user-images.githubusercontent.com/35156624/90906142-2ea39880-e39f-11ea-9258-bbfec54dca47.gif)
![Uploading big-bang-big-crunch.gif…]()


** Design of Model ** In our model, we have IShape, ITransform, and IAnimatorV2 interfaces. The IShape interface focuses on requirements for each shape such as x, y, width, height, color, etc. The ITransformV2 interface deals with specific transformations done to the shape such as move, scale, and change color. Finally, the IAnimatorV2 interface takes care of the animator as a whole, keeping track of not only where shapes are on the canvas, but also the transformations that are set to take place. From the previous Assignment, we created a new interface that handled Transformations. We also redesigned our IAnimator to include these changes. These are present in IAnimatorV2.

** Design of View ** In our view, we have an IView interface that abstracts commonalities between the visual and text view. We also have an IViewShape interface that extends IView and includes methods necessary for the JFrameView. The AbstractViewShape and JFrameView implement the IViewShape while the DrawingPanel, MyOval, and MyRectangle help support this implementation. On the other hand, the IViewText interface extends IView to include methods mandatory for the TextView implementation. The TextView class implements the IViewText interface.

** Design of Controller ** We decided to create one controller with multiple constructors that handle different inputs. We have a default constructor for an IAnimator model and IViewShape view. Second, we have a constructor for an IAnimator model, IViewShape view, and an inputted speed. Third, we have a default constructor for an IAnimator model and IViewText view. Lastly, we have a constructor for an IAnimator model, IViewText view, and an inputted speed.

** Main - EasyAnimator** This is the main method for the program.

All of these animations are built using Java Swing framework and awt. 
