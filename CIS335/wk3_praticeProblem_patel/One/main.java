package practicewk3ONE;

public class main
{
	public static void main(String[] args) 
	{
		int [] counts = new int[13];
		int dieOne;
		int dieTwo;
		
		for (int i = 0; i < counts.length; i++)
		{
			dieOne = 1 + (int)(Math.random() * 6);
			dieTwo = 1 + (int)(Math.random() * 6);
			
			int sum = dieOne + dieTwo;
			
			counts[sum]++;
			
			System.out.println("The sum of the dice's rolled is " + sum);
		}
	}
}
