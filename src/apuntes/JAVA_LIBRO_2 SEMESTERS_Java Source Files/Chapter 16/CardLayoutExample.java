
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutExample extends JFrame implements ActionListener
{     
	// create a CardLayout object
	private CardLayout cardLayout = new CardLayout();

	// create a panel to hold the cards
	private JPanel centrePanel = new JPanel();

	// create the buttons for selecting the next and previous cards
	private JButton nextButton = new JButton("Continue");
	private JButton previousButton = new JButton(" Go back ");

	// create the cards
	private JPanel firstCard = new JPanel();
	private JPanel secondCard = new JPanel();
	private JPanel thirdCard = new JPanel();

	// the constructor
	public CardLayoutExample()
	{
	// add labels and buttons to the cards
	firstCard.add(new JLabel("Choose your level"));
	firstCard.add(new JButton(" Novice "));
	firstCard.add(new JButton("Regular"));
	firstCard.add(new JButton(" Expert "));
	firstCard.add(new JButton("    Elite   "));
	secondCard.add(new JLabel("Select a character"));
	secondCard.add(new JButton("Zorrkk"));
	secondCard.add(new JButton("Kluggg"));
	secondCard.add(new JButton("Grrogg"));
	secondCard.add(new JButton("Skrank"));
	thirdCard.add(new JLabel("Select a location"));
	thirdCard.add(new JButton("Castle of Doom"));
	thirdCard.add(new JButton(" Forest of Fear "));

	previousButton.setBackground(Color.yellow);
	nextButton.setBackground(Color.yellow);

	// add the buttons and the centre panel to the frame
	add("West", previousButton);
	add("Center", centrePanel);
	add("East", nextButton);

	// set the layout of the centre panel to a CardLayout
	centrePanel.setLayout(cardLayout);

	// add the cards to the centre panel
	centrePanel.add(firstCard,"level");
	centrePanel.add(secondCard,"character");
	centrePanel.add(thirdCard,"location");

	// add Actionlisteners to the buttons
	nextButton.addActionListener(this);
	previousButton.addActionListener(this);

	// configure the frame
	setTitle("The Dungeons of Schpiltz");
	setSize(360,125);
	setLocation(300,300);
	setVisible(true);
	}

	// the event handler
	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource() == nextButton)
	{   
	cardLayout.next(centrePanel); // show the next card
	}
	else if(e.getSource() == previousButton)
	{
	cardLayout.previous(centrePanel); // show the previous card
	}
	}
}

