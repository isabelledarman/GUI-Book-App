import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class BookFrame implements ActionListener{
	
	JLabel label = new JLabel();
	JButton button = new JButton();
	JFrame frame = new JFrame();


	BookFrame(){
		ImageIcon image = new ImageIcon("clipart165792.png");
		
		button.setBounds(125, 225, 250, 100);
		button.setFocusable(false);
		button.addActionListener(this);
		button.setText("Press to Start!");
		button.setFocusable(false);
		button.setBackground(new Color(0xdf0054));
		button.setOpaque(true);
		button.setForeground(Color.darkGray);
		button.setFont(new Font("Garamond", Font.BOLD, 25));
		button.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		
		label.setText("Welcome!");
		label.setIcon(image);
		label.setVisible(true);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(new Color(0xdf0054));
		label.setFont(new Font("Garamond", Font.ITALIC, 60));
		
		frame.setTitle("Book App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(500, 600);
		frame.add(button);
		frame.add(label);
		frame.setVisible(true);
		frame.setLayout(null);
		
		frame.setIconImage(image.getImage());
		
		frame.getContentPane().setBackground(new Color(0x89DDFA));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		  
		 if(e.getSource()==button) {
			   frame.dispose();
			   NewWindow myWindow = new NewWindow();
			  }
	}
}

