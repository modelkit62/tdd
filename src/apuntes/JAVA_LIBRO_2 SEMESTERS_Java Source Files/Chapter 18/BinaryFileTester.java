import java.util.*; // required for List and ArrayList
import java.io.*; // required for handling the IOExceptions

public class BinaryFileTester
{
	public static void main(String[] args)
	{
		char choice;
		// create an empty list to hold Cars
		List<Car> carList = new ArrayList<Car>();
		// read the list from file when the program starts
		readList(carList);
		// menu options
		do
		{
			System.out.println("\nBinary File Tester");
			System.out.println("1. Add a car");
			System.out.println("2. Remove a car");
			System.out.println("3. List all cars");
			System.out.println("4. Quit\n");
			choice = EasyScanner.nextChar();
			System.out.println(); switch(choice)
			{
				case '1' : addCar(carList);
				break;
				case '2' : removeCar(carList);
				break;
				case '3' : listAll(carList);
				break;
				case '4' : writeList(carList); // write to the file
				break;
				default : System.out.print
				("\nPlease choose a number from 1 - 4 only\n ");
			}
		}while(choice != '4');
	}
	
	// method for adding a new car to the list
	static void addCar(List<Car> carListIn)
	{
		String tempReg;
		String tempMake;
		double tempPrice;
		
		System.out.print("Please enter the registration number: ");
		tempReg = EasyScanner.nextString();
		System.out.print("Please enter the make: ");
		tempMake = EasyScanner.nextString();
		System.out.print("Please enter the price: ");
		tempPrice = EasyScanner.nextDouble();
		carListIn.add(new Car(tempReg, tempMake, tempPrice));
	}
	
	/* method for removing a car from the list - in a real application this would need to include some validation */
	static void removeCar(List<Car> carListIn)
	{
	int pos;
		System.out.print("Enter the position of the car to be removed: ");
		pos = EasyScanner.nextInt();
		carListIn.remove(pos - 1);
	}
	
	// method for listing details of all cars in the list
	static void listAll(List<Car> carListIn)
	{
		for(Car item : carListIn)
		{
			System.out.println(item.getRegistration()
			+ " "
			+ item.getMake()
			+ " "
			+ item.getPrice());
		}
	}
	
	//method for writing the file
	static void writeList(List<Car> carListIn)
	{
		Car tempCar;
		try
		{
			FileOutputStream carFile = new FileOutputStream("Cars.bin");
			DataOutputStream carWriter = new DataOutputStream(carFile);
			for(Car item : carListIn)
			{
				carWriter.writeUTF(item.getRegistration());
				carWriter.writeUTF(item.getMake());
				carWriter.writeDouble(item.getPrice());
			}
			carWriter.close();
		}
		catch(IOException e)
		{
			System.out.println("There was a problem writing the file");
		}
	}

	//method for reading the file
	static void readList(List<Car> carListIn)
	{
		String tempReg;
		String tempMake;
		double tempPrice;
		boolean endOfFile = false;
		try
		{
			FileInputStream carFile = new FileInputStream("Cars.bin");
			DataInputStream carStream = new DataInputStream(carFile);
			while(endOfFile == false)
			{
				try
				{
					tempReg = carStream.readUTF();
					tempMake = carStream.readUTF();
					tempPrice = carStream.readDouble();
					carListIn.add(new Car(tempReg, tempMake, tempPrice));
				}
				catch(EOFException e)
				{
					endOfFile = true;
				}
			}
			carStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("\nThere are currently no records");
		}
	
		catch(IOException e)
		{
			System.out.println("There was a problem reading the file");
		}
	}

	
}

