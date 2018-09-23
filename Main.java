/*Main.java
 * Julia Zhao, Tiantian Li, Marina Zheng
 * Finished December 20 2016
 * Main menu for MMM game
 */

import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener//, Runnable
{    
  static int endMusic = 1;
  static int screen = 1; //screen is main screen
  
  //Create some GUI components
  JButton instrButton = new JButton ("MANUAL"); //instructions button
  JButton marchButton = new JButton ("MARCH"); //start game button
  JButton credButton = new JButton ("MAKERS"); //credits button
  JLabel nameLabel = new JLabel ("MARTIANS MARVELOUS MARCH"); //name of game
  
  public Main () //GUI Constuctor
  {
    setTitle("Martians Marvelous March");  //Create a window with a title
    setSize(800, 600);         //Set the size of the window
    setResizable(false);     // Do not allow the user to resize the window
    
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); //set frame to BoxLayout in the vertical form
    
    nameLabel.setAlignmentX(CENTER_ALIGNMENT); //set alignment to center of the page
    nameLabel.setVisible (true); //set label to visible
    
    //specify details for each component
    marchButton.setAlignmentX(CENTER_ALIGNMENT);
    marchButton.addActionListener (this); //add an actionListener so the program knows when you press the button
    marchButton.setVisible (true);
    
    credButton.setAlignmentX(CENTER_ALIGNMENT);
    credButton.addActionListener (this);
    credButton.setVisible (true);
    
    instrButton.setAlignmentX(CENTER_ALIGNMENT);
    instrButton.addActionListener(this); //add actionListener to instrButton
    instrButton.setVisible (true);
    
    //add the components to the frame
    add (nameLabel);
    add (instrButton);
    add (marchButton);
    add (credButton);
    
    setVisible (true); //set the frame to visible
  }
  
  //Check if user clicked a button
  public void actionPerformed(ActionEvent event)
  { 
    String command = event.getActionCommand();
    
    if (command.equals("MANUAL")) 
    { 
      System.out.println("Loading manual...");
      Instructions instructions = new Instructions (); //call up instructions class
      this.dispose(); //stop main screen frame from running
      screen = 2; //screen changes to manual
    }  
    else if (command.equals ("MARCH"))
    {
      System.out.println ("Mission commencing in 3...2...1...");
      this.dispose();
      JFrame shipFrame = new JFrame ();
      SpaceShip playing = new SpaceShip ();//call up SpaceShip class
      shipFrame.add(playing);
      shipFrame.setSize(800,600);
      shipFrame.setVisible (true);
      repaint();
      endMusic = 2;
    }
    else if (command.equals ("MAKERS"))
    {
      System.out.println ("Meet the makers of MMM!");
      Makers credits = new Makers ();//call up credits class
      this.dispose();
    }
  }
  
  public static class threadMusic implements Runnable 
  {
    //method to tell program what to thread
    public void run()
    {
      try
      {
        while (endMusic != 0) //0 meaning that all windows are closed (the game is exited)
        {
          int previous = endMusic;
          
          //if on main menu call play method and play main menu music
          if (endMusic == 1)
            Music.play("menuMusic.wav");
          
          do
          {
            if (screen > 1) //if screen changed
            {
              endMusic = Instructions.getEndMusic(); //get value of endMusic from instructions
            }
          }
          while (previous == endMusic);
          
//          //if all frames are closed stop the music
//          if (endMusic == 0 || endMusic >1)
//            Music.stop();
//          
          //if screen has changed stop the original music and change the music
          if (endMusic > 1)
            System.out.println ("Screen change");
            Music.stop();
            Music.change(endMusic);  
        }
      }
      catch (Exception e)
      {
        System.out.println ("Error: " + e);
      }
    }
  }
  
  //Main method
  public static void main(String[] args) throws Exception
  {
    Main frame = new Main();  // Start the GUI
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the frame is the x button is pressed
    //start running the music thread from the threadMusic class
    //(new Thread(new threadMusic())).start();
    
    Thread music = new Thread (new threadMusic());
    music.start (); //start the thread
  }
}//end of class
