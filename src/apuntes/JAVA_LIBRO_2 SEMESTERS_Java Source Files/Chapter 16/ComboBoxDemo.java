
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxDemo extends JFrame implements ActionListener
{
	// declare and create an array of strings
	private String[] colours = {"Select colour","Red", "Blue", "Green"};
	
	// declare and create a combo box
	private JComboBox box = new JComboBox(colours);
	
	// the constructor
	public ComboBoxDemo()
	{
		setTitle("Combo Box Demo"); // set the title of the frame
	
		// choose a flow layout, then add the combo box to the frame
		setLayout(new FlowLayout());
		add(box);
	
		// add an ActionListener to the combo box
		box.addActionListener(this);
	
		// configure the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,250);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		// determine which item is selected
		String item = (String) box.getSelectedItem();
		if (item.equals("Red"))
		{
			getContentPane().setBackground(Color.red); // set background to red
		}
		if (item.equals("Blue"))
		{
			getContentPane().setBackground(Color.blue);	// set background to blue
		}
		if (item.equals("Green"))
		{
			getContentPane().setBackground(Color.green); 	// set background to green
		}
		// set selcted item to the first option so that "select colour" is displayed
		box.setSelectedIndex(0); 
	}
}

