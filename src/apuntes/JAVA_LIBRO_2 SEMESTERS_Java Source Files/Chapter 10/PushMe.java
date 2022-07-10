
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PushMe extends JFrame implements ActionListener
{
	private JTextField myTextField = new JTextField(15);
	private JButton myButton = new JButton("please push me");
	private JLabel myLabel
	= new JLabel("Enter some text and push the button", JLabel.CENTER);
	
	// the constructor
	public PushMe()
	{
		setTitle("Push Me");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(220,120);
		setLocation(400, 300);
		add(myTextField);
		add(myButton);
		add(myLabel);
		myButton.addActionListener(this);
		setVisible(true);
	}
	
	// the event-handler
	public void actionPerformed(ActionEvent e)
	{
		String myText;
		myText = myTextField.getText();
		myLabel.setText("You entered " + "\"" + myText + "\"");
	}
}

