/*Instructions.java
 * Julia Zhao, Tiantian Li, Marina Zheng
 * Finished December 16 2016
 * Display the instructions for MMM game
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JLayeredPane;

public class Instructions extends JFrame implements ActionListener
{ 
  static int endMusic = 1, screen = 2;
  //Create GUI components
  JLayeredPane layeredPane = getLayeredPane(); //create a layered pane to put contents
  
  JButton marchButton = new JButton("MARCH");  
  ImageIcon icon = new ImageIcon("instructions.jpg");
  JLabel iconLabel = new JLabel (icon); //save icon as a JLabel
  
  // Constructor - Setup GUI
  public Instructions() 
  { 
    setTitle("Instructions");  //Create a window with a title
    setSize(800, 600);         //Set the size of the window
    setResizable(false);     // Do not allow the user to resize the window
    
//    //Notifies program when frame is closed (disposed)
//    this.addWindowListener (new WindowAdapter (){
//      @Override
//      public void windowClosed(WindowEvent e) //overrides the default action that is performed then window is closed
//      {
//        Music.stop(); //stop music from playing
//      }
//    });
    
    iconLabel.setBounds (0, 0, 800, 600);
    marchButton.setBounds (350, 500, 100, 50); //set position of marchButton
    marchButton.setBackground (Color.white); //set color of marchButton
    
    marchButton.addActionListener(this); //add actionListener to marchButton so computer knows when you press it
    
    layeredPane.add(iconLabel, new Integer (1)); //add instructionsPanel to layeredPane
    layeredPane.add (marchButton, new Integer(2)); //add marchButton to layeredPane on the topmost layer
    
    setVisible(true);  // Display the GUI
  }
  
  //Method to send endMusic back to music thread in Main
  public static int getEndMusic ()
  {
    if (screen == 3)//if screen is already changed to SpaceShip
      endMusic = SpaceShip.getEndMusic();
    return endMusic;
  }
  
  //method that performs actions when user presses buttons
  public void actionPerformed(ActionEvent event) 
  { 
    String command = event.getActionCommand(); //save the button press under variable command
    
    if (command.equals("MARCH")) //if user pressed march button
    { 
      System.out.println("Starting program...");
      this.dispose();
      endMusic = 2;
      
      JFrame shipFrame = new JFrame ();
      SpaceShip playing = new SpaceShip (); //run the spaceship class
      shipFrame.add(playing);
      shipFrame.setSize(800,600);
      shipFrame.setVisible (true);
      repaint();
    }                
  } 
  
  
  //Main method
  public static void main(String[] args) 
  {
    Instructions frame = new Instructions();  // Start the GUI
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the frame is the x button is pressed
    
  }
  
} //end of program