package pinckneyjames;

import javax.swing.*;

import java.awt.*;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits implements ActionListener {

	static JFrame frame;
	static JPanel gamePanel;
	static JButton goBack;
	static JLabel DescriptionTop, DescriptionBottom, JamesTop, JamesMiddle, JamesBottom, Space, LilaTop, LilaBottom, SecondSpace,
			AidanTop, AidanMiddle, AidanBottom, ThirdSpace, JamieTop, JamieBottom, title, versionNumber, updateDate, MusicCredits;

	public Credits() {
		creditsGUI();

	}

	public void setVisibility(boolean a) {
		frame.setVisible(a);
	}

	public void creditsGUI() {

		frame = new JFrame("Credits");
		frame.setVisible(false);
		frame.setLayout(null);
		frame.setSize(640, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		gamePanel = new JPanel();
		gamePanel.setVisible(true);
		gamePanel.setLayout(null);
		gamePanel.setBackground(UI.five);
		frame.add(gamePanel);

		goBack = new JButton("Back To Game");
		goBack.setFont(new Font("Monospaced", Font.PLAIN, 18));
		goBack.setSize(200, 50);
		goBack.setLocation(220, 500);
		goBack.setActionCommand("goBackButtonClicked");
		goBack.addActionListener(this);
		goBack.setFocusable(false);
		goBack.setVisible(true);
		gamePanel.add(goBack);
		
		// TODO Fix the text so it looks better, version 2.0?

		// Credit Text Here:
		
		title = new JLabel("Development Credits");
		title.setFont(new Font("Monospaced", Font.BOLD, 16));
		title.setForeground(Color.BLACK);
		title.setSize(400, 50);
		title.setLocation(225, 0);
		title.setVisible(true);
		gamePanel.add(title);
		
		versionNumber = new JLabel("v. Dynamic Penguin"); // Version Number of game also displayed in JFrame for UI
		versionNumber.setFont(new Font("Monospaced", Font.PLAIN, 12));
		versionNumber.setForeground(Color.BLACK);
		versionNumber.setSize(200, 50);
		versionNumber.setLocation(15, 500);
		versionNumber.setVisible(true);
		gamePanel.add(versionNumber);
		
		updateDate = new JLabel("Updated: November 21st, 2015");
		updateDate.setFont(new Font("Monospaced", Font.PLAIN, 12));
		updateDate.setForeground(Color.BLACK);
		updateDate.setSize(400, 50);
		updateDate.setLocation(15, 515);
		updateDate.setVisible(true);
		gamePanel.add(updateDate);
		
		DescriptionTop = new JLabel("This app was made by James Pinckney, Lila Hempel-Edgers,");
		DescriptionBottom = new JLabel("Aidan Lee, and Jamie Tynan at Code Day Boston 2015");
		JamesTop = new JLabel("James Pinckney is a 17 year old who is an avid programmer,");
		JamesMiddle = new JLabel("a bright leader in his school, a senior in the Windsor High School");
		JamesBottom = new JLabel("WHS chapter of NHS, as well as a member of the WHS Tech Club.");
		Space = new JLabel(" "); 
		LilaTop = new JLabel("Lila Hempel-Edgers is a 13 year old student at NuVu School of Innovation, ");
		LilaBottom = new JLabel("as a member of the CMS band, and a budding artist.");
		SecondSpace = new JLabel(" ");
		AidanTop = new JLabel("Aidan Lee is a 17 year old 2nd stand violin player his local orchestra,");
		AidanMiddle = new JLabel("as well as a member of the Windsor FRC team, Team Paragon 571, and a senior at");
		AidanBottom = new JLabel("Windsor High School in the WHS chapter of NHS.");
		ThirdSpace = new JLabel(" ");
		JamieTop = new JLabel("Jamie Tynan is a 15 year old cello player her loca orchestra, ");
		JamieBottom = new JLabel("a member of the Windsor High School swim team and part of the WHS Tech Club");
		MusicCredits = new JLabel("All Music belongs to their respectful owner. Music by Ninety9Lives");

		// text initalizers
		DescriptionTop.setVisible(true);
		DescriptionTop.setFont(new Font("Monospaced", Font.PLAIN, 12));
		DescriptionTop.setForeground(UI.three);
		DescriptionTop.setSize(950, 100);
		DescriptionTop.setLocation(50, 0);
		gamePanel.add(DescriptionTop);

		DescriptionBottom.setVisible(true);
		DescriptionBottom.setFont(new Font("Monospaced", Font.PLAIN, 12));
		DescriptionBottom.setForeground(UI.three);
		DescriptionBottom.setSize(950, 100);
		DescriptionBottom.setLocation(50, 25);
		gamePanel.add(DescriptionBottom);

		JamesTop.setVisible(true);
		JamesTop.setFont(new Font("Monospaced", Font.PLAIN, 12));
		JamesTop.setForeground(UI.three);
		JamesTop.setSize(2300, 100);
		JamesTop.setLocation(50, 75);
		gamePanel.add(JamesTop);

		JamesMiddle.setVisible(true);
		JamesMiddle.setFont(new Font("Monospaced", Font.PLAIN, 12));
		JamesMiddle.setForeground(UI.three);
		JamesMiddle.setSize(2300, 100);
		JamesMiddle.setLocation(50, 100);
		gamePanel.add(JamesMiddle);

		JamesBottom.setVisible(true);
		JamesBottom.setFont(new Font("Monospaced", Font.PLAIN, 12));
		JamesBottom.setForeground(UI.three);
		JamesBottom.setSize(2300, 100);
		JamesBottom.setLocation(50, 125);
		gamePanel.add(JamesBottom);

		Space.setVisible(true);
		Space.setFont(new Font("Monospaced", Font.PLAIN, 12));
		Space.setForeground(UI.three);
		Space.setSize(2300, 100);
		Space.setLocation(50, 125);
		//gamePanel.add(var6);

		LilaTop.setVisible(true);
		LilaTop.setFont(new Font("Monospaced", Font.PLAIN, 12));
		LilaTop.setForeground(UI.three);
		LilaTop.setSize(1100, 100);
		LilaTop.setLocation(50, 175);
		gamePanel.add(LilaTop);

		LilaBottom.setVisible(true);
		LilaBottom.setFont(new Font("Monospaced", Font.PLAIN, 12));
		LilaBottom.setForeground(UI.three);
		LilaBottom.setSize(1100, 100);
		LilaBottom.setLocation(50, 200);
		gamePanel.add(LilaBottom);

		SecondSpace.setVisible(true);
		SecondSpace.setFont(new Font("Monospaced", Font.PLAIN, 12));
		SecondSpace.setForeground(UI.three);
		SecondSpace.setSize(1100, 100);
		SecondSpace.setLocation(50, 225);
		gamePanel.add(SecondSpace);

		AidanTop.setVisible(true);
		AidanTop.setFont(new Font("Monospaced", Font.PLAIN, 12));
		AidanTop.setForeground(UI.three);
		AidanTop.setSize(2450, 100);
		AidanTop.setLocation(50, 250);
		gamePanel.add(AidanTop);

		AidanMiddle.setVisible(true);
		AidanMiddle.setFont(new Font("Monospaced", Font.PLAIN, 12));
		AidanMiddle.setForeground(UI.three);
		AidanMiddle.setSize(2450, 100);
		AidanMiddle.setLocation(50, 275);
		gamePanel.add(AidanMiddle);

		AidanBottom.setVisible(true);
		AidanBottom.setFont(new Font("Monospaced", Font.PLAIN, 12));
		AidanBottom.setForeground(UI.three);
		AidanBottom.setSize(2450, 100);
		AidanBottom.setLocation(50, 300);
		gamePanel.add(AidanBottom);

		ThirdSpace.setVisible(true);
		ThirdSpace.setFont(new Font("Monospaced", Font.PLAIN, 12));
		ThirdSpace.setForeground(UI.three);
		ThirdSpace.setSize(2450, 100);
		ThirdSpace.setLocation(50, 325);
		gamePanel.add(ThirdSpace);

		JamieTop.setVisible(true);
		JamieTop.setFont(new Font("Monospaced", Font.PLAIN, 12));
		JamieTop.setForeground(UI.three);
		JamieTop.setSize(1800, 100);
		JamieTop.setLocation(50, 350);
		gamePanel.add(JamieTop);

		JamieBottom.setVisible(true);
		JamieBottom.setFont(new Font("Monospaced", Font.PLAIN, 12));
		JamieBottom.setForeground(UI.three);
		JamieBottom.setSize(1800, 100);
		JamieBottom.setLocation(50, 375);
		gamePanel.add(JamieBottom);
		
		MusicCredits.setVisible(true);
		MusicCredits.setFont(new Font("Monospaced", Font.PLAIN, 12));
		MusicCredits.setForeground(UI.three);
		MusicCredits.setSize(1800, 100);
		MusicCredits.setLocation(50, 425);
		gamePanel.add(MusicCredits);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("goBackButtonClicked")) {
			frame.setVisible(false);
			frame.dispose();
			UI test = new UI();
			test.setVisibility(true);

		}

	}

}


