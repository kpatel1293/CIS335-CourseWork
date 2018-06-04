package labwk5;

//Stock Class
public class Stock 
{
	//Private Instances
	private String companyName;
	private int numOfShares;
	private double purchasePrice;
	private double currentPrice;
	
	//Public
	//Default Constructor
	public Stock()
	{
		companyName = " ";
		numOfShares = 0;
		purchasePrice = 0;
		currentPrice = 0;
	}
	//Parameterized Constructor
	public Stock(String companyName, int numOfShares, double purchasePrice, double currentPrice)
    {
        this.companyName = companyName;
        this.numOfShares = numOfShares;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }
	//Set and Get Company Name
	public String getCompanyName() 
	{
		return companyName;
	}
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}
	//Set and Get Number of Shares
	public int getNumOfShares() 
	{
		return numOfShares;
	}
	public void setNumOfShares(int numOfShares) 
	{
		this.numOfShares = numOfShares;
	}
	//Set and Get Purchase Price
	public double getPurchasePrice() 
	{
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) 
	{
		this.purchasePrice = purchasePrice;
	}
	//Set and Get Current Price
	public double getCurrentPrice() 
	{
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) 
	{
		this.currentPrice = currentPrice;
	}
	//Profit or Loss
	public double getProfitLoss()
	{
		return numOfShares * (currentPrice - purchasePrice);
	}
	//ToString - Modify to Display as Company: qty shares
	public String toString()
	{
		return companyName + ": " + numOfShares + " shares";
	}
}
