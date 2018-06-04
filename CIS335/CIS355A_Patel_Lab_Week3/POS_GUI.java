package lab3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class POS_GUI extends JFrame implements ActionListener
{
	/*
	 * Private
	 */
	private JRadioButton sBurger, dBurger;

	private JCheckBox addCheese, addBacon, meal;

	private JTextField txtItem, txtQuantity, txtTotal;

	private JTextArea txtReciept;

	private JMenuItem exit, addOrder, clear, newOrder; //file menu

	/*
	 * Public
	 */
	public POS_GUI()
	{
		//Instantiate GUI Components -

		//...Menu
		JMenu file = new JMenu("File");
		JMenu order = new JMenu("Order");
		//...dropdown menu
		exit = new JMenuItem("Exit");
		addOrder = new JMenuItem("Add to Order");
		clear = new JMenuItem("Clear for next item");
		newOrder = new JMenuItem("New Order");
		
		//attach items
		file.add(exit);
		order.add(addOrder);
		addOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				//here get order details and print on receipt
				//get item price
				String itemPrice = txtItem.getText();
				//get quantity
				String quantity = txtQuantity.getText();
				
				//prepare recipt details
				String receiptDeatils = new String();
				receiptDeatils = quantity + " ";
				
				if(burgerSlected==1){
					receiptDeatils = receiptDeatils + "Single ";
				}else{
					receiptDeatils = receiptDeatils + "Double ";
				}
				
				if(isCheeseRequied){
					receiptDeatils = receiptDeatils+ ", cheese ";
				}
				if(isBaconRequired){
					receiptDeatils = receiptDeatils + ", bacon ";
				}
				if(isMeal){
					receiptDeatils = receiptDeatils + ", meal ";
				}
				receiptDeatils = receiptDeatils + " at "+itemPrice+" each";
				
				txtReciept.setText(receiptDeatils);
				
			}
		});
		order.add(clear);
		order.add(newOrder);
		//menu bar
		JMenuBar menubar = new JMenuBar();
		//add to bar
		menubar.add(file);
		menubar.add(order);
		//add bar to gui
		setJMenuBar(menubar);

		//...Radio Button
		sBurger = new JRadioButton("Single Burger");
		sBurger.addActionListener(this);
		dBurger = new JRadioButton("Double Burger");
		dBurger.addActionListener(this);
		//...Check Boxes
		addCheese = new JCheckBox("Add cheese");
		addCheese.addActionListener(this);
		addBacon = new JCheckBox("Add bacon");
		addBacon.addActionListener(this);
		meal = new JCheckBox("Make it a meal");
		meal.addActionListener(this);
		//...Text Field
		txtItem = new JTextField(20);
		txtQuantity = new JTextField(20);
		txtTotal = new JTextField(20);
		//...Text Area
		txtReciept = new JTextArea(30,20);

		//group radio button
		ButtonGroup btnBurger = new ButtonGroup();
		btnBurger.add(sBurger);
		btnBurger.add(dBurger);

		add(new JLabel("YOUR ORDER"));
		setLayout(new FlowLayout());
		add(txtReciept);

		add(sBurger);
		add(dBurger);

		add(addCheese);
		add(addBacon);
		add(meal);

		add(new JLabel("Item Price "));
		add(txtItem);
		add(new JLabel("Quantity"));
		add(txtQuantity);
		txtQuantity.setText("1");
		add(new JLabel("Order Total"));
		add(txtTotal);

		setLayout(new GridLayout(0,1));
		setSize(400, 400);


		setVisible(true);
	}

	private int quantity = 1;
	private double totalPrice;
	private double itemPrice;
	private double singleBurgerPrice = 3.50;
	private double doubleBurgerPrice = 4.75;
	private double baconPrice = 1.25;
	private double mealPrice = 4.50;
	private double cheesePrice = .50;
	private boolean isMeal;
	private boolean isCheeseRequied;
	private boolean isBaconRequired;
	private int burgerSlected;
	//action event
	public void actionPerformed(ActionEvent e)
	{
		boolean isCheckBoxEvent = false;
		//update price
		if (e.getActionCommand() == "Single Burger")
		{
			burgerSlected = 1;
		}
		else if(e.getActionCommand() == "Double Burger")
		{
			//txtReciept.setText(quantity + "Double Burger at $4.75 each");
			burgerSlected = 2;
		}	else if (e.getActionCommand() == "Add cheese")
		{
			isCheeseRequied = true;
			isCheckBoxEvent = true;
		}
		else if (e.getActionCommand() == "Add bacon")
		{
			isBaconRequired = true;
			isCheckBoxEvent = true;
		}
		else if (e.getActionCommand() == "Make it a meal")
		{
			isMeal = true;
			isCheckBoxEvent = true;
		}

		//calculate item price here
		if(burgerSlected==1){
			itemPrice = itemPrice+singleBurgerPrice;
			if(isMeal){
				itemPrice = itemPrice+mealPrice;
			}
			if(isBaconRequired){
				itemPrice = itemPrice+baconPrice;
			}
			if(isCheeseRequied){
				itemPrice = itemPrice+cheesePrice;
			}
		}else if(burgerSlected==2){
			itemPrice = itemPrice+doubleBurgerPrice;
			if(isMeal){
				itemPrice = itemPrice+mealPrice;
			}
			if(isBaconRequired){
				itemPrice = itemPrice+baconPrice;
			}
			if(isCheeseRequied){
				itemPrice = itemPrice+cheesePrice;
			}
		}

		txtItem.setText(itemPrice+"");
		itemPrice  = 0;
	}
	public static void main(String[] args) {
		new POS_GUI();
	}
}