
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class RedCircleWithAdapter extends JFrame implements MouseMotionListener
{
private int xPos; 
private int yPos; 
private int width; 
private int height; 
private boolean mouseDown;

//inner class 
class RedCircleAdapter extends MouseAdapter
{
public void mousePressed(MouseEvent e)
{
mouseDown = true; 
repaint();
}
public void mouseReleased(MouseEvent e)
{
mouseDown = false; 
repaint();
}
	}

// the constructor 
public RedCircleWithAdapter(int widthIn, int heightIn)
{
setTitle("Red Circle Game"); 
addMouseMotionListener(this); 
addMouseListener(new RedCircleAdapter()); // create an object of the inner class
width = widthIn; 
height = heightIn; 
getContentPane().setBackground(Color.yellow);
xPos = widthIn/2 -20; 
yPos = heightIn/2 - 20; 
setSize(width, height); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocation(300,300); 
setVisible(true);
}
// the paint method 
public void paint(Graphics g)
{
super.paint(g); 
g.drawString("Click on the red circle", width/2 - 60, 50); 
g.setColor(Color.red); 
g.fillOval(xPos,yPos,20,20); 
if(mouseDown)
{
	g.drawString("Keep trying!!!", width/2 - 40, height - 10);
}
}

	public void mouseMoved(MouseEvent e)
	{
		xPos = e.getX() - 50; 
		yPos = e.getY() - 50; 
		repaint();
	}

	public void mouseDragged(MouseEvent e)
{
		xPos = e.getX() - 50; 
		yPos = e.getY() - 50; 
		repaint();
}
}

