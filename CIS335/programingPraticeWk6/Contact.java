//Package
package com.krishna.wk6.code;

//Contact class
public class Contact 
{
	/******Private Instances******/
	private int id;					//...id
	private String contactName;		//...contact name
	private String phoneNumber;		//...phone number
	private String emailAddress;		//...email address
	
	/******Default Constructor******/
	public Contact() 
	{}
	
	/******Parameterized Constructor******/
	public Contact(String contactName, String phoneNumber, String emailAddress)
	{
		//Variable
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	/******Id : setter******/
	public void setId(int id)
	{
		this.id = id;
	}
	
	/******Id : getter******/
	public int getId()
	{
		return id;
	}
	
	/******Contact Name : setter******/
	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}
	
	/******Contact Name : getter******/
	public String getContactName()
	{
		return contactName;
	}
	
	/******Phone Number : setter******/
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	/******Phone Number : getter******/
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/******Email : setter******/
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	/******Email : getter******/
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	/******ToString******/
	public String toString()
	{
		return contactName + " " + phoneNumber + " " + emailAddress;
	}
}
