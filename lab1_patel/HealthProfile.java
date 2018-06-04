package main;

public class HealthProfile
{
	//Private
	private String name;
	private int age;
	private int weight;
	private int inches;

	//Public

	//constructor
	public HealthProfile(String n, int a, int w, int in)
	{
		name = n;
		age = a;
		weight = w;
		inches = in;
	}
	//setName
	public void setName(String n)
	{
		name = n;
	}
	//setAge
	public void setAge(int a)
	{
		age = a;
	}
	//setWeight
	public void setWeight(int w)
	{
		weight = w;
	}
	//setHeight
	public void setHeight(int in, int ft)
	{
		inches = (ft * 12) + in;
	}
	//getName
	public String getName()
	{
		return name;
	}
	//getAge
	public int getAge()
	{
		return age;
	}
	//getWeight
	public int getWeight()
	{
		return weight;
	}
	//getHeight
	public int getHeight()
	{
		return inches;
	}
	//getBMI
	public double getBMI()
	{
		double bmi;
		double top = getWeight() * 703; 
		double btm = getHeight() * getHeight();
		bmi = top/btm;
		return bmi;
	}
	//getCategory
	public String getCategory()
	{
		String category = null;
		if (getBMI() < 18.5)
		{
			category = "Underweight";
		}
		else if (18.5 < getBMI() && getBMI() < 24.9)
		{
			category = "Normal";
		}
		else if (25 < getBMI() && getBMI() < 29.9)
		{
			category = "Overweight";
		}
		else if (getBMI() > 30)
		{
			category = "Obese";
		}
		return category;
	}
	//getMaxHR
	public int getMaxHR()
	{
		int maxHR;
		maxHR = 200 - getAge();
		return maxHR;
	}
}
