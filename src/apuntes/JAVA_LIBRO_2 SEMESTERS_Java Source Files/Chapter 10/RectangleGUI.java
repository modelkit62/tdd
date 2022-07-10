import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectangleGUI extends JFrame implements ActionListener
{
// declare a new rectangle with a length and height of zero
private Rectangle myRectangle = new Rectangle(0,0);

// now declare the graphics components
private JLabel lengthLabel = new JLabel("Length");
private JTextField lengthField = new JTextField(5);
private JLabel heightLabel = new JLabel("Height");
private JTextField heightField = new JTextField(5);
private JButton calcButton = new JButton("Calculate");
private JTextArea displayArea = new JTextArea(2,20);

public RectangleGUI()
{
setTitle("Rectangle GUI");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout());
setSize(240, 135);
setLocation(300,300);

// add the graphics components
add(lengthLabel);
add(lengthField);
add(heightLabel);
add(heightField);
add(calcButton);
add(displayArea);

// now add the ActionListener to the calcButton
calcButton.addActionListener(this);

setVisible(true);
}

// finally write the code for handling a mouse-click on the calcButton 
public void actionPerformed(ActionEvent e)
{
String lengthEntered = lengthField.getText();
String heightEntered = heightField.getText();
// make sure the fields aren't blank
if(lengthEntered.length() == 0 || heightEntered.length() == 0)
{
displayArea.setText("Length and height must be entered");
}
else
{
// we have to convert the input strings to doubles (see below)
myRectangle.setLength(Double.parseDouble(lengthEntered));
myRectangle.setHeight(Double.parseDouble(heightEntered));

// display area and perimeter of rectangle
displayArea.setText("The area of the rectangle is "
+ myRectangle.calculateArea()
+ "\n"
+ "The perimeter of the rectangle is "
+ myRectangle.calculatePerimeter());
}
}
}

