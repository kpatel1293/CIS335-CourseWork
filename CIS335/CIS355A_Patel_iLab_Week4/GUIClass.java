/**************************************************** 
Program Name: GUIClass.java 
Programmer's Name: Krishna Patel
Program Description: The program will run a gui to display a list of stock portfilo in one tab
 and in another tab, can add stock to the portfilo
***********************************************************/

package labwk4;

//Library 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class GUIClass extends JFrame
{
	//private instances
	//list
	private JList<StockClass> stkList;
	private DefaultListModel<StockClass> stkModel;
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
	
	public GUIClass() 
	{
		//Name of Application
		super("Porfolio Management");
		
		//Tab
		tab = new JTabbedPane();
		
		// constructing the first Tab
        JPanel pOne =new JPanel();
        removeStock = new JButton("Remove Stock");
        msgTxt = new JLabel("");
        tab.addTab("List",null, pOne);
        //List
        stkList = new JList<>();
        stkModel = new DefaultListModel<StockClass>();
        //connect list to model
        stkList.setModel(stkModel);
        //one selection at a time
        stkList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //scroll
        pOne.add(new JScrollPane(stkList));
        //add components
        pOne.add(removeStock);
        pOne.add(msgTxt);
        
        //Action listener
        removeStockHandlerBtn removeHandler = new removeStockHandlerBtn();
		removeStock.addActionListener((ActionListener) removeHandler);
        
        //Add Listener
        stkList.addListSelectionListener(
        new ListSelectionListener()
        {
        		public void valueChanged(ListSelectionEvent event)
        		{
        			if (stkList.getSelectedIndex() != -1)
        			{
        				StockClass ms = stkList.getSelectedValue();
    	                if (ms.getCalc() < 0)
    	                {
    	                		msgTxt.setText("loss of " + Math.round((ms.getCalc())*100.00)/100.00);
    	                }
    	                else
    	                {
    	                		msgTxt.setText("Profit of " + Math.round((ms.getCalc())*100.00)/100.00);
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
	
	class addStockHandlerBtn implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent eve)
		{
			//extract data from GUI and create an object
			StockClass newMngSys = new StockClass(
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
}
