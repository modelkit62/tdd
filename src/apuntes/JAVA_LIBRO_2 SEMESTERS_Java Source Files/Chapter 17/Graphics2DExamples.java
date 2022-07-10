
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;


public class Graphics2DExamples extends JFrame
{
	public Graphics2DExamples()
	{
		// configure the frame 
		super("Graphics2D Examples");
		setSize(540, 175);
		setLocation(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g); // call the paint method of JFrame
		Graphics2D g2g = (Graphics2D) g; // type cast the Graphics object to a Graphics2D object
		
		// create a rectangle		
		Rectangle2D.Double rectangle = new Rectangle2D.Double(50, 50,  70, 100); 
		
		// create an ellipse
		Ellipse2D.Double ellipse = new Ellipse2D.Double(150, 50, 70, 100); 
		
		// create an arc
		Arc2D.Double arc = new Arc2D.Double(250, 50, 100, 110, 70, 160, Arc2D.CHORD); 
		
		// create a line
	   Line2D.Double line = new Line2D.Double(400, 50, 320, 150);
	    
	    // create a rounded rectangle
	   	RoundRectangle2D.Double roundRect = new RoundRectangle2D.Double(430, 50, 75, 100, 50, 50); 
		
		// set the width of the brush stroke to 15 pixels
		g2g.setStroke(new BasicStroke(15));
				
		// draw the rectangle
		g2g.draw(rectangle);
		
		// set the colour of the brush to yellow then draw the ellipse, filled
		g2g.setPaint(Color.yellow);
		g2g.fill(ellipse);
		
				
		// set the colour of the brush to blue and the width to 4 pixels, then draw the arc
		g2g.setPaint(Color.blue);
		g2g.setStroke(new BasicStroke(4));
		g2g.draw(arc);	
		
		// declare a single element array to define the width of the dashes 	
		float dashes[] = { 10 };
		
		// define the style of a dashesd line
		g2g.setStroke(new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dashes, 0));
		
		// set the colour of the brush to red then draw the line		
		g2g.setPaint(Color.red);
		g2g.draw(line);
		
		
       // define a gradient so that the shape is painted in gradually changing colours
		g2g.setPaint(new GradientPaint(10, 40, Color.red, 45, 100, Color.green, true));
	
		// draw the rounded rectangle, filled
		g2g.fill(roundRect);
	}
}
