
public class NegativeSizeException extends Exception
{
	public NegativeSizeException () // constructor without parameter
	{
		super("cannot set a negative size");
	}
	
	public NegativeSizeException (String message)// constructor with parameter
	{
		super (message);
	}
}
