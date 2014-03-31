package com.interactivegraphicsapplication;

import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape
{
    private int componentX1;
    private int componentY1;
    
    private int componentX2;
    private int componentY2;
    
    private Color color;
    
    public MyLine(Color c)
    {
        color = c;         
    }
//***************************************************************************************************
    
    
    
    
    
//*****************************************************SETTERS***************************************    
    public void setPoint1(int x1, int y1)
    {
        if (x1 > -1 && y1 > -1)
        {
            componentX1 = x1;
            componentY1 = y1;
        }
    }  
    
     public void setPoint2(int x2, int y2)
     {
         if (x2 > -1 && y2 > -1)
         {
             componentX2 = x2;
             componentY2 = y2;
         }
     }
     
     public void setColor(Color c)
     {
         color = c;
     }
//***************************************************************************************************
     
     
     
     
     
//***************************************************************************************************
    @Override
    public void draw(Graphics g) 
    {
       g.setColor(color);       
       g.drawLine(componentX1, componentY1, componentX2, componentY2);
    }    
}
