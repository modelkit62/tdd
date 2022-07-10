
/** Class used to record the details of a tenant
?*  @author Charatan and Kans
?*  @version 6th September 2008
?*/
public class Tenant
{
	private String name;
	private int room;
	private PaymentList payments;
	public static final int maxNoOfPayments = 12;
	
	/** Constructor initialises the name and room number of the tenant
	?*  and sets the payments made to the empty list
	?*/
	Tenant(String nameIn, int roomIn)
	{
		name = new String(nameIn);
		room = roomIn;
		payments = new PaymentList(maxNoOfPayments);
	}
	
	/** Reads the name of the tenant */
	public String getName()
	{
		return name;
	}
	
	/** Reads the room number of the tenant */
	public int getRoom()
	{
	return room;
	}
	
	/** Records a payment for the tenant */
	public void makePayment(Payment paymentIn)
	{
		payments.add(paymentIn); // call PaymentList method
	}
	
	/** Reads the payments made by the tenant */
	public PaymentList getPayments()
	{
		return payments;
	}
}

