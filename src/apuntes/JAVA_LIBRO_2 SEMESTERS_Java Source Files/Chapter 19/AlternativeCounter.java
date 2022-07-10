
import javax.swing.*;

public class AlternativeCounter implements Runnable
{
	private JTextField counterWindow;
	private boolean go = true;

	// a thread object is now created as an attribute of the class
	private Thread cThread = new Thread(this);

	public AlternativeCounter(JTextField windowIn)
	{
	counterWindow = windowIn;
	}

	public void run()
	{
	int count = 1;
	while(go)
	{
	counterWindow.setText("" + count);
	count++;
	try
	{
	// the sleep method of the thread object is called
	cThread.sleep(1);
	}
	catch(InterruptedException e)
	{
	}
	if(count > 10)
	{
	count = 1;
	}
	}
   }

   // a separate method is now required to start the thread
   public void begin()
   {
	cThread.start();
   }

   public void finish()
   {
	go = false;
   }
}

