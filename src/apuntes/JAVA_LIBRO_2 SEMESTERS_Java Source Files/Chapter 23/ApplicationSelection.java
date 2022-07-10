
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class ApplicationSelection extends MIDlet implements CommandListener
{
  private Display display; // the display for this MIDlet
  private Command exitCommand; // exit command
  private Command backCommand; // back command
  private TextBox box; // the text box
  private Canvas canvas; // the canvas
  private List itemList; // the list of choices
  private String[] items = {"Hello World", "Smiley Face"}; // the items on the list

  public ApplicationSelection()
  {
    display = Display.getDisplay(this); // get an instance of the display object
    exitCommand = new Command("Exit", Command.EXIT, 0); // create the exit command
    backCommand = new Command("Back", Command.EXIT, 1); // create the back command
  }

  public void startApp()
  {
    box = new TextBox("Hello world", "Hello world", 256,0); // create the text box

    // add the commands to the text box and enable it to listen for commands
    box.addCommand(backCommand);
    box.addCommand(exitCommand);
    box.setCommandListener(this);

    canvas = new SmileyFaceCanvas(); // create the canvas

    // add the commands to the canvas and enable it to listen for commands
    canvas.addCommand(backCommand);
    canvas.addCommand(exitCommand);
    canvas.setCommandListener(this);

    itemList = new List("Select Item", List.IMPLICIT); // create the list of items
    for (int i = 0; i < items.length; i++) // add the items to the list
    {
        itemList.append(items[i], null);
    }

    itemList.addCommand(exitCommand); // add the exit command to the list
    itemList.setCommandListener(this); // enable the list to listen for commands

    display.setCurrent(itemList); // set the current display to the list
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

      if(c == backCommand)
      {
          display.setCurrent(itemList); // return to the list of items
      }

      if (d == itemList)
      {
          int index = itemList.getSelectedIndex(); // determine which item was selected
          if(index == 0) // the first item was selected
          {
              display.setCurrent(box); // set the current display to the text box
          }
          if(index == 1) // the second item was selected
          {
              display.setCurrent(canvas); // set the current display to the canvas
          }
      }
  }

  // define the SmileyFace canvas as an inner class
  class SmileyFaceCanvas extends Canvas
  {
    public void paint(Graphics g)
    {
      // get the width and height of the canvas
      int width = getWidth();
      int height = getHeight();

      // create an Image the same size as the canvas
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
      smileyFace.drawString("Smiley Face", width/2, 200, Graphics.TOP | Graphics.HCENTER); // the caption
      g.drawImage(image, 0, 0, Graphics.TOP | Graphics.LEFT); // draw the image
    }
  }
}

