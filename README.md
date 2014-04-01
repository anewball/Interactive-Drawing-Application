Interactive-Drawing-Application
===============================

This application let one draw an image by using line, oval, and rectangle.

Classes:
 - MyShape
 - MyLine
 - MyBoundedShape
 - MyRectangle
 - MyOval
 - Canvas
 - DrawFrame
 
The MyShape class is declared as an abstract and contain only one method "draw" with signature:
 - public void draw(Graphics g)
 
The MyLine class draw a line and it is a subclass of MyShape. The following are the public methods:
 - public void setPoint1(int x1, int y1)
 - public void setPoint2(int x2, int y2)
 - public void setColor(Color c)
 - public void draw(Graphics g)

The MyBoundedShape class is an abstract subclass of MyShape. The following are the public methods:
 - public int getComponentX()
 - public int getComponentY()
 - public void setPoint1(int x1, int y1)
 - public void setPoint2(int x2, int y2)
 - public int getWidth()
 - public int getHeight()
 - public void setFilled(boolean fill)
 - public boolean getFilled()
 - public void setColor(Color c)
 - public Color getColor()
 - public abstract void draw(Graphics g)
 
The MyRectangle class draw a rectangle and it is a subclass of MyBoundedShape. The following are the public methods:
 - public void draw(Graphics g)
 - Plus the inherited from MyShape and MyBoundedShape
 
The MyOval class draw an oval and it is a subclass of MyBoundedShape. The following are the public methods:
 - public void draw(Graphics g)
 - Plus the inherited from MyShape and MyBoundedShape

The Canvas class is a JPanel where all the drawing will be performed on. The following are the public methods and inner class:
 - public void paintComponent(Graphics g)
 - public void setShapeType(int type)
 - public void setCurrentColor(Color color)
 - public void setFilledShape(boolean fill)
 - public void clearLastShape()
 - public void clearDrawing()
 - private class EventCanvas extends MouseAdapter implements MouseMotionListener
   - public void mousePressed(MouseEvent event)
   - public void mouseReleased(MouseEvent event)
   - public void mouseMoved(MouseEvent event)
   - public void mouseDragged(MouseEvent event)
