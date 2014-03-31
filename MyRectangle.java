package com.interactivegraphicsapplication;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape
{
    public MyRectangle(Color c)
    {
        super(c);
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        
        if (getFilled())
            g.fillRect(getComponentX(), getComponentY(), getWidth(), getHeight());
        else
            g.drawRect(getComponentX(), getComponentY(), getWidth(), getHeight());
    }
}
