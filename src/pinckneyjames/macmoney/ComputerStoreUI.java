package pinckneyjames.macmoney;

import javax.swing.*;

import java.awt.*;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerStoreUI implements ActionListener {

	JFrame frame;
	JPanel gamePanel;
	JButton goBack, buyItem1, buyItem2, buyItem3, buyItem4, buyItem5, buyItem6,
			buyItem7, buyItem8, buyItem9;
	JLabel upgrade1, upgrade2, upgrade3, upgrade4, upgrade5, upgrade6,
			upgrade7, upgrade8, upgrade9;
	//UI ui;
	//double pci;

	public ComputerStoreUI() {
		cpuGUI();
		//ui = new UI();
		//pci = ui.getPCI();
	}

	public void setVisibility(boolean a) {
		frame.setVisible(a);

	}

	public void cpuGUI() {
		//UI color = new UI();

		// Computer Store JFrame
		frame = new JFrame("Computer Store");
		frame.setVisible(false);
		frame.setLayout(null);
		frame.setSize(640, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		// JPanel
		gamePanel = new JPanel();
		gamePanel.setVisible(true);
		gamePanel.setLayout(null);
		gamePanel.setBackground(UI.five);
		frame.add(gamePanel);

		// JButton
		goBack = new JButton("Back To Game");
		goBack.setFont(new Font("Monospaced", Font.PLAIN, 18));
		goBack.setSize(205, 100);
		goBack.setLocation(220, 450);
		goBack.setActionCommand("goBackButtonClicked");
		goBack.addActionListener(this);
		goBack.setFocusable(false);
		goBack.setVisible(true);
		gamePanel.add(goBack);

		// Mac XL:
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
		// iBook
		buyItem6 = new JButton("~Purchase~");
		buyItem6.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem6.setSize(100, 25);
		buyItem6.setLocation(450, 249);
		buyItem6.setActionCommand("buyItem6");
		buyItem6.addActionListener(this);
		buyItem6.setVisible(true);
		buyItem6.setFocusable(false);
		gamePanel.add(buyItem6);
		// iMac
		buyItem7 = new JButton("~Purchase~");
		buyItem7.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem7.setSize(100, 25);
		buyItem7.setLocation(450, 299);
		buyItem7.setActionCommand("buyItem7");
		buyItem7.addActionListener(this);
		buyItem7.setVisible(true);
		buyItem7.setFocusable(false);
		gamePanel.add(buyItem7);
		// MacBook
		buyItem8 = new JButton("~Purchase~");
		buyItem8.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem8.setSize(100, 25);
		buyItem8.setLocation(450, 350);
		buyItem8.setActionCommand("buyItem8");
		buyItem8.addActionListener(this);
		buyItem8.setVisible(true);
		buyItem8.setFocusable(false);
		gamePanel.add(buyItem8);
		// Mac Pro
		buyItem9 = new JButton("~Purchase~");
		buyItem9.setFont(new Font("Monospaced", Font.PLAIN, 10));
		buyItem9.setSize(100, 25);
		buyItem9.setLocation(450, 398);
		buyItem9.setActionCommand("buyItem9");
		buyItem9.addActionListener(this);
		buyItem9.setVisible(true);
		buyItem9.setFocusable(false);
		gamePanel.add(buyItem9);

		// JLabel
		upgrade1 = new JLabel("Mac XL                      $750.00 "); 
		upgrade1.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade1.setForeground(UI.two);
		upgrade1.setSize(400, 20);
		upgrade1.setLocation(50, 30);
		upgrade1.setVisible(true);
		gamePanel.add(upgrade1);

		upgrade2 = new JLabel("Macintosh Portable         $2500.00");
		upgrade2.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade2.setForeground(UI.two);
		upgrade2.setSize(400, 20);
		upgrade2.setLocation(50, 70);
		upgrade2.setVisible(true);
		gamePanel.add(upgrade2);

		upgrade3 = new JLabel("Powerbook 100              $5500.00");
		upgrade3.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade3.setForeground(UI.two);
		upgrade3.setSize(400, 20);
		upgrade3.setLocation(50, 110);
		upgrade3.setVisible(true);
		gamePanel.add(upgrade3);

		upgrade4 = new JLabel("Quadra 610                $13000.00");
		upgrade4.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade4.setForeground(UI.two);
		upgrade4.setSize(400, 20);
		upgrade4.setLocation(50, 150);
		upgrade4.setVisible(true);
		gamePanel.add(upgrade4);

		upgrade5 = new JLabel("eMac G4                   $50000.00");
		upgrade5.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade5.setForeground(UI.two);
		upgrade5.setSize(400, 20);
		upgrade5.setLocation(50, 200);
		upgrade5.setVisible(true);
		gamePanel.add(upgrade5);

		upgrade6 = new JLabel("iBook                    $150000.00");
		upgrade6.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade6.setForeground(UI.two);
		upgrade6.setSize(400, 20);
		upgrade6.setLocation(50, 250);
		upgrade6.setVisible(true);
		gamePanel.add(upgrade6);

		upgrade7 = new JLabel("iMac                     $600000.00");
		upgrade7.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade7.setForeground(UI.two);
		upgrade7.setSize(400, 20);
		upgrade7.setLocation(50, 300);
		upgrade7.setVisible(true);
		gamePanel.add(upgrade7);

		upgrade8 = new JLabel("MacBook                 $3000000.00");
		upgrade8.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade8.setForeground(UI.two);
		upgrade8.setSize(400, 20);
		upgrade8.setLocation(50, 350);
		upgrade8.setVisible(true);
		gamePanel.add(upgrade8);

		upgrade9 = new JLabel("Mac Pro                $25000000.00");
		upgrade9.setFont(new Font("Monospaced", Font.BOLD, 16));
		upgrade9.setForeground(UI.two);
		upgrade9.setSize(400, 20);
		upgrade9.setLocation(50, 400);
		upgrade9.setVisible(true);
		gamePanel.add(upgrade9);

		// This is enough upgrades

	}

	// Handles the button commands to buy upgrades
	public void actionPerformed(ActionEvent e) {
		UI test1 = new UI();
		if (e.getActionCommand().equals("goBackButtonClicked")) {
			frame.setVisible(false);
			frame.dispose();
			test1.setVisibility(true);
		} else if (e.getActionCommand().equals("buyItem1")) {
			if (test1.getUserCreditAmount() >= 750) {
				//pci = test1.getPCI();
				test1.setPCI(0.5 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 750);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem2")) {
			if (test1.getUserCreditAmount() >= 2500) {
				//pci = test1.getPCI();
				test1.setPCI(1.0 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 2500);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem3")) {
			if (test1.getUserCreditAmount() >= 5500) {
				//pci = test1.getPCI();
				test1.setPCI(2.0 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 5500);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem4")) {
			if (test1.getUserCreditAmount() >= 13000) {
				//pci = test1.getPCI();
				test1.setPCI(5.0 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 13000);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem5")) {

			if (test1.getUserCreditAmount() >= 50000) {
				//pci = test1.getPCI();
				test1.setPCI(20.0 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 50000);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem6")) {
			if (test1.getUserCreditAmount() >= 150000) {
				//pci = test1.getPCI();
				test1.setPCI(50.0 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 150000);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem7")) {
			if (test1.getUserCreditAmount() >= 600000) {
				//pci = test1.getPCI();
				test1.setPCI(100.0 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 600000);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem8")) {
			if (test1.getUserCreditAmount() >= 3000000) {
				test1.setPCI(150.0 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 3000000);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		} else if (e.getActionCommand().equals("buyItem9")) {
			if (test1.getUserCreditAmount() >= 25000000) {
				//pci = test1.getPCI();
				test1.setPCI(300.0 + test1.getPCI());
				test1.setUserCreditAmount(test1.getUserCreditAmount() - 25000000);
				UI.userCreditsPassive.setText("Generating " + String.valueOf(test1.getPCI())
						+ "/per second");
				frame.setVisible(false);
				frame.dispose();
				test1.setVisibility(true);
			}
			else {
			    JOptionPane.showMessageDialog(null, "You don't have enough money!", "Error!", JOptionPane.ERROR_MESSAGE);
			 }
		}

		// End of else if
	}
}


