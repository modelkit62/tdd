import javax.swing.*;

public class RunChatServer
{
	
	public static void main(String[] args)
	{
		String port, name;
		
		port = JOptionPane.showInputDialog
		         (null, "Enter the port number", null, JOptionPane.PLAIN_MESSAGE);
		name = JOptionPane.showInputDialog
		         (null, "Choose a user name", null, JOptionPane.PLAIN_MESSAGE);
		
		new ChatServer(Integer.valueOf(port), name); 
		
	}	
}
