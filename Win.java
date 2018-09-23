import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
//import javax.swing.*;
import java.awt.Color;
public class Win extends JFrame implements ActionListener
{
  JFrame frame = new JFrame();
  JPanel pan1 = new JPanel(); //Create a Panel
  JButton back = new JButton("BACK");
  JButton again = new JButton("PLAY AGAIN");
  String bgPic;
  
  
  public Win () 
  { 
    //decide which picture to use
    if (SpaceShip.gameResult() == 0) //if player lost
    {
      bgPic = "fail.PNG";
      System.out.println ("You lose");
    }
    else //if result = 1
    {
      bgPic = "accomplish.PNG"; //if player won
      System.out.println ("You win");
    }
    
    ImageIcon icon = new ImageIcon(bgPic);
    JLabel label = new JLabel(icon);
  
    JLabel scoreLabel = new JLabel("SCORE: " + SpaceShip.returnScore()); //call the returnScore method to get value of 
    //the score
   
    scoreLabel.setForeground(Color.red);
    
    pan1.setLocation(700, 500);
    pan1.setSize (20, 10);
    frame.setSize (800, 600); //Set the size of the window
    //frame.setResizable(false); //Do not allow the user to resize the window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    again.addActionListener(this);
    back.addActionListener(this);
    
    label.setVisible(true);
    frame.add(label);
    frame.setVisible(true);
    
    again.setVisible(true);
    back.setVisible(true);
    scoreLabel.setVisible(true);

//    frame.add(again);
//    frame.add(back);
//    frame.add(scoreLabel);
    
    pan1.add(back);
    pan1.add(again);
    pan1.add(scoreLabel);
    
    frame.add(pan1);
  }
  
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();  //find out the name of the component
    //that was used
    
    if (command.equals("PLAY AGAIN")) {                 // if the OK button was pressed
      System.out.println("ok button pressed");  // display message in console(for testing)
      
      System.out.println ("Mission commencing in 3...2...1...");
      frame.dispose();
      JFrame shipFrame = new JFrame ();
      SpaceShip playing = new SpaceShip ();//replace WheelOfFortuneGUI with name of playing class
      shipFrame.add(playing);
      shipFrame.setSize(800,600);
      shipFrame.setVisible (true);
      repaint();
    } // no other conditions 
    
    if (command.equals("BACK")) {   
      frame.dispose();
      Main frame = new Main (); //call up main
    }    
  }
  
  public static void main(String args[]) 
  {
    Win frame = new Win();
  }
}