package pinckneyjames;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.Runnable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Base64;
import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;

public class UI implements ActionListener, Runnable {
	static JFrame frame;
	static JPanel gamePanel;
	static JLabel userCredits, userCreditsPassive, timeWasted;
	static JButton creditClicker, computerStoreButton, developmentTeamButton,
			devTeamCredits, load, save;
	static JFileChooser chooseFile;
	public static int coderCreditAmount=1; // Value of clicking creditClicker
	public static double userCreditAmount = 0;
	public static double pci=0.0; // Passive Credit Increase; Initialization
	static boolean abc = true;
	File tempFile;
	PrintWriter writer;
	
	static Color one;
	static Color two;
	static Color three;
	static Color four;
	static Color five;
	static Color six;
	public StopWatch stopwatch;
	Clip clip;
	int cnt = 9;

	/**
	 * Default Constructor - Fixed issue with the double thread
	 */
	public UI(){
		//Fixed the issue - I messed with it
		/**
		if (abc == true) // Don't mess with this, this fixes Thread being run more then once when different windows opened
		{                // Seriously, if you touch this if statement I'm gonna kill you. 
			guiSetUp();
			new Thread(this).start();                       
			abc = false;
		}
		*/
		guiSetUp();
		//play();
		one = new Color(39,24,72);
		two = new Color(88,56,86);
		three = new Color(175,90,80);
		four = new Color(235,154,93);
		five = new Color(253,226,130);
		six = new Color(190,58,62);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * 
	 * @param a Makes it so that we do not repeat the same constructor over and over
	 */
	public UI(boolean a){
			new Thread(this).start(); 
			guiSetUp();
			one = new Color(39,24,72);
			two = new Color(88,56,86);
			three = new Color(175,90,80);
			four = new Color(235,154,93);
			five = new Color(253,226,130);
			six = new Color(190,58,62);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	public void guiSetUp() {
		// Initializing JFrame
		frame = new JFrame("MacMoney vDynamic Penguin");
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

		timeWasted = new JLabel("Time wasted :: " + stopwatch.toString().substring(0, stopwatch.toString().length()-4));
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
		
		load = new JButton("Load Game");
		load.setFont(new Font("Monospaced", Font.PLAIN, 12));
		load.setBounds(30,100,100,50);
		/**
		 * SetSize + Location no longer needed. Now using setBounds()
		 */
		//computerStoreButton.setSize(205, 100);
		//computerStoreButton.setLocation(0, 480);
		load.setActionCommand("loadClicked");
		load.addActionListener(this);
		load.setFocusable(false);
		load.setVisible(true);
		gamePanel.add(load);
		
		save = new JButton("Save Game");
		save.setFont(new Font("Monospaced", Font.PLAIN, 12));
		save.setBounds(30,150,100,50);
		/**
		 * SetSize + Location no longer needed. Now using setBounds()
		 */
		//computerStoreButton.setSize(205, 100);
		//computerStoreButton.setLocation(0, 480);
		save.setActionCommand("saveClicked");
		save.addActionListener(this);
		save.setFocusable(false);
		save.setVisible(true);
		gamePanel.add(save);
		
		//JFileChooser
		chooseFile = new JFileChooser();
	}

	public static void main(String args[]){
		new UI(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("creditClickerClicked")) {
			userCreditAmount += coderCreditAmount;
			DecimalFormat df = new DecimalFormat("##.##");
			String formattedText = "" + df.format(userCreditAmount);
			userCredits.setText(formattedText);
		}
		if (e.getActionCommand().equals("computerStoreButtonClicked")) {
			frame.setVisible(false);
			frame.removeAll();
			ComputerStoreUI test = new ComputerStoreUI();
			test.cpuGUI();
			test.setVisibility(true);
		}
		if (e.getActionCommand().equals("developmentTeamButtonClicked")) {
			frame.setVisible(false);
			frame.removeAll();
			DevelopmentTeamUI test = new DevelopmentTeamUI();
			test.devGUI();
			test.setVisibility(true);

		}
		if (e.getActionCommand().equals("devTeamCreditsClicked")) {
			frame.setVisible(false);
			frame.removeAll();
			Credits test = new Credits();
			test.creditsGUI();
			test.setVisibility(true);
		}
		if (e.getActionCommand().equals("loadClicked")) {
			
			try {
				openFile();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("saveClicked")) {
			
			try {
				createFile();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
				timeWasted.setText("Time wasted :: " + stopwatch.toString().substring(0, stopwatch.toString().length()-4));
				userCreditAmount += pci;
				DecimalFormat df = new DecimalFormat("##.##");
				df.setRoundingMode(RoundingMode.DOWN);
				userCredits.setText(df.format(userCreditAmount).toString());
				if(stopwatch.getNanoTime() <= 1000000000 || (clip.getMicrosecondPosition() == clip.getMicrosecondLength()))
				{
					play();
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
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
	public int getcoderCreditAmount()
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
			  if(cnt == 0)
			  {
				InputStream jakeSong = getClass().getResourceAsStream("MacMoneySound.wav");
				BufferedInputStream bufferedIn = new BufferedInputStream(jakeSong);
			    AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedIn);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 1)
			  {
				InputStream HavenBleeding = getClass().getResourceAsStream("Haven - Bleeding Through.wav");
				BufferedInputStream bufferedInJake = new BufferedInputStream(HavenBleeding);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 2)
			  {
				InputStream JskeeIAm = getClass().getResourceAsStream("Jskee - I Am Pharaoh .wav");
				BufferedInputStream bufferedInJake = new BufferedInputStream(JskeeIAm);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 3)
			  {
				InputStream KozoroASpring = getClass().getResourceAsStream("Kozoro - A Spring Without You (feat. Noctilucent).wav");
				BufferedInputStream bufferedInJake = new BufferedInputStream(KozoroASpring);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 4)
			  {
				InputStream KozoroRyzu = getClass().getResourceAsStream("Kozoro, Ryzu, Unison _ Evence - Ascend.wav");
				BufferedInputStream bufferedInJake = new BufferedInputStream(KozoroRyzu);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 5)
			  {
				InputStream RyzuUnison = getClass().getResourceAsStream("Ryzu _ Unison - Midway.wav");
				BufferedInputStream bufferedInJake = new BufferedInputStream(RyzuUnison);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 6)
			  {
				InputStream tiasuThorn = getClass().getResourceAsStream("tiasu - Thorn.wav");
				BufferedInputStream bufferedInJake = new BufferedInputStream(tiasuThorn);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 7)
			  {
				InputStream WiseYoung1 = getClass().getResourceAsStream("Wise Young Gent - A New Beginning.wav");
				BufferedInputStream bufferedInJake = new BufferedInputStream(WiseYoung1);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 8)
			  {
				InputStream WiseYoung2 = getClass().getResourceAsStream("Wise Young Gent - Destiny.wav");
				BufferedInputStream bufferedInJake = new BufferedInputStream(WiseYoung2);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				cnt++;
			  }
			  else if(cnt == 9)
			  {
				  InputStream SavantSplinter = getClass().getResourceAsStream("Savant - Splinter.wav");
				  BufferedInputStream bufferedInJake = new BufferedInputStream(SavantSplinter);
				  AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				  clip = AudioSystem.getClip();
				  clip.open(audioStream);
				  cnt=0;
			  }
			  else {
				  InputStream SavantSplinter = getClass().getResourceAsStream("Savant - Splinter.wav");
				  BufferedInputStream bufferedInJake = new BufferedInputStream(SavantSplinter);
				  AudioInputStream audioStream = AudioSystem.getAudioInputStream((InputStream) bufferedInJake);
				  clip = AudioSystem.getClip();
				  clip.open(audioStream);
				  cnt=0;
			  }
			  clip.start();
		  } catch (Exception e) {
			  System.err.println(e.getMessage());
		  }
	}
	
	public void openFile() throws FileNotFoundException
	{
		File infile = null;
		@SuppressWarnings("unused")
		FileReader reader = null;
		String s = null;
		if(chooseFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			infile = chooseFile.getSelectedFile();
			reader = new FileReader(infile);
			Scanner input = new Scanner(infile);
			while(input.hasNextLine())
			{
				s = input.nextLine();
				if(s.equals("MacMoneySAVEFILE"))
				{
					byte[] encoded = input.nextLine().getBytes();
					byte[] decoded = null;
					String result = null;
					try {
						decoded = Base64.getDecoder().decode(encoded);
						result = new String(decoded, "UTF-8");
						userCreditAmount = Double.parseDouble(result.substring(result.indexOf("Credit Amount :: ")+17, result.indexOf(".")));
						double localPci = Double.parseDouble(result.substring(result.indexOf("Generation Amount :: ")+21, result.lastIndexOf(".")+3));
						setPCI(localPci);
						userCreditsPassive.setText("Generating "+String.valueOf(getPCI()) + "/per second");
					}
					catch(IllegalArgumentException e){
						
						JOptionPane.showMessageDialog(null, "Unsupported Save File\n(Either the contents are corrupted, or the file has been edited)", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					catch (UnsupportedEncodingException e) {
						
						JOptionPane.showMessageDialog(null, "Unsupported Save File\n(Either the contents are corrupted, or the file has been edited)", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					input.close();
					JOptionPane.showMessageDialog(null, "FileLoaded Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Not a valid save file!", "Error!", JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		}
	}
	
	public void createFile() throws FileNotFoundException, UnsupportedEncodingException
	{
        tempFile = new File("MacMoneySAVEFILETEMP.txt");
        writer = new PrintWriter(tempFile.getName(), "UTF-8");
        writer.println("MacMoneySAVEFILE");
    	writer.println("Credit Amount :: " + userCreditAmount);
    	writer.println("Generation Amount :: " + pci);
    	writer.close();
    	File file = new File("MacMoneySAVEFILE.txt");
    	PrintWriter secondWriter = new PrintWriter(file.getName(), "UTF-8");
    	secondWriter.println("MacMoneySAVEFILE");
    	secondWriter.println(encodeFileToBase64Binary(tempFile));
    	secondWriter.close();
    	tempFile.delete();
    	JOptionPane.showMessageDialog(null, "File Created at :: " + file.getAbsolutePath(), "Success!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private String encodeFileToBase64Binary(File file){
	    String encodedfile = null;
	    try {
	        FileInputStream fileInputStreamReader = new FileInputStream(file);
	        byte[] bytes = new byte[(int)file.length()];
	        fileInputStreamReader.read(bytes);
	        encodedfile = Base64.getEncoder().encodeToString(bytes);
	        fileInputStreamReader.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	     
	    return encodedfile;
	}
}