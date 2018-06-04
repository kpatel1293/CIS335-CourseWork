package lab2;

public class HealthProfile 
{
	/*
	 * Private
	 */
	private String name;
	private int age;
	private int weight;
	private int height;
	
	/*
	 * Public
	 */
	
	//Constructor
	public HealthProfile()
	{
		name = "unknown";
		age = 0;
		weight = 0;
		height = 0;
	}
	public HealthProfile(String n, int a, int w, int in, int ft)
	{
		name = n;
		age = a;
		weight = w;
		height = in + (12 * ft);
	}
	
	//return name
	public String getName() {
		return name;
	}

	//set name
	public void setName(String n) {
		name = n;
	}

	//return age
	public int getAge() {
		return age;
	}

	//set age
	public void setAge(int a) {
		age = a;
	}

	//return weight
	public int getWeight() {
		return weight;
	}

	//set weight
	public void setWeight(int w) {
		weight = w;
	}

	//return height
	public int getHeight() {
		return height;
	}

	//set height in inches (in)
	public void setHeight(int ft, int in) {
		height = in + (ft * 12);
	}
	
	//return BMI
	public double getBMI()
	{
		double bmi;
		double top = getWeight() * 703; 
		double btm = getHeight() * getHeight();
		bmi = top/btm;
		return bmi;
	}
	
	//return weight category
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
		
	//calculate max heart rate
	public int getMaxHR()
	{
		int maxHR;
		maxHR = 200 - getAge();
		return maxHR;
	}
}
