
public class Customer implements Checkable
{
	private String number;
	
	// other attributes
	
	public Customer(String numberIn)
	{
		number = numberIn;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	
	public boolean check()
	{
		if(number.length() != 5)
		{
			return false;
		}
		else if(!Character.isLetter(number.charAt(0)))
		{
			return false;
		} 
		else
		{
			for(int i = 1; i <= 4;  i++)
			{
				if(!Character.isDigit(number.charAt(i)))
				{
					return false;
				}
			}
		}   
		return true;
	}
	
	// other methods
}

