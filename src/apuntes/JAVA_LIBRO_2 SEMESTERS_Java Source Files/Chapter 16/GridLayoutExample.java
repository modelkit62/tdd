import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridLayoutExample extends JFrame implements ActionListener
{
	
	private JButton[] buttonArray = new JButton[12]; // declare an array of 12 JButtons
	
	public GridLayoutExample()
	{
		setLayout(new GridLayout(3, 4)); // set the layout policy to a GridLayout of 3 rows and 4 columns
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JFrame");
		setSize(400,300);
		setLocation(400, 300);
		
		for(int i = 0; i < buttonArray.length; i++)
		{
			buttonArray[i] = new JButton("Button" + (i+1)); // add a JButton into the array
			add(buttonArray[i]); // add the new JButton to the JFrame
			buttonArray[i].setBackground(Color.yellow); // set the colour of the JButton to yellow
			buttonArray[i].addActionListener(this); // add an actionListioner to the button
		}
		setVisible(true);
	}	
	
	public void actionPerformed(ActionEvent e)
	{
		for(int i = 0; i < buttonArray.length; i++)
		{
			if(e.getSource() == buttonArray[i]) // check each button to see if it was the one pressed
			{
				if(buttonArray[i].getBackground() == Color.yellow) // if the button is currently yellow
				{
					buttonArray[i].setBackground(Color.red); // set the colour of the button to red
				}
				else // if the button is not yellow
				{
					buttonArray[i].setBackground(Color.yellow); // set the colour to yellow
				}
				return; // there is no need to search the remaining buttons 
			}
		}	
	}
	
}
