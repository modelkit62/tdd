
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class RedBall extends MIDlet implements CommandListener
{
  private Display display; // the display for this MIDlet
  private RedBallCanvas canvas; // the canvas
  private Command exitCommand; // exit command

  public RedBall()
  {
    display = Display.getDisplay(this); // get an instance of the display object
    exitCommand = new Command("Exit", Command.EXIT, 1); // create the exit command
  }

  public void startApp()
  {
    canvas = new RedBallCanvas(); // create the canvas
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
  class RedBallCanvas extends Canvas
  {
    private Sprite ball; // declare a Sprite object
    private int width; // to hold the width of the canvas
    private int height; // to hold the height of the canvas

    RedBallCanvas()
    {
      width = getWidth(); // get the width of the canvas
      height = getHeight(); // get the height of the canvas

      // load the image
      Image ballImage;
      try
      {
        ballImage = Image.createImage("/ball.png"); // create an image
        ball = new Sprite(ballImage); // create a new sprite with this image

        // set the initial position of the sprite to the centre of the screen
        ball.setX(width/2);
        ball.setY(height/2);
      }
      catch (Exception e)
      {
        System.err.println("Problem loading image " + e);
      }
    }

    public void paint(Graphics g)
    {
      g.setColor( 255, 255, 255 ); // set colour to white
      g.fillRect( 0, 0, width, height ); // paint a white background

      ball.paint(g); // paint the sprite
    }

    public void keyPressed(int keyCode)
    {
      int key = getGameAction(keyCode);

      if(key == LEFT) // move the sprite left
      {
        int newX = ball.getX()-12;
        if (newX < 12)
		 {
            newX = 12;
        }
        ball.setX(newX);
      }
      else if(key == RIGHT) // move the sprite right
      {
        int newX = ball.getX()+12;
        if (newX > width-12)
        {
            newX = width-12;
        }
        ball.setX(newX);
      }
      else if(key == UP) // move the sprite up
      {
        int newY = ball.getY()-12;
        if (newY < 12)
        {
            newY = 12;
        }
        ball.setY(newY);
      }
      else if(key == DOWN) // move the sprite down
      {
        int newY = ball.getY()+12;
        if (newY > height-36)
        {
            newY = height-36;
        }
        ball.setY(newY);
      }
      repaint(); // repaint the canvas
    }
  }
}



class Sprite
{
  public Image image;
  public int x;
  public int y;

  public Sprite(Image imageIn) // the constructor
  {
    image = imageIn;
  }

  public void paint(Graphics g)
  {
    // draw the image at position (x, y) using the centre of the image as the anchor point
    g.drawImage(image, x, y, Graphics.VCENTER | Graphics.HCENTER);
  }

  public Image getImage()  // get the current image
  {
    return image;
  }

  public int getX() // get the current x-coordiante
  {
    return x;
  }

  public void setX(int xIn) // set the x-coordiante
  {
    x = xIn;
  }

  public int getY() // get the current y-coordiante
  {
    return y;
  }

  public void setY(int yIn) // set the y-coordiante
  {
    y = yIn;
  }
}


