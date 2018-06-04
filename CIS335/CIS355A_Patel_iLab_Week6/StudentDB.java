/**************************************************** 
Program Name: StudentDB.java 
Programmer's Name: Krishna Patel
Program Description: This program calculates the students average test score and grade out of three tests
***********************************************************/

package com.krishna.wk6.lab;

import java.sql.*; //...sql
import java.util.ArrayList;

public class StudentDB 
{
	/******
	 * Private
	 ******/
	private static ArrayList<Student> list;		//...array list - student class

	private Connection connect;				 	//...connection
	
	private PreparedStatement insertStudent; 				//...insert query
	private PreparedStatement displayStudent;				//...display all student query
	
	
	/******
	 * Public
	 ******/
	/******Create Connection With Database******/
	public void studentDB()
	{
		//call student array list
		list = new ArrayList<Student>();
		
		/******Database Credentials******/
		String url = "jdbc:mysql://devry.edupe.net:4300/CIS355A_3675";	//...url

		String usrname = "3675";		//...user name
		String pwd = "DeVry_Student";	//...password
		
		//Connect JBDC
		System.out.print("Testing Connection - JBDC");
		try
		{
			Class.forName("com.mysql.jbdc.Driver");
		}
		catch(ClassNotFoundException notFound)
		{
			System.out.println("JBDC Error: Can't be located!!");
		}
		System.out.println("JBDC Registered!");
		
		try
		{
			//connect using url, user name, password
			connect = DriverManager.getConnection(url, usrname, pwd);
			System.out.println("Sucess! url: " + url + " username: " + usrname + " password: " + pwd);
			
			//Query: Insert Student into Table
			String insertQuery = "INSERT INTO StudentResults (studentID, name, testOne, testTwo, testThree, average, grade) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			insertStudent = connect.prepareStatement(insertQuery);
			
			String displayQuery = "SELECT * FROM StudentResults";
			
			displayStudent = connect.prepareStatement(displayQuery);
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		
	}
	
	/******Add Student to Database******/
	protected void add(Student s)
	{	
		try
		{
			int stID = 0;
					
			//Fill Row
			insertStudent.setInt(1, stID);
			insertStudent.setString(2, s.getStudentName());
			insertStudent.setString(7, s.getLetterGrade());
			insertStudent.setDouble(6, s.getAverage());
			insertStudent.setDouble(3, s.getTestScoreOne());
			insertStudent.setDouble(4, s.getTestScoreTwo());
			insertStudent.setDouble(5, s.getTestScoreThree());
			
			//execute query
			insertStudent.executeUpdate();
			
			//row added message
			System.out.println("Student Added!");
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e);
			closeConnection();
		}
	}
	
	//getAll method
	protected ArrayList<Student> getAll()
	{
		//Invoke array list
		list = new ArrayList<Student>();
		ResultSet rs;
		
		try
		{
			rs = displayStudent.executeQuery();
			list = new ArrayList<Student>();
			
			while (rs.next())
			{
				System.out.println(rs.getInt(1) + "		" + rs.getString(2) + " 		" + rs.getDouble(3) + "		 " + rs.getDouble(4) + " 	" + rs.getDouble(5) + " " + rs.getDouble(6) + " " + rs.getString(7));
				//list.add(new Student(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	/******Close Connection******/
	public void closeConnection()
	{
		try
		{
			//check - connection open, close if true
			if (connect != null)
			{
				connect.close();
				System.out.println("connection closed!"); //confirmation message
			}
		}
		catch(SQLException e)
		{
			e.getStackTrace();
		}
	}
}
