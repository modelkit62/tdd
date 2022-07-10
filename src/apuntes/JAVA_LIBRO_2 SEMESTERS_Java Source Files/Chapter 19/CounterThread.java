
import javax.swing.*;

public class CounterThread extends Thread
{
	private JTextField counterWindow;  /* this is the window where the
	numbers are displayed */
	private boolean go = true; // this variable controls the loop

	/* the text window where the numbers are displayed is sent in as a
	parameter to the constructor */
	public CounterThread(JTextField windowIn)
	{
	counterWindow = windowIn;
	}



	public void run()
	{
	int count = 1;
	while(go)
	{
	counterWindow.setText("" + count);
	/* Some additional code is going to go here later to
	improve our program */

/*	try
	{
	sleep(500); //force the thread to sleep for 1 msec
	}
	catch(InterruptedException e)
	{
	} */




	count++;
	if(count > 10) // reset the counter if it has gone over 10
	{
	count=1;
	}
	}
   }

	// this method will stop the numbers being displayed
	public void finish()
	{
	go = false;
	}
}

