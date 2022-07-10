
import java.net.*;
import java.io.*;
import javax.swing.*;

public class AdditionServer extends JFrame
{

private JTextArea textWindow = new JTextArea();
private int port;

// the constructor
public AdditionServer(int portIn)
{

port = portIn;
setTitle("Addition Server");
add("Center",textWindow);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(400, 300);
setVisible(true);
startServer();
}

private void startServer()
{

// declare a "general" socket and a server socket
Socket connection;
ServerSocket listenSocket;

// declare low level and high level objects for input
InputStream inStream;
DataInputStream inDataStream;

// declare low level and high level objects for output
OutputStream outStream;
DataOutputStream outDataStream;

// declare other variables
String client;
int first, second, sum;
boolean connected;

while(true)
{

try
{

// create a server socket
listenSocket = new ServerSocket (port);
textWindow.append("Listening on port " + port + "\n");

// listen for a connection from the client
connection = listenSocket.accept();
connected = true;
textWindow.append("Connection established" + "\n");

// create an input stream from the client
inStream = connection.getInputStream();
inDataStream = new DataInputStream(inStream);

// create an output stream to the client
outStream = connection.getOutputStream ();
outDataStream = new DataOutputStream(outStream);

// wait for a string from the client
client = inDataStream.readUTF();
textWindow.append("Address of client: " + client + "\n");
while(connected)
{

// read an integer from the client
first = inDataStream.readInt();
textWindow.append("First number received: " + first + "\n");

// read an integer from the client
second = inDataStream.readInt();
textWindow.append("Second number received: " + second + "\n");

sum = first + second;
textWindow.append("Sum returned: " + sum + "\n");
// send the sum to the client
outDataStream.writeInt(sum);

}
}

catch (IOException e)
{
connected = false;
}
}

}
}

