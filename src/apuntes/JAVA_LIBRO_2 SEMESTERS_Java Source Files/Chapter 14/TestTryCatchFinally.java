
public class TestTryCatchFinally
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("START TRY\n");
			String[] colours = {"RED","BLUE","GREEN"}; // initialize array
			System.out.print("Which colour? (1,2,3): ");
			String pos = EasyScanner.nextString(); // requires EasyScanner class
			// next line could throw NumberFormatException
			int i = Integer.parseInt(pos);
			// next line could throw ArrayIndexOutOfBoundsException
			System.out.println(colours[i-1]);
			System.out.println("\nEND TRY\n");
		}
		// include a catch only for ArrayIndexOutOfBoundsException
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("\nENTER CATCH\n");
			System.out.println(e);
		}
		// this code will always be executed
		finally
		{
			System.out.println("\nENTER FINALLY\n");
			System.out.println("Goodbye\n");
		}
	}
}

