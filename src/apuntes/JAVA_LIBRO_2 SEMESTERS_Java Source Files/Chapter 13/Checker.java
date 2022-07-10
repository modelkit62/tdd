
public class Checker
{
	public static void main(String[] args)
	{
		// create two rectangles
		Rectangle rectangle1 = new Rectangle(0, 8); // invalid: first attribute is zero
		Rectangle rectangle2 = new Rectangle(10, 8); // valid
		
		// create two customers
		Customer customer1 = new Customer("A37"); // invalid: number must be 1 letter and 4 digits
		Customer customer2 = new Customer("S1234"); // valid
		 
		// send objects to the check method 
		checkObject(rectangle1);
		checkObject(rectangle2);
		checkObject(customer1);
		checkObject(customer2);
	}

	public static void checkObject(Checkable objectIn)
	{
		if(objectIn.check())  // call the check method
		{
			System.out.println("Valid object");
		}
		else
		{
			System.out.println("Invalid object");			
		}
	}
		
}

