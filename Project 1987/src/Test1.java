import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Test1 {

	        int boardWidth = 360;
			int boardHeight = 540;
	
	JFrame frame = new JFrame("Calculator");
	
	Test1() {
		frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
	}
	
	
}
