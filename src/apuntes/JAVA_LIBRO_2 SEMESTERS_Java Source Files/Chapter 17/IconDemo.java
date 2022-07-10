
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IconDemo extends JFrame implements ActionListener
// adds an icon and text to a component
{
	private JButton button = new JButton();
	private SquareIcon icon = new SquareIcon(30);

	public IconDemo()
	{
	button.setMargin(new Insets(0,0,0,0));
	button.setIcon(icon);        	// adds the icon to the button
	button.setText("  Quit  ");  	// adds the text to the button
	add(button);
	button.addActionListener(this);

	// configure the frame
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(180,100);
	setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
	System.exit(0);
	}
}

