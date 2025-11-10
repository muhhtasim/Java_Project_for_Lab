import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test2 {

	        int boardWidth = 360;
			int boardHeight = 540;
			
			
			//collecting colour idea from this website
			//https://www.schemecolor.com/apple-calculator-app-icon-2017-colors.php
			
			//Defining color
			Color customLightGray = new Color(212, 212, 210);
			Color customDarkGray = new Color(80, 80, 80);
			Color customBlack = new Color(28, 28, 28);
			Color customOrange = new Color(255, 149, 0);
			
	
	JFrame frame = new JFrame("Calculator");
	JLabel displayLabel = new JLabel();
	JPanel displayPanel = new JPanel();
	
	
	Test2() {
		frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		
		displayLabel.setBackground(customBlack);
		displayLabel.setForeground(Color.white);
		displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));    //80 for font size
		displayLabel.setHorizontalAlignment(JLabel.RIGHT);
		displayLabel.setText("0");
		displayLabel.setOpaque(true);
		
		
		displayPanel.setLayout(new BorderLayout());
		displayPanel.add(displayLabel);
		frame.add(displayPanel, BorderLayout.NORTH);    //BorderLayout.NORTH for 0 jumped to the top of the frame
		
	}
	
	
	
	//For run in main class
	
	/*  public class App {

		public static void main(String[] args) throws Exception {
	        Test2 test2 = new Test2();

		}

	}
	*/
	
	
}
