package airportSys;

/**
 * Application Specific Exception
 * 
 * @author Charatan and Kans 
 * @version 1st November 2008
 */
public class AirportException extends Exception
{
  /**
   * Default Constructor
   */
  public AirportException ()
  {
    super("Error: Airport System Violation");
  }

  /**
   * Constructor that accepst an error message
   */
  public AirportException (String msg)
  {
    super(msg);
  }
}
