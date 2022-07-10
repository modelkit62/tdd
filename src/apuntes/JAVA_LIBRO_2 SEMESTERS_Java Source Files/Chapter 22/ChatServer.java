import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ChatServer extends JFrame implements KeyListener
{ 
	// declare and initialize visual components
	private JTextArea textWindow = new JTextArea(20, 30);
	private JTextField inputWindow = new JTextField(30);
	private JScrollPane pane = new JScrollPane(textWindow);

	private OutputStream outStream; // for low level output
	private DataOutputStream outDataStream; // for high level output

	private ChatListener listener; // a reference to the listening thread (discussed in detail later)

	private int port; // to hold the port number chosen by the user
	private String name; // to hold the name chosen by the user
  
   // the constructor
   public ChatServer(int portIn, String nameIn)
   { 
       port = portIn;
       name = nameIn;

		// configure the text window where the messages are displayed
       textWindow.setLineWrap(true);
       textWindow.setWrapStyleWord(true);
       textWindow.setEditable(false);

		// add a KeyListener to the input window so that messages can be sent by pressing <Enter>
       inputWindow.addKeyListener(this);
		
		// configure the frame
       setTitle("Chat Server");
       setLayout(new FlowLayout());   
       add(pane);
       add(inputWindow);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(350, 400);
       setVisible(true);

		// start the server
       startServer();
   }
   
   private void startServer()  
   {
       // declare a "general" socket and a server socket
       Socket connection;
       ServerSocket listenSocket;
       
		try  
		{
          // create a server socket
	       listenSocket = new ServerSocket (port);  	    
    
          // listen for a connection from the client
		   connection = listenSocket.accept();		       
	       		         
	    	// create an output stream to the connection   
	    	outStream = connection.getOutputStream ();
	    	outDataStream = new DataOutputStream(outStream );

			// create a thread to listen for massages
   			listener = new ChatListener(textWindow, connection);
      		listener.start(); // start the thread

		}  
		catch (IOException e)  
		{		 
			textWindow.setText("An error has occured");     	  
		}
  }  
      
  // handle a "key typed" event
  public void keyTyped(KeyEvent e)
  {  
      String text;
      if(e.getKeyChar()=='\n') // if the <Emter> key was pressed
      {
        	// echo the message typed in the input window (including the name) in the text area
			text = inputWindow.getText();
		   	textWindow.append("<" + name + "> " + text + "\n"); 

			// clear the input window
        	inputWindow.setText("");
        	
			// send the message to the client
			try
        	{
          		outDataStream.writeUTF("<" + name + "> " + text + "\n");
        	}
        	catch(IOException ie)
        	{
       	}
      }
  }

  // implement the remaining methods of KeyListener
  public void keyReleased(KeyEvent e)
  {    
  }

  public void keyPressed(KeyEvent e)
  {  
  }
}  

