import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogDemo extends JFrame implements ActionListener
{
	// declare and create the button
	private JButton button = new JButton("Select background colour");
	
	// declare and create the dialogue window
	private JDialog dialog = new JDialog();
	
	// declare and create a group for the radio buttons
	private ButtonGroup group = new ButtonGroup();
	
	// declare and create the radio buttons
	private JRadioButton red = new JRadioButton("Red");
	private JRadioButton yellow = new JRadioButton("Yellow");
	private JRadioButton green = new JRadioButton("Green");
	
	// the constructor
	public DialogDemo()
	{
			setTitle("Dialogue Demo"); // set the title of the frame
	
			// add the radio buttons to the group
			group.add(red);
			group.add(yellow);
			group.add(green);
	
			// set the layout policy of the dialogue window to flow layout
			dialog.setLayout(new FlowLayout());
	
			// set title of dialogue
			dialog.setTitle("Choose a colour");
	
			// add the radio buttons to the dialogue window
			dialog.add(red);
			dialog.add(yellow);
			dialog.add(green);
	
			// get the dialogue window to size itself
			dialog.pack();
	
			// set the location of the dialogue window
			dialog.setLocation(550,400);
	
			// add ActionListeners to the button and to the radio buttons
			button.addActionListener(this);
			red.addActionListener(this);
			yellow.addActionListener(this);
		green.addActionListener(this);
	
			// set the policy of the frame to flow layout
			setLayout(new FlowLayout());
	
			// add the button to the frame
			add(button);
	
			// remove the highlighting around the button text
			button.setFocusPainted(false);
	
			// configure the frame
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(250,250);
	
			setLocation(250,250);
			setVisible(true);
	}
	
	// the event handler
	public void actionPerformed(ActionEvent e)
	{
			if (e.getSource() == button)
			{
				dialog.setVisible(true); // make the dialogue window visible
			}
	
			// select correct action for each radio button
			if (e.getSource() == red)
			{
				getContentPane().setBackground(Color.red); // set background to red
			}
			if (e.getSource() == yellow)
			{
				getContentPane().setBackground(Color.yellow); // set background to yellow
			}
			if (e.getSource() == green)
			{
				getContentPane().setBackground(Color.green); // set background to green
			}
	}
}

