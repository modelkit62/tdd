
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Flag extends JFrame implements ActionListener
{

	// declare and create three panels, one for each stripe
	private JPanel topPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	// declare and create the top menu bar
	private JMenuBar bar = new JMenuBar();
	
	// declare and create the three menus  
	private JMenu topStripeMenu = new JMenu("Top Colour");
	private JMenu middleStripeMenu = new JMenu("Middle Colour");
	private JMenu bottomStripeMenu = new JMenu("Bottom Colour");
	
	// declare and create each menu item
	private JMenuItem blueStripe = new JMenuItem("Blue");
	private JMenuItem redStripe = new JMenuItem("Red");
	private JMenuItem whiteStripe = new JMenuItem("White");
	private JMenuItem yellowStripe = new JMenuItem("Yellow");
	private JMenuItem greenStripe = new JMenuItem("Green");
	private JMenuItem blackStripe = new JMenuItem("Black");
	
	// the constructor
	public Flag()
	{
		setTitle("Pull-down Menu Demo"); // set the title of the frame
		
		// set each stripe to an initial colour
		topPanel.setBackground(Color.red);
		middlePanel.setBackground(Color.yellow);
		bottomPanel.setBackground(Color.green);
		
		// add menu items to the top stripe menu
		topStripeMenu.add(blueStripe);
		topStripeMenu.add(redStripe);
		
		// add menu items to the middle stripe menu
		middleStripeMenu.add(whiteStripe);
		middleStripeMenu.add(yellowStripe);
		
		// add menu items to the bottom stripe menu
		bottomStripeMenu.add(greenStripe);
		bottomStripeMenu.add(blackStripe);
		
		// add the menus to the menu bar
		bar.add(topStripeMenu);
		bar.add(middleStripeMenu);
		bar.add(bottomStripeMenu);
		
		// add the menu bar to the frame
		setJMenuBar(bar);
		
		// add listerners to each menu item
		blueStripe.addActionListener(this);
		redStripe.addActionListener(this);
		whiteStripe.addActionListener(this);
		yellowStripe.addActionListener(this);
		greenStripe.addActionListener(this);
		blackStripe.addActionListener(this);
		
		// select a GridLayout
		setLayout(new GridLayout(3,1));
		
		// add the panels to the frame
		add(topPanel);
		add(middlePanel);
		add(bottomPanel);
		
		// choose settings for the frame and make it visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		setVisible(true);
	  }
	
	  // the event handler  
	  public void actionPerformed(ActionEvent e)
	  {
		if(e.getSource() == blueStripe)
		{
			topPanel.setBackground(Color.blue); // set top stripe to blue
		}
		if(e.getSource() == redStripe)
		{
			topPanel.setBackground(Color.red); // set top stripe to red
		}
		if(e.getSource() == whiteStripe)
		{
			middlePanel.setBackground(Color.white); 	// set middle stripe to white
		}
		if(e.getSource() == yellowStripe)
		{
			middlePanel.setBackground(Color.yellow); 	// set middle stripe to yellow
		}
		if(e.getSource() == greenStripe)
		{
			bottomPanel.setBackground(Color.green); 	// set bottom stripe to green
		}
		if(e.getSource() == blackStripe)
		{
			bottomPanel.setBackground(Color.black); 	// set bottom stripe to black
		}
	  }
}

