
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;


/**GUI for the Hostel application
  *@author Charatan and Kans
  *@version 7th September 2008
  */
public class Hostel extends JFrame implements ActionListener
{
    // the attributes
    private  int noOfRooms;
    private  TenantList list;
    private  JButton addButton  = new JButton("Add Tenant");
    private  JButton displayButton =  new JButton("Display Tenants");
    private  JButton removeButton  = new JButton("Remove Tenant");
    private  JTextField roomField =  new JTextField(4);
    private  JTextField nameField =  new JTextField(39);
    private  JButton saveAndQuitButton  = new JButton("Save and Quit");
    private  JButton quitButton   =new JButton("Quit without Saving");
    private  JTextArea displayArea1  = new JTextArea(8,45);
    private  JTextArea displayArea2 =  new JTextArea(8,45);
    private  JTextField roomField2  = new JTextField(4);
    private  JTextField monthField  = new JTextField(7);
    private  JTextField amountField =  new JTextField(8);
    private JButton paymentButton  = new JButton("   Make Payment      ");
    private  JButton listButton  = new JButton("   List Payments     ");

    //the constructor
    public Hostel (int numberIn)
    {
		// initialse the number of rooms and the TenantList
		noOfRooms =  numberIn;
		list  = new TenantList(noOfRooms);    

		// set layout policy to FlowLayout
		setLayout(new FlowLayout());
		// allow program to end when cross-hairs are clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set appearance of JFrame
		setTitle("Hostel");
		setSize(550, 450);
		setLocation(400,100);
		getContentPane().setBackground(Color.cyan);
		// create a border style to be used for the JButtons 
		BevelBorder raisedBevel =  new BevelBorder(BevelBorder.RAISED);
		// add components
		add(roomField);
		/* The setBorder method is used to give a a component a titledborder. 
			This version of the method accepts an appropriate TitleBoarder object */
		roomField.setBorder(new TitledBorder("Room"));
		// repeat this process for the nameField
		add(nameField);
		nameField. setBorder(new TitledBorder("Name"));
		//  JButtons are added, their background colours and borders set
		add(addButton);
		addButton.setBackground(Color.green);
		addButton.setBorder(raisedBevel);
		add(displayButton);
		displayButton.setBorder(raisedBevel);
		displayButton.setBackground(Color.green);
		add(removeButton);
		removeButton.setBackground(Color.green);
		removeButton.setBorder(raisedBevel);
		add(saveAndQuitButton);
		saveAndQuitButton.setBackground(Color.green);
		saveAndQuitButton.setBorder(raisedBevel);
		add(quitButton);
		quitButton.setBackground(Color.green);
		quitButton.setBorder(raisedBevel);
		/* By default the title of a component will be left justified.
			To choose another justification (in this case to centre the 	title) another version of the
        	constructor is required. 
			This takes a border style (we chose black line), 
			the title (we chose "Tenants"), 
			the justification (we chose Centre) 
			and the title position (we chose Top) */

    		 displayArea1.setBorder	(new TitledBorder(new LineBorder(Color.black),
	                  "Tenants",TitledBorder.CENTER,TitledBorder.TOP));

		// A JScrollPane created for displayArea1 (see discussion below)
		JScrollPane p1 =  new JScrollPane(displayArea1);
		add(p1);
	
       // the remaining components are added in a similar way
		add(roomField2);
		roomField2.setBorder(new TitledBorder("Room"));
		add(monthField);
		monthField.setBorder(new TitledBorder("Month"));
		add(amountField);
		amountField. setBorder(new TitledBorder("Amount"));
		add(paymentButton);
		paymentButton.setBackground(Color.green);
		paymentButton.setBorder(raisedBevel);
		add(listButton);
		listButton.setBorder(raisedBevel);
		listButton.setBackground(Color.green);
		displayArea2.setBorder	(new TitledBorder(new LineBorder(Color.black),
										"Payments",TitledBorder.CENTER,TitledBorder.TOP));       
		// see discussion below about ScrollPanes
		JScrollPane p2 = new JScrollPane(displayArea2);
		add(p2);
		// listeners given to buttons
		addButton.addActionListener(this);
		displayButton.addActionListener(this);
		paymentButton.addActionListener(this);
		listButton.addActionListener(this);
		removeButton.addActionListener(this);
		listButton.addActionListener(this);
		saveAndQuitButton.addActionListener(this);
		quitButton.addActionListener(this);
		// read records from file into the list
		TenantFileHandler.readRecords(list);
		// make GUI visible
		setVisible(true);
	} 

