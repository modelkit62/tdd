import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class FileHandler extends JFrame implements ActionListener
{
	// the attributes

	// declare a TextArea
	private JTextArea viewArea = new JTextArea(10,55);

	// declare the menu components
	private JMenuBar bar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu quitMenu = new JMenu("Quit");
	private JMenuItem selectChoice = new JMenuItem("Select");
	private JMenuItem runChoice = new JMenuItem("Run");
	private JMenuItem reallyQuitChoice = new JMenuItem("Really quit");
	private JMenuItem cancelChoice = new JMenuItem("Cancel");
	private JMenuItem displayContentsChoice = new JMenuItem("Display contents");

	// declare an attribute to hold the chosen file 
	private File chosenFile;

	// the constructor
	public FileHandler()
	{
	setTitle("File Handler"); // set title of the frame

	add(viewArea); // add the text area

	// add the menus to the menu bar
	bar.add(fileMenu);
	bar.add(quitMenu);

	// add the menu items to the menus
	fileMenu.add(selectChoice);
	fileMenu.add(runChoice);
	fileMenu.add(displayContentsChoice);
	quitMenu.add(reallyQuitChoice);
	quitMenu.add(cancelChoice);
	

	// add the menu bar to the frame
	setJMenuBar(bar);

	// add the ActionListeners
	selectChoice.addActionListener(this);
	runChoice.addActionListener(this);
	displayContentsChoice.addActionListener(this);
	reallyQuitChoice.addActionListener(this);
	cancelChoice.addActionListener(this);

	// configure the frame
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setSize(450,200);
	setVisible(true);
}

	// the event handler
	public void actionPerformed(ActionEvent e)
	 { 
	   if(e.getSource() == selectChoice)
	   {
		// create a new JFileChooser object
			JFileChooser chooser = new JFileChooser();
		
			// show the dialogue
			chooser.showDialog(this, "Select File");
		
			// determine which file has been selected
			chosenFile = chooser.getSelectedFile();
		
			// display the name of the chosen file
			viewArea.append("Selected File: " + chosenFile.getName() + '\n');
	   }
	
	   if(e.getSource() == runChoice)
	   {
			// create a RunTime object
			Runtime rt = Runtime.getRuntime();
			try
			{
				// run the file
				rt.exec(chosenFile.getPath());
			}
		
			// if the file name is null
			catch(NullPointerException npe)
			{
				viewArea.append("No file selected\n");                
			}
		
			// if the file cannot be executed
			catch(IOException ioe)
			{
				viewArea.append("Not an executable file\n");
			}
	   }
	   if(e.getSource() == reallyQuitChoice)
	   {
			System.exit(0);
	   }
	
	   if(e.getSource() == cancelChoice)
	   {
			viewArea.append("Quit option cancelled\n");
	   }
	   
	   
	   if(e.getSource() == displayContentsChoice)
		{
			try
			{
				final int MAX = 1000;
				FileReader testFile = new FileReader(chosenFile.getName());
				BufferedReader textStream = new BufferedReader(testFile);
				int ch; // to hold the integer (Unicode) value of the character
				char c; // to hold the character when type cast from integer
				int counter = 0; // to count the number of characters read so far
				ch = textStream.read(); // read the first character from the file
				c = (char) ch; // type cast from integer to character
				viewArea.append("\n");
				/* continue through the file until either the end of the file is 
				   reached (in which case -1 is returned) or the maximum number of 
				   characters stipulated have been read */
				while( ch != -1 && counter <= MAX)
				{
					counter++; // increment the counter
					viewArea.append("" + c); // display the character
					ch = textStream.read(); // read the next character
					c = (char) ch;
				}
				textStream.close();
				viewArea.append("\n");
			}
		
			catch(IOException ioe)
			{
				if(chosenFile == null) // no file selected
				{
					viewArea.append("No file selected\n");
				}
				else
				{
					viewArea.append("There was a problem reading the file\n");
				}
			}
		}

	}
	
	
	
}

