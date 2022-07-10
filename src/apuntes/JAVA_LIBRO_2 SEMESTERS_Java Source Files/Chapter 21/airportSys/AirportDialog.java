package airportSys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *  This is an abstract class for a general Airport dialog
 *
 *  @author Charatan and Kans
 *  @version 6th November 2008
 */
abstract class AirportDialog extends JDialog implements ActionListener
{
  protected JPanel flightPanel = new JPanel();
  protected JPanel buttonPanel = new JPanel();
  private JLabel jlbFlightNumber = new JLabel ("enter flight number ");
  protected JTextField jtfFlight = new JTextField(12);
  protected JButton jbtnOk = new JButton ("OK");
  private JButton jbtnCancel = new JButton ("Cancel");
  protected Airport associatedAirport;

  public AirportDialog(JFrame frameIn, String titleIn, Airport airportIn)
  {
       super(frameIn, true);
       associatedAirport = airportIn;
       setLocation(100,200);
       setTitle(titleIn);
       flightPanel.add(jlbFlightNumber);
       flightPanel.add(jtfFlight);
       flightPanel.setBorder(new TitledBorder("Flight"));
       buttonPanel.add(jbtnOk);
       buttonPanel.add(jbtnCancel);
       jbtnOk.addActionListener(this);
       jbtnCancel.addActionListener(new CancelButtonListener());
       buttonPanel.setBorder(new TitledBorder("Select"));
    }


  
  private class CancelButtonListener implements ActionListener
  {
        public void actionPerformed(ActionEvent event)
        {
           dispose();
        }
  }
}
