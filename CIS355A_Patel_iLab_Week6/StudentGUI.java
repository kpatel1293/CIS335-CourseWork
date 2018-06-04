/**************************************************** 
Program Name: StudentDB.java 
Programmer's Name: Krishna Patel
Program Description: This program calculates the students average test score and grade out of three tests
***********************************************************/

package com.krishna.wk6.lab;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentGUI extends JFrame
{
	/******
	 * Private Instances
	 * ******/
	
	/*****GUI Components******/
	JLabel nameTxt, oneTxt, twoTxt, threeTxt;
	JTextField nameStr, oneStr, twoStr, threeStr;
	JButton addBtn, allBtn;

	JPanel left, right;
	
	/******General******/
	private String name/*, grade*/;
	private double /*avg,*/ tOne, tTwo, tThree;
	
	private ArrayList<Student> list;
	private StudentDB sdb;
	private Student s;
	
	/******
	 * Public Instances
	 * ******/
	
	public StudentGUI()
	{
		/******Initialize******/
		name = "";
		tOne = 0;
		tTwo = 0;
		tThree = 0;
		
		list = new ArrayList<Student>();
		sdb = new StudentDB();
		sdb.studentDB();
		s = new Student();
		
		/******Declaration******/
		nameTxt = new JLabel("Name");
		oneTxt = new JLabel("TestOne");
		twoTxt = new JLabel("Test Two");
		threeTxt = new JLabel("Test Three");
		nameStr = new JTextField(30);
		oneStr = new JTextField(30);
		twoStr = new JTextField(30);
		threeStr = new JTextField(30);
		addBtn = new JButton("Add Student");
		allBtn = new JButton("Display All");
		
		/*****Action Listener : Add Student******/
		addBtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent ae)
			{ 
				System.out.println("click add btn");
				addStudentQuery();
			}
				});

		/*****Action Listener : Display All Student******/
		allBtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("click all btn");
				displayStudentQuery();
			}
				});
		
		/******Panel : Left******/
		left = new JPanel();
		
		//add to left panel
		left.setLayout(new GridLayout(0,1));
		left.add(nameTxt);
		left.add(oneTxt);
		left.add(twoTxt);
		left.add(threeTxt);
		left.add(addBtn);
		
		/******Panel : Right******/
		right = new JPanel();
		
		//add to right panel
		right.setLayout(new GridLayout(0,1));
		right.add(nameStr);
		right.add(oneStr);
		right.add(twoStr);
		right.add(threeStr);
		right.add(allBtn);
		
		/******Add Panel to GUI******/
		add(left);				
		add(right);
		
		/******GUI Layout******/
		setSize(300, 400);						//size
		setLayout(new GridLayout(0,2));			//layout
		setVisible(true); 						//visible
	}
	
	/******Add Student******/
	public void addStudentQuery()
	{
		name = nameStr.getText();
		tOne = Double.parseDouble(oneStr.getText());
		tTwo = Double.parseDouble(twoStr.getText());
		tThree = Double.parseDouble(threeStr.getText());
		
		Student s = new Student(name, tOne, tTwo, tThree);
		
		sdb.add(s);
		
		clear();
	}
	
	/******Display All Student******/
	public void displayStudentQuery()
	{
		list = new ArrayList<Student>();
		
		sdb.getAll();
	}
	
	/******Clear All User Input******/
	public void clear()
	{
		nameStr.setText("");
		oneStr.setText("");
		twoStr.setText("");
		threeStr.setText("");
		list.clear();
	}
	
	public static void main(String agr[])
	{
		StudentGUI gui = new StudentGUI();
	}
}
