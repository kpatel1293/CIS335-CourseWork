package programingPractice_wk2;

public class InvoiceClass 
{
	/*
	 * Private
	 */
	private String productName;
	private int quantityPurchased;
	private double pricePerItem;
	
	/*
	 * Public
	 */
	//Default Constructor
	public InvoiceClass()
	{
		productName = "unknown";
		
		if (quantityPurchased <= 0)
		{
			quantityPurchased = 0;
		}
		
		if (pricePerItem <= 0)
		{
			pricePerItem = 0;
		}
	}
	
	//return product name
	public String getProductName() 
	{
		return productName;
	}
	//set product name
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	//return quantity purchased
	public int getQuantityPurchased() 
	{
		return quantityPurchased;
	}
	//set quantity purchased
	public void setQuantityPurchased(int quantityPurchased) 
	{
		this.quantityPurchased = quantityPurchased;
		//validate
		if (quantityPurchased <= 0) 
		{
			quantityPurchased = 0;
		}
	}
	//return price per item
	public double getPricePerItem() 
	{
		return pricePerItem;
	}
	//set price per item
	public void setPricePerItem(double pricePerItem) 
	{
		this.pricePerItem = pricePerItem;
		//validate
		if (pricePerItem <= 0)
		{
			pricePerItem = 0;
		}
	}
	
	//Invoice Method
	public double invoiceAmount()
	{
		return quantityPurchased * pricePerItem;
	}
}
