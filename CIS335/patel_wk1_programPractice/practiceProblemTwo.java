package practiceTwo;

import java.text.NumberFormat;
import java.util.Scanner;

/**************************************************** 
Program Name: praticeProblemTwo.java 
Programmer's Name: Krishna Patel
Program Description: The console program will calculate what is 
the cost of the minimum insurance for the building to be able to replace it
***********************************************************/

public class main
{
	//Main
	public static void main(String[] args) 
	{
		//variable
		double costOfBuilding;
		double insureCost;
		
		//scanner
		Scanner UserInput = new Scanner(System.in);
		
		//format - currency
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		//input
		System.out.print("Enter the cost of the building :  $");
		costOfBuilding = UserInput.nextDouble();
		
		//call method
		insureCost = calcInsurance(costOfBuilding);
		
		//output result
		System.out.println("The cost of the building entered is : " + currencyFormat.format(costOfBuilding));
		System.out.println("The minimum insurance suggestion cost in order to be eligible for replacement	: " + currencyFormat.format(insureCost));
	}
	//Method
	public static double calcInsurance(double cost)
	{
		//variable
		double recommend;
		//calculate
		recommend = cost * .80;
		//return
		return recommend;
	}
	
}
