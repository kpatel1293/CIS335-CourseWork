package programingPractice_wk2;

import java.util.Scanner;

public class mainClass 
{
	//Main
	public static void main(String[] args) 
	{
		//Variables
		String name;		//...Product Name
		int quantity;	//...Quantity Purchased
		double price;	//...Price per item
		double amt; 		//...Total Amount
		
		//Instantiates Invoice Object
		InvoiceClass invoice = new InvoiceClass();
		
		//Scanner
		Scanner str = new Scanner(System.in);
		
		//Input
		System.out.print("Enter the Product Name : ");
		name = str.nextLine();
		invoice.setProductName(name);
		
		System.out.print("Enter the Quantity Purchased : ");
		quantity = str.nextInt();
		invoice.setQuantityPurchased(quantity);
		
		System.out.print("Enter the Price per Item : ");
		price = str.nextDouble();
		invoice.setPricePerItem(price);
		
		//Process
		amt = invoice.invoiceAmount();
		
		//Output
		System.out.println("************Invoice************");
		System.out.println("Product Name : " + invoice.getProductName());
		System.out.println("Quantity : " + invoice.getQuantityPurchased());
		System.out.printf("Price per Item : $%.2f%n", invoice.getPricePerItem());
		System.out.printf("Total : $%.2f%n", amt);
		
	}
}