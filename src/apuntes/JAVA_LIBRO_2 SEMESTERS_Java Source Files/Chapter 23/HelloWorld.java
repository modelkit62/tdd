
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class HelloWorld extends MIDlet
{
    private Display display;     // the display for this MIDlet
    private TextBox box;         // a TextBox to display the message

    public HelloWorld()
    {
        display = Display.getDisplay(this);
    }

    public void startApp()
    {
        box = new TextBox("First Micro Program", "Hello world", 256, 0);
        display.setCurrent(box);
    }

    public void pauseApp()
    {
    }

    public void destroyApp(boolean unconditional)
    {
    }
}
