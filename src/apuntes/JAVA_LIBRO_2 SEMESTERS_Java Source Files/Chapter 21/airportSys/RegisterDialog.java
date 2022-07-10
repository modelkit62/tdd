package airportSys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class RegisterDialog extends AirportDialog
{
  private JPanel cityPanel = new JPanel();
  private JLabel jlbCity = new JLabel("enter city of origin ");
  private JTextField jtfCity = new JTextField(12);

  public RegisterDialog(JFrame frameIn, String titleIn,Airport airportIn)
  {
       super(frameIn, titleIn,airportIn);
       setLayout(new GridLayout(3,1));
       add(flightPanel);
       add(cityPanel);
       add(buttonPanel);
       cityPanel.add(jlbCity);
       cityPanel.add(jtfCity);
       cityPanel.setBorder(new TitledBorder("City"));
       pack();
       setVisible(true);
  }

    public void actionPerformed(ActionEvent e)
    {
        String flight = jtfFlight.getText();
        String city = jtfCity.getText();
        if (flight.equals("") ||city.equals("") )
        {
            JOptionPane.showMessageDialog(this, "make sure all fields are entered", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
          try
          {
            associatedAirport.registerFlight(flight, city);
            JOptionPane.showMessageDialog(this, "registration successful", "Information", JOptionPane.INFORMATION_MESSAGE);
            dispose();
          }
          catch (AirportException ae)
          {
            JOptionPane.showMessageDialog(this, ae.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
          }
        }

  }
}
