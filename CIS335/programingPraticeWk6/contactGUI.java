//Package Name
package com.krishna.wk6.code;

import java.sql.*;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.Connection;

//Contact GUI Class
public class contactGUI extends JFrame
{
  /******Private Instances******/
  
  /***************
   General
   ***************/
  private int id = 0;           //...id
  private String contactName;       //...contact name
  private String phoneNumber;       //...phone number
  private String emailAddress;        //...email address
  
  private ArrayList<Contact> contactList;   //...array list (contact class)
  private contactDB cdb;          //...contact database class
  private Contact c;
  
  private Connection connect;
  private Statement stmt;
  private ResultSet rs;
  
  
  private JTabbedPane contactPane;  
  
  /***************
   Add Contact
   ***************/
  private JPanel addContact;
  
  private JTextField nameStr, phoneNoStr, emailAddressStr;
  private JLabel nameTxt, phoneNoTxt, emailAddressTxt;
  
  private JButton submitBtn;
  
  
  /***************
   Display Contact
   ***************/
  private JPanel displayContact;
  
  //JTable table;
  private JLabel title;
  private JTable table;
  private DefaultTableModel model;
  
  /******Public Instances******/
  public contactGUI()
  {
    //Initialize Variables
    contactName = "no name";
    phoneNumber = "0";
    emailAddress = "no email";
    
    //Invoke called classes
    cdb = new contactDB();            //...Contact Database
    cdb.connectDatabase();              //...Connect to edupe database
    contactList = new ArrayList<Contact>();   //...Contact Array List
  
    //Tab Pane
    contactPane = new JTabbedPane();
    
    /******Add Contact Tab******/
    /***
     * Initialize
     ***/
    addContact = new JPanel();
        
    nameTxt = new JLabel("Contact Name");
    nameStr = new JTextField(20);
    
    phoneNoTxt = new JLabel("Phone Number");
    phoneNoStr = new JTextField(20);
    
    emailAddressTxt = new JLabel("Email");
    emailAddressStr = new JTextField(20);
        
    submitBtn = new JButton("Add Contact");
    
    submitBtn.addActionListener(new ActionListener()
        {
      public void actionPerformed(ActionEvent ae)
      {
        insertQuery();
		displayQuery();
		contactPane.setSelectedIndex(1);
        System.out.println("Submit Button Clicked!");
      }
        });
        
    /***
     * individual panel
     ***/
    //name panel
    JPanel nameP = new JPanel();
    nameP.add(nameTxt);
    nameP.add(nameStr);
            
    //phone number panel
    JPanel phoneNoP = new JPanel();
    phoneNoP.add(phoneNoTxt);
    phoneNoP.add(phoneNoStr);
    
    //email address panel
    JPanel emailP = new JPanel();
    emailP.add(emailAddressTxt);
    emailP.add(emailAddressStr);
        
    /***
     * add components
     ***/
    addContact.add(nameP);
    addContact.add(phoneNoP);
    addContact.add(emailP);
    addContact.add(new JLabel(""));
    addContact.add(new JLabel(""));
    addContact.add(submitBtn);  
  
    contactPane.add("Add Contact", addContact);   //add contact tab
    
    /******Display Contact Tab******/
    /***
     * Initialize
     ***/
    displayContact = new JPanel();
   
    model = new DefaultTableModel();
	title = new JLabel("Contact");
	//Attach model to table
	table = new JTable();
	table.setModel(model);
    
    
    displayContact.add(new JScrollPane(table));

    contactPane.add("Display Contact", displayContact);
    
    //Add Contact Tabs to GUI
    add(contactPane);
        
    //Set GUI Layout
    //setLayout(new GridLayout(1));
    setSize(600,600);
    setVisible(true); 
  }
  
  /******Show Table Query******/
  public void displayQuery()
  {
	  //Database Info
	  //...url - edupe
	  String url = "jdbc:mysql://devry.edupe.net:4300/CIS355A_3675";
	  //...user name
	  String usrnm = "3675";
	  //...password
	  String pwd = "DeVry_Student";
	  
	  try
	  {
		  //Connect to database
		  connect = (Connection) DriverManager.getConnection(url, usrnm, pwd);
	        		
		  //Query to display data
		  String query = "SELECT * FROM contact";
		  stmt = connect.createStatement();
		  rs = stmt.executeQuery(query);
	        		
		  //Metadata to get column names
		  ResultSetMetaData ms = rs.getMetaData();
	        		
		  //Get Column Count
		  int count = ms.getColumnCount();
	        		
		  //Vector object to add column name
		  Vector<String> columnName = new Vector<String>();
	        		
		  //Loop to Get column name
		  for (int i = 1; i <= count; i++)
		  {
			  columnName.add(ms.getColumnName(i));
		  }
	        		
		  //Add column name to model
		  model.setColumnIdentifiers(columnName);
	        		
		  //Get Each Row
		  while(rs.next())
		  {
			  model.addRow(new Object[] { rs.getInt("contactID"),
					  rs.getString("contactName"),
					  rs.getString("phoneNumber"),
					  rs.getString("emailAddress")});
		  }
	  }
	  catch(SQLException sqle)
	  {
		  sqle.printStackTrace();
	  }	 
  }
  
  /******Insert Query******/
  public void insertQuery()
  {
	  //Get user input
    contactName = nameStr.getText();
    phoneNumber = phoneNoStr.getText();
    emailAddress = emailAddressStr.getText();
    
    //invoke contact class
    Contact c = new Contact(contactName, phoneNumber, emailAddress);
    
    //add to database
    cdb.insertContact(c);
      
    //clear all input
    clearInput();
  }
  
  /******Clear Frame******/
  public void clearInput()
  {
    //Clear all input field
    nameStr.setText("");  
    phoneNoStr.setText("");
    emailAddressStr.setText("");
    contactList.clear();
  }
  
  public static void main(String[] args) throws SQLException 
  {
    contactGUI cGUI = new contactGUI();
  }
}