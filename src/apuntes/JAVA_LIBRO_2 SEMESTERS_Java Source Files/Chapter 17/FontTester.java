
import java.awt.*;
import javax.swing.*;

public class FontTester extends JFrame
{
	public FontTester()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(260,260);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g); // call the paint method of the superclass
	
		// create seven new fonts of our own
		Font font1 = new Font("SansSerif",Font.PLAIN,16);
		Font font2 = new Font("Serif",Font.PLAIN,20);
		Font font3 = new Font("Monospaced",Font.PLAIN,30);
		Font font4 = new Font("Dialog",Font.BOLD,20);
		Font font5 = new Font("DialogInput",Font.BOLD,20);
		Font font6 = new Font("Serif",Font.ITALIC,30);
		Font font7 = new Font("Serif",Font.ITALIC + Font.BOLD,16);
	
		// draw a string in each of the new fonts
		g.setFont(font1);
		g.drawString("This is font1", 10,47);
		g.setFont(font2);
		g.drawString("This is font2", 10,75);
		g.setFont(font3);
		g.drawString("This is font3", 10,105);
		g.setFont(font4);
		g.drawString("This is font4", 10,135);
		g.setFont(font5);
		g.drawString("This is font5", 10,165);
		g.setFont(font6);
		g.drawString("This is font6", 10,200);
		g.setFont(font7);
		g.drawString("This is font7", 10,230);
    }
}
	
