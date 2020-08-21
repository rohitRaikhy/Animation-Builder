** Design of Model **
In our model, we have IShape, ITransform, and IAnimatorV2 interfaces. The IShape interface focuses on 
requirements for each shape such as x, y, width, height, color, etc. The ITransformV2 interface deals
with specific transformations done to the shape such as move, scale, and change color. Finally, the 
IAnimatorV2 interface takes care of the animator as a whole, keeping track of not only where shapes 
are on the canvas, but also the transformations that are set to take place. From the previous 
Assignment, we created a new interface that handled Transformations. We also redesigned our 
IAnimator to include these changes. These are present in IAnimatorV2.

** Design of View **
In our view, we have an IView interface that abstracts commonalities between the visual and text 
view. We also have an IViewShape interface that extends IView and includes methods necessary for 
the JFrameView. The AbstractViewShape and JFrameView implement the IViewShape while the 
DrawingPanel, MyOval, and MyRectangle help support this implementation. On the other hand, the 
IViewText interface extends IView to include methods mandatory for the TextView implementation. 
The TextView class implements the IViewText interface. 

** Design of Controller **
We decided to create one controller with multiple constructors that handle different inputs. We have
a default constructor for an IAnimator model and IViewShape view. Second, we have a constructor 
for an IAnimator model, IViewShape view, and an inputted speed. Third, we have a default constructor
for an IAnimator model and IViewText view. Lastly, we have a constructor for an IAnimator model, 
IViewText view, and an inputted speed. 

** Main - EasyAnimator**
This is the main method for the program.



