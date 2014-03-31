package com.interactivegraphicsapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFrame extends JFrame
{
    private BorderLayout layout;
    private Canvas canvas;
    private JButton undoButton;
    private JButton clearButton;
    private JComboBox colorComboBox;
    private JComboBox shapeComboBox;
    private JCheckBox filledCheckBox;
    private JLabel statusBarLabel;
    
    private final String[] colors = 
                                    { "BLACK",       "BLUE",    "CYAN", 
                                      "DARK_GRAY",   "GRAY",    "GREEN", 
                                      "LIGHT_GRAY",  "MAGENTA", "ORANGE", 
                                      "PINK", "RED", "WHITE",   "YELLOW"
                                    };
    
    private final Color[] color = 
                                    { Color.BLACK,      Color.BLUE,    Color.CYAN, 
                                      Color.DARK_GRAY,  Color.GRAY,    Color.GREEN, 
                                      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
                                      Color.PINK,       Color.RED,     Color.WHITE, Color.YELLOW
                                    };
    
    private final String[] shapes = {"LINE", "OVAL", "RECTANGLE"};
    
    private final JPanel northPanel;
    
    public DrawFrame()
    {
        super("Anewball Drawing");                
        
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 5));
        
        layout = new BorderLayout(5, 5);
        setLayout(layout);
        
        undoButton     = new JButton("Undo");
        clearButton    = new JButton("Clear");
        colorComboBox  = new JComboBox(colors);
        shapeComboBox  = new JComboBox(shapes);
        filledCheckBox = new JCheckBox("Filled");
        
        // set events to the colorComboBox
        colorComboBox.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent event) 
            {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    canvas.setCurrentColor(color[colorComboBox.getSelectedIndex()]);
            }
        });
        
        // set events to the shapeComboBox
        shapeComboBox.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent event) 
            {
               if (event.getStateChange() == ItemEvent.SELECTED)
                   canvas.setShapeType(shapeComboBox.getSelectedIndex());
            }
        });
        
        // set events to the undoButton
        undoButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                canvas.clearLastShape();
            }
        });
        
        // set events to the clearButton
        clearButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                canvas.clearDrawing();
            }
        });
        
        // set event to the filledCheckBox
        filledCheckBox.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent event) 
            {
                if (filledCheckBox.isSelected())
                    canvas.setFilledShape(true);
                else
                    canvas.setFilledShape(false);
            }
        });
        
        northPanel.add(undoButton);
        northPanel.add(clearButton);
        northPanel.add(colorComboBox);
        northPanel.add(shapeComboBox);
        northPanel.add(filledCheckBox);
        
        statusBarLabel = new JLabel("(0, 0)");
        canvas = new Canvas(statusBarLabel);
        
        add(northPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(statusBarLabel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new DrawFrame();
    }
}
