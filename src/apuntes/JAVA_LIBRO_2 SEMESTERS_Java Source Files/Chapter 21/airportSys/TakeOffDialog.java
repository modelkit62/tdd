package airportSys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TakeOffDialog extends AirportDialog
{

    public TakeOffDialog(JFrame frameIn, String titleIn,Airport airportIn )
    {
        super(frameIn, titleIn,airportIn);
        setLayout(new GridLayout(2,1));
        add(flightPanel);
        add(buttonPanel);
        pack();
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
       String flight = jtfFlight.getText();
        if (flight.equals(""))
        {
            JOptionPane.showMessageDialog(this, "make sure you enter a flight number", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
          try
          {
            Plane nextPlane = associatedAirport.takeOff(flight);
            JOptionPane.showMessageDialog(this, "flight "+flight+" removed from system","Information",JOptionPane.INFORMATION_MESSAGE);
            if (nextPlane != null)
            {
             JOptionPane.showMessageDialog(this, "flight "+nextPlane.getFlightNumber()+" can land on runway "+nextPlane.getRunwayNumber(),"Information",JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
          }
          catch (AirportException ae)
          {
            JOptionPane.showMessageDialog(this,ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
    }
}

