
/** Collection class to hold a list of tenants
?*  @author Charatan and Kans
?*  @version 6th September 2008
?*/
public class TenantList extends ObjectList
{
	/** Constructor initialises the empty list and sets the maximium
	?*  list size
	?*/
	public TenantList(int sizeIn)
	{
		super(sizeIn); // call ObjectList constructor
	}
	
	/** Reads the tenant at the given position in the list
	?*  @param positionIn The position of the tenant in the list
	?*  @return Returns the tenant at the given position in the list
	?*  	or null if no tenant at that posiiton
	?*/
	public Tenant getTenant(int positionIn)
	{
		if (positionIn<1 || positionIn>getTotal()) // check for valid position
		{
			return null; // no object found at given position
		}
		else
		{
			// call inherited method and type cast
			return (Tenant) getItem(positionIn);
		}
	}
	
	/** Searches for the tenant in the given room number
	?*  @param roomIn The room number to search for
	?*  @return Returns the tenant in the given room or null if no tenant in the given room
	?*/
	public Tenant search(int roomIn)
	{
		for(int i = 1;i <= getTotal();i++)
		{  // find tenant with given room number
			if(getTenant(i).getRoom() == roomIn)
			{
				return getTenant(i);
			}
		}
		return null; // no tenant found with given room number
	}
	
	/** Removes the tenant in the given room number
	?*  @param roomIn The room number to of the tenant to remove
	?*  @return Returns true if the tenant is removed successfully or false otherwise
	?*/
	public boolean removeTenant(int roomIn)
	{
		for(int i = 1;i <= getTotal();i++)
		{  
			// remove tenant with given room number
			if(getTenant(i).getRoom() == roomIn)
			{
				remove(i);
				return true;
			}
		}
		return false; // no tenant found with given room number
	}
}

