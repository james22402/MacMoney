import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Runnable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JFrame;

public class UI implements ActionListener, Runnable {
	static JFrame frame;
	static JPanel gamePanel;
	static JLabel userCredits, userCreditsPassive;
	static JButton creditClicker, computerStoreButton, developmentTeamButton,
			devTeamCredits;
	public static int coderCreditAmount; // Value of clicking creditClicker
	public static double userCreditAmount = 0;
	public static double pci = 0.01; // Passive Credit Increase; Initialization
	static boolean abc = true;
	
	Color one;
	Color two;
	Color three;
	Color four;
	Color five;
	Color six;

	public UI() {
		
		
		if (abc == true) // Don't mess with this, this fixes Thread being run more then once when different windows opened
		{                // Seriously, if you touch this if statement I'm gonna kill you. 
			guiSetUp();
			new Thread(this).start();                       
			abc = false;
		}
		
		one = new Color(39,24,72);
		two = new Color(88,56,86);
		three = new Color(175,90,80);
		four = new Color(235,154,93);
		five = new Color(253,226,130);
		six = new Color(190,58,62);
	}

	public void guiSetUp() {
		
		
		// Initializing JFrame
		frame = new JFrame("MacMoney v1.0.1");
		frame.setLayout(null);
		frame.setSize(640, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		// Initializing JPanel
		gamePanel = new JPanel();
		gamePanel.setVisible(true);
		gamePanel.setLayout(null);
		gamePanel.setBackground(Color.ORANGE);
		frame.add(gamePanel);

		// JLabels
		userCredits = new JLabel(String.valueOf(userCreditAmount)); // Displays how many credits the user has, updated every second
		userCredits.setFont(new Font("Monospaced", Font.BOLD, 32));
		userCredits.setForeground(Color.BLUE);
		//userCredits.setBounds(225,25,450,50);
		userCredits.setSize(300, 50);
		userCredits.setLocation(270, 25);
		gamePanel.add(userCredits);

		userCreditsPassive = new JLabel("Generating "+String.valueOf(pci) + "/per second"); // change pci as you upgrade Development Team
		userCreditsPassive.setFont(new Font("Monospaced", Font.PLAIN, 16)); // Line above may have problems when the number gets larger
		userCreditsPassive.setForeground(Color.BLUE);
		userCreditsPassive.setBounds(180,400,400,50);
		/**
		 * SetSize + Location no longer needed. Now using setBounds()
		 */
		//userCreditsPassive.setSize(200, 50);
		//serCreditsPassive.setLocation(240, 400);
		gamePanel.add(userCreditsPassive);

		// JButtons
		coderCreditAmount = 1;
		creditClicker = new JButton(coderCreditAmount + "$ Credit");
		creditClicker.setFont(new Font("Monospaced", Font.PLAIN, 32));
		creditClicker.setSize(305, 250);
		creditClicker.setLocation(160, 125);
		creditClicker.setHorizontalAlignment(JLabel.CENTER);
		creditClicker.setActionCommand("creditClickerClicked");
		creditClicker.addActionListener(this);
		creditClicker.setFocusable(false);
		creditClicker.setVisible(true);
		gamePanel.add(creditClicker);

		computerStoreButton = new JButton("Computer Store");
		computerStoreButton.setFont(new Font("Monospaced", Font.PLAIN, 18));
		computerStoreButton.setSize(205, 100);
		computerStoreButton.setLocation(0, 480);
		computerStoreButton.setActionCommand("computerStoreButtonClicked");
		computerStoreButton.addActionListener(this);
		computerStoreButton.setFocusable(false);
		computerStoreButton.setVisible(true);
		gamePanel.add(computerStoreButton);

		developmentTeamButton = new JButton("Development Team");
		developmentTeamButton.setFont(new Font("Monospaced", Font.PLAIN, 18));
		developmentTeamButton.setSize(200, 100);
		developmentTeamButton.setLocation(440, 480);
		developmentTeamButton.setActionCommand("developmentTeamButtonClicked");
		developmentTeamButton.addActionListener(this);
		developmentTeamButton.setFocusable(false);
		developmentTeamButton.setVisible(true);
		gamePanel.add(developmentTeamButton);

		devTeamCredits = new JButton("Credits");
		devTeamCredits.setFont(new Font("Monospaced", Font.PLAIN, 18));
		devTeamCredits.setSize(234, 100);
		devTeamCredits.setLocation(205, 480);
		devTeamCredits.setActionCommand("devTeamCreditsClicked");
		devTeamCredits.addActionListener(this);
		devTeamCredits.setFocusable(false);
		devTeamCredits.setVisible(true);
		gamePanel.add(devTeamCredits);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		new UI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("creditClickerClicked")) {
			userCreditAmount += coderCreditAmount;
			userCredits.setText(String.valueOf((float) (userCreditAmount)));
		}
		if (e.getActionCommand().equals("computerStoreButtonClicked")) {
			frame.setVisible(false);
			frame.dispose();
			ComputerStoreUI test = new ComputerStoreUI();
			test.cpuGUI();
			test.setVisibility(true);
		}
		if (e.getActionCommand().equals("developmentTeamButtonClicked")) {
			frame.setVisible(false);
			frame.dispose();
			DevelopmentTeamUI test = new DevelopmentTeamUI();
			test.devGUI();
			test.setVisibility(true);

		}
		if (e.getActionCommand().equals("devTeamCreditsClicked")) {
			frame.setVisible(false);
			frame.dispose();
			Credits test = new Credits();
			test.creditsGUI();
			test.setVisibility(true);
		}

	}

	public void setVisibility(boolean a) {
		frame.setVisible(a);

	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(1000);
				userCreditAmount += pci;
				DecimalFormat df = new DecimalFormat("##.##");
				df.setRoundingMode(RoundingMode.DOWN);
				userCredits.setText(df.format(userCreditAmount).toString());
			}
		}

		catch (Exception e) {
		}
	}

	public double getUserCreditAmount()
	{
		return userCreditAmount;
	}
	public void setUserCreditAmount(double newValue)
	{
		userCreditAmount = newValue;
	}
	
	public double getPCI()
	{
		return pci;
	}
	public void setPCI(double pci)
	{
		this.pci = pci;
	}
	public double getcoderCreditAmount()
	{
		return coderCreditAmount;
	}
	public void setcoderCreditAmount()
	{
		this.coderCreditAmount = coderCreditAmount;
	}
	

}


