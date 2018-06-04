package lab2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HealthProfileGUI extends JFrame
{
	//GUI components
	private JTextField txtName, txtAge, txtFeet, txtInches, txtWeight;
	private JButton btnResult, btnClear;
	private JTextField txtBMI, txtCategory, txtMaxHeartRate;
	private HealthProfile hp;
	
	//Default constructor
	public HealthProfileGUI()
	{
		super("Health Profile"); //title of application
		hp = new HealthProfile(); //Health Profile Class Object
		
		//instantiate components
		txtName = new JTextField(10);
		txtAge = new JTextField(10);
		txtWeight = new JTextField(10);
		txtFeet = new JTextField(10);
		txtInches = new JTextField(10);
		btnResult = new JButton("Calculate");
		btnClear = new JButton("Clear");
		txtBMI = new JTextField(10);
		txtCategory =  new JTextField(10);
		txtMaxHeartRate = new JTextField(10);
		
		//set layout
		setLayout(new GridLayout(0,2));
		add(new JLabel("Name"));
		add(txtName);
		add(new JLabel("Age"));
		add(txtAge);
		add(new JLabel("Weight"));
		add(txtWeight);
		add(new JLabel("Height - Feet"));
		add(txtFeet);
		add(new JLabel("Height - Inches"));
		add(txtInches);
		add(btnResult);
		add(btnClear);
		add(new JLabel("BMI"));
		add(txtBMI);
		add(new JLabel("Category"));
		add(txtCategory);
		add(new JLabel("Maximum Heart Rate"));
		add(txtMaxHeartRate);
		
		//create object - event handler
		ButtonHandler handler = new ButtonHandler();
		//connect btn to ActionListener with the object
		btnResult.addActionListener(handler);
		btnClear.addActionListener(handler);
	}
	//class implementing ActionListener
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent actEve) 
		{
			if (actEve.getSource() == btnResult)
			{
				//get the input
				if (txtName.getText().isEmpty() || txtAge.getText().isEmpty() || txtFeet.getText().isEmpty() || txtInches.getText().isEmpty() || txtWeight.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please fill out all required fields");
					return;
				}
				hp.setName(txtName.getText());
				try
				{
					hp.setAge(Integer.parseInt(txtAge.getText()));
					hp.setHeight(Integer.parseInt(txtFeet.getText()), Integer.parseInt(txtInches.getText()));
					hp.setWeight(Integer.parseInt(txtWeight.getText()));
				}
				catch (NumberFormatException numForEx)
				{
					JOptionPane.showMessageDialog(null, "Age, Height, and Weight must be numeric");
				}
				//display
				txtBMI.setText(String.valueOf(hp.getBMI()));
				txtCategory.setText(String.valueOf(hp.getCategory()));
				txtMaxHeartRate.setText(String.valueOf(hp.getMaxHR()));
			}
			else if (actEve.getSource() == btnClear)
			{
				//clear input
				txtName.setText("");
				txtAge.setText("");
				txtFeet.setText("");
				txtInches.setText("");
				txtWeight.setText("");
				txtBMI.setText("");
				txtCategory.setText("");
				txtMaxHeartRate.setText("");
			}
		}
		
	}
}
