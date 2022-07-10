import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangingFaceApplet extends JApplet implements ActionListener
{
private boolean isHappy = true; // will determine the mood of the face
private JButton happyButton = new JButton("Smile");
private JButton sadButton = new JButton("Frown");

public void init() // initialization routines are placed in thsi method
	{
// use a flow layout
setLayout(new FlowLayout());

// add the buttons to the panel
add(happyButton);
add(sadButton);

// set the background to yellow
getContentPane().setBackground(Color.yellow); // changed

// make the buttons transparent
happyButton. setOpaque(false);
sadButton.setOpaque(false);

// enable the buttons to listen for a mouse-click
happyButton. addActionListener(this);
sadButton.addActionListener(this);

}

public void paint(Graphics g) // changed
{

// call the paint method of the superclass, Japplet
super. paint(g); // changed
g.setColor(Color. red);
g.drawOval(85,45,75,75);
g.setColor(Color. blue);
g.drawOval(100,65,10,10);
g.drawOval(135,65,10,10);
g.drawString("Changing Face", 80,155);
if(isHappy == true)
{

// draw a smiling mouth
g.drawArc(102,85,40,25,0,-180);
}
else
{

// draw a frowning mouth
g.drawArc(102,85,40,25,0,180);
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
