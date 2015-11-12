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
	static JLabel var1, var2, var3, var4, var5, var6, var8, var9, var10,
			var11, var12, var13, var14, var16, var17, title, versionNumber, updateDate;

	public Credits() {
		creditsGUI();

	}

	public void setVisibility(boolean a) {
		frame.setVisible(a);
	}

	public void creditsGUI() {
		@SuppressWarnings("unused")
		UI color = new UI();

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
		
		versionNumber = new JLabel("v1.0.1"); // Version Number of game also displayed in JFrame for UI
		versionNumber.setFont(new Font("Monospaced", Font.PLAIN, 12));
		versionNumber.setForeground(Color.BLACK);
		versionNumber.setSize(200, 50);
		versionNumber.setLocation(15, 500);
		versionNumber.setVisible(true);
		gamePanel.add(versionNumber);
		
		updateDate = new JLabel("Updated: November 9th, 2015");
		updateDate.setFont(new Font("Monospaced", Font.PLAIN, 12));
		updateDate.setForeground(Color.BLACK);
		updateDate.setSize(400, 50);
		updateDate.setLocation(15, 515);
		updateDate.setVisible(true);
		gamePanel.add(updateDate);
		
		var1 = new JLabel(
				"This app was made by Connor Bailey, Lila Hempel-Edgers,");
		var2 = new JLabel("Aidan Lee, and Jamie Tynan at Code Day Boston 2015");
		var3 = new JLabel(
				"Connor Bailey is a 17 year old 1st Viola in his local orchestra,");
		var4 = new JLabel(
				"an Apple retail employee, a senior in the Windsor High School");
		var5 = new JLabel(
				" WHS chapter of NHS, as well as co-president of the WHS Tech Club.");
		var6 = new JLabel(" "); 
		var8 = new JLabel("Lila Hempel-Edgers is a 13 year old student at NuVu School of Innovation, ");
		var9 = new JLabel("as a member of the CMS band, and a budding artist.");
		var10 = new JLabel(" ");
		var11 = new JLabel("Aidan Lee is a 17 year old 2nd stand violin player his local orchestra,");
		var12 = new JLabel(
				"as well as a member of the Windsor FRC team, Team Paragon 571, and a senior at");
		var13 = new JLabel(
				"Windsor High School in the WHS chapter of NHS.");
		var14 = new JLabel(" ");
		var16 = new JLabel(
				"Jamie Tynan is a 15 year old cello player her loca orchestra, ");
		var17 = new JLabel(
				"a member of the Windsor High School swim team and part of the WHS Tech Club");

		// text initalizers
		var1.setVisible(true);
		var1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var1.setForeground(UI.three);
		var1.setSize(950, 100);
		var1.setLocation(50, 0);
		gamePanel.add(var1);

		var2.setVisible(true);
		var2.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var2.setForeground(UI.three);
		var2.setSize(950, 100);
		var2.setLocation(50, 25);
		gamePanel.add(var2);

		var3.setVisible(true);
		var3.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var3.setForeground(UI.three);
		var3.setSize(2300, 100);
		var3.setLocation(50, 50);
		gamePanel.add(var3);

		var4.setVisible(true);
		var4.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var4.setForeground(UI.three);
		var4.setSize(2300, 100);
		var4.setLocation(50, 75);
		gamePanel.add(var4);

		var5.setVisible(true);
		var5.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var5.setForeground(UI.three);
		var5.setSize(2300, 100);
		var5.setLocation(50, 100);
		gamePanel.add(var5);

		var6.setVisible(true);
		var6.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var6.setForeground(UI.three);
		var6.setSize(2300, 100);
		var6.setLocation(50, 125);
		gamePanel.add(var6);

		var8.setVisible(true);
		var8.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var8.setForeground(UI.three);
		var8.setSize(1100, 100);
		var8.setLocation(50, 175);
		gamePanel.add(var8);

		var9.setVisible(true);
		var9.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var9.setForeground(UI.three);
		var9.setSize(1100, 100);
		var9.setLocation(50, 200);
		gamePanel.add(var9);

		var10.setVisible(true);
		var10.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var10.setForeground(UI.three);
		var10.setSize(1100, 100);
		var10.setLocation(50, 225);
		gamePanel.add(var10);

		var11.setVisible(true);
		var11.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var11.setForeground(UI.three);
		var11.setSize(2450, 100);
		var11.setLocation(50, 250);
		gamePanel.add(var11);

		var12.setVisible(true);
		var12.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var12.setForeground(UI.three);
		var12.setSize(2450, 100);
		var12.setLocation(50, 275);
		gamePanel.add(var12);

		var13.setVisible(true);
		var13.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var13.setForeground(UI.three);
		var13.setSize(2450, 100);
		var13.setLocation(50, 300);
		gamePanel.add(var13);

		var14.setVisible(true);
		var14.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var14.setForeground(UI.three);
		var14.setSize(2450, 100);
		var14.setLocation(50, 325);
		gamePanel.add(var14);

		var16.setVisible(true);
		var16.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var16.setForeground(UI.three);
		var16.setSize(1800, 100);
		var16.setLocation(50, 375);
		gamePanel.add(var16);

		var17.setVisible(true);
		var17.setFont(new Font("Monospaced", Font.PLAIN, 12));
		var17.setForeground(UI.three);
		var17.setSize(1800, 100);
		var17.setLocation(50, 400);
		gamePanel.add(var17);

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


