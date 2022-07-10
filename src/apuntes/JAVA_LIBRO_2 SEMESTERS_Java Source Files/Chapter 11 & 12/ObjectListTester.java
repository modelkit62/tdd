
public class ObjectListTester
{
  public static void main(String[] args)
  {
	char choice;
	int size;
	ObjectList list; // declare ObjectList object to test
	
	// get size of list
	System.out.print("Size of list? ");
	size = EasyScanner.nextInt();
	list = new ObjectList(size); // create object to test
	// menu
	do
	{
		// display options
		System.out.println();
		System.out.println("[1] ADD");
		System.out.println("[2] REMOVE");
		System.out.println("[3] IS EMPTY");
		System.out.println("[4] IS FULL");
		System.out.println("[5] DISPLAY");
		System.out.println("[6] Quit");
		System.out.println();
		System.out.print("Enter a choice [1-6]: ");
		// get choice
		choice = EasyScanner.nextChar();
		System.out.println();
		// process choice
		switch(choice)
		{
			case '1': option1(list); break;
			case '2': option2(list); break;
			case '3': option3(list); break;
			case '4': option4(list); break;
			case '5': option5(list); break;
			case '6': System.out.println("TESTING COMPLETE"); break;
			default: System.out.print("1-6 only");
		}
	} while (choice != '6');
  }
  
  // ADD
  static void option1(ObjectList listIn)
  {  
  		System.out.print("Enter String: ");
		String str = EasyScanner.nextString();
		listIn.add(str);
  }

  // REMOVE
  static void option2(ObjectList listIn)
  {  
  		System.out.print("Enter position to remove: ");
		int pos = EasyScanner.nextInt();
		listIn.remove(pos);
  }

  // IS EMPTY
  static void option3(ObjectList listIn)
  {  
  		if (listIn.isEmpty())
  		{
  			System.out.println("list is empty");
  		}
  		else
  		{
  			System.out.println("list is NOT empty");
  		}
  }

  // IS FULL
  static void option4(ObjectList listIn)
  {  
  		if (listIn.isFull())
  		{
  			System.out.println("list is full");
  		}
  		else
  		{
  			System.out.println("list is NOT full");
  		}
  }

  // DISPLAY
  static void option5(ObjectList listIn)
  {  
  		System.out.println(listIn); // calls toString method of ObjectList
  }

}

