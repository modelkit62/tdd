
/** This is a generic container class to store a list of objects
?*  @author Charatan and Kans
?*  @version 2nd September 2008
?*/
public class ObjectList
{
	private Object[] list ;
	private int total ;
	
	/** Constructor intitialises an empty list
	?*  @param sizeIn Used to set the maximum size of the list
	?*/
	public ObjectList(int sizeIn)
	{
		list = new Object[sizeIn];
		total = 0;
	}
	
	/** Adds an object to the end of the list
	?*  @param objectIn The object to add
	?*  @return Returns true if the object was added successfully and false otherwise
	?*/
	public boolean add(Object objectIn)
	{
		if(!isFull())
		{
			list [total] = objectIn;
			total++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/** Reports on whether or not the list is empty
	?*  @return Returns true if the list is empty and false otherwise
	?*/
	public boolean isEmpty()
	{
		if(total==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/** Reports on whether or not the list is full
	?*  @return Returns true if the list is full and false otherwise
	?*/
	
	public boolean isFull()
	{
		if(total== list.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/** Reads an object from a specified position in the list
	?*  @param positionIn The position of the object in the list
	?*  @return Returns the object at the specified position in the list
	?*  	or null if no object is at that position
	?*/
	public Object getItem(int positionIn)
	{
		if (positionIn <1 || positionIn > total)
		{
			return null;
		}
		else
		{
			return list [positionIn -1];
		}
	}
	
	/** Reads the number of objects stored in the list */
	public int getTotal()
	{
		return total;
	}
	
	/** Removes an object from the specified position in the list
	?*  @param numberIn The position of the object to be removed
	?*  @return Returns true if the item is removed successfully	and false otherwise
	?*/
	public boolean remove(int numberIn)
	{
		if(numberIn >= 1 && numberIn <= total)
		{
			for(int i = numberIn-1; i <= total-2; i++)
			{
				list[i] = list[i+1];
			}
			total--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/** Returns a string representation of the list */
	public String toString()
	{
		String items = ""; // initialize empty string
		for(int i =0; i < total; i++)
		{
			items = items + list[i].toString() + "  "; // call toString of contained items
		}
		return "[  " + items +"]"; // surround list in square brackets
	}
}

