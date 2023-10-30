import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class NewWindow implements ChangeListener, ActionListener{

	JFrame frame;
	JLabel label;
	
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	
	JSlider sliderHours;
	JSlider sliderWeeks;
	
	JLabel label2;
	JLabel label3;
	JButton button;
	
	public int hours;
	public int weeks;
	
	private String title;
	private int pageCount;
	public String author;
	public String genre;

 
	NewWindow(){
	 
		frame = new JFrame("Book App");
		
		/*panel = new JPanel();
		panel.setBounds(0, 150, 500, 150);
		panel.setBackground(new Color(0x89DDFA));
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 500, 150);
		panel2.setBackground(new Color(0x89DDFA));
		
		panel3 = new JPanel();
		panel3.setBounds(0, 300, 500, 300);
		panel3.setBackground(Color.GRAY);*/
		
		label = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
				
		sliderHours = new JSlider(0,16,8);
		sliderWeeks = new JSlider(0, 8, 4);
		
		button = new JButton();
		
		button.setBounds(125, 400, 250, 100);
		button.setFocusable(false);
		button.addActionListener(this);
		button.setText("Next");
		button.setFocusable(false);
		//button.setBackground(new Color(0xdf0054));
		button.setOpaque(true);
		button.setForeground(Color.darkGray);
		button.setFont(new Font("Garamond", Font.BOLD, 25));
		  
		sliderHours.setPreferredSize(new Dimension(400,75));
		  
		sliderHours.setPaintTicks(true);
		sliderHours.setMinorTickSpacing(1);
		  
		sliderHours.setPaintTrack(true);
		sliderHours.setMajorTickSpacing(2);
		  
		sliderHours.setPaintLabels(true);
		sliderHours.setFont(new Font("Garamond",Font.ITALIC,15));
		
		label.setFont(new Font("Garamond",Font.PLAIN,18));
		  
		//.setOrientation(SwingConstants.HORIZONTAL);
		sliderHours.setOrientation(SwingConstants.HORIZONTAL);
		  
		label.setText("I read " + sliderHours.getValue() + " hours a week");
		
		//label.setHorizontalTextPosition(JSlider.CENTER);
		//label.setVerticalTextPosition(JSlider.BOTTOM);
		
		sliderHours.addChangeListener(this);
		
		sliderWeeks.setPreferredSize(new Dimension(400, 75));
		
		sliderWeeks.setPaintTicks(true);
		sliderWeeks.setMinorTickSpacing(1);
		
		sliderWeeks.setPaintTrack(true);
		sliderWeeks.setMajorTickSpacing(2);
		
		sliderWeeks.setPaintLabels(true);
		sliderWeeks.setFont(new Font("Garamond", Font.ITALIC, 15));
		
		label2.setFont(new Font("Garamond", Font.PLAIN, 20));
		
		sliderWeeks.setOrientation(SwingConstants.HORIZONTAL);
		
		label2.setText("Target Finish Time: " + sliderWeeks.getValue() + " week(s)");
		
		sliderWeeks.addChangeListener(this);
		
		label3.setFont(new Font("Garamond", Font.BOLD, 25));
		
		label3.setText("Set Your Preferences then Press Next");
		
		label3.setVerticalAlignment(JButton.TOP);
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 35, 35));

		frame.add(sliderHours);
		frame.add(label);
		
		frame.add(sliderWeeks);
		frame.add(label2);
		//frame.add(panel2);
		
		frame.add(label3);
		frame.add(button);
		//frame.add(panel3);
		
		frame.setTitle("Book App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(500,600);
		frame.setVisible(true);
		frame.setLayout(null);
		
		frame.getContentPane().setBackground(new Color(0x89DDFA));

	}

@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	  	label.setText("I read " + sliderHours.getValue() + " hours a week");
	  	label2.setText("Target Finish Time: " + sliderWeeks.getValue() + " week(s)");
	  	label3.setText("Set Your Preferences and Press Next");
	  	
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if(e.getSource()==button) {
		
		int weeks = sliderWeeks.getValue();
		int hours = sliderHours.getValue();	
		frame.dispose();
		NewWindow2 myWindow = new NewWindow2();
		
		double num = numPages(weeks, hours);
		
		printRecommended(num);
		
	}
	
	
}

public static ArrayList<BookInfo> book = new ArrayList<BookInfo>();

public double numPages(int weeks, int hours)
{
	return hours*60.0*weeks;
}

