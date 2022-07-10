 package airportSys; // add to package

 import java.awt.*; // for Layout managers and Color
 import java.awt.event.*; // for ActionListener interface
 import javax.swing.*; // for Swing components
 import javax.swing.border.*; // for Swing borders
 import java.io.*; // for File input, output
 import java.util.*; // for Set class

/**
 * Class to provide GUI for Airport application
 * 
 * @author Charatan and Kans
 * @version 5th November 2008
 */
 public class AirportFrame extends JFrame implements ActionListener
 {
    //attributes
    
    private Airport myAirport; // the airport Object
    
    // graphical components
    private JMenuBar jmb= new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem jmiOpen = new JMenuItem("Open");
    private JMenuItem jmiSave = new JMenuItem("Save");
    private JMenuItem jmiExit = new JMenuItem("Exit");
    private JTabbedPane tabs = new JTabbedPane();
    private JPanel controlPanel = new JPanel();
    private JLabel jlblPicture = new JLabel();
    private JPanel buttonPanel = new JPanel();
    private JButton jbtnRegister = new JButton ("Register");
    private JButton jbtnArrive = new JButton ("Request to Land");
    private JButton jbtnLand = new JButton ("Land");
    private JButton jbtnBoard = new JButton ("Board");
    private JButton jbtnTakeOff = new JButton ("Take Off");
    private JPanel arrivalsPanel = new JPanel();
    private JPanel departuresPanel = new JPanel();
    private JTextArea jtaArrivals = new JTextArea(30,20);
    private JTextArea jtaDepartures = new JTextArea(30,10);
    private JScrollPane jspArrivals = new JScrollPane(jtaArrivals);
    private JScrollPane jspDepartures = new JScrollPane(jtaDepartures);
    private JFileChooser jfc = new JFileChooser();

   /**
    * Constructor initialises Arirport object and arranges the GUI components
    *
    * @param	numIn The number of runways
    */
    public AirportFrame(int numIn)
    {
        // instantiate Airport object
        try
        {
          myAirport = new Airport (numIn);
        }
        catch (AirportException ae)
        {
            ae.printStackTrace(); // display error to console
            JOptionPane.showMessageDialog(this,"AIRPORT SYSTEM VIOLATION", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // indicates exit with error
        }
        
        // arrange GUI components
        setJMenuBar(jmb);
        jmb.add(fileMenu);
        fileMenu.setMnemonic('F');
        fileMenu.add(jmiOpen);
        fileMenu.add(jmiSave);
        fileMenu.add(jmiExit);
        controlPanel.setLayout(new BorderLayout());
        jlblPicture.setIcon(new ImageIcon ("clouds.gif"));
        buttonPanel.setBorder(new TitledBorder("Enter an option"));
        buttonPanel.add(jbtnRegister);
        buttonPanel.add(jbtnArrive);
        buttonPanel.add(jbtnLand);
        buttonPanel.add(jbtnBoard);
        buttonPanel.add(jbtnTakeOff);
        controlPanel.add(jlblPicture, BorderLayout.WEST);
        controlPanel.add(buttonPanel, BorderLayout.SOUTH);
        jtaArrivals.setBackground(Color.white);
        jtaArrivals.setBorder(new TitledBorder("Arrivals"));
        jtaDepartures.setBackground(Color.white);
        jtaDepartures.setBorder(new TitledBorder("Departures"));
        jtaArrivals.setEditable(false);
        jtaDepartures.setEditable(false);
        tabs.addTab("Flight Control", controlPanel);
        tabs.add("Flight Arrivals", jspArrivals);
        tabs.add("Flight Departures", jspDepartures);
        getContentPane().add(tabs,BorderLayout.CENTER);
        jbtnRegister.setToolTipText("Register a plane with airport");
        jbtnArrive.setToolTipText("Record a flight arrival");
        jbtnLand.setToolTipText("Record a flight landing at airport");
        jbtnBoard.setToolTipText("Record a flight as ready for boarding");
        jbtnTakeOff.setToolTipText("Record a flight taking off from airport");
        listArrivals();
        listDepartures();
        jbtnRegister.addActionListener(this);
        jbtnArrive.addActionListener(this);
        jbtnLand.addActionListener(this);
        jbtnBoard.addActionListener(this);
        jbtnTakeOff.addActionListener(this);
        jmiOpen.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
        
        // set Frame attributes
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Airport System");
        setVisible(true);


     }

     
    /**
     * Process button presses
     */
     public void actionPerformed (ActionEvent e)
     {
         if (e.getSource()==jbtnRegister)
         {
             new RegisterDialog(this,"Registration form", myAirport);
         }
         if (e.getSource()==jbtnArrive)
         {
             new RequestToLandDialog(this,"Request To Land form",myAirport);
         }

         if (e.getSource()==jbtnLand)
         {
             new LandingDialog(this, "Landing form",myAirport);
         }
         if (e.getSource()==jbtnBoard)
         {
             new BoardingDialog(this,"Boarding form", myAirport);
         }
         if (e.getSource()==jbtnTakeOff)
         {
             new TakeOffDialog(this, "Take Off form",myAirport);
         }
         if (e.getSource()==jmiOpen)
         {
             if (jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
             {
                File fileName = jfc.getSelectedFile();
                String filePath = fileName.getAbsolutePath();
                open(filePath);
             }
         }
         if (e.getSource()==jmiSave)
         {
              if (jfc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
             {
                File fileName = jfc.getSelectedFile();
                String filePath = fileName.getAbsolutePath();
                save(filePath);
             }
         }
         if (e.getSource()==jmiExit)
         {
             int answer = JOptionPane.showConfirmDialog(this, "are you sure you want to quit", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if (answer == JOptionPane.YES_OPTION)
            {
              System.exit(0);
            }
         }

         listArrivals();
         listDepartures();
     }

  
  // helper methods
  
  private void listArrivals()
  {
     jtaArrivals.setText("");
     jtaArrivals.append ("\nFLIGHT \tFROM  \tSTATUS          \tRUNWAY");
     try
     {
      Set<Plane> arrivals = myAirport.getArrivals();
      for (Plane thisPlane: arrivals)
      {
        jtaArrivals.append ("\n"+thisPlane.getFlightNumber()+ "\t" +
                            thisPlane.getCity() + "\t" +
                            thisPlane.getStatus() + "\t");
        if (thisPlane.isAllocatedARunway())
        {
            jtaArrivals.append (""+thisPlane.getRunwayNumber());
        }
     }
    }
    catch (AirportException ae)
    {
       JOptionPane.showMessageDialog(this, ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void listDepartures()
  {
     jtaDepartures.setText("");
     jtaDepartures.append ("\nFLIGHT \tTO    \tRUNWAY");
     try
     {
      Set<Plane> arrivals = myAirport.getDepartures();
      for (Plane thisPlane: arrivals)
      {
        jtaDepartures.append ("\n"+thisPlane.getFlightNumber()+ "\t" +
                            thisPlane.getCity() + "\t" +
                            thisPlane.getRunwayNumber());
      }
    }
    catch (AirportException ae)
    {
       JOptionPane.showMessageDialog(this, ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void open(String fileName)
  {
     try
     {
       myAirport.load(fileName);
       JOptionPane.showMessageDialog(this, "planes loaded","Information", JOptionPane.INFORMATION_MESSAGE);
     }
     catch (Exception e)
     {
        JOptionPane.showMessageDialog
             (this, e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);

     }
  }

  private void save(String fileName)
  {
     try
     {
      myAirport.save(fileName);
      JOptionPane.showMessageDialog(this, "planes saved","Information", JOptionPane.INFORMATION_MESSAGE);
     }
     catch (Exception e)
     {
        JOptionPane.showMessageDialog
             (this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

     }
  }

}


