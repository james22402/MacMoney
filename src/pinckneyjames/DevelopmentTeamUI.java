package pinckneyjames;

import javax.swing.*;

import java.awt.*;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevelopmentTeamUI implements ActionListener {

	static JFrame frame;
	static JPanel gamePanel;
	static JButton goBack, buyItem1, buyItem2, buyItem3, buyItem4, buyItem5; 
	JLabel upgrade1, upgrade2, upgrade3, upgrade4, upgrade5;

	public DevelopmentTeamUI() {
		try {
			devGUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setVisibility(boolean a) {
		frame.setVisible(a);
	}

	public void devGUI() {

		frame = new JFrame("Development Store");
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
		goBack.setSize(205, 100);
		goBack.setLocation(220, 450);
		goBack.setActionCommand("goBackButtonClicked");
		goBack.addActionListener(this);
		goBack.setFocusable(false);
		goBack.setVisible(true);
		gamePanel.add(goBack);

		// All the damn JButtons
		buyItem1 = new JButton("~Purchase~");
		buyItem1.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem1.setSize(100, 25);
		buyItem1.setLocation(450, 30);
		buyItem1.setActionCommand("buyItem1");
		buyItem1.addActionListener(this);
		buyItem1.setVisible(true);
		buyItem1.setFocusable(false);
		gamePanel.add(buyItem1);
		// Macintosh Portable
		buyItem2 = new JButton("~Purchase~");
		buyItem2.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem2.setSize(100, 25);
		buyItem2.setLocation(450, 70);
		buyItem2.setActionCommand("buyItem2");
		buyItem2.addActionListener(this);
		buyItem2.setVisible(true);
		buyItem2.setFocusable(false);
		gamePanel.add(buyItem2);
		// Powerbook 100
		buyItem3 = new JButton("~Purchase~");
		buyItem3.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem3.setSize(100, 25);
		buyItem3.setLocation(450, 108);
		buyItem3.setActionCommand("buyItem3");
		buyItem3.addActionListener(this);
		buyItem3.setVisible(true);
		buyItem3.setFocusable(false);
		gamePanel.add(buyItem3);
		// Quadra 610
		buyItem4 = new JButton("~Purchase~");
		buyItem4.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem4.setSize(100, 25);
		buyItem4.setLocation(450, 148);
		buyItem4.setActionCommand("buyItem4");
		buyItem4.addActionListener(this);
		buyItem4.setVisible(true);
		buyItem4.setFocusable(false);
		gamePanel.add(buyItem4);
		// eMac G4
		buyItem5 = new JButton("~Purchase~");
		buyItem5.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem5.setSize(100, 25);
		buyItem5.setLocation(450, 198);
		buyItem5.setActionCommand("buyItem5");
		buyItem5.addActionListener(this);
		buyItem5.setVisible(true);
		buyItem5.setFocusable(false);
		gamePanel.add(buyItem5);

		// Starts all the JLabels

		upgrade1 = new JLabel("After School Club            $500.00 ");
		upgrade1.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade1.setForeground(UI.two);
		upgrade1.setSize(400, 20);
		upgrade1.setLocation(50, 30);
		upgrade1.setVisible(true);
		gamePanel.add(upgrade1);

		upgrade2 = new JLabel("Group of Friends             $1250.00");
		upgrade2.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade2.setForeground(UI.two);
		upgrade2.setSize(400, 20);
		upgrade2.setLocation(50, 70);
		upgrade2.setVisible(true);
		gamePanel.add(upgrade2);

		upgrade3 = new JLabel("Small Buisness Dev Team      $3250.00");
		upgrade3.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade3.setForeground(UI.two);
		upgrade3.setSize(400, 20);
		upgrade3.setLocation(50, 110);
		upgrade3.setVisible(true);
		gamePanel.add(upgrade3);

		upgrade4 = new JLabel("Executive Buisness Team     $9250.00");
		upgrade4.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade4.setForeground(UI.two);
		upgrade4.setSize(400, 20);
		upgrade4.setLocation(50, 150);
		upgrade4.setVisible(true);
		gamePanel.add(upgrade4);

		upgrade5 = new JLabel("Apple Dev Team              $13000.00");
		upgrade5.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade5.setForeground(UI.two);
		upgrade5.setSize(400, 20);
		upgrade5.setLocation(50, 200);
		upgrade5.setVisible(true);
		gamePanel.add(upgrade5);

		}

	public void actionPerformed(ActionEvent e) {
		UI test1 = new UI();
		test1.setVisibility(false);
		if (e.getActionCommand().equals("goBackButtonClicked")) {
			frame.setVisible(false);
			frame.dispose();
			test1.setVisibility(true);
			

		} else if (e.getActionCommand().equals("buyItem1")) {

			if (test1.getUserCreditAmount() >= 500) {
				test1.setcoderCreditAmount(2 + (int)test1.getcoderCreditAmount());
				UI.creditClicker.setText(String.valueOf(test1.getcoderCreditAmount())
						+ "$ Credit");
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 500);
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
				
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem2")) {
			if (test1.getUserCreditAmount() >= 1250) {
				test1.setcoderCreditAmount(5 + (int)test1.getcoderCreditAmount());
				UI.creditClicker.setText(String.valueOf(test1.getcoderCreditAmount())
						+ "$ Credit");
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 1250);
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
				
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem3")) {
			if (test1.getUserCreditAmount() >= 3250) {
				test1.setcoderCreditAmount(25 + (int)test1.getcoderCreditAmount());
				UI.creditClicker.setText(String.valueOf(test1.getcoderCreditAmount())
						+ "$ Credit");
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 3250);
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
				
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem4")) {
			if (test1.getUserCreditAmount() >= 9250) {
				test1.setcoderCreditAmount(85 + (int)test1.getcoderCreditAmount());
				UI.creditClicker.setText(String.valueOf(test1.getcoderCreditAmount())
						+ "$ Credit");
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 9250);
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
				
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem5")) {
			if (test1.getUserCreditAmount() >= 13000) {
				test1.setcoderCreditAmount(210 + (int)test1.getcoderCreditAmount());
				UI.creditClicker.setText(String.valueOf(test1.getcoderCreditAmount())
						+ "$ Credit");
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 13000);
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
				
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		}
	}
}


