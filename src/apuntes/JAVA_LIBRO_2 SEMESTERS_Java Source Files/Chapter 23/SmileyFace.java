
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class SmileyFace extends MIDlet implements CommandListener
{
    private Display display; // the display for this MIDlet
    private Command exitCommand;  // exit command
    private Canvas canvas;  // the canvas

    public SmileyFace()
    {
        display = Display.getDisplay(this); // get an instance of the display object
		 exitCommand = new Command("Exit", Command.EXIT, 0); // create the exit command
    }

    public void startApp()
    {
       canvas = new SmileyFaceCanvas(); // create the canvas
       canvas.addCommand(exitCommand); // add the exit command to the canvas
       canvas.setCommandListener(this); // enable the canvas to listen for commands
       display.setCurrent(canvas); // set the current display to the canvas
    }

    public void pauseApp()
    {
    }

    public void destroyApp(boolean unconditional)
    {
    }

    public void commandAction(Command c, Displayable d)
    {
        if (c == exitCommand) // destroy the MIDlet
        {
            destroyApp(false);
            notifyDestroyed();
        }
    }

   // define the canvas as an inner class
   class SmileyFaceCanvas extends Canvas
   {
      public void paint(Graphics g)
      {
		 // get the width and height of the canvas
        int width = getWidth();
        int height = getHeight();

        // create an Image the same size as the Canvas.
        Image image = Image.createImage(width, height);

		 // get a graphics object that will render to this image
        Graphics smileyFace = image.getGraphics();

        // define a font
        Font font = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);

        smileyFace.setFont(font); // set the font
		 smileyFace.setColor(255,255,0); // set the colour to yellow
        smileyFace.fillRect(0, 0, width, height); // fill the canvas with the chosen colour
		 smileyFace.setColor(255, 0, 0); // set colour to red
        smileyFace.drawArc(width/2 - 40, height/2 - 40, 80, 80, 0, 360); // the face
        smileyFace.setColor(0, 0, 255); // set colour to blue
        smileyFace.drawArc(width/2 - 25, height/2 - 20, 10, 10, 0, 360); // the right eye
        smileyFace.drawArc(width/2 + 15, height/2 - 20, 10, 10, 0, 360); // the left eye
        smileyFace.drawArc(width/2 - 20, height/2, 40, 25, 0, -180); // the mouth

		 // draw the caption
        smileyFace.drawString("Smiley Face", width/2, 200, Graphics.TOP | Graphics.HCENTER);

        // draw the image
        g.drawImage(image, 0, 0, Graphics.TOP | Graphics.LEFT);
      }
   }
}

