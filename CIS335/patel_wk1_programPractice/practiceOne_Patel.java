package practicOne;

import java.text.DecimalFormat;
//libary
import java.util.Scanner;

/**************************************************** 
Program Name: practiceOne_Patel.java 
Programmer's Name: Krishna Patel
Program Description: The console program will convert the even
distance in kilometers to miles.
***********************************************************/

public class practiceOne_Patel 
{
	//Main
	public static void main(String[] args) 
	{
		//variables
		double kilometers = 0;
		double mileCon;
		
		//scanner
		Scanner userInput = new Scanner(System.in);
		
		//Welcome Message
		System.out.println("Welcome, Let's get started!");
		
		//input for kilometers
		System.out.print("Enter the distance in kilometers: ");
		kilometers = userInput.nextDouble();
				
		//call method to convert to miles
		mileCon = convertMile(kilometers);
		
		//Decimal Format to 4 decimals 
		DecimalFormat decFormat = new DecimalFormat("############.####");
		
		//output in miles 
		System.out.print("Distance traveled in miles is : " + decFormat.format(mileCon) + " miles");
		
	}
	
	//Methods
	public static double convertMile(double kilo)
	{	
		//variable
		double miles;
		//conversion formula
		miles = kilo * 0.6214;
		//return mile
		return miles;
	}
}
