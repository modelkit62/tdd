

import javax.swing.*;
import javax.swing.event.*;

public class SliderDemo extends JFrame implements ChangeListener
{
	// declare and initialize a horizontal slider
	private JSlider bar = new JSlider(JSlider.HORIZONTAL);

	// declare and initialize a label
	private JLabel valueLabel = new JLabel();

	// the constructor
	public SliderDemo ()
	{
		setTitle("Slider Demo"); // set the title of the frame
	
		// set the slider to its minimum value
		bar.setValue(0);
		// add the slider to the top of the frame
		add("North", bar);
		// set the initial text for the label
		valueLabel.setText("Current value: 0");
	
		// add the label to the frame
		add("South", valueLabel);
	
		// add the listener to the slider
		bar.addChangeListener(this);
	
		// configure the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,100);
		setLocation(300,300);
		setVisible(true);
	}

	// the event-handler
	public void stateChanged(ChangeEvent e)
	{
		// report on the current position of the bar
		valueLabel.setText("Current value: " + bar.getValue());
	}
}


