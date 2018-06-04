//Package Name
package com.krishna.wk6.code;

//Library
import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Statement;

//Contact Database Class
public class contactDB
{
	/******Private Instances******/
	private Connection connect;				//...connection
	private ArrayList<Contact> contactList; 	//...array list (contact class)
	
	private PreparedStatement insertContact;
	private PreparedStatement displayContact;
	
	/******Verify and Connect to Database******/
	public void connectDatabase()
	{
		//User Information
		//...url - edupe
		String url = "jdbc:mysql://devry.edupe.net:4300/CIS355A_3675";
		//...user name
		String usrnm = "3675";
		//...password
		String pwd = "DeVry_Student";
		
		//invoke array list
		contactList = new ArrayList<Contact>();
		
		//Test Connection - JBDC
		System.out.println("Test MySQL Connection - JBDC");
		try 
		{
		     Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException notFound) 
		{
		     System.out.println("Cannot locate the driver!");
		}
		System.out.println("Registered!");
		
		//Execute Connection to Database
		try 
		{
			//Connect using url, username, password
			connect = DriverManager.getConnection(url, usrnm, pwd);
			System.out.println("url: " + url + " username: " + usrnm + " password: " + pwd);
			
			//Insert Query to add row to contact database
			String sqlInsert = "INSERT INTO contact (contactID, contactName, phoneNumber, emailAddress) VALUES (?, ?, ?, ?)";
			
			insertContact = connect.prepareStatement(sqlInsert);
			
			//Query to select the table
			String sqlSelectTable = "select * from contact";
			
			displayContact = connect.prepareStatement(sqlSelectTable);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/*finally
		{
			try 
			{
				//if connection is open - close it
				if(connect != null) 
					connect.close(); 
				System.out. println("closed!"); //message to confrim
			} 
			catch (SQLException e)
			{ 
				e. printStackTrace(); 
			} 
		}*/
	}
	
	/******Display Table******/
	protected ArrayList<Contact> displayTable()
	{		
		ArrayList<Contact> contactlist = null;
		ResultSet rs = null;
		
		try
		{	
			//Result Set - execute
			rs = displayContact.executeQuery();
			contactlist = new ArrayList<Contact>();
			
			//Run through table to display all rows
			while(rs.next())
			{
				/*//Get all the values of columns
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				
				//Invoke contact class, and set all values
				contact c = new contact(name, phone, email);
				c.setId(id);
				contactList.add(c);
				*/
				
				contactlist.add(new Contact(rs.getString(2), rs.getString(3), rs.getString(4)));
				
				//print in console
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
		
		//Return list
		return contactList;
	}
	
	/******Add Contact to Database******/
	protected void insertContact(Contact c)
	{
		try
		{
			//Insert Query to add row to contact database
			//String sqlInsert = "INSERT INTO contact (contactID, contactName, phoneNumber, emailAddress) VALUES (?, ?, ?, ?)";
			
			//Prepare Statement
			//insertContact = connect.prepareStatement(sqlInsert);
			
			//Fill Row
			insertContact.setInt(1, c.getId());					//get id
			insertContact.setString(2, c.getContactName());		//get name
			insertContact.setString(3, c.getPhoneNumber());		//get phone number
			insertContact.setString(4, c.getEmailAddress());		//get email address
			
			//execute query
			insertContact.executeUpdate();
			
			//Row Added Message
			System.out.println("Row Added!");
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e);
			close();
		}
	}
	
	/******Close Connection******/
	public void close()
	{
		try 
		{
			//if connection is open - close it
			if(connect != null) 
				connect.close(); 
			System.out. println("closed!"); //message to confirm
		} 
		catch (SQLException e)
		{ 
			e. printStackTrace(); 
		} 
	}
}
