
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangingFace extends JFrame implements ActionListener
{
	private boolean isHappy = true; // will determine the mood of the face
	private JButton happyButton = new JButton("Smile");
	private JButton sadButton = new JButton("Frown");
	
	public ChangingFace()
	{
		// set the title
		setTitle("Changing Face");
		
		// choose a Flow Layout policy
		setLayout(new FlowLayout());
		
		// add the buttons to the frame
		add(happyButton); add(sadButton);
		
		// set the background to yellow
		getContentPane().setBackground(Color.yellow);
		
		// enable the buttons to listen for a mouse-click
		happyButton.addActionListener(this);
		sadButton.addActionListener(this);
		
		// configure the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 200);
		setLocation(300,300);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		// call the paint method of the superclass, Jframe
		super.paint(g);
		// paint the face
		g.setColor(Color.red);
		g.drawOval(85,75,75,75);
		g.setColor(Color.blue);
		g.drawOval(100,95,10,10);
		g.drawOval(135,95,10,10);
		g.drawString("Changing Face", 80,185);
		if(isHappy == true)
		{
			// draw a smiling mouth
			g.drawArc(102,115,40,25,0,-180);
		}
		else
		{
			// draw a frowning mouth
			g.drawArc(102,115,40,25,0,180);
		}
	}
		// this is where we code the event-handling routine
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == happyButton)
		{
			isHappy = true;
			repaint();
		}
		if(e.getSource() == sadButton)
		{
			isHappy = false;
			repaint();
		}
	}
}

