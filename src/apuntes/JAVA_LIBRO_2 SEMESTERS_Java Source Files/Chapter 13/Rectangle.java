public class Rectangle implements Checkable
{

	private double length;
	private double height;

	public Rectangle(double lengthIn, double heightIn)
	{
		length = lengthIn;
		height = heightIn;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setLength(double lengthIn)
	{
		length = lengthIn;
	}
	
	public void setHeight(double heightIn)
	{
		height = heightIn;
	}
	
	public double calculateArea()
	{
		return length * height;
	}
	
	public double calculatePerimeter()
	{
		return 2 * (length + height);
	}
	
	public boolean check() // the check method of Checkable must be overriden
	{
		return length > 0 && height > 0;
	}
}
