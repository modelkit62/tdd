
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class HelloWorldWithExitCommand extends MIDlet implements CommandListener
{
    private Command exitCommand; // the exit command
    private Display display;     // the display for this MIDlet
    private TextBox box; // a TextBox to display the message

    public HelloWorldWithExitCommand()
    {
        display = Display.getDisplay(this);
        exitCommand = new Command("Exit", Command.EXIT, 0);
    }

    public void startApp()
    {
        box = new TextBox("Hello world with exit command", "Hello world", 256,0);
        box.addCommand(exitCommand);
        box.setCommandListener(this);

        display.setCurrent(box);
    }

    public void pauseApp()
    {
    }

    public void destroyApp(boolean unconditional)
    {
    }

    public void commandAction(Command c, Displayable s)
    {
        if (c == exitCommand)
        {
            destroyApp(false);
            notifyDestroyed();
        }
    }
}

