
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*; // required for the DecimalFormat class
import javax.swing.border.*;

public class MetricConverter extends JFrame implements ActionListener
{
	// we declare the various components as attributes.
	
	// first the components for converting back and forth from inches to centimetres 
	
	private JTextField cmText = new JTextField(6);
	private JLabel cmLabel = new JLabel("Cm");
	private JButton cmToInchButton = new JButton(" ===> ");
	private JButton inchToCmButton = new JButton(" <=== ");
	private JPanel inchCmButtons = new JPanel(); // compound container
	private JTextField inchText = new JTextField(6);
	private JLabel inchLabel = new JLabel("Inches");
	private JPanel inchCmPanel = new JPanel(); // compound container
	
	// next the components for converting back and forth from miles to kilometres 
	
	private JTextField kmText = new JTextField(6);
	private JLabel kmLabel = new JLabel("Km");
	private JButton kmToMileButton = new JButton(" ===> ");
	private JButton mileToKmButton = new JButton(" <=== ");
	private JPanel mileKmButtons = new JPanel(); // compound container
	private JTextField mileText = new JTextField(6);
	private JLabel mileLabel = new JLabel("Miles  "); // extra spaces make all labels the same length
	private JPanel mileKmPanel = new JPanel(); // compound container
	
	// finally the components for converting back and forth from pounds to kilograms 
	
	private JTextField kgText = new JTextField(6);
	private JLabel kgLabel = new JLabel("Kg "); // extra spaces make all labels the same length
	private JButton kgToPoundButton = new JButton(" ===> ");
	private JButton poundToKgButton = new JButton(" <=== ");
	private JPanel poundKgButtons = new JPanel(); // compound container
	private JTextField poundText = new JTextField(6);
	private JLabel poundLabel = new JLabel("Lb        "); // extra spaces make all labels the same length
	private JPanel poundKgPanel = new JPanel(); // compound container
	
	
	// the constructor adds the components to the object at the time it is created 
	
	public MetricConverter()
	{
		inchCmButtons.setLayout(new BorderLayout()); // see discussion
		inchCmButtons.add("North", cmToInchButton);
		inchCmButtons.add("South", inchToCmButton);
		inchCmPanel.add(cmText);
		inchCmPanel.add(cmLabel);
		inchCmPanel.add(inchCmButtons);
		inchCmPanel.add(inchText);
		inchCmPanel.add(inchLabel);
		
		mileKmButtons.setLayout(new BorderLayout()); // see discussion
		mileKmButtons.add("North", kmToMileButton);
		mileKmButtons.add("South", mileToKmButton);
		mileKmPanel.add(kmText);
		mileKmPanel.add(kmLabel);
		mileKmPanel.add(mileKmButtons);
		mileKmPanel.add(mileText);
		mileKmPanel.add(mileLabel);
		poundKgButtons.setLayout(new BorderLayout()); // see discussion
		poundKgButtons.add("North", kgToPoundButton);
		poundKgButtons.add("South", poundToKgButton);
		poundKgPanel.add(kgText);
		poundKgPanel.add(kgLabel);
		poundKgPanel.add(poundKgButtons);
		poundKgPanel.add(poundText);
		poundKgPanel.add(poundLabel);
		
		add(inchCmPanel);
		add(mileKmPanel);
		add(poundKgPanel);
		
		// give raised borders to the buttons
		cmToInchButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		cmToInchButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		inchToCmButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		kmToMileButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		mileToKmButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		kgToPoundButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		poundToKgButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		cmToInchButton.addActionListener(this);
		inchToCmButton.addActionListener(this);
		kmToMileButton.addActionListener(this);
		mileToKmButton.addActionListener(this);
		kgToPoundButton.addActionListener(this);
		poundToKgButton.addActionListener(this);
		
		setTitle("Metric Converter");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(320, 220);
		setLocation(300, 300);
		setVisible(true);
	}
	
	// now we code the event-handlers
	
	public void actionPerformed(ActionEvent e)
	{
		double d;
		String s;
		// format the output
		DecimalFormat df = new DecimalFormat("0.0#"); // see discussion that follows
		if (e.getSource() == cmToInchButton) // convert cm to inches
		{
			s = new String(cmText.getText());
			d = Double.parseDouble(s); // convert String to double
			d = d / 2.54; // convert to inches
			s = df.format(d); // format number for output
			inchText.setText(s);
		}
		if (e.getSource() == inchToCmButton) // convert inches to cm
		{
			s = new String(inchText.getText());
			d = Double.parseDouble(s); // convert String to double
			d = d * 2.54; // convert to cm
			s = df.format(d); // format number for output
			cmText.setText(s);
		}
		if (e.getSource() == kmToMileButton) // convert km to miles
		{
			s = new String(kmText.getText());
			d = Double.parseDouble(s); // convert String to double
			d = d / 1.609; // convert to miles
			s = df.format(d); // format number for output
			mileText.setText(s);
		}
		if (e.getSource() == mileToKmButton) // convert miles to km 
		{
			s = new String(mileText.getText());
			d = Double.parseDouble(s); // convert String to double
			d = d * 1.609; // convert to km
			s = df.format(d); // format number for output
			kmText.setText(s);
		}
		if (e.getSource() == kgToPoundButton) // convert kg to pounds
		{
			s = new String(kgText.getText());
			d = Double.parseDouble(s); // convert String to double
			d = d * 2.2; // convert to pounds
			s = df.format(d); // format number for output
			poundText.setText(s);
		}
		if (e.getSource() == poundToKgButton) // convert pounds to kg
		{	
			s = new String(poundText.getText());
			d = Double.parseDouble(s); // convert String to double
			d = d / 2.2; // convert to kg
			s = df.format(d); // format number for output
			kgText.setText(s);
		}
	}
}

