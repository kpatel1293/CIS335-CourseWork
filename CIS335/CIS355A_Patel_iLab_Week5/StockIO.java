package labwk5;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Read from and write to a text file using ArrayList
 * Use a delimiter b/t the fields
 * 		Ex: Apple#100#55.0#80.0
 */


public class StockIO 
{
	private String fileName;
	//parameterized constructor
	/*
	 * file name will be an instance variable set with parameterized constructor
	 */
	public StockIO(String name)
	{
		fileName = name;
	}
	//getData class method
	/*
	 * read data from file
	 * return data in array list of stock objects
	 */
	//Read data from file, create Stock class object and add that object into an ArrayList, at the end return that arraylist
	public ArrayList<Stock> getData()
	{
		ArrayList <Stock> stk = new ArrayList<>();
		try
		{	
			BufferedReader inbuffer = new BufferedReader(new FileReader ("C:\\Users\\HP\\Desktop\\"+fileName+".txt"));
			String str = "";
			//get first line
			str = inbuffer.readLine();
			while (str != null)   //not EOF
			{
				//read data from str split it by hash(#) and add this info into stock object
				// we read a line from the file and stored that line into str, now split this str using (#), this will retun an array of sting, there will be four index in this array 0-3, 0 for company name, 1 for number of share, 2 for purchase  price,3 for current price
				String [] strArray = str.split("#");
				String companyName  = strArray[0];
				int  numOfShares  = Integer.parseInt(strArray[1]);
				double  purchasePrice  = Double.parseDouble(strArray[2]);
				double  currentPrice  = Double.parseDouble(strArray[3]);

				//here create an object of Stock with above info
				stk.add(new Stock(companyName, numOfShares, purchasePrice, currentPrice));

				//System.out.println(str);  //echo to console
				//read next line
				str = inbuffer.readLine();
			}			
			inbuffer.close();			
		}
		catch (Exception eIO) 
		{
			System.err.println("Input Error " + eIO.toString());
		}
		return stk;
	}
	//saveData class method
	/*
	 * writes data from an array list to the file in proper format
	 */
	public void saveData(ArrayList<Stock> stk)
	{
		//ArrayList<Stock> stk = new ArrayList<Stock>();
		try 
		{
			//create the file
			BufferedWriter outfile = new BufferedWriter(new FileWriter (/*"C:\\Users\\HP\\Desktop\\"+*/fileName+".txt", true));
			for (Stock s: stk)
			{
				outfile.write(s.getCompanyName());
				outfile.write("#" + s.getNumOfShares());  
				outfile.write("#" + s.getCurrentPrice());
				outfile.write("#" + s.getPurchasePrice());
				outfile.newLine();  //"enter" key          
			}
			//close the file
			outfile.close();
		}		
		catch (IOException exIO)
		{
			System.err.println("Input Error " + exIO.toString());
		}                                                                                                                                                                                                                                                                                                
	}
	
	/*public static void main(String[] args) {
		StockIO io = new StockIO("stock_info");
		ArrayList<Stock> stk = io.getData();
		//System.out.println(data);
		io.saveData(stk);
	}*/
}
