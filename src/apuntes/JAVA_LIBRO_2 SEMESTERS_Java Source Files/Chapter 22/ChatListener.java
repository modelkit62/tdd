
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;

public class ChatListener extends Thread
{ 	
	private InputStream inputStream; // for low level input
	private DataInputStream dataInputStream; // for high level input
	private JTextArea window; // a reference to the text area where the message will be displayed
	private Socket connection; // a reference to the connection
		
	// constructor receives references to the text area and the connection
	public ChatListener(JTextArea windowIn, Socket connectionIn)
	{
		window = windowIn;
		connection = connectionIn;
	
		try
		{
			// create an input stream from the remote machine
			inputStream = connection.getInputStream(); 
		   	dataInputStream = new DataInputStream(inputStream);
		}
		catch(IOException e)
		{
		}
	}
	
	public void run()
	{ 
		String msg;
		while(true)
		{
			
			try
			{
				msg = dataInputStream.readUTF(); // read the incoming message
				window.append(msg); // display the message

				// ensure that the window scrolls correctly (see discussion below)
			 	window.setCaretPosition(window.getCaretPosition() + msg.length());
			}
			catch(IOException e)
			{ 
			}
	    }	 
	}	
}

