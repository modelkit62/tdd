
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.util.*;

public class BouncingRedBall extends MIDlet implements CommandListener
{
  // The main display elements
  private Display display;
  private BouncingRedBallCanvas canvas;
  private Command exitCommand;  // exit command

  private final long interval = 50; // the time interval

  public BouncingRedBall()
  {
    exitCommand = new Command("Exit", Command.EXIT, 1);
    display = Display.getDisplay(this);
  }


  public void startApp()
  {
    canvas = new BouncingRedBallCanvas();
    canvas.addCommand(exitCommand);
    canvas.setCommandListener(this) ;
    display.setCurrent(canvas);

    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new Bounce(), 0, interval);
  }

  public void pauseApp()
  {
  }

  public void destroyApp(boolean unconditional)
  {
  }

  public void commandAction(Command c, Displayable d)
  {
    if (c == exitCommand)
    {
      destroyApp(false);
      notifyDestroyed();
    }
  }

  // define a canvas as an inner class
  class BouncingRedBallCanvas extends Canvas
  {
    private Sprite ball;
    private int width;
    private int height;
    private boolean onTheWayUp = true;

    BouncingRedBallCanvas()
    {
      width = getWidth();
      height = getHeight();

      // load the image
      Image ballImage;
      try
      {
        ballImage = Image.createImage("/ball.png");
        ball = new Sprite(ballImage);
        ball.setX(width/2);
        ball.setY(height/2);
      }
      catch (Exception ioe)
      {
        System.err.println("Problem loading image " + ioe);
      }
    }

    public void paint(Graphics g)
    {
      g.setColor( 255, 255, 255 ); // set colour to white
      g.fillRect( 0, 0, width, height ); // paint a white background

      ball.paint(g); // paint the sprite
    }

    public void moveBall()
    {
        int newY, currentY;
        currentY = ball.getY();
        if (onTheWayUp)
        {
            newY = currentY - 12; // move the ball up by 12 pixels
            if(currentY < 12) // the ball has reached the top of the screen
            {
                onTheWayUp = false;
            }
        }
        else
        {
            newY = currentY + 12; // move the ball down by 12 pixels
            if(currentY > height - 36) // the ball has reached the bottom of the screen
            {
                onTheWayUp = true;
            }
        }
        ball.setY(newY);
        canvas.repaint(); // repaint the canvas
    }
  }

    // define a timer task as an inner class
    class Bounce extends TimerTask
    {
        public void run()
        {
            canvas.moveBall();  // call the moveBall method
        }
    }
}



class Sprite
{
  public Image image;
  public int x;
  public int y;
  public boolean visible;

  public Sprite(Image imageIn)
  {
    image = imageIn;
  }

  public void paint(Graphics g)
  {
    g.drawImage(image, x, y, Graphics.VCENTER | Graphics.HCENTER);
  }

  public Image getImage()
  {
    return image;
  }

  public int getX()
  {
    return x;
  }

  public void setX(int xIn)
  {
    x = xIn;
  }

  public int getY()
  {
    return y;
  }

  public void setY(int yIn)
  {
    y = yIn;
  }

  public boolean isVisible()
  {
    return visible;
  }

  public void setVisible(boolean visibleIn)
  {
    visible = visibleIn;
  }
}



