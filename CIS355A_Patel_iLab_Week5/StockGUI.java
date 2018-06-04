package labwk5;

//Library 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class StockGUI extends JFrame
{
	//private instances
	//list
	private JList<Stock> stkList; //Share List
	private JList<StockIO> ArrayList; //Array List linked to StockIO
	private DefaultListModel<Stock> stkModel;
	//tab
	private JTabbedPane tab;
	//text message
	private JLabel msgTxt;
	//remove btn
	private JButton removeStock;
	//Stock Tab
	private JLabel stkNameTxt;
	private JTextField stkNameStr;
	private JLabel qtyTxt;
	private JTextField qtyStr;
	private JLabel purPriceTxt;
	private JTextField purPriceStr;
	private JLabel curPriceTxt;
	private JTextField curPriceStr;
	private JButton addStock;
	//Total Value of Portfilo 
	private JLabel totalValue;

	//file
	JMenu file;
	JMenuBar bar;
	JMenuItem open, save, exit;

	public StockGUI() 
	{
		//Name of Application
		super("Porfolio Management");

		//Menu
		file = new JMenu("File");
		//Dropdown Menu
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		//Attach Item
		file.add(open);
		open.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent a) 
			{
				TxtOptionPane txtOptionPane = new TxtOptionPane();
				java.util.ArrayList<Stock> data = txtOptionPane.io.getData();
				for (Stock stock : data) {
					stkModel.addElement(stock);
				}
			}
		});
		file.add(save);
		// add action listener to save
		save.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent a) 
			{
				//here we will ask user to input file name in which data will be saved
				TxtOptionPane txtOptionPane = new TxtOptionPane();
				// now we will read the data from the stk model and call the save method
				java.util.ArrayList<Stock> stocklist = new java.util.ArrayList<>();
				for(int i=0;i<stkModel.size();i++){
					//here we have object of stock, put into an ArrayList
					Stock stock = stkModel.get(i);
					//add stock into stockLIst
					stocklist.add(stock);
				}
				//call saveData here
				txtOptionPane.io.saveData(stocklist);
			}
		});
		file.add(exit);
		//Menu Bar
		bar = new JMenuBar();
		//Add to bar
		bar.add(file);
		//add bar to gui
		setJMenuBar(bar);

		//Tab
		tab = new JTabbedPane();

		// constructing the first Tab
		JPanel pOne =new JPanel();
		removeStock = new JButton("Remove Stock");
		msgTxt = new JLabel("");
		tab.addTab("List",null, pOne);
		//List
		stkList = new JList<>();
		stkModel = new DefaultListModel<Stock>();
		//connect list to model
		stkList.setModel(stkModel);
		//one selection at a time
		stkList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//scroll
		pOne.add(new JScrollPane(stkList));
		//Total Value Message
		totalValue = new JLabel("Total Value: ");
		//add components
		pOne.add(removeStock);
		pOne.add(msgTxt);
		pOne.add(totalValue);

		//Action listener
		removeStockHandlerBtn removeHandler = new removeStockHandlerBtn();
		removeStock.addActionListener((ActionListener) removeHandler);

		//Add Listener
		stkList.addListSelectionListener(
				new ListSelectionListener()
				{
					public void valueChanged(ListSelectionEvent event)
					{
						String strOutput = "";
						if (stkList.getSelectedIndex() != -1)
						{
							Stock ms = stkList.getSelectedValue();
							//Convert to Two decimal places
							double d = ms.getProfitLoss();
							DecimalFormat formatDecimal = new DecimalFormat ("#, ###.00");
							//Determine wether profit or loss
							String rndNum = formatDecimal.format(d);
							if (d < 0)
							{
								msgTxt.setText("Intel: loss of -" + rndNum);
							}
							else
							{
								msgTxt.setText("Intel: Profit of " + rndNum);
							}
						}
					}
				});


		// constructing the second Tab
		JPanel pTwo =new JPanel();
		addStock = new JButton("Add Stock");
		stkNameTxt = new JLabel("Stock Name");
		stkNameStr = new JTextField(10);
		qtyTxt = new JLabel("Quantity");
		qtyStr = new JTextField(10);
		purPriceTxt = new JLabel("Purchase Price");
		purPriceStr = new JTextField(10);
		curPriceTxt = new JLabel("Current Price");
		curPriceStr = new JTextField(10);
		//add to tab
		tab.addTab("Add Stock",null, pTwo);
		pTwo.add(stkNameTxt);
		pTwo.add(stkNameStr);
		pTwo.add(qtyTxt);
		pTwo.add(qtyStr);
		pTwo.add(purPriceTxt);
		pTwo.add(purPriceStr);
		pTwo.add(curPriceTxt);
		pTwo.add(curPriceStr);
		pTwo.add(addStock);

		//Action listener
		addStockHandlerBtn addHandler = new addStockHandlerBtn();
		addStock.addActionListener(addHandler);

		//add tab to window
		add(tab);
	}

	public class TxtOptionPane
	{  
		JFrame txtFrame;  
		TxtOptionPane(){  
			txtFrame = new JFrame();   
		}
		String name=JOptionPane.showInputDialog(txtFrame,"Enter Filename");
		// here we need to call the getData
		StockIO io = new StockIO(name);
	
	}  

	class addStockHandlerBtn implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent eve)
		{
			//extract data from GUI and create an object
			Stock newMngSys = new Stock(
					stkNameStr.getText(), 
					Integer.parseInt(qtyStr.getText()), 
					Double.parseDouble(purPriceStr.getText()), 
					Double.parseDouble(curPriceStr.getText()));
			//add the object to the model connected to JList
			stkModel.addElement(newMngSys);
		}
	}

	class removeStockHandlerBtn implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent eve)
		{
			int listItem = stkList.getSelectedIndex();
			if (listItem == -1)
			{
				JOptionPane.showMessageDialog(null, "ERROR: Must select item to remove");
			}
			else
			{
				stkModel.removeElementAt(listItem);
				msgTxt.setText("");
			}
		}
	}

	public static void main(String[] args) 
	{
		StockGUI test = new StockGUI();
		test.setVisible(true);
		test.setSize(500, 400);
		StockIO io = new StockIO("stock_info");
		ArrayList<Stock> stk = io.getData();
		//System.out.println(data);
		io.saveData(stk);
	}
}
