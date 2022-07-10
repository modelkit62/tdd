import javax.swing.*;

public class RunChatClient
{
	
	public static void main(String[] args)
	{
		String host;
		String port;
		String name;
		
		host = JOptionPane.showInputDialog
		         (null, "Enter the address of the host machine", null, JOptionPane.PLAIN_MESSAGE);
		port = JOptionPane.showInputDialog
		         (null, "Enter the port number that the host listens on", null, JOptionPane.PLAIN_MESSAGE);
		name = JOptionPane.showInputDialog
		         (null, "Choose a user name", null, JOptionPane.PLAIN_MESSAGE);
		
		new ChatClient  (host, Integer.valueOf(port), name); 
	}	
}