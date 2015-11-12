package pinckneyjames;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.Runnable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import org.apache.commons.lang3.time.StopWatch;

public class UI implements ActionListener, Runnable {
	static JFrame frame;
	static JPanel gamePanel;
	static JLabel userCredits, userCreditsPassive, timeWasted;
	static JButton creditClicker, computerStoreButton, developmentTeamButton,
			devTeamCredits;
	public static int coderCreditAmount; // Value of clicking creditClicker
	public static double userCreditAmount = 0;
	public static double pci=0.01; // Passive Credit Increase; Initialization
	static boolean abc = true;
	
	static Color one;
	static Color two;
	static Color three;
	static Color four;
	static Color five;
	static Color six;
	public StopWatch stopwatch;
	Clip clip;
	AudioInputStream stream;

	public UI(){
		
		
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		play();
	}

	public void guiSetUp() {
		
		// Initializing JFrame
		frame = new JFrame("MacMoney vAngry_Wasp");
		frame.setSize(640, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		stopwatch = new StopWatch();
		stopwatch.start();

		// Initializing JPanel
		gamePanel = new JPanel();
		gamePanel.setVisible(true);
		gamePanel.setLayout(null);
		gamePanel.setBackground(Color.decode("#99ca00"));
		frame.add(gamePanel);

		// JLabels
		userCredits = new JLabel(String.valueOf(userCreditAmount)); // Displays how many credits the user has, updated every second
		userCredits.setFont(new Font("Monospaced", Font.BOLD, 32));
		userCredits.setForeground(Color.BLUE);
		userCredits.setHorizontalAlignment(JLabel.CENTER);
		userCredits.setVerticalAlignment(JLabel.CENTER);
		userCredits.setBounds(0,0,640,125);
		/**
		 * SetSize + Location no longer needed. Now using setBounds()
		 */
		//userCredits.setSize(300, 50);
		//userCredits.setLocation(270, 25);
		gamePanel.add(userCredits);

		timeWasted = new JLabel("Time wasted :: " + stopwatch.toString());
		timeWasted.setFont(new Font("Monospaced", Font.PLAIN, 12));
		timeWasted.setForeground(Color.BLUE);
		timeWasted.setBounds(0,0,450,50);
		gamePanel.add(timeWasted);
		
		userCreditsPassive = new JLabel("Generating "+String.valueOf(getPCI()) + "/per second"); // change pci as you upgrade Development Team
		userCreditsPassive.setFont(new Font("Monospaced", Font.PLAIN, 16)); // Line above may have problems when the number gets larger
		userCreditsPassive.setForeground(Color.BLUE);
		userCreditsPassive.setHorizontalAlignment(JLabel.CENTER);
		userCreditsPassive.setVerticalAlignment(JLabel.CENTER);
		userCreditsPassive.setBounds(80,400,450,50);
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
		creditClicker.setBounds(160,125,305,250);
		/**
		 * SetSize + Location no longer needed. Now using setBounds()
		 */
		//creditClicker.setSize(305, 250);
		//creditClicker.setLocation(160, 125);
		creditClicker.setHorizontalAlignment(JLabel.CENTER);
		creditClicker.setActionCommand("creditClickerClicked");
		creditClicker.addActionListener(this);
		creditClicker.setFocusable(false);
		creditClicker.setVisible(true);
		gamePanel.add(creditClicker);

		computerStoreButton = new JButton("Computer Store");
		computerStoreButton.setFont(new Font("Monospaced", Font.PLAIN, 18));
		computerStoreButton.setBounds(0,480,205,100);
		/**
		 * SetSize + Location no longer needed. Now using setBounds()
		 */
		//computerStoreButton.setSize(205, 100);
		//computerStoreButton.setLocation(0, 480);
		computerStoreButton.setActionCommand("computerStoreButtonClicked");
		computerStoreButton.addActionListener(this);
		computerStoreButton.setFocusable(false);
		computerStoreButton.setVisible(true);
		gamePanel.add(computerStoreButton);

		developmentTeamButton = new JButton("Development Teams");
		developmentTeamButton.setFont(new Font("Monospaced", Font.PLAIN, 15));
		developmentTeamButton.setBounds(440,480,200,100);
		/**
		 * SetSize + Location no longer needed. Now using setBounds()
		 */
		//developmentTeamButton.setSize(200, 100);
		//developmentTeamButton.setLocation(440, 480);
		developmentTeamButton.setActionCommand("developmentTeamButtonClicked");
		developmentTeamButton.addActionListener(this);
		developmentTeamButton.setFocusable(false);
		developmentTeamButton.setVisible(true);
		gamePanel.add(developmentTeamButton);

		devTeamCredits = new JButton("Program Credits");
		devTeamCredits.setFont(new Font("Monospaced", Font.PLAIN, 18));
		/**
		 * SetSize + Location no longer needed. Now using setBounds()
		 */
		devTeamCredits.setSize(234, 100);
		devTeamCredits.setLocation(205, 480);
		devTeamCredits.setActionCommand("devTeamCreditsClicked");
		devTeamCredits.addActionListener(this);
		devTeamCredits.setFocusable(false);
		devTeamCredits.setVisible(true);
		gamePanel.add(devTeamCredits);
		frame.setVisible(true);
	}

	public static void main(String args[]){
		new UI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("creditClickerClicked")) {
			userCreditAmount += coderCreditAmount;
			DecimalFormat df = new DecimalFormat("##.##");
			String formattedText = "" + df.format(userCreditAmount);
			userCredits.setText(formattedText);
		}
		if (e.getActionCommand().equals("computerStoreButtonClicked")) {
			clip.stop();
			clip.loop(0);
			frame.setVisible(false);
			frame.dispose();
			ComputerStoreUI test = new ComputerStoreUI();
			test.cpuGUI();
			test.setVisibility(true);
		}
		if (e.getActionCommand().equals("developmentTeamButtonClicked")) {
			clip.stop();
			frame.setVisible(false);
			frame.dispose();
			DevelopmentTeamUI test = new DevelopmentTeamUI();
			test.devGUI();
			test.setVisibility(true);

		}
		if (e.getActionCommand().equals("devTeamCreditsClicked")) {
			clip.stop();
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

	@SuppressWarnings("static-access")
	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(1000);
				userCreditAmount += pci;
				DecimalFormat df = new DecimalFormat("##.##");
				df.setRoundingMode(RoundingMode.DOWN);
				userCredits.setText(df.format(userCreditAmount).toString());
				timeWasted.setText("Time wasted :: " + stopwatch.toString());
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
	@SuppressWarnings("static-access")
	public void setPCI(double pci)
	{
		this.pci = pci;
	}
	public double getcoderCreditAmount()
	{
		return coderCreditAmount;
	}
	@SuppressWarnings("static-access")
	public void setcoderCreditAmount(int coderCreditAmount)
	{
		this.coderCreditAmount = coderCreditAmount;
	}
	
	public void play() {
		  try {
			  InputStream audioSrc = getClass().getResourceAsStream("MacMoneySound.wav");
			  BufferedInputStream bufferedIn = new BufferedInputStream(audioSrc);
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedIn);
			  clip = AudioSystem.getClip();
			  clip.open(audioStream);
			  clip.start();
			  clip.loop(Clip.LOOP_CONTINUOUSLY);
		  } catch (Exception e) {
			  System.err.println(e.getMessage());
		  }
		 }
		 
	}


