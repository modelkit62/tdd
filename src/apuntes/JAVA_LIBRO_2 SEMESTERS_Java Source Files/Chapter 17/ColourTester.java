
import java.awt.*;
import javax.swing.*;

public class ColourTester extends JFrame
{
	public ColourTester()
	{
		// configure the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(150,160);
		setVisible(true);  
	}

	public void paint(Graphics g)
	{
		super.paint(g); // call the paint method of the superclass
	
		// create six new colours of our own
		Color magenta = new Color(255,0,255);
		Color cyan = new Color(0,255,255);
		Color black = new Color(0,0,0);
		Color purple = new Color(210,100,210);
		Color orange = new Color(250,150,0);
		Color brown =  new Color(200,150,150);
	
		// draw a string in each of the new colours
		g.setColor(magenta);
		g.drawString("This is magenta", 10,40);
		g.setColor(cyan);
		g.drawString("This is cyan", 10,60);
		g.setColor(black);
		g.drawString("This is black", 10,80);
		g.setColor(purple);
		g.drawString("This is purple", 10,100);
		g.setColor(orange);
		g.drawString("This is orange", 10,120);
		g.setColor(brown);
		g.drawString("This is brown", 10,140);   
	}
}

