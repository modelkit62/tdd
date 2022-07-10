
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdditionClient extends JFrame implements ActionListener
{

	// declare the visual components
	private JTextField firstNumber = new JTextField(3);
	private JLabel plus = new JLabel("+");
	private JTextField secondNumber = new JTextField(3);
	private JLabel equals = new JLabel("=");
	private JLabel sum = new JLabel();
	private JTextField msg = new JTextField(20);
	private JButton addButton
	= new JButton("Press to see the sum of the two numbers");
	
	// declare low level and high level objects for input
	private InputStream inStream;
	private DataInputStream inDataStream;
	
	// declare low level and high level objects for output
	private OutputStream outStream;
	private DataOutputStream outDataStream;
	
	// declare a socket
	private Socket connection;
	
	// declare attributes to hold details of remote machine and port
	private String remoteMachine;
	private int port;
	
	// constructor
	public AdditionClient(String remoteMachineIn, int portIn)
	{
	
		remoteMachine = remoteMachineIn;
		port = portIn;
		// add the visual components
		add(firstNumber);
		add(plus);
		add(secondNumber);
		add(equals); add(sum);
		add(msg); add(addButton);
		
		// configure the frame
		setLayout(new FlowLayout());
		setTitle("Addition Client");
		msg.setHorizontalAlignment(JLabel.CENTER);
		addButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150); setLocation(300,300);
		setVisible(true);
		
		// start the helper method that starts the client
		startClient();
	}
	
	private void startClient()
	{
		
		try
		{
		
			// attempt to create a connection to the server
			connection = new Socket(remoteMachine, port);
			msg.setText("Connection established");
			
			// create an input stream from the server
			inStream = connection.getInputStream();
			inDataStream = new DataInputStream(inStream);
			
			// create an output stream to the server
			outStream = connection.getOutputStream();
			outDataStream = new DataOutputStream(outStream);
			
			// send the host IP to the server
			outDataStream.writeUTF(connection.getLocalAddress().getHostAddress());
		}
		catch (UnknownHostException e)
		{
			msg.setText("Unknown host");
		}
		catch (IOException except)
		{
			msg.setText("Network Exception");
		}
		
	}
		
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		
			// send the two integers to the server 
			outDataStream.writeInt(Integer.parseInt(firstNumber.getText())); outDataStream.writeInt(Integer.parseInt(secondNumber.getText()));
			
			// read and display the result sent back from the server
			int result = inDataStream.readInt();
			sum.setText("" + result);
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		
	  }
  }
}
