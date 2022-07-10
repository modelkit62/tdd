
import javax.swing.*;

public class ImageHolder extends JFrame
{
	public ImageHolder()
	{
		ImageIcon image = new ImageIcon("Cover.jpg"); // create the image
		JLabel label = new JLabel(image); // add the image to a label
		add(label); // add the label to the frame
		setSize(360,530);
		setVisible(true);
	}       
}

