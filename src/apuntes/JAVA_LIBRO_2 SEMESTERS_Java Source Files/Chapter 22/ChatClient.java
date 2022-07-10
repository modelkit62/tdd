import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ChatClient extends JFrame implements KeyListener
{
   // declare and initialize visual componenets
   private JTextArea textWindow = new JTextArea(20,30);
   private JTextField inputWindow = new JTextField(30);  
   private JScrollPane pane = new JScrollPane(textWindow);
   
   private OutputStream outStream; // for low level output
   private DataOutputStream outDataStream; // for high level output
   
   private ChatListener listener;
   
   private int port; // to hold the port number of the server
   private  String remoteMachine; // to hold the name chosen by the user

   
   private String name;
  
   // the constructor
   public ChatClient(String remoteMachineIn, int portIn, String nameIn)
   {   
   	   port = portIn;
       name = nameIn;
       remoteMachine = remoteMachineIn;
       
       // configure the text window where the messages are displayed
       textWindow.setLineWrap(true);
       textWindow.setWrapStyleWord(true);
       textWindow.setEditable(false); 
       
       // add a KeyListener to the input window so that messages can be sent by pressing <Enter>
       inputWindow.addKeyListener(this);
       
       // configure the frame
       setTitle("Chat Client");
       setLayout(new FlowLayout());
       add(pane);
       add(inputWindow);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(350, 400);
       setVisible(true);
       
       // start the client
       startClient();
   }
   
   private void startClient()  
   {
   	    // declare a "general" socket
        Socket connection;
        
        try
        {
        	// create a connection to the server
           	connection = new Socket (remoteMachine, port ); 
           	
     		// create output stream to the connection   
		    outStream = connection.getOutputStream();
		    outDataStream = new DataOutputStream (outStream);      	
         	
         	// create a thread to listen for messages
         	listener = new ChatListener(textWindow, connection);
        	listener.start(); // start the thread
		}  

        catch(UnknownHostException e)
        {	
        	textWindow.setText("Unknown host");
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
      if(e.getKeyChar()=='\n')
      {
      	// echo the message typed in the input window (including the name) in the text area
        text = inputWindow.getText();
        textWindow.append("<" + name + "> " + text + "\n");
    
        //clear the input window
        inputWindow.setText("");
    
        // send the message to the server
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

