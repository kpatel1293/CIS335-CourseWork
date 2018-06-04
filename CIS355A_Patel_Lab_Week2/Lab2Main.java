package lab2;

import javax.swing.JFrame;

public class Lab2Main 
{

	public static void main(String[] args) 
	{
		//GUI
		HealthProfileGUI hpg = new HealthProfileGUI();
		hpg.setSize(400,300);
		hpg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hpg.setVisible(true);
	}

}
