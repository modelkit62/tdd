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
	quitMenu.add(reallyQuitChoice);
	quitMenu.add(cancelChoice);

	// add the menu bar to the frame
	setJMenuBar(bar);

	// add the ActionListeners
	selectChoice.addActionListener(this);
	runChoice.addActionListener(this);
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
	}
}

