
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RecordVersion2 extends JFrame implements ActionListener
{ 
	public static final String fileName = "record";  
	public static final int numberOfImages = 8; 
	public static final int SLEEP_TIME = 100; 

	private ImageIcon image;
	private JLabel label = new JLabel();
	private int currentImage = 0;

	// declare a Timer 
	private Timer animationTimer;

	public RecordVersion2()
	{            
	// create a new Timer object
	animationTimer = new Timer(SLEEP_TIME, this);

	// add the label to the frame and centre the image

	add(label);
	label.setHorizontalAlignment(JLabel.CENTER);
	label.setIcon(new ImageIcon ("record1.jpg"));

	// configure the frame
	setTitle("Revolving Record");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.white);
	setSize(300,300);
	setVisible(true);

	// start the Timer
	animationTimer.start();
	}

	// the instructions for the Timer
	public void actionPerformed(ActionEvent e) 
	{
	String strImage = fileName + (currentImage+1) + ".jpg";
	image = new ImageIcon(strImage); 
	label.setIcon(image);
	currentImage++;
	if(currentImage == numberOfImages) 
	{
	currentImage = 0;
	}
   }    
}

