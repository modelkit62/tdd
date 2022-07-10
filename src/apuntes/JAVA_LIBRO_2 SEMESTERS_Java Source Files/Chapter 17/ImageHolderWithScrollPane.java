
import javax.swing.*;

public class ImageHolderWithScrollPane extends JFrame
{
	public ImageHolderWithScrollPane()
	{           
		ImageIcon image = new ImageIcon("Cover.jpg"); 	// create the image
		JLabel label = new JLabel(image); // add the image to a label
		JScrollPane pane = new JScrollPane(label); 	/* add the label to a 
		scrollpane*/
		add(pane); // add the scrollpane to the frame
		setSize(250,340);
		setVisible(true);
	}
}
