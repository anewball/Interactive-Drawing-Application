package com.interactivegraphicsapplication;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape
{    
    public MyOval(Color c)
    {
        super(c);
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        
        if (getFilled())
            g.fillOval(getComponentX(), getComponentY(), getWidth(), getHeight());
        else
            g.drawOval(getComponentX(), getComponentY(), getWidth(), getHeight());
    }    
}
