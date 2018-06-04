package main;

import java.text.DecimalFormat;
import java.util.Scanner;

/**************************************************** 
Program Name: Lab1Main.java
Programmer's Name: Student Name 
Program Description: The program measures the users maximum heart rate and BMI
***********************************************************/

public class Lab1Main
{
	
	public static void main(String[] args) 
	{
		//variable
		String name = null;
		int age = 0;
		int weight = 0;
		int inches = 0;
		int in;
		int ft;
		
		//call HealthProfile Class
		HealthProfile hProfile = new HealthProfile(name, age, weight, inches);
		
		//scanner
		Scanner str = new Scanner(System.in);
		
		//input
		while(true) {
		//...name	
		System.out.print("Enter name or X to quit : ");
		name = str.nextLine();
		//check for exit condition
		if (name.equals("X"))
		{
			break;
		}
		hProfile.setName(name);
		//...age
		System.out.print("Your age : ");
		age = str.nextInt();
		hProfile.setAge(age);
		//...weight
		System.out.print("Your weight : ");
		weight = str.nextInt();
		hProfile.setWeight(weight);
		//...height -ft -in
		System.out.print("Your height - ft : ");
		ft = str.nextInt();
		System.out.print("Your height - in : ");
		in = str.nextInt();
		hProfile.setHeight(in, ft);

		//blank line
		System.out.println();
        str.nextLine();
		
		//format - decimal place
		DecimalFormat decPlace = new DecimalFormat("############.#");
		
		//output for profile
		System.out.println("Health Profile for " + hProfile.getName());
		System.out.println("BMI : " + decPlace.format(hProfile.getBMI()));
		System.out.println("BMI Category : " + hProfile.getCategory());
		System.out.println("Maximum Heart Rate : " + hProfile.getMaxHR());

		}
	}

}
