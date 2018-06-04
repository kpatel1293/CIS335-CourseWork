/**************************************************** 
Program Name: MngmentSystem.java 
Programmer's Name: Krishna Patel
Program Description: This class consists of the algroithms needed as well as the setter and getters
***********************************************************/
package labwk4;

public class StockClass
{
	//Private Instances
	private String companyName;
	private int numOfShares;
	private double purchasePrice;
	private double currentPrice;
	
	//Defualt Constructor
	StockClass()
	{
		setCompanyName("unknown");
		numOfShares = 0;
		purchasePrice = 00.00;
		currentPrice = 00.00;
	}
	//Parameterized Constructor
	StockClass(String compName, int shares, double pPrice, double cPrice)
	{
		companyName = compName;
		numOfShares = shares;
		purchasePrice = pPrice;
		currentPrice = cPrice;
	}
	//Set/Get Company Name
	public String getCompanyName() 
	{
		return companyName;
	}
	public void setCompanyName(String compName) 
	{
		companyName = compName;
	}
	//Set/Get Number of Shares
	public int getNumOfShares() 
	{
		return numOfShares;
	}
	public void setNumOfShares(int shares) 
	{
		numOfShares = shares;
	}
	//Set/Get Purchase price
	public double getPurchasePrice()
	{
		return purchasePrice;
	}
	public void setPurchasePrice(double pPrice)
	{
		purchasePrice = pPrice;
	}
	//Set/Get Current Price
	public double getCurrentPrice()
	{
		return currentPrice;
	}
	public void setCurrentPrice(double cPrice)
	{
		currentPrice = cPrice;
	}
	//get method calculate - return profit or loss
	public double getCalc()
	{
		double result = numOfShares * (currentPrice - purchasePrice);
		return result;
	}
	
	//toString method
	public String toString()
	{
	        return companyName;
	}
	
}
