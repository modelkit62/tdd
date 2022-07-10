
import java.awt.*;
import javax.swing.*;

public class Record extends JFrame implements Runnable
{
	// declare some constants
	public static final String fileName = "record";  
	public static final int numberOfImages = 8; 
	public static final int SLEEP_TIME = 100; 

	private JLabel label = new JLabel();
	private ImageIcon image; 
	private Thread animationThread;

	public Record() 
	{                  
	// create a new thread
	animationThread = new Thread(this);

	// add the label to the frame and centre the image
	add("Center",label);
	label.setHorizontalAlignment(JLabel.CENTER);

	// configure the frame
	setTitle("Revolving Record");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.white);
	setSize(300,300);
	setVisible(true);

	// start the thread
	animationThread.start();
	}

	public void run()
	{   
	int currentImage = 0;
	String strImage;
	while(true)
	{                
	strImage = fileName + (currentImage+1) + ".jpg";
	image = new ImageIcon(strImage); 

	label.setIcon(image);

	try
	{
	animationThread.sleep(SLEEP_TIME);
	}
	catch(InterruptedException e)
	{
	}
	currentImage++;
	if(currentImage == numberOfImages) 
	{
	currentImage = 0;
	}
	}    
	}
}