public static void printRecommended(double pages)
{
	double max = pages + 100;
	double mid = pages;
	double min = pages - 100;
	
	ArrayList<BookInfo> reach = new ArrayList<BookInfo>();
	ArrayList<BookInfo> target = new ArrayList<BookInfo>();
	
	for(int i = 0; i < book.size(); i++)
	{
		int p = book.get(i).getPageCount();
		BookInfo b = book.get(i);
		
		if(p <= max && p >= mid)
		{
			reach.add(b);
		}
		
		if(p < mid && p >= min)
		{
			target.add(b);
		}
	}
	
	if(target.size() == 0)
	{
		System.out.println("Sorry, we don't know any books that you will be able to finish on time.");
	}
	else
	{
		System.out.println("Books that you will finish by your target time: ");
	
		for(BookInfo i: target)
		{
			System.out.println(i);
		}
	
	}
	if(reach.size() == 0)
	{
		System.out.println("Sorry, we don't know any books that may be a reach for you.");
	}
	else
	{
		System.out.println("Some books that may take you a little longer: ");
	
		for(BookInfo k: reach)
		{
			System.out.println(k);
		}
	}
	
}

public String getTitle()
{
	return title;
}

public int getPageCount()
{
	return pageCount;
}

public String getAuthor()
{
	return author;
}

public void setTitle(String newTitle)
{
	title = newTitle;
}

public void setPageCount(int newPageCount)
{
	pageCount = newPageCount;
}

public void setAuthor(String newAuthor)
{
	author = newAuthor;
}

public String toString()
{
	return "We recommend " + title + " it is " + pageCount + " pages long and it is by " + author + ".";
}

public static void main(String[] args)
{
	BookFrame launchPage = new BookFrame();
	BookInfo Frankenstein = new BookInfo("Frankenstein", "Mary Shelley", 166, "Science-Fiction");
	BookInfo AndThenThereWereNone = new BookInfo("And Then There Were None", "Agatha Christie", 300, "Mystery");
	BookInfo JaneEyre = new BookInfo("Jane Eyre", "Charlotte Bronte", 500, "Fiction");
	BookInfo TheGreatGatsby = new BookInfo("The Great Gatsby", "F. Scott Fitzgerald", 208, "Fiction");
	BookInfo Hamlet = new BookInfo("Hamlet", "William Shakespeare", 330, "Drama");
	BookInfo LOTR = new BookInfo("Lord of the Rings", "J. R. R. Tolkein", 1178, "Fantasy");
	BookInfo LittleWomen = new BookInfo("Little Women", "Louisa May Alcott", 528, "Fiction");
	BookInfo MYORR = new BookInfo("My Year of Rest and Relaxation", "Ottessa Moshgeh", 304, "Fiction");
	BookInfo SecretHistory = new BookInfo("The Secret History", "Donna Tartt", 544, "Fiction");
	BookInfo NormalPeople = new BookInfo("Normal People", "Sally Rooney", 266, "Fiction");
	BookInfo Sam = new BookInfo("I'm Glad My Mom Died", "Jeanette McCurdy", 320, "Memoir");
	BookInfo Wuthering = new BookInfo("Wuthering Heights", "Emily Bronte", 400, "Fiction");
	BookInfo Station11 = new BookInfo("Station Elevne", "Emily St. John Mandel", 352, "Sci-Fi");
	BookInfo ToKill = new BookInfo("To Kill A Mockingbird", "Harper Lee", 281, "Fiction");
	BookInfo Beloved = new BookInfo("Beloved", "Toni Morrison", 324, "Fiction");
	BookInfo ColorPurple = new BookInfo("The Color Purple", "Alice Walker", 304, "Fiction");
	BookInfo The1984 = new BookInfo("1984", "George Orwell", 328, "Fiction");
	BookInfo BraveNewWorld = new BookInfo("Brave New World", "Aldous Huxley", 311, "Sci Fi");
	BookInfo GrapesWrath = new BookInfo("The Grapes of Wrath", "John Steinbeck", 464, "fiction");
	BookInfo CatcherRye = new BookInfo("The Catcher in the Rye", "J. D. Salinger", 234, "Fiction");
	BookInfo BellJar = new BookInfo("The Bell Jar", "Sylvia Plath", 244, "Fiction");
	
	book.add(Frankenstein);
	book.add(AndThenThereWereNone);
	book.add(JaneEyre);
	book.add(TheGreatGatsby);
	book.add(Hamlet);	
	book.add(LOTR);
	book.add(LittleWomen);
	book.add(MYORR);
	book.add(SecretHistory);
	book.add(NormalPeople);
	book.add(Sam);
	book.add(Wuthering);
	book.add(ToKill);
	book.add(Beloved);
	book.add(ColorPurple);
	book.add(The1984);
	book.add(BraveNewWorld);
	book.add(GrapesWrath);
	book.add(CatcherRye);
	book.add(BellJar);
	
}

}