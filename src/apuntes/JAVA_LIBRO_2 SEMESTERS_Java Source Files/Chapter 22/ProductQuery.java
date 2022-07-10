
import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class ProductQuery extends JFrame
{

// the attributes
public static final String DRIVER = "org.gjt.mm.mysql.Driver";
public static final String URL = "jdbc:mysql://localhost/ElectricalStore";
public static final String USERNAME = "U1098765";
public static final String PASSWORD = "scott";

private Connection con;
private Statement st;
private ResultSet result;
private JTextArea display = new JTextArea(25,25);

// the constructor
public ProductQuery()
{

// configure the frame and text area
setTitle("Product query");
add("Center",display);
setSize(520,250);
setVisible(true);
display.setTabSize(16);
display.setFont(new Font("DialogInput", Font.BOLD, 14));

try
{

// load the MySQL jdbc driver
Class.forName(DRIVER);

}
catch(ClassNotFoundException e)
{
display.setText("Driver not found");
}

try
{
// connect to the database
con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

// create an SQL statement
st = con.createStatement();

// execute an SQL query
result = st.executeQuery("select * from products");

// create a heading
display.setText("Serial#" + "\t" + "Make" + "\t" +
"Description" + "\t" + "Price" + "\n");
display.append("----" + "\t" + "--" + "\t" +
"------" + "\t" + "---" + "\n");

// display results
while(result.next()) // move to next record
{

// retrieve and display first field
display.append(result.getString(1) + "\t");
// retrieve and display second field
display.append(result.getString(2) + "\t");
// retrieve and display third field
display.append(result.getString(3)+ "\t");
// retrieve and display fourth field
display.append("£" + result.getString(4)+ "\n");

}
}

catch(SQLException e) // handle the SQLException
{
		e.printStackTrace();
}
}
}

