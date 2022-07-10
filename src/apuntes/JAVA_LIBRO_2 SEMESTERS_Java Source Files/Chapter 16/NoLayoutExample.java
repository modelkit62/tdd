import javax.swing.*;

public class NoLayoutExample extends JFrame 
{
	
	private JButton button1 = new JButton("I am at (20,20)");
	private JButton button2 = new JButton("I am at (40, 200)");
	private JButton button3 = new JButton("I am at (240, 80)");
	
	public NoLayoutExample()
	{
		setLayout(null); // set to no layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JFrame");
		setSize(450,400);
		setLocation(400, 300);
		
		add(button1);
		add(button2);
		add(button3);
		
       // place buttons in frame
		button1.setBounds(20, 20, 150, 120);
		button2.setBounds(40, 200, 150, 120);
		button3.setBounds(240, 80, 150, 120);

		setVisible(true);  
	}	
}
