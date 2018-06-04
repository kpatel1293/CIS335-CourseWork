package practiceProblem_wk4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class guessNumberProgram extends JFrame 
{
	//Private Instances - GUI Component
	private JButton resetBtn;
	private JButton guessBtn;
	private JTextField inputTxt;
	private JLabel msgTxt;
	private JLabel guessTxt;
	private JLabel numGuessTxt;
	
	//Private Instances - Variables
	private int randNum; //random number
	private int usrStr; //user input
	private int cnt = 0; //count
	
	//Guess Number Program
	public guessNumberProgram()
	{
		//Title of Application
		super("Guess The Number");
		
		//Button
		resetBtn = new JButton("Start Over");
		guessBtn = new JButton("Take a guess");
		
		//Input Text box - Usr enter number to guess
		inputTxt = new JTextField(10);
		
		//Display Message
		msgTxt = new JLabel("I'm thinking of a number between 1 and 1000. Guess it!");
		//Result Output
		guessTxt = new JLabel("");
		//Number of Guesses
		numGuessTxt = new JLabel("");
		
		//Random number generator
		randNum = new Random().nextInt(1000) + 1;
		
		//Set Layout
		setLayout(new FlowLayout());
		
		//Add component to layout
		add(msgTxt);
		add(inputTxt);
		add(guessBtn);
		add(resetBtn);
		add(guessTxt);
		add(numGuessTxt);
		
		//Size of Window
		setSize(400, 150);
		
		//Call Handler
		strtOverHandlerBtn soHandler = new strtOverHandlerBtn();
		resetBtn.addActionListener(soHandler);
		
		guessBtnHandler guessHandler = new guessBtnHandler();
		guessBtn.addActionListener(guessHandler);
		
	}
	
	//Handler for Reset Btn
	class strtOverHandlerBtn implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent eve)
		{
			guessTxt.setText("");
			inputTxt.setText("");
			randNum = new Random().nextInt(1000) + 1;
			numGuessTxt.setText("");
		}
	}
	
	//Handler for Guess Button
	class guessBtnHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent eve)
		{
			//Convert input to int
			usrStr = Integer.parseInt(inputTxt.getText());
			//Loop for 10 tries
            if (cnt == 10)
			{
					guessTxt.setText("You Lose! The number was " + randNum);
			}
			else
			{
                cnt++;
				if (usrStr == randNum)
				{
					guessTxt.setText("You Won!");
				}
				else if (usrStr > randNum)
				{
					guessTxt.setText("Too high");
				}
				else if (usrStr < randNum)
				{
					guessTxt.setText("Too low");
				}
				//Count Number of guesses token
				numGuessTxt.setText("Guess: " + cnt + "/10");
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		guessNumberProgram mainGame = new guessNumberProgram();
        mainGame.setVisible(true);
	}

}
