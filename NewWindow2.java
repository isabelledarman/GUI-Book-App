import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class NewWindow2 extends NewWindow{
	
	JFrame frame;
	JLabel label;
	
	NewWindow2()
	{
		frame = new JFrame("Book App");
		label = new JLabel();
		
		label.setText("Check the Console to see What books we Recommend!");
		
		frame.add(label);
		
		frame.setTitle("Book App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(500,600);
		frame.setVisible(true);
		frame.setLayout(null);
		
		frame.getContentPane().setBackground(new Color(0x89DDFA));
				
	}
}
