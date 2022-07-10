
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RecordVersion3 extends JFrame implements ActionListener
{ 

	public static final String fileName = "record";  
	public static final int numberOfImages = 8; 
	public static final int SLEEP_TIME = 10; 

	private ImageIcon image;
	private JLabel label = new JLabel();
	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	private int currentImage = 0;
	private Timer animationTimer;

	// define an inner class to hold the timer instructions
	class TimerListener implements ActionListener
	{    
	public void actionPerformed(ActionEvent e)
	{
	String strImage = fileName + (currentImage + 1) + ".jpg";
	image = new ImageIcon(strImage); 
	label.setIcon(image);
	currentImage++;
	if(currentImage == numberOfImages) 
	{
	currentImage = 0;
	}
	}
	}

	public RecordVersion3()
	{            
	// create a new Timer object
	animationTimer = new Timer(SLEEP_TIME, new TimerListener());

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());     
	// add the buttons and label to the frame and centre the image
	add(startButton);
	add(stopButton);
	add(label);
	label.setHorizontalAlignment(JLabel.CENTER);
	label.setIcon(new ImageIcon ("record1.jpg"));

	startButton.addActionListener(this);
	stopButton.addActionListener(this);

	// configure the frame
	setTitle("Revolving Record");
	getContentPane().setBackground(Color.white);
	setSize(300,300);
	setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource() == startButton)
	{
	animationTimer.start(); // start the timer
	}
	else
	{
	animationTimer.stop(); // stop the timer
	}
	}
}

