//Screen for game over (lose)

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;

public class Fail extends JFrame
{
  JFrame frame = new JFrame();
  ImageIcon icon = new ImageIcon("fail.PNG");
    JLabel label = new JLabel(icon);
  
  public Fail () 
  { 
    frame.setSize (800, 600); //Set the size of the window
    frame.setResizable(false); //Do not allow the user to resize the window
    label.setVisible(true);
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops program once frame is closed
    frame.setVisible(true);
  }
  
  public static void main(String args[]) 
  {
    Fail frame = new Fail();
  }
}
