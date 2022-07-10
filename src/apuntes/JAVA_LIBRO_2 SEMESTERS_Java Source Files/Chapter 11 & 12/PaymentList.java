
/** Collection class to hold a list of Payment objects
?*  @author Charatan and Kans
?*  @version 4th September 2008
?*/
public class PaymentList extends ObjectList // inherit from ObjectList
{
	/** Constructor initialises the empty list and sets the maximium list size
	?*/
	public PaymentList(int sizeIn)
	{  // call ObjectList constructor
		super(sizeIn);
	}
		
	/** Reads the payment at the given position in the list
	?* @param positionIn The position of the payment in the list
	?* @return Returns the payment at the given position in the list
	?* 	or null if no payment at that posiiton
	?*/
	public Payment getPayment(int positionIn)
	{  //check for valid position
		if (positionIn <1 || positionIn > getTotal())
		{
			// no object found at given position
			return null;
		}
		else
		{
			// call inherited method and type cast
			return (Payment) getItem(positionIn);
		}
	}
	
	/** Returns the total value of payments recorded */
	public double calculateTotalPaid()
	{
		double totalPaid = 0; // initialize totalPaid
		// loop through all payments
		for (int i = 1; i <= getTotal();i++)
		{  // add current payment to running total
			totalPaid = totalPaid + getPayment(i).getAmount();
		}
		return totalPaid;
	}
}