	// the event handlers
	public void actionPerformed(ActionEvent e)
	{
	  if(e.getSource() == addButton)
	  {
		String roomEntered =  roomField.getText();
		String nameEntered =  nameField.getText();
		// check for errors
		if(roomEntered.length()== 0 || nameEntered.length()== 0) 
		{
			displayArea1.setText ("Room number and name must be entered");
		} 
		else if(Integer.parseInt(roomEntered)< 1 || Integer.parseInt(roomEntered)>noOfRooms)
		{
			displayArea1.setText ("There are only "  + noOfRooms  + " rooms");
		} 
		else if(list.search(Integer.parseInt(roomEntered)) !=  null)
		{
			displayArea1.setText("Room number " +  Integer.parseInt(roomEntered)  + " is occupied");
		}
		else  // ok to add a Tenant
		{
			Tenant t =  new Tenant(nameEntered,Integer.parseInt(roomEntered));
		  	list.add(t);
	    	roomField.setText("");
	    	nameField.setText("");
	    	displayArea1.setText("New tenant in room " 	+  roomEntered +  " successfully added");
    	} 
	} 

	if(e.getSource() == displayButton)
	{
    	int i;
    	if(list.isEmpty()) // no rooms to display
    	{
			displayArea1.setText("All rooms are empty");
    	} 
    	else // display rooms
    	{
			displayArea1.setText("Room" +  "\t" +  "Name" +  "\n");
			for(i = 1; i <=  list.getTotal(); i++ )
			{
				displayArea1.append(list.getTenant(i).getRoom() 
	  			+ "\t" 
	  			+ list.getTenant(i).getName() + "\n");
			} 
    	} 
	} 

	if(e.getSource()== removeButton)
	{
    	String roomEntered =  roomField.getText();
		// check for errors
    	if(roomEntered.length()== 0)
    	{
			displayArea1.setText("Room number must be entered");
    	} 
    	else if(Integer.parseInt(roomEntered) < 1 || Integer.parseInt(roomEntered)>noOfRooms)
    	{
			displayArea1.setText("Invalid room number");
    	} 
    	else if(list.search(Integer.parseInt(roomEntered))== null)
    	{
			displayArea1.setText("Room number " +  roomEntered +  " is empty");
    	} 
    	else // ok to remove Tenant
    	{
			list.removeTenant(Integer.parseInt(roomEntered));
			displayArea1.setText("Tenant removed from room " +  Integer.parseInt(roomEntered));
    	} 
	} 

	if(e.getSource() == paymentButton)
	{
    	String roomEntered = roomField2.getText();
    	String monthEntered = monthField.getText();
    	String amountEntered = amountField.getText();
		// check for errors
    	if(roomEntered.length()== 0 || monthEntered.length()== 0 || amountEntered.length()== 0)
    	{
			displayArea2.setText("Room number, month and amount must all be entered");
    	} 
    	else if(Integer.parseInt(roomEntered) < 1 || Integer.parseInt(roomEntered)>noOfRooms)
    	{
			displayArea2.setText("Invalid room number");
    	} 
    	else if(list.search(Integer.parseInt(roomEntered)) == null)
    	{
			displayArea2.setText("Room number " +  roomEntered +  " is empty");
    	} 
    	else // ok to process payment
    	{
			Payment p =  new Payment(monthEntered,Double.valueOf(amountEntered).doubleValue());
			list.search(Integer.parseInt(roomEntered)).makePayment(p);
			displayArea2.setText("Payment recorded");
    	} 
	} 

	if(e.getSource() == listButton)
	{
    	int i;
    	String roomEntered =  roomField2.getText();
		// check for errors
    	if(roomEntered.length()== 0)
    	{
			displayArea2.setText("Room number must be entered");
    	} 
    	else if(Integer.parseInt(roomEntered) < 1 || Integer.parseInt(roomEntered) > noOfRooms)
    	{
			displayArea2.setText("Invalid room number");
    	} 
    	else if(list.search(Integer.parseInt(roomEntered)) == null)
    	{
			displayArea2.setText("Room number " + Integer.parseInt(roomEntered) + " is empty");
    	} 
    	else // ok to list payments
    	{
			Tenant t =  list.search(Integer.parseInt(roomEntered));
			PaymentList p  = t.getPayments();
			if(t.getPayments().getTotal() == 0)
			{
				displayArea2.setText("No payments made for this tenant");
			} 
			else
			{  
				/* 	The NumberFormat class is similar to the DecimalFormat class that we used previously.
					The	getCurrencyInstance method of this class reads the	system values to find out 							which country we are in, then uses the correct currency symbol */
				NumberFormat nf =  NumberFormat.getCurrencyInstance();
				String s;
				displayArea2.setText("Month" +  "\t\t" +  "Amount" +  "\n");
				for(i =  1; i <=  p.getTotal(); i++  )
				{
					s =  nf.format(p.getPayment(i).getAmount());
					displayArea2.append("" + p.getPayment(i).getMonth() +  "\t\t" + s + "\n");
				} 
				displayArea2.append("\n" + "Total paid so far :   " + nf.format(p.calculateTotalPaid()));
				monthField.setText("");
				amountField.setText("");
			} 
		} 
	} 
	
	if(e.getSource()== saveAndQuitButton)
	{
		TenantFileHandler.saveRecords(noOfRooms,list);
		System.exit(0);
	} 
	if(e.getSource()== quitButton)
	{
		System.exit(0);
	} 
  } 
} 

