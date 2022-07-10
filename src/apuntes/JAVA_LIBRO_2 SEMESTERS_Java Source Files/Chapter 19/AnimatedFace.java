
import java.awt.*;
import javax.swing.*;

public class AnimatedFace extends JFrame implements Runnable
{
	private boolean isHappy;

	// a separate thread is required to run the animation
	private Thread thread1;  

	public AnimatedFace()
	{
	isHappy = true;

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(250,250);
	setLocation(300,300);
	getContentPane().setBackground(Color.yellow);
	setVisible(true);

	// create a new thread
	thread1 = new Thread(this); 
	// start the thread
	thread1.start();
	}

	public void run()
	{
	while(true)  // a continuous loop
	{
	// on each iteration of the loop the mood is changed.....
	if(isHappy == true)
	{
	isHappy = false;
	}
	else
	{
	isHappy = true;
	}
	// ..... and the face is repainted
	repaint();
	try
	{
	thread1.sleep(1000);
	}
	catch(InterruptedException e)
	{
	}
	}
	}

	public void paint(Graphics g)
	{
	super.paint(g);
	g.setColor(Color.red);
	g.drawOval(85,75,75,75);  // the face
	g.setColor(Color.blue);
	g.drawOval(100,95,10,10); // the right eye
	g.drawOval(135,95,10,10); // the left eye
	g.drawString("Animated Face", 82,175);
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
}

