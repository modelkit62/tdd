/* the purpose of this class is just to test which exception is thrown when a negative array size is entered */

public class TrapException
{
	public static void main(String[] args)
	{
		try 
		{
			// here write the code you are testing
			System.out.println("Enter size");
			int size = EasyScanner.nextInt(); // requires EasyScanner class
			int[] list = new int[size];
		}
			catch (Exception e) // this will catch any exception that is thrown
		{
			System.out.println(e); // will display the name of the exception
		}
	}
}
