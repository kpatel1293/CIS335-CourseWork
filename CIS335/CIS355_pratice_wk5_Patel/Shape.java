package finlpp5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import labwk4.StockClass;
import labwk4.GUIClass.addStockHandlerBtn;


@SuppressWarnings("serial")
public class Shape extends JFrame
{
	//private instances
    JLabel clrLbl, spLbl;
    JRadioButton cRed, cBlue, cYellow;
    ButtonGroup colorList, shapesList;
    JRadioButton btnCircle, btnSquare, btnRectangle;
    JButton submitBtn; 
	
    private Rectangle r; 
    
	public Shape()
	{
		super("Shape");
		
		clrLbl = new JLabel("Colors: ");
		cRed = new JRadioButton("Red");
		cBlue = new JRadioButton("Blue");
		cYellow = new JRadioButton("Yellow");
		colorList = new ButtonGroup();
		spLbl = new JLabel("Shapes: ");
		btnCircle = new JRadioButton("Circle");
		btnSquare = new JRadioButton("Square");
		btnRectangle = new JRadioButton("Rectangle");
		shapesList = new ButtonGroup();
        submitBtn = new JButton("Draw Shape"); 

		
		add(clrLbl);
		add(cRed);
		add(cBlue);
		add(cYellow);
		colorList.add(cRed);
		colorList.add(cBlue);
		colorList.add(cYellow);
		add(spLbl);
		add(btnCircle);
		add(btnSquare);
		add(btnRectangle);
		shapesList.add(btnCircle);
		shapesList.add(btnSquare);
		shapesList.add(btnRectangle);
		add(submitBtn);
		
		shapebtn addHandler = new shapebtn();
        //shapebtn.addActionListener(addHandler);
		
		setLayout(new FlowLayout());
		setSize(400, 400);

		setVisible(true);
	}
	class shapebtn implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent eve)
		{
			if(eve.getSource() == submitBtn)
			{
				if(cRed.isSelected() && btnRectangle.isSelected())
				{
					Graphics g = null;
					g.fillRect(10, 30, 32, 32);
					g.setColor(Color.RED);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Shape();
	}
}
