package airportSys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ArrivalDialog extends AirportDialog
{

    public ArrivalDialog(JFrame frameIn, String titleIn, Airport airportIn )
    {
        super(frameIn, titleIn, airportIn);
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
            int runway = associatedAirport.arriveAtAirport(flight);
            String message;
            String title = "Information";
            if (runway == 0)
            {
                message = "no runway available, circle the airport";
            }
            else
            {
               message = "land on runway "+runway;
            }
            JOptionPane.showMessageDialog(this, message, title,JOptionPane.INFORMATION_MESSAGE);
            dispose();
          }
          catch (AirportException ae)
          {
            JOptionPane.showMessageDialog(this,ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          }
        }

    }
}

