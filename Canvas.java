package com.interactivegraphicsapplication;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Canvas extends JPanel
{
    private final MyShape[] shape;
    private int shapeCount;
    private int shapeType;
    private MyShape currentShape;
    private Color currentColor;
    private boolean filledShape;
    private final JLabel statusLabel;
    
    public Canvas(JLabel label)
    {
        statusLabel  = label;
        shape        = new MyShape[100];
        shapeCount   = 0;
        currentShape = null;
        currentColor = Color.BLACK;
        setBackground(Color.WHITE);
        addMouseListener(new EventCanvas());
        addMouseMotionListener(new EventCanvas());
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        // draw all the shape
        for (int i = 0; i < shapeCount; i++)
            shape[i].draw(g);
        
        // if the current shape is not null it will be draw
        if (currentShape != null)
            currentShape.draw(g);
    }
    
    public void setShapeType(int type)
    {
        shapeType = type;
    }
    
    public void setCurrentColor(Color color)
    {
        currentColor = color;
    }
    
    public void setFilledShape(boolean fill)
    {
        filledShape = fill;
    }
    
    public void clearLastShape()
    {
        currentShape = null;
        if (shapeCount > 0)
        {
            shape[shapeCount] = null;
            shapeCount--;
        }
        repaint();
    }
    
    public void clearDrawing()
    {        
        for (int i = 0; i < shapeCount; i++)
            shape[i] = null;
            
        shapeCount = 0;
        repaint();
    }
    
    private class EventCanvas extends MouseAdapter implements MouseMotionListener
    {
        @Override
        public void mousePressed(MouseEvent event)
        {
            switch(shapeType)
            {
                case 0: // Line
                    MyLine line = new MyLine(currentColor);
                    line.setPoint1(event.getX(), event.getY());
                    currentShape = line;
                    break;
                case 1: // Oval   
                    MyOval oval = new MyOval(currentColor);
                    oval.setFilled(filledShape);
                    oval.setPoint1(event.getX(), event.getY());
                    currentShape = oval;
                    break;
                case 2: // Rectangle
                    MyRectangle rectangle = new MyRectangle(currentColor);
                    rectangle.setFilled(filledShape);
                    rectangle.setPoint1(event.getX(), event.getY());
                    currentShape = rectangle;
                    break;
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent event)
        {
            if (currentShape != null)
            {
                switch(shapeType)
                {
                    case 0: // Line
                        ((MyLine)currentShape).setPoint2(event.getX(), event.getY());                        
                        break;
                    case 1: // Oval   
                        ((MyOval)currentShape).setPoint2(event.getX(), event.getY());                        
                        break;
                    case 2: // Rectangle
                        ((MyRectangle)currentShape).setPoint2(event.getX(), event.getY());                                              
                        break;
                }  
                shape[shapeCount] = currentShape;
                currentShape      = null;
                shapeCount++;
                repaint();
            }
        }
        
        @Override
        public void mouseMoved(MouseEvent event)
        {            
           statusLabel.setText(String.format("(%d, %d)", event.getX(), event.getY()));           
        }
        
        @Override
        public void mouseDragged(MouseEvent event)
        {
            if (currentShape != null)
            {
                switch (shapeType)
                {
                    case 0: // line                        
                        ((MyLine)currentShape).setPoint2(event.getX(), event.getY());                      
                        break;
                    case 1: // Oval
                        ((MyOval)currentShape).setPoint2(event.getX(), event.getY());
                        break;
                    case 2: // Rectangle
                        ((MyRectangle)currentShape).setPoint2(event.getX(), event.getY());
                        break;
                }
                
                statusLabel.setText(String.format("(%d, %d)", event.getX(), event.getY()));
                repaint();
            }
        }
    }
}
