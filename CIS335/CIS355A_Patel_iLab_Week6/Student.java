/**************************************************** 
Program Name: StudentDB.java 
Programmer's Name: Krishna Patel
Program Description: This program calculates the students average test score and grade out of three tests
***********************************************************/

package com.krishna.wk6.lab;

import java.text.DecimalFormat;

public class Student 
{
	/******
	 * Private Instances
	 * ******/
	private String studentName; //...student name
	//test scores
	private double testScoreOne;		//...test score one
	private double testScoreTwo;		//...test score two
	private double testScoreThree;	//...test score three
	
	/******
	 * Public Instances
	 * ******/
	
	/******Default Constructor******/
	public Student() 
	{ 
		studentName = ""; 
		testScoreOne = 0; 
		testScoreTwo = 0; 
		testScoreThree = 0; 
	}
	
	/******Parameterized Constructor******/
	public Student(String name, double testOne, double testTwo, double testThree)
	{
		studentName = name; 
		testScoreOne = testOne; 
		testScoreTwo = testTwo; 
		testScoreThree = testThree;
	}
	
	/******Name : setter******/
	public void setStudentName(String name)
	{
		studentName = name;
	}
	
	/******Name : getter******/
	public String getStudentName()
	{
		return studentName;
	}
	
	/******Test One : setter******/
	public void setTestScoreOne(double testOne)
	{
		testScoreOne = testOne;
	}
	
	/******Test One : getter******/
	public double getTestScoreOne()
	{
		return testScoreOne;
	}
	
	/******Test Two : setter******/
	public void setTestScoreTwo(double testTwo)
	{
		testScoreTwo = testTwo;
	}
	
	/******Test Two : getter******/
	public double getTestScoreTwo()
	{
		return testScoreTwo;
	}
	/******Test Three : setter******/
	public void setTestScoreThree(double testThree)
	{
		testScoreThree = testThree;
	}
	
	/******Test Three : getter******/
	public double getTestScoreThree()
	{
		return testScoreThree;
	}
	
	/******Get : calculate & return average******/
	public double getAverage()
	{		
		double average = (testScoreOne + testScoreTwo + testScoreThree) / 3.0;
		
		return Math.round(average);
	}
	
	/******Get : calculate & return letter******/
	public String getLetterGrade()
	{	
		if (getAverage() < 60)
		{
			return "F";
		}
		else if (getAverage() < 70)
		{
			return "D";
		}
		else if (getAverage() < 80)
		{
			return "C";
		}
		else if (getAverage() < 90)
		{
			return "B";
		}
		else
		{
			return "A";
		}
	}
	
	/******To String******/
	public String toString()
	{
		return studentName;
	}
}
