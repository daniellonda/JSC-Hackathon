package SpaceMindGame;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReactionGame implements ActionListener{
	
	int l = 0;
	int reflex = 0;
	int reflexMisses = 0;
	
	int colorScore = 0;
	int correctPanel = 0;
	int colorMisses = 0;
	
	int dataArray[] = new int[5];//used for writing data to .txt
	
	private JPanel panel;
	private JFrame frame;
	private JLabel label;
	private Random rand;
	
	boolean reflexPlayed = false;
	boolean colorsplayed = false;
	
	private JButton reactionStartButton = new JButton("Welcome to Minigame Experience: Press Here to Begin");
	private JButton perceptionStartButton = new JButton("Click here to begin the color perception game");
	private JButton betweenGameScreen = new JButton();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JButton button4 = new JButton();
	private JButton button5 = new JButton();
	private JButton button6 = new JButton();
	private JButton button7 = new JButton();
	private JButton button8 = new JButton();// all buttons are setup to act upon being pressed
	
	long startTime;
	long endTime;
	long timeElapsed;
	
	public ReactionGame(){
		panel = new JPanel();
		frame = new JFrame();
		
		reactionStartButton.addActionListener(this);
		perceptionStartButton.addActionListener(this);
		betweenGameScreen.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));;
		panel.setLayout(new GridLayout(1,1));
		panel.add(reactionStartButton);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("RealSpaceMindGame");
		frame.pack();
		frame.setVisible(true);// the panel is setup 
		
	}
	public static void main(String[] args) {		
		new ReactionGame();
	}
	public void actionPerformed(ActionEvent e) {// listens for specific buttons to either launch methods or 
		
		//var: reflex - current tile index, 0-3, used to 
		//var: l - used to indicate score, bad naming conventions but i don't care :)
		//var: reflexMisses - counts the number of misses, used to calculate accuracy
		if(e.getSource()==reactionStartButton) {
			reactionTimeGame(e);
		}
		else if(e.getSource()==perceptionStartButton) {
			panel.remove(label);
			try {
				colorPerceptionGame(e);
			} catch (IOException e1) {
				
			}
		}
		else if(e.getSource()==button5) {
			if(reflex == 0) {// this runs if the user hit the right button during the game
				l++;
				reactionTimeGame(e);
			}
			else {
				reflexMisses++;
			}
		}
		else if(e.getSource() == button6) {
			if(reflex == 1) {// right answer
				l++;
				reactionTimeGame(e);
			}
			else {
				reflexMisses++;
			}
		}
		else if(e.getSource() == button7) {
			if(reflex == 2) {// right answer
				l++;
				reactionTimeGame(e);
			}
			else {
				reflexMisses++;
			}
		}
		else if(e.getSource() == button8) {
			if(reflex == 3) {// right answer
				l++;
				reactionTimeGame(e);
			}
			else {
				reflexMisses++;
			}
		}
		
		// code for events for color game
		//var: correctPanel - which panel is correct
		//var: score - current score, used for ending game
		//var: colorMisses - used for tracking number of misses, to be used in accuracy tracking
		//variables are not local to be edited in event method and in colorPerceptionGame method
		else if(e.getSource() == button1){
			if(correctPanel == 0) {
				try {
					colorPerceptionGame(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				colorScore++;
			}
			else {
				colorMisses++;
			}	
		}
		else if(e.getSource() == button2){
			if(correctPanel == 1) {
				try {
					colorPerceptionGame(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				colorScore++;
			}
			else {
				colorMisses++;
			}	
		}
		else if(e.getSource() == button3){
			if(correctPanel == 2) {
				try {
					colorPerceptionGame(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				colorScore++;
			}
			else {
				colorMisses++;
			}	
		}
		else{
			if(correctPanel == 3) {
				try {
					colorPerceptionGame(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				colorScore++;
			}
			else {
				colorMisses++;
			}	
		}

	}
	public void reactionTimeGame(ActionEvent e) {// 
		button5.setBackground(Color.white);
		button6.setBackground(Color.white);
		button7.setBackground(Color.white);
		button8.setBackground(Color.white);
		panel.revalidate();
		panel.repaint();
		
		if(l == 0) {
			panel.remove(reactionStartButton);
			panel.remove(perceptionStartButton);
			startTime = System.nanoTime();
			l++;
		}

		rand = new Random();
		int k = rand.nextInt(4);
		reflex = k; 
		
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		if(k == 0) {
			button5.setBackground(Color.black);	
		}
		else if(k == 1) {
			button6.setBackground(Color.black);	
		}
		else if(k == 2) {
			button7.setBackground(Color.black);	
		}
		else {
			button8.setBackground(Color.black);	
		}
		panel.revalidate();
		panel.repaint();
		
		if(l == 19) {
			//take user to the next game
			// log result in text document
			endTime = System.nanoTime();
			timeElapsed = endTime-startTime;// time the minigame took
			panel.remove(button5);
			panel.remove(button6);
			panel.remove(button7);
			panel.remove(button8);
			double time = Math.floorDiv(timeElapsed, 1000000000);
			label = new JLabel("Your time: "+time);
			panel.add(label);
			panel.add(perceptionStartButton);
			panel.revalidate();
			panel.repaint();
			
		}
		
		
	}
	public void colorPerceptionGame(ActionEvent e) throws IOException {
		if(colorScore == 0) {
			panel.remove(perceptionStartButton);
			panel.add(button1);
			panel.add(button2);
			panel.add(button3);
			panel.add(button4);
			panel.revalidate();
			panel.repaint();
			
		}
		if(colorScore == 9) {
			
			
			panel.remove(button1);
			panel.remove(button2);
			panel.remove(button3);
			panel.remove(button4);
			panel.revalidate();
			panel.repaint();
			endScreen(e);
		}
		rand = new Random();
		
		button1.setBackground(Color.white);// resets colors between rounds
		button2.setBackground(Color.white);
		button3.setBackground(Color.white);
		button4.setBackground(Color.white);
		panel.revalidate();
		panel.repaint();
		
		Color color;
		Color otherColor;
		int difference = 30;
		int buttonSelection;
		int RGBselection;
		buttonSelection = rand.nextInt(4);
		RGBselection = rand.nextInt(2);
		int rColor = rand.nextInt(216);
		int gColor = rand.nextInt(216);
		int bColor = rand.nextInt(216);
		
		correctPanel = buttonSelection;
		
		if(RGBselection == 0) {// red value will be changed a random amount
			color = new Color(((rColor+40) - difference), gColor, bColor);
			otherColor = new Color(rColor,gColor,bColor);
			if(buttonSelection == 0) {
				button1.setBackground(color);
				button2.setBackground(otherColor);
				button3.setBackground(otherColor);
				button4.setBackground(otherColor);
			}
			else if(buttonSelection == 1) {
				button1.setBackground(otherColor);
				button2.setBackground(color);
				button3.setBackground(otherColor);
				button4.setBackground(otherColor);
			}
			else if(buttonSelection == 2) {
				button1.setBackground(otherColor);
				button2.setBackground(otherColor);
				button3.setBackground(color);
				button4.setBackground(otherColor);
			}
			else {
				button1.setBackground(otherColor);
				button2.setBackground(otherColor);
				button3.setBackground(otherColor);
				button4.setBackground(color);
			}
		}
		else if(RGBselection == 1) {// green value will be changed 
			color = new Color(rColor, ((gColor+40) - difference), gColor);
			otherColor = new Color(rColor,gColor,bColor);
			if(buttonSelection == 0) {
				button1.setBackground(color);
				button2.setBackground(otherColor);
				button3.setBackground(otherColor);
				button4.setBackground(otherColor);
			}
			else if(buttonSelection == 1) {
				button1.setBackground(otherColor);
				button2.setBackground(color);
				button3.setBackground(otherColor);
				button4.setBackground(otherColor);
			}
			else if(buttonSelection == 2) {
				button1.setBackground(otherColor);
				button2.setBackground(otherColor);
				button3.setBackground(color);
				button4.setBackground(otherColor);
			}
			else {
				button1.setBackground(otherColor);
				button2.setBackground(otherColor);
				button3.setBackground(otherColor);
				button4.setBackground(color);
			}	
		}
		else {// blue value will be changed
			color = new Color(rColor,gColor,((bColor+40) - difference));
			otherColor = new Color(rColor,gColor,bColor);
			if(buttonSelection == 0) {
				button1.setBackground(color);
				button2.setBackground(otherColor);
				button3.setBackground(otherColor);
				button4.setBackground(otherColor);
			}
			else if(buttonSelection == 1) {
				button1.setBackground(otherColor);
				button2.setBackground(color);
				button3.setBackground(otherColor);
				button4.setBackground(otherColor);
			}
			else if(buttonSelection == 2) {
				button1.setBackground(otherColor);
				button2.setBackground(otherColor);
				button3.setBackground(color);
				button4.setBackground(otherColor);
			}
			else {
				button1.setBackground(otherColor);
				button2.setBackground(otherColor);
				button3.setBackground(otherColor);
				button4.setBackground(color);
			}
		}	
	}
	public void endScreen(ActionEvent e) throws IOException {
		
		System.out.println();
		panel.revalidate();
		panel.repaint();
		
		double colorAccuracy = (((double)colorMisses/ 20) * 100);
		double reflexAccuracy = (((double)reflexMisses/20) * 100);

		if(colorAccuracy == 0.0) {
			colorAccuracy = 100.0;
		}
		if(reflexAccuracy == 0.0) {
			reflexAccuracy = 100.0;
		}
		
		File file = new File("D:/GameDataLog.txt");
		FileWriter fw = new FileWriter(file);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		try (BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write("Date: " + formatter.format(date) + "\n\nRelfex Game: \n	Time Elapsed: " + timeElapsed + 
					" nanoseconds \n	Number of misses: "+ reflexMisses +"\n	User Accuracy: "+reflexAccuracy+"% \n\nColor Perception Game:\n"+
					"	Number of misses: "+colorMisses+"\n	User Accuracy: "+colorAccuracy+"%");
		}
		
		
	}
}
