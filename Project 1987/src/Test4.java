package kj;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test4 {

	        int boardWidth = 360;
			int boardHeight = 540;
			
			
			//collecting colour idea from this website
			//https://www.schemecolor.com/apple-calculator-app-icon-2017-colors.php
			
			//Defining color
			Color customLightGray = new Color(212, 212, 210);
			Color customDarkGray = new Color(80, 80, 80);
			Color customBlack = new Color(28, 28, 28);
			Color customOrange = new Color(255, 149, 0);
			
			
		    String[] buttonValues = {
		            "AC", "+/-", "%", "÷", 
		            "7", "8", "9", "×", 
		            "4", "5", "6", "-",
		            "1", "2", "3", "+",
		            "0", ".", "√", "="
		        };
		    
		    
		    String[] rightSymbols = {"÷", "×", "-", "+", "="};
		    String[] topSymbols = {"AC", "+/-", "%"};                        //for tracking from the condition
		    

		        

			
	
	JFrame frame = new JFrame("Calculator");  //Title
	JLabel displayLabel = new JLabel();       //Creates a label to show the calculator's numbers (initially empty).
	JPanel displayPanel = new JPanel();       //A panel to hold the label.
	JPanel buttonsPanel = new JPanel();       //A panel for buttons
	
	
	Test4() {
		frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);  //Sets size to 360×540.
		frame.setLocationRelativeTo(null);       //Centers the window on the screen.
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		
		displayLabel.setBackground(customBlack);                     //Sets background color of the display.
		displayLabel.setForeground(Color.white);                     //Sets text color → White.
		displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));    //80 for font size
		displayLabel.setHorizontalAlignment(JLabel.RIGHT);          //Aligns text to the right, like a real calculator.
		displayLabel.setText("0");
		displayLabel.setOpaque(true);                               //Makes background color visible (labels are transparent by default!).
		
		
		displayPanel.setLayout(new BorderLayout());
		displayPanel.add(displayLabel);
		frame.add(displayPanel, BorderLayout.NORTH);   //BorderLayout.NORTH for 0 jumped to the top of the frame
		
		buttonsPanel.setLayout(new GridLayout(5, 4));    //background for buttons
		buttonsPanel.setBackground(customBlack);
		frame.add(buttonsPanel);
		
		
		
		for(int i=0; i<buttonValues.length; i++) 
		{
			JButton button = new JButton();
			String buttonValue = buttonValues[i];
			button.setFont(new Font("Arial", Font.PLAIN, 30));
			button.setText(buttonValue);
			button.setFocusable(false);             //for hide the rectangle box after clicking the button
			
			if (Arrays.asList(topSymbols).contains(buttonValue)) {         //topSymble array already created
				button.setBackground(customLightGray);
				button.setForeground(customBlack);            //coloring AC,+/-,% button as lightgray
			}
			else if (Arrays.asList(rightSymbols).contains(buttonValue)) {           //rightSymble array already created
				button.setBackground(customOrange);                   //coloring +,-.*,/,= as orange
				button.setForeground(Color.white);       //foreground = buttonsValues own,means highlighting                  //coloring symble  
			}
			else {
				button.setBackground(customDarkGray);
				button.setForeground(Color.white);
			}
			
			
			
			buttonsPanel.add(button);
			
			
		}
		
		
		
	}
	
	
	
	//For run in main class
	
	/*  public class App {

		public static void main(String[] args)  {
	        Test4 test4 = new Test4();

		}

	}
	*/
	
	
}
