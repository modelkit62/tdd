
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CounterVersionThree extends JFrame implements ActionListener
{
  private JButton startButton = new JButton("Start");
  private JButton stopButton = new JButton("Stop");
  private JTextField counterWindow = new JTextField(2);

  /* we are now using the AlternativeCounter class instead of the
	CounterThread class that we used in version two */
  private AlternativeCounter aCounter; 

  public CounterVersionThree()
  {
	setTitle("Counter");
	add(startButton);
	add(stopButton);
	add(counterWindow);

	startButton.addActionListener(this);
	stopButton.addActionListener(this);

	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(250,100);
	setLocation(300,300);
	setVisible(true);
  }

 public void actionPerformed(ActionEvent e)
{
	if(e.getSource() == startButton)
	{
	aCounter = new AlternativeCounter(counterWindow);
	/* this time we have to use the object's begin method; it does
	not have a start method as it is not an extension of Thread */
	aCounter.begin();  
	}
	else if(e.getSource() == stopButton)
	{
	aCounter.finish();
	}
  }
}

