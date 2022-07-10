
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CounterVersionTwo extends JFrame implements ActionListener
{
  private JButton startButton = new JButton("Start");
  private JButton stopButton = new JButton("Stop");
  private JTextField counterWindow = new JTextField(2);
  private CounterThread thread;

  public CounterVersionTwo()
  {
	setTitle("Counter");
	add(startButton);
	add(stopButton);
	add(counterWindow);

	startButton.addActionListener(this);
	stopButton.addActionListener(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	setSize(250,100);
	setLocation(300,300);
	setVisible(true);
  }
  
  
  



  public void actionPerformed(ActionEvent e)
  {
	if(e.getSource() == startButton)
	{
	//create a new thread
	thread = new CounterThread(counterWindow);
	// start the thread
	thread.start();
	}
	else if(e.getSource() == stopButton)
	{   
	// stop the thread
	thread.finish();
	}
  }
}

