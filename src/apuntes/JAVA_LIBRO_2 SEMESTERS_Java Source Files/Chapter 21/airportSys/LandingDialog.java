package airportSys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class LandingDialog extends AirportDialog
{
    private JPanel runwayPanel = new JPanel();
    private JLabel jlbRunway = new JLabel("enter runway number");
    private JComboBox jcbRunway = new JComboBox();

    public LandingDialog(JFrame frameIn, String titleIn,Airport airportIn )
    {
       super(frameIn, titleIn, airportIn);
       for (int i = 1; i<= associatedAirport.getNumberOfRunways(); i++)
       {
          jcbRunway.addItem(i);
       }
       setLayout(new GridLayout(3,1));
       add(flightPanel);
       add(runwayPanel);
       add(buttonPanel);
       jcbRunway.setSelectedIndex(0);
       runwayPanel.add(jlbRunway);
       runwayPanel.add(jcbRunway);
       runwayPanel.setBorder(new TitledBorder("Runway"));
       pack();
       setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String flight = jtfFlight.getText();
        Integer runway = (Integer)jcbRunway.getSelectedItem();
        if (flight.equals("") )
        {
            JOptionPane.showMessageDialog(this, "make sure you enter a flight number", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
          try
          {
            int runwayNumber = runway.intValue();
            associatedAirport.landAtAirport(flight, runwayNumber);
            JOptionPane.showMessageDialog(this, "confirmed:\nflight "+flight+" landed on runway "+runwayNumber, "Information", JOptionPane.INFORMATION_MESSAGE);
            dispose();
          }
          catch (AirportException ae)
          {
            JOptionPane.showMessageDialog(this, ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          }
        }

    }
}
