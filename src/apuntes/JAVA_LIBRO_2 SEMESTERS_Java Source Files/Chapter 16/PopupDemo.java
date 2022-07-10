
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PopupDemo extends JFrame implements ActionListener
{
	// declare and create the button
	private JButton button = new JButton("Select background colour");
	
	// declare and create the pop-up menu
	private JPopupMenu popup = new JPopupMenu();
	
	// declare and create the menu items
	private JMenuItem red = new JMenuItem("Red");
	private JMenuItem yellow = new JMenuItem("Yellow");
	private JMenuItem green = new JMenuItem("Green");
	
	// the constructor
	public PopupDemo()
	{
			setTitle("Pop-up Menu Demo"); // set the title of the frame
	
			// add the menu items to the menu
			popup.add(red);
			popup.add(yellow);
			popup.add(green);
	
			// set the location of the pop-up menu
			popup.setLocation(260,180);
	
			// add ActionListeners to the menu items and to the button
			red.addActionListener(this);
			yellow.addActionListener(this);
			green.addActionListener(this);
			button.addActionListener(this);
	
			// choose a flow layout, then add the button to the frame
			setLayout(new FlowLayout());
			add(button);
	
			// remove the highlighting around the button text
			button.setFocusPainted(false);
	
			// choose settings for the frame and make it visible
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(250,250);
			setVisible(true);
	
	}
	
	// the event-handler
	public void actionPerformed(ActionEvent e)
	{
			if (e.getSource() == button)
			{
				popup.setVisible(true); // show the pop-up menu
			}
			if (e.getSource() == red)
			{
				getContentPane().setBackground(Color.red); // set background to red
				popup.setVisible(false);  // hide the pop-up menu
			}
			if (e.getSource() == yellow)
			{
				getContentPane().setBackground(Color.yellow); // set background to yellow
				popup.setVisible(false);	// hide the pop-up menu
			}
			if (e.getSource() == green)
			{
				getContentPane().setBackground(Color.green); // set background to green
				popup.setVisible(false); 	// hide the pop-up menu
			}
	}
}

