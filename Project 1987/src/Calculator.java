
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {

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
		    String[] topSymbols = {"AC", "+/-", "%"};                        
		    //for tracking from the condition
		    

		        

			
	
	JFrame frame = new JFrame("Calculator");  //Title
	JLabel displayLabel = new JLabel();       //Creates a label to show the calculator's numbers (initially empty).
	JPanel displayPanel = new JPanel();       //A panel to hold the label.
	JPanel buttonsPanel = new JPanel();       //A panel for buttons
	
	// A+B, A-B, A*B, A/B          //for saving
	String A = "0";     //saving the first number before clicking the operators
	String operator = null;
	String B = null;
	
	
	Calculator() {
		// frame.setVisible(true);     //bejal
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
			button.setBorder(new LineBorder(customBlack));     //for lineborder in 2button's chipped(black)
			
			
			if (Arrays.asList(topSymbols).contains(buttonValue)) {         //topSymble array already created
				button.setBackground(customLightGray);
				button.setForeground(customBlack);            //coloring AC,+/-,% button as lightgray
			}
			else if (Arrays.asList(rightSymbols).contains(buttonValue)) {           //rightSymble array already created
				button.setBackground(customOrange);                   //coloring +,-.*,/,= as orange
				button.setForeground(Color.white);       //foreground = buttonsValues own,means highlighting    //coloring symble  
			}
			else {
				button.setBackground(customDarkGray);
				button.setForeground(Color.white);
			}
			
			
			
			buttonsPanel.add(button);
			
			
			button.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {                            
					JButton button = (JButton) e.getSource();          //e is action event and getSource for where the event comes from
					String buttonValue = button.getText();                               // get the button text
					
					//for identifing the right buttons         //contains = checks if element/part exists
					if (Arrays.asList(rightSymbols).contains(buttonValue)) {              // handle operations (+ - × ÷ =)
						if (buttonValue == "=") {
							if (A != null) {
                                B = displayLabel.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                if (operator == "+") {
                                    displayLabel.setText(removeZeroDecimal(numA+numB));
                                }
                                else if (operator == "-") {
                                    displayLabel.setText(removeZeroDecimal(numA-numB));
                                }
                                else if (operator == "×") {
                                    displayLabel.setText(removeZeroDecimal(numA*numB));
                                }
                                else if (operator == "÷") {
                                    displayLabel.setText(removeZeroDecimal(numA/numB));
                                }
                                clearAll();
                            }
						}
						else if ("+-×÷".contains(buttonValue)) {
							if(operator == null) {           // this condition for user doesn't click two operator at a time
								A = displayLabel.getText();
								displayLabel.setText("0");
								B = "0";
							}
							operator = buttonValue;
						}
					}
					
					else if (Arrays.asList(topSymbols).contains(buttonValue)) {           // handle AC, +/-, %
						// For clearing everything
						if (buttonValue == "AC") {
							clearAll();
							displayLabel.setText("0");
							
						}
						// For positive to negative
						else if (buttonValue == "+/-") {
			                // get the text and convert it double number 
							//cause display shows the number as a text
							double numDisplay = Double.parseDouble(displayLabel.getText());
							numDisplay *= -1;
							displayLabel.setText(removeZeroDecimal(numDisplay));
							
						}
						else if (buttonValue == "%") {
							double numDisplay = Double.parseDouble(displayLabel.getText());
							numDisplay /= 100;
							displayLabel.setText(removeZeroDecimal(numDisplay));
							
						}
						
					}
					else {                                                                // number or decimal
						
						if (buttonValue == ".") {
							if (!displayLabel.getText().contains(buttonValue)) {     //for not accepting double point(.)
								displayLabel.setText(displayLabel.getText() + buttonValue);
							}
							
						} 
						
						
						else if (buttonValue == "√") {
						    double numDisplay = Double.parseDouble(displayLabel.getText());

						    if (numDisplay < 0) {
						        displayLabel.setText("Invalid");
						    } else {
						        double result = Math.sqrt(numDisplay);
						        displayLabel.setText(removeZeroDecimal(result));
						    }
						}

						
						
						// When clicking a number:

                        // If display shows "0", replace with new number

                        // Otherwise append the digit
						
						 else if ("0123456789".contains(buttonValue)) {                  //
							 if (displayLabel.getText() == "0") {               //in initially
	                                displayLabel.setText(buttonValue);
	                            }
	                            else {
	                                displayLabel.setText(displayLabel.getText() + buttonValue);      
	                                //show previos text for (getText()) and buttonValue for new text
	                            }
							 
						 }
					}
					
				}
			});
			
			frame.setVisible(true);     //bejal
		}
		
		
		
	}
	
	
	// For clearing all the number from  the display
    void clearAll() {
        A = "0";
        operator = null;
        B = null;
    }
    
    
    // For removing (.00) from integer number
    String removeZeroDecimal(double numDisplay) {
        if (numDisplay % 1 == 0) {
            return Integer.toString((int) numDisplay);
        }
        return Double.toString(numDisplay);
    }
	
    
    
    
    
	//For run in main class
	
	/*  public class App {

		public static void main(String[] args)  {
	        Calculator  = new Calculator();

		}

	}
	*/
	
	
}

