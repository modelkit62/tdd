
import javax.swing.*;
import java.awt.*;

public class SquareIcon implements Icon
{
	private int size;

	public SquareIcon(int sizeIn)
	{
	size = sizeIn;
	}

	// all the following methods are required by the Icon interface
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	g.setColor(Color.red);
	g.fillRect(x, y, size, size);
	}

	public int getIconWidth()
	{
	return size;
	}

	public int getIconHeight()
	{
	return size;
	}
}

