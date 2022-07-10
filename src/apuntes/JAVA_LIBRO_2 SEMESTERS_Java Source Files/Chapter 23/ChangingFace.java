
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class ChangingFace extends MIDlet implements CommandListener
{
  private Display display; // the display for this MIDlet

  private Command exitCommand; // exit command
  private Command frownCommand; // frown command
  private Command smileCommand; // smile command
  private Canvas canvas; // the canvas
  private boolean isHappy = true; // boolean attribute to determine the mood of the face

  public ChangingFace()
  {
    display = Display.getDisplay(this); // get an instance of the display object
    exitCommand = new Command("Exit", Command.EXIT, 0); // create the exit command
    frownCommand = new Command("Frown", Command.SCREEN,1); // create the frown command
    smileCommand= new Command("Smile", Command.SCREEN,1);  // create the smile command
  }

  public void startApp()
  {
    canvas = new ChangingFaceCanvas(); // create the canvas
    canvas.addCommand(exitCommand); // add the exit command to the canvas
    canvas.addCommand(frownCommand); //add frown command to the canvas (but not the smile command yet)
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
        if(c == exitCommand) // destroy the MIDlet
        {
            destroyApp(false);
            notifyDestroyed();
        }

        if(c == frownCommand)
        {
               d.removeCommand(frownCommand); // remove the frown comand
               d.addCommand(smileCommand); // add the smile comand
               isHappy = false; // set attribute to false so the face frowns when canvas is repainted
               canvas.repaint(); // repaint the canvas
        }

        if(c == smileCommand)
        {
                d.removeCommand(smileCommand); // remove the smile comand
                d.addCommand(frownCommand); // add the frown comand
                isHappy = true; // set attribute to true so the face smiles when canvas is repainted
                canvas.repaint(); // repaint the canvas
        }
 }

 // define an inner class
 class ChangingFaceCanvas extends Canvas
 {
      public void paint(Graphics g)
      {
		 // get the width and height of the canvas
        int width = getWidth();
        int height = getHeight();

        // create an Image the same size as the Canvas.
        Image image = Image.createImage(width, height);

		 // get a graphics object that will render to this image
        Graphics changingFace = image.getGraphics();

        // define a font
        Font font = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);

        changingFace.setFont(font); // set the font
		 changingFace.setColor(255,255,0); // set the colour to yellow
        changingFace.fillRect(0, 0, width, height); // fill the canvas with the chosen colour
		 changingFace.setColor(255, 0, 0); // set colour to red
        changingFace.drawArc(width/2 - 40, height/2 - 40, 80, 80, 0, 360); // the face
        changingFace.setColor(0, 0, 255); // set colour to blue
        changingFace.drawArc(width/2 - 25, height/2 - 20, 10, 10, 0, 360); // the right eye
        changingFace.drawArc(width/2 + 15, height/2 - 20, 10, 10, 0, 360); // the left eye
        if(isHappy)
        {
            changingFace.drawArc(width/2- 20 ,height/2,40,25,0,-180); // smiling mouth
        }
        else
        {
            changingFace.drawArc(width/2- 20 ,height/2,40,25,0,180); // frowning mouth
        }

		 // draw the caption
        changingFace.drawString("Changing Face", width/2, 200, Graphics.TOP | Graphics.HCENTER);

        // draw the image
        g.drawImage(image, 0, 0, Graphics.TOP | Graphics.LEFT);
      }
  }
}
