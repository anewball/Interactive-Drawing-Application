package com.interactivegraphicsapplication;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyBoundedShape extends MyShape
{
    private int componentX;
    private int componentY;    
    
    private int width;
    private int height;
    
    private boolean filled;
    
    private Color color;
    
    public MyBoundedShape(Color c)
    {
        color = c;
    }
    
    public int getComponentX()
    {
        return componentX;
    }
    
    public int getComponentY()
    {
        return componentY;
    }
    
    public void setPoint1(int x1, int y1)
    {
        if (x1 > -1 && y1 > -1)
        {
            componentX = x1;
            componentY = y1;
        }
    }  
    
     public void setPoint2(int x2, int y2)
     {
         if (x2 > -1 && y2 > -1)
         {
             width  = Math.abs(componentX - x2);
             height = Math.abs(componentY - y2);
         }
     }
     
     public int getWidth()
     {
         return width;
     }
     
     public int getHeight()
     {
         return height;
     }
     
     public void setFilled(boolean fill)
     {
         filled = fill;
     }
     
     public boolean getFilled()
     {
         return filled;
     }
     
     public void setColor(Color c)
     {
         color = c;
     }
     
     public Color getColor()
     {
         return color;
     }
     
     public abstract void draw(Graphics g);
}
